package lapr.project.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import lapr.project.controller.MenuController;
import lapr.project.controller.UserRegistrationController;
import lapr.project.model.*;

class Main {

    /**
     * private constructor to hide implicit public one
     */
    private Main() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
      
//        User u = new User("Rui", "rui.s.lomba@hotmail.com", "Ruilomba", "1234");
//        eventCenter.getUserRegistration().addUserRegistration(u);
//        Event e= new Event();
//        e.setEventState(new StartingEventState());
//        Event e1= new Event();
//        e1.setEventState(new StartingEventState());
//        eventCenter.getEventRegistration().registerEvento(e);
//        eventCenter.getEventRegistration().registerEvento(e1);
//        e.setEventDescription("EventoDoRui");
//        Organizer o=e.getOrganizerRegistration().newOrganizer();
//        o.setUser(u);
//        //tenho que tentar isto de novo qando tiver a instanciaçao dos utilizadores correta
//        List<Event> organizerEventList=eventCenter.getEventRegistration().getOrganizerEvents(u, new StartingEventState());
//        System.out.println("");
        
        EventCenter center;
        center = new EventCenter();
        
        // PARA ENTRAR NO MEU
        // MenuController menuController = new MenuController(center);
        // MenuUI menuUI = new MenuUI(center, menuController);
        
        // PARA ENTRAR NA AUTENTICAÇÃO
        UserRegistrationController registrationController = new UserRegistrationController(center);
        UserRegistrationUI registrationUI = new UserRegistrationUI(center, registrationController);
    }
}