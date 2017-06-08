package lapr.project.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import lapr.project.model.*;
import lapr.project.controller.*;

public class MenuUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private final EventCenter eventCenter;
    private final MenuController menuController;

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

    public MenuUI(EventCenter center, MenuController controller) {
        super("Menu");
        eventCenter = center;
        menuController = controller;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        createMenuBar();
        addListenersToButtons();
        showWelcomePanel();
        this.setVisible(true);
    }
    
    private void createMenuBar() {
        JMenuBar menubar = new JMenuBar();
        String userName;
        userName = menuController.getAuthenticatedUserName();
        userNameItem = new JMenuItem("authenticated user");
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
        importExportMenu.add(exportDataMenuItem);
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
        createEventMenuItem.addActionListener((ActionEvent e) -> {
            showCreateEventPanel();
        });
        
        listApplications.addActionListener((ActionEvent e) -> {
            showGlobalApplicationsList();
        });
        
        statisticsMenuItem.addActionListener((ActionEvent e) -> {
            showStatistics();
        });
        userUpdateMenuItem.addActionListener((ActionEvent e) -> {
            showUserUpdatePanel();
        });
        logoutMenuItem.addActionListener((ActionEvent e) -> {
            goToLogin();
        });
    }

    private void showWelcomePanel() {
        WelcomePanel welcomePanel = new WelcomePanel();
        setContentPane(welcomePanel);
    }
    
    private void showCreateEventPanel() {
        CreateEventController createEventController = new CreateEventController(eventCenter);
        CreateEventUI createEventUI = new CreateEventUI(eventCenter, createEventController);
        setContentPane(createEventUI);
    }
    
    private void showGlobalApplicationsList() {
        ListGlobalApplicationsController applicationsController = new ListGlobalApplicationsController(eventCenter);
        ListGlobalApplicationsUI applicationsUI = new ListGlobalApplicationsUI(eventCenter, applicationsController);
        setContentPane(applicationsUI);
    }

    private void showUserUpdatePanel() {
        UserDataUpdateController userUpdateController = new UserDataUpdateController(eventCenter);
        UserDataUpdateUI userUpdateUI = new UserDataUpdateUI(eventCenter, userUpdateController);
        setContentPane(userUpdateUI);
    }
    
    private void showStatistics() {
        RatingController ratingController = new RatingController(eventCenter);
        RatingUI ratingUI = new RatingUI(eventCenter, ratingController);
        setContentPane(ratingUI);
    }
    
    private void goToLogin() {
        UserLoginUI login = new UserLoginUI(eventCenter);
        login.setVisible(true);
        this.dispose();
    }
}
