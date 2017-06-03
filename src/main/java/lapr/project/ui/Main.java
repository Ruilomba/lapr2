package lapr.project.ui;

import javax.swing.*;
import lapr.project.model.EventCenter;

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
        UserRegistrationUI registration;
        registration = new UserRegistrationUI(center);
        window.setContentPane(registration);
        window.setAlwaysOnTop(true);
        window.setVisible(true);
    }
}