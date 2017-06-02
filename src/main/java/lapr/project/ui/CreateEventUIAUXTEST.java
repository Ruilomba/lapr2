/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.util.Date;
import java.util.Scanner;
import lapr.project.controller.CreateEventController;
import lapr.project.model.Event;
import lapr.project.model.EventCenter;
import lapr.project.model.EventManager;
import lapr.project.model.Exhibition;
import lapr.project.model.User;
import lapr.project.model.UserRegistration;

/**
 *
 * @author RuiSL
 */
public class CreateEventUIAUXTEST {
    private final EventCenter eventCenter;
    private CreateEventController createEventController;

    public CreateEventUIAUXTEST(EventCenter eventCenter) {
        this.eventCenter = eventCenter;
        createEventController = new CreateEventController(eventCenter);
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        EventManager eventManager = new EventManager();
        Event e = createEventController.newEvent();
        int op = 0;
        do {
            System.out.println("1-Exhibition\n"
                    + "2-Congress"
                    + "0 para sair");
            op = in.nextInt();
            switch (op) {
                case 1:
                    e.setEventType(new Exhibition());
                    System.out.println("Please insert title");
                    String titulo = in.next();
                    System.out.println("Please insert description");
                    String description = in.next();
                    System.out.println("Please insert event starting date - mm/dd/yyyy");
                    Date dataInicioEvento = new Date(in.next());
                    System.out.println("Please insert event end date - mm/dd/yyyy");
                    Date dataFimEvento = new Date(in.next());
                    System.out.println("Please insert starting aplication submission date");
                    Date dataInicioSubmissao = new Date(in.next());
                    System.out.println("Please insert ending aplication submission date");
                    Date dataFimSubmissao = new Date(in.next());
                    System.out.println("Please insert Location");
                    String local = in.next();
                    User u1= new User();
                    u1.setUsername("Rui");
                    eventCenter.getUserRegistration().addUserRegistration(u1);
                    createEventController.setData(e, titulo, description, dataInicioEvento, dataFimEvento, dataInicioSubmissao, dataFimSubmissao, local);
                    UserRegistration listaUtilizadores = createEventController.getUserList();
                    int count = 0;
                    while (count < 2) {
                        for (User u : listaUtilizadores.getUserList()) {
                            System.out.println(u);
                        }
                        System.out.println("Please insert username of pretender User");
                        String username = in.next();
                        if (createEventController.associateOrganizer(e, listaUtilizadores, username)) {
                            count++;
                        }
                    }
                    if(createEventController.validateEvento(e)){
                        createEventController.registEvent(e);
                    }
                    System.out.println("adasdasdsa");
                    break;
                case 2:
                    break;
            }
        } while (op != 0);
    }
}
