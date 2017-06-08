package lapr.project.ui;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
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
    private final List<User> userList;

    public CreateEventUI(EventCenter eventCenter, CreateEventController createEventController) {
        this.eventCenter = eventCenter;
        this.createEventController = createEventController;
        userList = new ArrayList<>();
        setLayout(new GridLayout(0, 2));
        createComponents();
        this.add(comboEvents);
        this.add(eventSelection);
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
                        break;
                    case "Congress":
                        eventSelection.setText("You have selected a congress");
                        createEventController.startNewEvent();
                        createEventController.setEventType(new Congress());
                        break;
                }
            } catch (Exception invalidCastException) {
                System.out.println(invalidCastException.getMessage());
            }
        });
    }
}