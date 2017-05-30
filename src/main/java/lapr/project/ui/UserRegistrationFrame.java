package lapr.project.ui;

import java.awt.FlowLayout;
import javax.swing.*;
import lapr.project.model.EventCenter;
import lapr.project.model.User;

public class UserRegistrationFrame extends JFrame {

    private final EventCenter eventCenter;
    private JLabel mainLabel;
    private JLabel nameLabel;
    private JTextField nameTextField;
    private JLabel emailLabel;
    private JTextField emailTextField;
    private JLabel passwordLabel;
    private JTextField passwordTextField;
    private JLabel confirmPasswordLabel;
    private JTextField confirmPasswordTextField;
    private JButton submitFormButton;
    private JLabel errorMessageLabel;

    public UserRegistrationFrame(EventCenter center) {
        super("User Registration");
        eventCenter = center;
        setSize(150, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        createElements();
        addListenerForSubmitButton();
        addElementsToContentPane();
    }

    private void createElements() {
        mainLabel = new JLabel("User Registration");
        nameLabel = new JLabel("Enter username");
        nameTextField = new JTextField(20);
        emailLabel = new JLabel("Enter email");
        emailTextField = new JTextField(50);
        passwordLabel = new JLabel("Enter password");
        passwordTextField = new JTextField(25);
        confirmPasswordLabel = new JLabel("Confirm password");
        confirmPasswordTextField = new JTextField(25);
        errorMessageLabel = new JLabel();
    }

    private void addListenerForSubmitButton() {
        submitFormButton.addActionListener((java.awt.event.ActionEvent e) -> {
            if (formIsValid()) {
                submitForm();
            }
        });
    }

    private boolean formIsValid() {
        String name = nameTextField.getText();
        String email = emailTextField.getText();
        String password = passwordTextField.getText();
        String confirmPassword = confirmPasswordTextField.getText();
        if (name == null || name.isEmpty()) {
            errorMessageLabel.setText("Username is invalid");
            return false;
        }
        else if (email == null || email.isEmpty()) {
            errorMessageLabel.setText("Email is invalid");
            return false;
        }
        else if (password == null || password.isEmpty()) {
            errorMessageLabel.setText("Email is invalid");
            return false;
        }
        else if (confirmPassword == null || confirmPassword.isEmpty()) {
            errorMessageLabel.setText("Confirm password is invalid");
            return false;
        }
        else {
            return true;
        }
    }

    private boolean submitForm() {
        String name = nameTextField.getText();
        String email = emailTextField.getText();
        String password = passwordTextField.getText();
        String confirmPassword = confirmPasswordTextField.getText();
        User createdUser = eventCenter.getUserRegistration().createUser();
        // todo: conitnue
        createdUser.setName(name);
        createdUser.setEmail(email);
        return true;
    }

    private void addElementsToContentPane() {
        add(mainLabel);
        add(nameLabel);
        add(nameTextField);
        add(emailLabel);
        add(emailTextField);
        add(passwordLabel);
        add(passwordTextField);
        add(confirmPasswordLabel);
        add(confirmPasswordTextField);
    }
}
