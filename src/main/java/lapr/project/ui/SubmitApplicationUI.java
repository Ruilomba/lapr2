package lapr.project.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
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
    private JTextField companyNameTextField;
    private JTextField companyAddressTextField;
    private JTextField companyPhoneTextField;
    private JTextField applicationDescriptionTextField;
    private JTextField applicationKeywordsTextField;
    private JSpinner areaSelector;
    private JSpinner invitationsSelector;
    private JLabel invalidFormLabel;

    public SubmitApplicationUI(EventCenter center, SubmitApplicationController controller) {
        this.eventCenter = center;
        this.applicationController = controller;
        this.setLayout(new BorderLayout());

        JPanel mainTitlePanel = new JPanel();
        mainTitlePanel.setLayout(new GridBagLayout());
        JLabel mainTitle = new JLabel("SUBMIT APPLICATION");
        mainTitlePanel.add(mainTitle);
        this.add(mainTitlePanel, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(0, 2));
        JPanel selectEventPanel = createSelectEventPanel();
        contentPanel.add(selectEventPanel);
        JPanel applicationFormPanel = createApplicationFormPanel();
        contentPanel.add(applicationFormPanel);
        this.add(contentPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }

    private JPanel createSelectEventPanel() {
        JPanel panelContainer = new JPanel();
        panelContainer.setLayout(new GridBagLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));
        String[] eventsData = this.applicationController.getEventListInSubmissionPeriodAsStrings();
        JLabel panelSubTitle = new JLabel("");

        eventList = new JList<>(eventsData);
        eventList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        eventList.setVisibleRowCount(10);
        if (eventsData.length == 0) {
            panelSubTitle.setText("Unable to submit application, there are no events in submission period");
            panelSubTitle.setForeground(Color.red);
        } else {
            panelSubTitle.setText("Please select the event to which you want to apply.");
            eventList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            eventList.addListSelectionListener((ListSelectionEvent e) -> {
                clearForm();
                String selectedEvent = eventList.getSelectedValue();
                if (applicationController.selectEventWithTitle(selectedEvent)) {
                    enableApplicationFormPanel();
                }
            });
        }
        panel.add(panelSubTitle);
        JScrollPane listScroller = new JScrollPane(eventList);
        listScroller.setPreferredSize(new Dimension(200, 200));
        panel.add(listScroller);
        panelContainer.add(panel);
        return panelContainer;
    }

    private JPanel createApplicationFormPanel() {
        JPanel applicationFormPanel = new JPanel();
        applicationFormPanel.setLayout(new GridBagLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        JLabel companyNameLabel = new JLabel("Enter company name: ");
        companyNameTextField = new JTextField(40);
        companyNameTextField.setEditable(false);
        panel.add(companyNameLabel);
        panel.add(companyNameTextField);

        JLabel companyAddressLabel = new JLabel("Enter company address: ");
        companyAddressTextField = new JTextField(60);
        companyAddressTextField.setEditable(false);
        panel.add(companyAddressLabel);
        panel.add(companyAddressTextField);

        JLabel companyPhoneLabel = new JLabel("Enter company phone: ");
        companyPhoneTextField = new JTextField(20);
        companyPhoneTextField.setEditable(false);
        panel.add(companyPhoneLabel);
        panel.add(companyPhoneTextField);

        JLabel applicationDescriptionLabel = new JLabel("Enter application description: ");
        applicationDescriptionTextField = new JTextField(60);
        applicationDescriptionTextField.setEditable(false);
        panel.add(applicationDescriptionLabel);
        panel.add(applicationDescriptionTextField);

        JLabel applicationKeywordsLabel = new JLabel("Enter keywords describing your application");
        applicationKeywordsTextField = new JTextField(60);
        applicationKeywordsTextField.setEditable(false);
        panel.add(applicationKeywordsLabel);
        panel.add(applicationKeywordsTextField);
        
        JLabel areaLabel = new JLabel("Please selected preferred area: ");
        areaSelector = new JSpinner();
        areaSelector.setEnabled(false);
        panel.add(areaLabel);
        panel.add(areaSelector);

        JLabel invitationsLabel = new JLabel("Please select preferred number of invitations: ");
        invitationsSelector = new JSpinner();
        invitationsSelector.setEnabled(false);
        panel.add(invitationsLabel);
        panel.add(invitationsSelector);

        invalidFormLabel = new JLabel("");
        panel.add(invalidFormLabel);
        
        JButton submitApplicationButton = new JButton("Submit application");
        submitApplicationButton.addActionListener((ActionEvent e) -> {
            if (formDataIsValid()) {
                if (!submitFormData()) {
                    showErrorAlert();
                }
            }
        });

        applicationFormPanel.add(panel);

        return applicationFormPanel;
    }

    private void enableApplicationFormPanel() {
        companyNameTextField.setEditable(true);
        companyAddressTextField.setEditable(true);
        companyPhoneTextField.setEditable(true);
        applicationDescriptionTextField.setEditable(true);
        applicationKeywordsTextField.setEditable(true);
        areaSelector.setEnabled(true);
        invitationsSelector.setEnabled(true);
    }

    private boolean formDataIsValid() {
        if (companyNameTextField.getText() == null || companyNameTextField.getText().isEmpty()) {
            invalidFormLabel.setText("Invalid company name");
            return false;
        }
        else if (companyAddressTextField.getText() == null || companyAddressTextField.getText().isEmpty()) {
            invalidFormLabel.setText("Invalid company address");
            return false;
        }
        else if (companyPhoneTextField.getText() == null || companyPhoneTextField.getText().isEmpty()) {
            invalidFormLabel.setText("Invalid company phone");
            return false;
        }
        else if (applicationDescriptionTextField.getText() == null || applicationDescriptionTextField.getText().isEmpty()) {
            invalidFormLabel.setText("Invalid company phone");
            return false;
        }
        else if (applicationKeywordsTextField.getText() == null || applicationDescriptionTextField.getText().isEmpty()) {
            invalidFormLabel.setText("Invalid keywords");
            return false;
        }
        else {
            try {
                Integer.parseInt(areaSelector.getValue().toString());
            }
            catch (Exception e) {
                invalidFormLabel.setText("Invalid area");
                return false;
            }
            try {
                Integer.parseInt(invitationsSelector.getValue().toString());
            }
            catch (Exception e) {
                invalidFormLabel.setText("Invalid number of invites");
                return false;
            }
        }
        return true;
    }

    private boolean submitFormData() {
        String companyName = companyNameTextField.getText();
        String companyAddress = companyAddressTextField.getText();
        String companyPhone = companyPhoneTextField.getText();
        String applicationDescription = applicationDescriptionTextField.getText();
        String applicationKeywords = applicationKeywordsTextField.getText();
        int area, numberOfInvites;
        try {
            area = Integer.parseInt(areaSelector.getValue().toString());
            numberOfInvites = Integer.parseInt(invitationsSelector.getValue().toString());
        }
        catch (Exception e) {
            return false;
        }
        return applicationController.submitApplication(companyName, companyAddress, companyPhone, applicationDescription, applicationKeywords, area, numberOfInvites);
    }

    private void clearForm() {
        companyNameTextField.setText("");
        companyAddressTextField.setText("");
        companyPhoneTextField.setText("");
        applicationDescriptionTextField.setText("");
        applicationKeywordsTextField.setText("");
        areaSelector.setValue(0);
        invitationsSelector.setValue(0);
    }
    
    private void showErrorAlert() {
        JOptionPane.showMessageDialog(this, "Application coult not be submitted", "Error", JOptionPane.WARNING_MESSAGE);
    }
}
