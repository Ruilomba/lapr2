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
        UserRegistrationFrame frame;
        frame = new UserRegistrationFrame(center);
        JWindow window = new JWindow();
        window.setContentPane(frame);
        window.setAlwaysOnTop(true);
        window.setVisible(true);
    }
    
}
