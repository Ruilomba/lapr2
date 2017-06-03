package lapr.project.ui;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import lapr.project.controller.*;
import lapr.project.model.*;
import lapr.project.utils.DataValidationService;

public class UserDataUpdateUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private final EventCenter eventCenter;
    private final UserDataUpdateController controller;

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

    public UserDataUpdateUI(EventCenter center) {
        super("User Registration");
        eventCenter = center;
        controller = new UserDataUpdateController(eventCenter);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));
        this.add(panel);
        createElements();
        addListenersForButtons();
        addElementsToJPanel(panel);
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
        errorMessageLabel.setForeground(Color.red);
    }

    private void addListenersForButtons() {
        submitFormButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (formIsValid()) {
                    try {
                        updateUserData();
                    } catch (IOException ex) {
                        showErrorAlertWithMessage(ex.getMessage());
                    }
                    showSuccessAlert();
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

    private boolean updateUserData() throws IOException {
        String name = nameTextField.getText();
        String username = usernameTextField.getText();
        String email = emailTextField.getText();
        String password = passwordTextField.getText();
        return controller.updateUserData(name, username, email, password);
    }

    private void addElementsToJPanel(JPanel panel) {
        panel.add(nameLabel);
        panel.add(nameTextField);
        panel.add(usernameLabel);
        panel.add(usernameTextField);
        panel.add(emailLabel);
        panel.add(emailTextField);
        panel.add(passwordLabel);
        panel.add(passwordFormatLabel);
        panel.add(passwordTextField);
        panel.add(confirmPasswordLabel);
        panel.add(confirmPasswordTextField);
        panel.add(submitFormButton);
        panel.add(errorMessageLabel);
    }

    private void showSuccessAlert() {
        JOptionPane.showMessageDialog(this, "User was registrated successfully", "Success", JOptionPane.PLAIN_MESSAGE);
    }

    private void showErrorAlertWithMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.WARNING_MESSAGE);
    }
}
