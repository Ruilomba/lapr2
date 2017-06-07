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
    
    private JMenu eventsMenu;
    private JMenuItem createEventMenuItem;
    private JMenuItem showEventKeywordsMenuItem;
    
    private JMenu applicationsMenu;
    private JMenuItem listApplications;
    private JMenuItem decideApplicationMenuItem;
    private JMenuItem assingApplicationMenuItem;
    private JMenuItem changeRemoveApplicationMenuItem;

    private JMenu standsMenu;
    private JMenuItem showStandsMenuItem;
    private JMenuItem createStandMenuItem;
    private JMenuItem assignStandMenuItem;

    private JMenu importExportMenu;
    private JMenuItem importDataMenuItem;
    private JMenuItem exportDataMenuItem;

    private JMenuItem statisticsMenuItem;
    
    private JMenuItem userUpdateMenuItem;
    private JMenuItem logoutMenuItem;

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
        
        eventsMenu = new JMenu("Events");
        createEventMenuItem = new JMenuItem("Create Event");
        showEventKeywordsMenuItem = new JMenuItem("Show Event Keywords");
        eventsMenu.add(createEventMenuItem);
        eventsMenu.add(showEventKeywordsMenuItem);
        menubar.add(eventsMenu);
        
        applicationsMenu = new JMenu("Applications");
        listApplications = new JMenuItem("List applications");
        decideApplicationMenuItem = new JMenuItem("Decide application");
        assingApplicationMenuItem = new JMenuItem("Assign application");
        changeRemoveApplicationMenuItem = new JMenuItem("Change or remove application");
        applicationsMenu.add(listApplications);
        applicationsMenu.add(decideApplicationMenuItem);
        applicationsMenu.add(assingApplicationMenuItem);
        applicationsMenu.add(changeRemoveApplicationMenuItem);
        menubar.add(applicationsMenu);
        
        standsMenu = new JMenu("Stands");
        showStandsMenuItem = new JMenuItem("Show stands");
        createStandMenuItem = new JMenuItem("Create stand");
        assignStandMenuItem = new JMenuItem("Assign stand");
        standsMenu.add(showStandsMenuItem);
        standsMenu.add(createStandMenuItem);
        standsMenu.add(assignStandMenuItem);
        menubar.add(standsMenu);
        
        importExportMenu = new JMenu("Import/Export data");
        importDataMenuItem = new JMenuItem("Import data");
        exportDataMenuItem = new JMenuItem("Export data");
        importExportMenu.add(importDataMenuItem);
        exportDataMenuItem.add(exportDataMenuItem);
        menubar.add(importExportMenu);
        
        statisticsMenuItem = new JMenuItem("Statistics");
        menubar.add(statisticsMenuItem);
        
        userUpdateMenuItem = new JMenuItem("Update user data");
        menubar.add(userUpdateMenuItem);
        
        logoutMenuItem = new JMenuItem("Logout");
        menubar.add(logoutMenuItem);

        setJMenuBar(menubar);
    }

    private void addListenersToButtons() {
        userUpdateMenuItem.addActionListener((ActionEvent e) -> {
            goToUpdateUserData();
        });
        logoutMenuItem.addActionListener((ActionEvent e) -> {
            goToLogin();
        });
    }

    private void goToUpdateUserData() {
        UserDataUpdateUI userUpdate = new UserDataUpdateUI(eventCenter);
        userUpdate.setVisible(true);
        this.dispose();
    }
    
    private void goToLogin() {
        UserLoginUI login = new UserLoginUI(eventCenter);
        login.setVisible(true);
        this.dispose();
    }
}
