package lapr.project.ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import lapr.project.controller.SubmitApplicationController;
import lapr.project.model.EventCenter;

/**
 *
 * @author teixe
 */
public class SubmitApplicationUI extends JPanel {

    public static final long serialVersionUID = 1L;
    private final EventCenter eventCenter;
    private final SubmitApplicationController applicationController;
    private JList<String> eventList;
    private JPanel createApplicationFormPanel;

    public SubmitApplicationUI(EventCenter center,SubmitApplicationController controller) {
        this.eventCenter = center;
        this.applicationController = controller;
        this.setLayout(new GridLayout(0, 2));
        JPanel selectEventPanel = createSelectEventPanel();
        this.add(selectEventPanel);
        JPanel applicationFormPanel = createApplicationFormPanel();
        applicationFormPanel.setVisible(false);
        this.add(applicationFormPanel);
        this.setVisible(true);
    }

    private JPanel createSelectEventPanel() {
        JPanel panelContainer = new JPanel();
        panelContainer.setLayout(new GridBagLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));
        JLabel panelTitle = new JLabel("List of events in submission period");
        panel.add(panelTitle);
        JLabel panelSubTitle = new JLabel("Please select the event to which you want to apply.");
        panel.add(panelSubTitle);
        String[] eventsData = this.applicationController.getEventListInSubmissionPeriodAsStrings();
        eventList = new JList<>(eventsData);
        eventList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        eventList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        eventList.setVisibleRowCount(10);
        eventList.addListSelectionListener((ListSelectionEvent e) -> {
            String selectedEvent = eventList.getSelectedValue();
            if (applicationController.selectEventWithTitle(selectedEvent)) {
                showApplicationFormPanel();            
            }
        });
        JScrollPane listScroller = new JScrollPane(eventList);
        listScroller.setPreferredSize(new Dimension(200, 200));
        panel.add(listScroller);
        panelContainer.add(panel);
        return panelContainer;
    }
    
    private JPanel createApplicationFormPanel() {
        createApplicationFormPanel = new JPanel();
        createApplicationFormPanel.setLayout(new GridBagLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));
        createApplicationFormPanel.add(panel);
        createApplicationFormPanel.setVisible(false);
        return createApplicationFormPanel;
    }
    
    private void showApplicationFormPanel() {
        createApplicationFormPanel.setVisible(true);
    }
}