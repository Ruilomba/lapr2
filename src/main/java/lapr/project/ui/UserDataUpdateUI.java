package lapr.project.ui;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import lapr.project.controller.*;
import lapr.project.model.*;
import lapr.project.utils.DataValidationService;

public class UserDataUpdateUI extends JPanel {

    private static final long serialVersionUID = 1L;
    private final EventCenter eventCenter;
    private final UserDataUpdateController userUpdateController;

    private JLabel nameLabel;
    private JTextField nameTextField;
    private JLabel usernameLabel;
    private JTextField usernameTextField;
    private JLabel emailLabel;
    private JTextField emailTextField;
    private JLabel changePasswordLabel;
    private JLabel passwordLabel;
    private JLabel passwordFormatLabel;
    private JTextField passwordTextField;
    private JLabel confirmPasswordLabel;
    private JTextField confirmPasswordTextField;
    private JButton submitFormButton;
    private JLabel errorMessageLabel;

    public UserDataUpdateUI(EventCenter center, UserDataUpdateController controller) {
        eventCenter = center;
        userUpdateController = controller;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
        this.setLayout(new GridLayout(0, 1));
        createElements();
        addUserDataToForm();
        addListenersForButtons();
        addElementsToJPanel();
        this.setVisible(true);
    }

    private void createElements() {
        nameLabel = new JLabel("Name");
        nameLabel.setFont(new Font(nameLabel.getFont().getName(), nameLabel.getFont().getStyle(), 18));
        nameTextField = new JTextField(30);
        usernameLabel = new JLabel("Username");
        usernameLabel.setFont(new Font(usernameLabel.getFont().getName(), usernameLabel.getFont().getStyle(), 18));
        usernameTextField = new JTextField(20);
        emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font(emailLabel.getFont().getName(), emailLabel.getFont().getStyle(), 18));
        emailTextField = new JTextField(50);
        changePasswordLabel = new JLabel("Update password");
        passwordLabel = new JLabel("Enter password");
        passwordLabel.setFont(new Font(passwordLabel.getFont().getName(), passwordLabel.getFont().getStyle(), 18));
        passwordFormatLabel = new JLabel("The user password must include at least a number, "
                + "both upper and lower case characters and a punctuation mark (“,”, “.”, “;”, “:” or “-“)");
        passwordTextField = new JTextField(25);
        confirmPasswordLabel = new JLabel("Confirm password");
        confirmPasswordLabel.setFont(new Font(confirmPasswordLabel.getFont().getName(), confirmPasswordLabel.getFont().getStyle(), 18));
        confirmPasswordTextField = new JTextField(25);
        submitFormButton = new JButton("Update data");
        errorMessageLabel = new JLabel("");
        errorMessageLabel.setForeground(Color.red);
    }

    private void addUserDataToForm() {
        /*
        User userData = userUpdateController.getCurrentUserData();
        nameTextField.setText(userData.getName());
        usernameTextField.setText(userData.getUsername());
        emailTextField.setText(userData.getEmail());
        */
    }

    private void addListenersForButtons() {
        submitFormButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (formIsValid()) {
                    try {
                        if (updateUserData()) {
                            showSuccessAlert();
                        }
                        else {
                            showErrorAlert();
                        }
                    } catch (IOException ex) {
                        showErrorAlertWithMessage(ex.getMessage());
                    }
                }
            }
        });
    }

    private boolean formIsValid() {
        String email = emailTextField.getText();
        String password = passwordTextField.getText();
        String confirmPassword = confirmPasswordTextField.getText();

        if (email != null && !email.isEmpty()) {
            if (!DataValidationService.emailIsValid(email)) {
                errorMessageLabel.setText("Email is invalid");
                return false;
            }
        } else if (password != null && password.isEmpty()) {
            if (confirmPassword == null || confirmPassword.isEmpty()) {
                errorMessageLabel.setText("Confirm password is invalid");
                return false;
            } else if (!password.matches(".*\\d+.*")) {
                errorMessageLabel.setText("The user password must include a number");
                return false;
            } else if (!password.matches(".*[A-Z].*") || !password.matches(".*[a-z].*")) {
                errorMessageLabel.setText("The password must include upper and lowercase characters");
                return false;
            } else if (!password.matches(".*\\p{Punct}.*")) {
                errorMessageLabel.setText("The user password must include a punctuation mark (“,”, “.”, “;”, “:” or “-“)");
                return false;
            } else if (!password.equals(confirmPassword)) {
                errorMessageLabel.setText("The passwords don't match");
                return false;
            }
        }
        return true;
    }

    private void addElementsToJPanel() {
        this.add(nameLabel);
        this.add(nameTextField);
        this.add(usernameLabel);
        this.add(usernameTextField);
        this.add(emailLabel);
        this.add(emailTextField);
        this.add(passwordLabel);
        this.add(passwordFormatLabel);
        this.add(passwordTextField);
        this.add(confirmPasswordLabel);
        this.add(confirmPasswordTextField);
        this.add(submitFormButton);
        this.add(errorMessageLabel);
    }

    private boolean updateUserData() throws IOException {
        String name = nameTextField.getText();
        String username = usernameTextField.getText();
        String email = emailTextField.getText();
        String password = passwordTextField.getText();
        return userUpdateController.updateUserData(name, username, email, password);
    }
    
    private void showSuccessAlert() {
        JOptionPane.showMessageDialog(this, "User data was updates successfully", "Success", JOptionPane.PLAIN_MESSAGE);
    }

    private void showErrorAlert() {
        JOptionPane.showMessageDialog(this, "User info could not be updated", "Error", JOptionPane.WARNING_MESSAGE);
    }
    
    private void showErrorAlertWithMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.WARNING_MESSAGE);
    }
}
