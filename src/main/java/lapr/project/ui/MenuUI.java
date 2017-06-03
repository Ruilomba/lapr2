package lapr.project.ui;

import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.*;
import lapr.project.model.*;
import lapr.project.utils.AuthenticationService;

public class MenuUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private final EventCenter eventCenter;

    public MenuUI(EventCenter center) {
        super("User Authentication");
        eventCenter = center;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        createMenuBar();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,1));
        this.add(panel);
        createElements();
        addElementsToJPanel(panel);
        this.setVisible(true);
    }
    
    private void createMenuBar() {
        JMenuBar menubar = new JMenuBar();

        String username = AuthenticationService.getUsernameOfAuthenticatedUser();
        JMenuItem userNameItem = new JMenuItem(username);
        menubar.add(userNameItem);

        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);
        menubar.add(file);

        setJMenuBar(menubar);
    }

    private void createElements() {
    }

    private void addListenersToButtons() {
    }

    private void addElementsToJPanel(JPanel panel) {
    }
}
