package lapr.project.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import lapr.project.model.*;
import lapr.project.controller.*;

public class MenuUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private final EventCenter eventCenter;
    private final MenuController controller;

    public MenuUI(EventCenter center) {
        super("User Authentication");
        eventCenter = center;
        controller = new MenuController(eventCenter);
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

        String userName;
        userName = controller.getAuthenticatedUserName();
        JMenuItem userNameItem = new JMenuItem(userName);
        menubar.add(userNameItem);
        
        JMenuItem userUpdateItem = new JMenuItem("Update user data");
        userUpdateItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goToUpdateUserData();
            }
            
        });
        menubar.add(userUpdateItem);

        setJMenuBar(menubar);
    }

    private void createElements() {
    }

    private void addListenersToButtons() {
    }

    private void addElementsToJPanel(JPanel panel) {
    }
    
    private void goToUpdateUserData() {
        UserDataUpdateUI userUpdate = new UserDataUpdateUI(eventCenter);
        userUpdate.setVisible(true);
        this.dispose();
    }
}
