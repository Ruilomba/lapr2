package lapr.project.ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import lapr.project.model.EventCenter;
import lapr.project.model.User;

public class UserRegistrationFrame extends JFrame {

    private final EventCenter eventCenter;
    private JLabel mainLabel;
    private JLabel nameLabel;
    private JTextField nameTextField;
    private JLabel usernameLabel;
    private JTextField usernameTextField;
    private JLabel emailLabel;
    private JTextField emailTextField;
    private JLabel passwordLabel;
    private JLabel passwordFormatLabel;
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
        nameLabel = new JLabel("Enter name");
        nameTextField = new JTextField(30);
        usernameLabel = new JLabel("Enter username");
        usernameTextField = new JTextField(20);
        emailLabel = new JLabel("Enter email");
        emailTextField = new JTextField(50);
        passwordLabel = new JLabel("Enter password");
        passwordFormatLabel = new JLabel("The user password must include at least a number, " +
            "both upper and lower case characters and a punctuation mark (“,”, “.”, “;”, “:” or “-“)");
        passwordTextField = new JTextField(25);
        confirmPasswordLabel = new JLabel("Confirm password");
        confirmPasswordTextField = new JTextField(25);
        submitFormButton = new JButton("Create User");
        errorMessageLabel = new JLabel();
    }

    private void addListenerForSubmitButton() {
        submitFormButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (formIsValid()) {
                submitForm();
                }
            }
        });
    }

    private boolean formIsValid() {
        String name = nameTextField.getText();
        String username = usernameTextField.getText();
        String email = emailTextField.getText();
        String password = passwordTextField.getText();
        String confirmPassword = confirmPasswordTextField.getText();
        
        CharSequence numberSequence = "1234567890";
        CharSequence punctuationMarksSequence;
        punctuationMarksSequence = ".,;:-";
        
        if (name == null || name.isEmpty()) {
            errorMessageLabel.setText("Name is invalid");
            return false;
        }
        else if (username == null || username.isEmpty()) {
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
        else if (!password.contains(numberSequence)) {
            errorMessageLabel.setText("The user password must include a number");
            return false;
        }
        else if (!password.matches(".*[A-Z].*") || !password.matches(".*[a-z].*")) {
            errorMessageLabel.setText("The password must include upper and lowercase characters");
            return false;
        }
        else if (!password.contains(punctuationMarksSequence)) {
            errorMessageLabel.setText("The user password must include a punctuation mark (“,”, “.”, “;”, “:” or “-“)");
            return false;
        }
        else if (!password.equals(confirmPassword)) {
            errorMessageLabel.setText("The passwords don't match");
            return false;
        }
        return true;
    }

    private boolean submitForm() {
        String name = nameTextField.getText();
        String username = usernameTextField.getText();
        String email = emailTextField.getText();
        String password = passwordTextField.getText();
        User createdUser = eventCenter.getUserRegistration().createUser();
        createdUser.setName(name);
        createdUser.setUsername(username);
        createdUser.setEmail(email);
        createdUser.setPassword(password);
        return true;
    }

    private void addElementsToContentPane() {
        add(mainLabel);
        add(nameLabel);
        add(nameTextField);
        add(usernameLabel);
        add(usernameTextField);
        add(emailLabel);
        add(emailTextField);
        add(passwordLabel);
        add(passwordFormatLabel);
        add(passwordTextField);
        add(confirmPasswordLabel);
        add(confirmPasswordTextField);
        add(submitFormButton);
    }
}
