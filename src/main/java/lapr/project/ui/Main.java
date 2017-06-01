package lapr.project.ui;

import javax.swing.JWindow;
import lapr.project.model.EventCenter;

class Main {

    /**
     * Private constructor to hide implicit public one.
     */
    private Main() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EventCenter center = new EventCenter();
        
        // creates user registration frame for testing purposes
        UserRegistrationFrame userRegistrationFrame;
        userRegistrationFrame = new UserRegistrationFrame(center);

        // creates and adds main window to 
        JWindow window = new JWindow();
        window.setContentPane(userRegistrationFrame);
        window.setAlwaysOnTop(true);
        window.setVisible(true);
    }
    
}
