package lapr.project.ui;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import lapr.project.controller.SubmitApplicationController;
import lapr.project.model.Event;
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
        JLabel panelTitle = new JLabel(("Select the event to apply:"));
        panel.add(panelTitle);
        String[] eventsData = this.applicationController.getEventListInSubmissionPeriodAsStrings();
        eventList = new JList<>(eventsData);
        eventList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        eventList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        eventList.setVisibleRowCount(10);
        eventList.addListSelectionListener((ListSelectionEvent e) -> {
            showApplicationFormPanel();
        });
        JScrollPane listScroller = new JScrollPane(eventList);
        listScroller.setPreferredSize(new Dimension(200, 200));
        this.add(listScroller);
        panelContainer.add(panel);
        return panelContainer;
    }
    
    private JPanel createApplicationFormPanel() {
        JPanel panelContainer = new JPanel();
        panelContainer.setLayout(new GridBagLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));
        panelContainer.add(panel);
        return panelContainer;
    }
    
        
    public void run(){
        List<Event> el = submitApplicationController.getEventListInSubmissionPeriod();
        //eventList.setListData(el.toArray());
        setVisible(true);
    }
}