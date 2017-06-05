package lapr.project.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import lapr.project.model.*;
import lapr.project.controller.*;

public class MenuUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private final EventCenter eventCenter;
    private final MenuController controller;
    
    private JMenuItem userNameItem;
    private JMenuItem userUpdateItem;

    public MenuUI(EventCenter center) {
        super("User Authentication");
        eventCenter = center;
        controller = new MenuController(eventCenter);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        createMenuBar();
        addListenersToButtons();
        this.setVisible(true);
    }
    
    private void createMenuBar() {
        JMenuBar menubar = new JMenuBar();
        String userName;
        userName = controller.getAuthenticatedUserName();
        userNameItem = new JMenuItem(userName);
        menubar.add(userNameItem);
        userUpdateItem = new JMenuItem("Update user data");
        menubar.add(userUpdateItem);
        setJMenuBar(menubar);
    }

    private void addListenersToButtons() {
        userUpdateItem.addActionListener((ActionEvent e) -> {
            goToUpdateUserData();
        });
    }

    private void goToUpdateUserData() {
        UserDataUpdateUI userUpdate = new UserDataUpdateUI(eventCenter);
        userUpdate.setVisible(true);
        this.dispose();
    }
}
