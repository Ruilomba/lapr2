package lapr.project.ui;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import lapr.project.controller.ChangeApplicationController;
import lapr.project.model.*;

/**
 *
 * @author RuiSL
 */
public class ChangeApplicationUI extends JPanel {

    private static final long serialVersionUID = 1L;
    private final EventCenter eventCenter;
    private final ChangeApplicationController changeController;
    private JList<String> applicationSelectionList;
    private JLabel selectedApplicationLabel;
    private Application selectedApplication;
    
    private JTextField companyNameTextField;
    private JTextField companyAddressTextField;
    private JTextField companyPhoneTextField;
    private JTextField applicationDescriptionTextField;
    private JTextField applicationKeywordsTextField;
    private JSpinner areaSelector;
    private JSpinner invitationsSelector;
    private JLabel invalidFormLabel;

    /**
     * 
     * @param eventCenter
     * @param changeController 
     */
    public ChangeApplicationUI(EventCenter eventCenter, ChangeApplicationController changeController) {
        this.eventCenter = eventCenter;
        this.changeController = changeController;
        this.setLayout(new GridLayout(0, 2));
        JPanel selectApplicationPanel = createSelectApplicationPanel();
        this.add(selectApplicationPanel);
        JPanel updateApplicationPanel = createApplicationFormPanel();
        this.add(updateApplicationPanel);
    }
    
    private JPanel createSelectApplicationPanel() {
        String userName = changeController.getAuthenticatedUserUsername();
        String[] applicationsListAsStrings = changeController.getApplicationsAsString(userName);
         
        JPanel container = new JPanel();
        container.setLayout(new GridBagLayout());
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(0, 1));
        JLabel listLabel = new JLabel("Please select Application");
        contentPanel.add(listLabel);

        selectedApplicationLabel = new JLabel("");
        selectedApplicationLabel.setVisible(false);

        applicationSelectionList = new JList<>(applicationsListAsStrings);
        applicationSelectionList.setVisibleRowCount(10);
        applicationSelectionList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        applicationSelectionList.setToolTipText("Please select one of the displayed applications");
        applicationSelectionList.addListSelectionListener((ListSelectionEvent e) -> {
            String selectedApplicationString = applicationSelectionList.getSelectedValue();
            selectedApplication = changeController.getApplication(selectedApplicationString);
            if (selectedApplication != null) {
                changeController.selectApplication(selectedApplication);
                selectedApplicationLabel.setText("Application chosen");
                selectedApplicationLabel.setVisible(true);                
                fillOutFormWithApplicationData();
                enableApplicationFormPanel();
            }
        });
        contentPanel.add(applicationSelectionList);
        contentPanel.add(selectedApplicationLabel);
        container.add(contentPanel);
        return container;
    }
    
    
    private JPanel createApplicationFormPanel() {
        JPanel container = new JPanel();
        container.setLayout(new GridBagLayout());

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(0, 1));

        JLabel companyNameLabel = new JLabel("Enter company name: ");
        companyNameTextField = new JTextField(40);
        companyNameTextField.setEditable(false);
        contentPanel.add(companyNameLabel);
        contentPanel.add(companyNameTextField);

        JLabel companyAddressLabel = new JLabel("Enter company address: ");
        companyAddressTextField = new JTextField(60);
        companyAddressTextField.setEditable(false);
        contentPanel.add(companyAddressLabel);
        contentPanel.add(companyAddressTextField);

        JLabel companyPhoneLabel = new JLabel("Enter company phone: ");
        companyPhoneTextField = new JTextField(20);
        companyPhoneTextField.setEditable(false);
        contentPanel.add(companyPhoneLabel);
        contentPanel.add(companyPhoneTextField);

        JLabel applicationDescriptionLabel = new JLabel("Enter application description: ");
        applicationDescriptionTextField = new JTextField(60);
        applicationDescriptionTextField.setEditable(false);
        contentPanel.add(applicationDescriptionLabel);
        contentPanel.add(applicationDescriptionTextField);

        JLabel applicationKeywordsLabel = new JLabel("Enter keywords describing your application");
        applicationKeywordsTextField = new JTextField(60);
        applicationKeywordsTextField.setEditable(false);
        contentPanel.add(applicationKeywordsLabel);
        contentPanel.add(applicationKeywordsTextField);
        
        JLabel areaLabel = new JLabel("Please selected preferred area: ");
        areaSelector = new JSpinner();
        areaSelector.setEnabled(false);
        contentPanel.add(areaLabel);
        contentPanel.add(areaSelector);

        JLabel invitationsLabel = new JLabel("Please select preferred number of invitations: ");
        invitationsSelector = new JSpinner();
        invitationsSelector.setEnabled(false);
        contentPanel.add(invitationsLabel);
        contentPanel.add(invitationsSelector);

        invalidFormLabel = new JLabel("");
        contentPanel.add(invalidFormLabel);
        
        JButton submitApplicationButton = new JButton("Update application");
        submitApplicationButton.addActionListener((ActionEvent e) -> {
            if (formDataIsValid()) {
                if (!updateFormData()) {
                    showErrorAlert();
                }
            }
        });
        contentPanel.add(submitApplicationButton);
        
        JButton removeApplicationButton = new JButton("Remove application");
        submitApplicationButton.addActionListener((ActionEvent e) -> {
            // TODO: COMPLETE
        });
        contentPanel.add(removeApplicationButton);
        
        container.add(contentPanel);
        return container;
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

    // TODO: COMPLETE
    private boolean updateFormData() {
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
        return changeController.updateApplicationData(companyName, companyAddress, companyPhone, applicationDescription, applicationKeywords, area, numberOfInvites);
    }

    private void fillOutFormWithApplicationData() {
        companyNameTextField.setText(selectedApplication.getCompanyName());
        companyAddressTextField.setText(selectedApplication.getAddress());
        companyPhoneTextField.setText(selectedApplication.getPhone());
        //applicationDescriptionTextField.setText(selectedApplication.getDescription());
        //applicationKeywordsTextField.setText(selectedApplication.getKeywordList());
        areaSelector.setValue(selectedApplication.getIntendedBoothArea());
        invitationsSelector.setValue(selectedApplication.getInvitation());
    }
    
    private void showErrorAlert() {
        JOptionPane.showMessageDialog(this, "Application coult not be altered", "Error", JOptionPane.WARNING_MESSAGE);
    }
}
