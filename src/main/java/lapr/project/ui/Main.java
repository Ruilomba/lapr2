package lapr.project.ui;

import java.io.IOException;
import javax.swing.*;
import lapr.project.controller.*;
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