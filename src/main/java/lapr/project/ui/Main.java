package lapr.project.ui;

import java.io.IOException;
import javax.swing.*;

import lapr.project.controller.RatingController;
import lapr.project.model.*;

import java.util.ArrayList;
import java.util.List;
import lapr.project.controller.CreateEventController;
import lapr.project.controller.ListApplicationsController;
import lapr.project.states.EventCreatedState;
import lapr.project.states.EventStateDefinedFAE;
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
        EventCenter eventCenter= new EventCenter();
        Event e=eventCenter.getEventRegistration().newEvent();
        Event e1=eventCenter.getEventRegistration().newEvent();
        e1.setEventDescription("dasdasd");
        Event e2=eventCenter.getEventRegistration().newEvent();
        e2.setEventDescription("qwoels");
        Event e3=eventCenter.getEventRegistration().newEvent();
        Event e4=eventCenter.getEventRegistration().newEvent();
        Event e5=eventCenter.getEventRegistration().newEvent();
        Event e6=eventCenter.getEventRegistration().newEvent();
        eventCenter.getEventRegistration().registerEvento(e);
        eventCenter.getEventRegistration().registerEvento(e1);
        eventCenter.getEventRegistration().registerEvento(e2);
        eventCenter.getEventRegistration().registerEvento(e3);
        eventCenter.getEventRegistration().registerEvento(e4);
        eventCenter.getEventRegistration().registerEvento(e5);
        eventCenter.getEventRegistration().registerEvento(e6);
        e.getApplicationRegistration().addApplication(new Application());
        e1.getApplicationRegistration().addApplication(new Application());
        e2.getApplicationRegistration().addApplication(new Application());
        e3.getApplicationRegistration().addApplication(new Application());
        ListApplicationsController cont= new ListApplicationsController(eventCenter);
        List<Application> applicationList=new ArrayList<>();
        applicationList=cont.getGlobalApplicationList();
        System.out.println(applicationList);
        System.out.println("asdsa");
        
        
        
        JWindow window = new JWindow();
        EventCenter center = new EventCenter();
        RatingController controller = new RatingController();
        RatingParameter parameter1 = new RatingParameter("FAE’s knowledge about the event topic", 0, 5, 0);
        RatingParameter parameter2 = new RatingParameter("FAE’s knowledge about the event topic", 0, 5, 0);
        RatingParameter parameter3 = new RatingParameter("FAE’s knowledge about the event topic", 0, 5, 0);
        List<RatingParameter> list = new ArrayList<RatingParameter>();
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