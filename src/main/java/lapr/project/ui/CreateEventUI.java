package lapr.project.ui;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import lapr.project.controller.*;
import lapr.project.model.Congress;
import lapr.project.model.EventCenter;
import lapr.project.model.Exhibition;
import lapr.project.model.User;

/**
 *
 * @author RuiSL
 */
public class CreateEventUI extends JPanel {

    private static final long serialVersionUID = 1L;
    private final EventCenter eventCenter;
    private final CreateEventController createEventController;
    private JComboBox<String> comboEvents;
    private JLabel eventSelection;
    private final int BUTTON_WIDTH = 300;
    private final int BUTTON_HEIGHT = 50;
    private JList<String> userListPrinted;
<<<<<<< HEAD
    private String[] userList;
    private JPanel userListPanelContainer; 
=======
    private final List<User> userList;
    private JPanel userListPanelContainer;
>>>>>>> 6f2ab4220360faa6f8687783ad536614e91077ac

    public CreateEventUI(EventCenter eventCenter, CreateEventController createEventController) {
        this.eventCenter = eventCenter;
        this.createEventController = createEventController;
        userList = new String[createEventController.getUserCount()];
        setLayout(new GridLayout(0, 2));
        createComponents();
        
        setVisible(true);
    }

    private void createComponents() {
        
        eventSelection = new JLabel("Please select event Type");
        eventSelection.setVisible(true);
        String[] eventTipes = {"Exhibition", "Congress"};
        comboEvents = new JComboBox<>(eventTipes);
        comboEvents.setVisible(true);
        comboEvents.setSelectedIndex(1);
        comboEvents.addActionListener((ActionEvent e) -> {
            try {
                String msg = comboEvents.getSelectedItem().toString();
                switch (msg) {
                    case "Exhibition":
                        eventSelection.setText("You have selected an exhibition");
                        createEventController.startNewEvent();
                        createEventController.setEventType(new Exhibition());
                        showUserList();
                        break;
                    case "Congress":
                        eventSelection.setText("You have selected a congress");
                        createEventController.startNewEvent();
                        createEventController.setEventType(new Congress());
                        showUserList();

                        break;
                }
            } catch (Exception invalidCastException) {
                System.out.println(invalidCastException.getMessage());
            }
        });
<<<<<<< HEAD
        JPanel selectTypeOfEventPanelContainer = new JPanel();
        selectTypeOfEventPanelContainer.setLayout(new GridBagLayout());
        JPanel selectTypeOfEventPanel = new JPanel();
        selectTypeOfEventPanel.setLayout(new GridLayout(0, 1));
        selectTypeOfEventPanel.add(eventSelection);
        selectTypeOfEventPanel.add(comboEvents);
        selectTypeOfEventPanelContainer.add(selectTypeOfEventPanel);
        this.add(selectTypeOfEventPanelContainer);
=======

>>>>>>> 6f2ab4220360faa6f8687783ad536614e91077ac
        userListPanelContainer = new JPanel();
        userListPanelContainer.setLayout(new GridBagLayout());
        JPanel userListPanel = new JPanel();
        userListPanel.setLayout(new GridLayout(0, 1));
        JLabel chooseUsersLabel = new JLabel("Please select users you wish to add as organisers of the event");
        userListPanel.add(chooseUsersLabel);
        userListPanel.add(createUserList());
        userListPanelContainer.add(userListPanel);
        userListPanelContainer.setVisible(false);
        this.add(userListPanelContainer);
    }
    
<<<<<<< HEAD
    private void showUserList(){
    userListPanelContainer.setVisible(true);
    }
    
    public JList<String> createUserList(){
        JLabel onlyTwo= new JLabel("Please select only two users");
        userList=createEventController.getUsersAsStrings();
        userListPrinted = new  JList<String>(userList);
        userListPrinted.addListSelectionListener((ListSelectionEvent e)->{
            List<String> userNames=userListPrinted.getSelectedValuesList();
            if(userNames.size()==2){
                onlyTwo.setVisible(false);
                createEventController.associateOrganizer(userNames.get(0));
                createEventController.associateOrganizer(userNames.get(1));
            } else{
                onlyTwo.setVisible(true);
            }
        });
        userListPrinted.setVisible(true);
        return userListPrinted;
    }
    
=======
    private void showUserList() {
        userListPanelContainer.setVisible(true);
    }
>>>>>>> 6f2ab4220360faa6f8687783ad536614e91077ac
}
