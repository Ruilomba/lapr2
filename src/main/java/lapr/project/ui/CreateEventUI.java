/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import lapr.project.controller.CreateEventController;
import lapr.project.model.Congress;
import lapr.project.model.EventCenter;
import lapr.project.model.Exhibition;
import lapr.project.model.User;

/**
 *
 * @author RuiSL
 */
public class CreateEventUI extends JPanel {

    private final EventCenter eventCenter;
    private final CreateEventController createEventController;
    private JComboBox comboEvents;
    private JLabel eventSelection;
    private final int BUTTON_WIDTH = 300;
    private final int BUTTON_HEIGHT = 50;
    private JList<String> userListPrinted;
    private List<User> userList;

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
        comboEvents = new JComboBox(eventTipes);
        comboEvents.setVisible(true);
        comboEvents.setSelectedIndex(1);
        comboEvents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == comboEvents) {
                    JComboBox box = (JComboBox) e.getSource();
                    String msg = (String) box.getSelectedItem();
                    switch (msg) {
                        case "Exhibition":
                            eventSelection.setText("You have Selected an exhibition");
                            createEventController.startNewEvent();
                            createEventController.setEventType(new Exhibition());
                            break;
                        case "Congress":
                            eventSelection.setText("You have selected a Congress");
                            createEventController.startNewEvent();
                            createEventController.setEventType(new Congress());
                            break;
                    }
                }
            }
        });
    }
}
