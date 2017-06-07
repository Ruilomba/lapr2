package lapr.project.ui;

import javax.swing.*;

import lapr.project.controller.RatingController;
import lapr.project.model.*;

import java.util.ArrayList;
import java.util.List;

class Main {

    /**
     * private constructor to hide implicit public one
     */
    private Main() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JWindow window = new JWindow();
        EventCenter center = new EventCenter();
        RatingController controller = new RatingController();

        User user = new User("Gastão", "gastao@fdv.com", "ogastao", "gaston");
        FAE fae = new FAE(user);

        window.setContentPane(controller.showGlobalAverageRating(center));
        window.setAlwaysOnTop(true);
        window.setVisible(true);
    }
}