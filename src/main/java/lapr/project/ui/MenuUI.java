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
    private JMenuItem submitApplicationMenuItem;
    private JMenuItem decideApplicationMenuItem;
    private JMenuItem changeRemoveApplicationMenuItem;
    private JMenu standsMenu;
    private JMenuItem showStandsMenuItem;
    private JMenuItem createStandMenuItem;
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
        // TODO: ADD AUTHENTICATED USER
        //userName = menuController.getAuthenticatedUserName();
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
        submitApplicationMenuItem = new JMenuItem("Submit application");
        decideApplicationMenuItem = new JMenuItem("Decide application");
        changeRemoveApplicationMenuItem = new JMenuItem("Change or remove application");
        applicationsMenu.add(listApplications);
        applicationsMenu.add(submitApplicationMenuItem);
        applicationsMenu.add(decideApplicationMenuItem);
        applicationsMenu.add(changeRemoveApplicationMenuItem);
        menubar.add(applicationsMenu);
        
        standsMenu = new JMenu("Stands");
        showStandsMenuItem = new JMenuItem("Show stands");
        createStandMenuItem = new JMenuItem("Create stand");
        standsMenu.add(showStandsMenuItem);
        standsMenu.add(createStandMenuItem);
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
        userNameItem.addActionListener((ActionEvent e) -> {
            showWelcomePanel();
        });
        createEventMenuItem.addActionListener((ActionEvent e) -> {
            showCreateEventPanel();
        });
        submitApplicationMenuItem.addActionListener((ActionEvent e) -> {
            showSubmitApplicationPanel();
        });
        showStandsMenuItem.addActionListener((ActionEvent e) -> {
            showStandsPanel();
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
        this.setContentPane(welcomePanel);
        this.getContentPane().revalidate();
        this.getContentPane().repaint();
    }
    
    private void showCreateEventPanel() {
        CreateEventController createEventController = new CreateEventController(eventCenter);
        CreateEventUI createEventUI = new CreateEventUI(eventCenter, createEventController);
        this.setContentPane(createEventUI);
        this.getContentPane().revalidate();
        this.getContentPane().repaint();
    }
    
    private void showSubmitApplicationPanel() {
        SubmitApplicationController newApplicationController = new SubmitApplicationController(eventCenter);
        SubmitApplicationUI newApplicationUI = new SubmitApplicationUI(eventCenter, newApplicationController);
        this.setContentPane(newApplicationUI);
        this.getContentPane().revalidate();
        this.getContentPane().repaint();
    }
    
    private void showGlobalApplicationsList() {
        ListGlobalApplicationsController applicationsController = new ListGlobalApplicationsController(eventCenter);
        ListGlobalApplicationsUI applicationsUI = new ListGlobalApplicationsUI(eventCenter, applicationsController);
        this.setContentPane(applicationsUI);
        this.getContentPane().revalidate();
        this.getContentPane().repaint();
    }
    
    private void showStandsPanel() {
        ShowEventStandsInformationController standsController = new ShowEventStandsInformationController(eventCenter);
        ShowEventStandsInformationUI standsUI = new ShowEventStandsInformationUI(eventCenter, standsController);
        this.setContentPane(standsUI);
        this.getContentPane().revalidate();
        this.getContentPane().repaint();
    }

    private void showUserUpdatePanel() {
        UserDataUpdateController userUpdateController = new UserDataUpdateController(eventCenter);
        UserDataUpdateUI userUpdateUI = new UserDataUpdateUI(eventCenter, userUpdateController);
        this.setContentPane(userUpdateUI);
        this.getContentPane().revalidate();
        this.getContentPane().repaint();
    }
    
    private void showStatistics() {
        RatingController ratingController = new RatingController(eventCenter);
        RatingUI ratingUI = new RatingUI(eventCenter, ratingController);
        this.setContentPane(ratingUI);
        this.getContentPane().revalidate();
        this.getContentPane().repaint();
    }
    
    private void goToLogin() {
        UserLoginUI login = new UserLoginUI(eventCenter);
        login.setVisible(true);
        this.dispose();
    }
}
