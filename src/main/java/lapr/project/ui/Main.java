package lapr.project.ui;

import java.io.IOException;
import java.util.List;
import javax.swing.*;
import lapr.project.controller.*;
import lapr.project.controller.UserRegistrationController;
import lapr.project.model.*;
import lapr.project.states.StartingEventState;

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
        EventCenter eventCenter=new EventCenter();
        CreateEventController createController= new CreateEventController(eventCenter);
        CreateEventUI create= new CreateEventUI(eventCenter, createController);
        create.setVisible(true);
        System.out.println("dasdjasjind");
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
        JWindow window = new JWindow();
        window.setAlwaysOnTop(true);
        UserRegistrationController registrationController = new UserRegistrationController(center);
        UserRegistrationUI registrationUI = new UserRegistrationUI(center, registrationController);
        window.setContentPane(registrationUI);
        window.setVisible(true);        
    }
}