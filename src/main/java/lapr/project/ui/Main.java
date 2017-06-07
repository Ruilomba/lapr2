package lapr.project.ui;

import java.io.IOException;
import javax.swing.*;
import lapr.project.model.*;
import lapr.project.controller.*;
import java.util.ArrayList;
import java.util.List;
import lapr.project.controller.CreateEventController;
import lapr.project.controller.ListApplicationsController;
import lapr.project.states.EventCreatedState;
import lapr.project.states.EventStateDefinedFAE;
import lapr.project.states.StartingEventState;
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
//        JFrame p = new JFrame();
//        SubmitApplicationUI uiSubApp = new SubmitApplicationUI(p, center);
//        uiSubApp.run();
    }
}