package lapr.project.ui;

import java.io.IOException;
import javax.swing.*;

import lapr.project.controller.RatingController;
import lapr.project.model.*;

import java.util.ArrayList;
import java.util.List;
import lapr.project.controller.*;
import lapr.project.states.*;

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
        User u = new User("Rui", "ruilomba@hotmail.com", "Ruilomba", "1234");
        eventCenter.getUserRegistration().addUserRegistration(u);
        Event e= new Event();
        e.setEventDescription("EventoDoRui");
        e.setEventState(new StartingEventState());
        Event e1= new Event();
        e1.setEventState(new StartingEventState());
        eventCenter.getEventRegistration().registerEvento(e);
        eventCenter.getEventRegistration().registerEvento(e1);
        Organizer o=e.getOrganizerRegistration().newOrganizer();
        o.setUser(u);
        List<Event> organizerEventList=eventCenter.getEventRegistration().getOrganizerEvents(u, new StartingEventState());
        System.out.println("asdsad");
        
        
        
        JWindow window = new JWindow();
        EventCenter center = new EventCenter();
        RatingController controller = new RatingController();
        RatingParameter parameter1 = new RatingParameter("FAE’s knowledge about the event topic", 0, 5, 0);
        RatingParameter parameter2 = new RatingParameter("FAE’s knowledge about the event topic", 0, 5, 0);
        RatingParameter parameter3 = new RatingParameter("FAE’s knowledge about the event topic", 0, 5, 0);
        List<RatingParameter> list = new ArrayList<>();
        list.add(parameter1);
        list.add(parameter2);
        list.add(parameter3);
        User user = new User("Gastão", "gastao@fdv.com", "ogastao", "gaston");
        FAE fae = new FAE(user);
        FAERating faeRating = new FAERating(fae, list);
        System.out.println("corrid");
        window.setContentPane(controller.showGlobalAverageRating(center));
        window.setAlwaysOnTop(true);
        window.setVisible(true);
        JFrame p = new JFrame();
        SubmitApplicationUI uiSubApp = new SubmitApplicationUI(p, center);
        uiSubApp.run();
        
    }
}