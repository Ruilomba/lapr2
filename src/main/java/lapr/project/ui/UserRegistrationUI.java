package lapr.project.ui;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import lapr.project.model.*;
import lapr.project.utils.AuthenticationService;

public class UserRegistrationUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private final EventCenter eventCenter;
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
    private JButton goToLoginButton;

    public UserRegistrationUI(EventCenter center) {
        super("User Registration");
        eventCenter = center;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,1));
        this.add(panel);
        createElements();
        addListenersForButtons();
        addElementsToJPanel(panel);
        this.setVisible(true);
    }

    private void createElements() {
        nameLabel = new JLabel("Enter name");
        nameLabel.setFont(new Font(nameLabel.getFont().getName(), nameLabel.getFont().getStyle(), 18));
        nameTextField = new JTextField(30);
        usernameLabel = new JLabel("Enter username");
        usernameLabel.setFont(new Font(usernameLabel.getFont().getName(), usernameLabel.getFont().getStyle(), 18));
        usernameTextField = new JTextField(20);
        emailLabel = new JLabel("Enter email");
        emailLabel.setFont(new Font(emailLabel.getFont().getName(), emailLabel.getFont().getStyle(), 18));
        emailTextField = new JTextField(50);
        passwordLabel = new JLabel("Enter password");
        passwordLabel.setFont(new Font(passwordLabel.getFont().getName(), passwordLabel.getFont().getStyle(), 18));
        passwordFormatLabel = new JLabel("The user password must include at least a number, " +
            "both upper and lower case characters and a punctuation mark (“,”, “.”, “;”, “:” or “-“)");
        passwordTextField = new JTextField(25);
        confirmPasswordLabel = new JLabel("Confirm password");
        confirmPasswordLabel.setFont(new Font(confirmPasswordLabel.getFont().getName(), confirmPasswordLabel.getFont().getStyle(), 18));
        confirmPasswordTextField = new JTextField(25);
        errorMessageLabel = new JLabel();
        errorMessageLabel.setForeground(Color.red);
        submitFormButton = new JButton("Create User");
        goToLoginButton = new JButton("Already registered?");
    }

    private void addListenersForButtons() {
        submitFormButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (formIsValid()) {
                    try {
                        registerUser();
                    } catch (IOException ex) {
                        showErrorAlertWithMessage(ex.getMessage());
                    }
                    saveUserCredentials();
                    goToMenu();                        
                }
            }
        });
        goToLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goToLogin();
            }
        });
    }

    private boolean formIsValid() {
        String name = nameTextField.getText();
        String username = usernameTextField.getText();
        String email = emailTextField.getText();
        String password = passwordTextField.getText();
        String confirmPassword = confirmPasswordTextField.getText();
        
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
            errorMessageLabel.setText("Password is invalid");
            return false;
        }
        else if (confirmPassword == null || confirmPassword.isEmpty()) {
            errorMessageLabel.setText("Confirm password is invalid");
            return false;
        }
        // TODO: not working
        else if (!password.matches(".*\\d+.*")) {
            errorMessageLabel.setText("The user password must include a number");
            return false;
        }
        else if (!password.matches(".*[A-Z].*") || !password.matches(".*[a-z].*")) {
            errorMessageLabel.setText("The password must include upper and lowercase characters");
            return false;
        }
        else if (!password.matches(".*\\p{Punct}.*")) {
            errorMessageLabel.setText("The user password must include a punctuation mark (“,”, “.”, “;”, “:” or “-“)");
            return false;
        }
        else if (!password.equals(confirmPassword)) {
            errorMessageLabel.setText("The passwords don't match");
            return false;
        }
        return true;
    }

    private boolean registerUser() throws IOException {
        UserRegistration userRegistration = eventCenter.getUserRegistration();
        String name = nameTextField.getText();
        String username = usernameTextField.getText();
        String email = emailTextField.getText();
        String password = passwordTextField.getText();
        User createdUser = userRegistration.createUser();
        createdUser.setName(name);
        createdUser.setUsername(username);
        createdUser.setEmail(email);
        createdUser.setPassword(password);
        return userRegistration.addUserRegistration(createdUser);
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
        panel.add(errorMessageLabel);
        panel.add(submitFormButton);
        panel.add(goToLoginButton);
    }
    
    private void showSuccessAlert() {
        JOptionPane.showMessageDialog(this, "User was registrated successfully", "Success", JOptionPane.PLAIN_MESSAGE);
    }

    private void showErrorAlertWithMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.WARNING_MESSAGE);
    }
    
    private void goToLogin() {
        UserLoginUI login = new UserLoginUI(eventCenter);
        login.setVisible(true);
        this.dispose();
    }
    
    private void saveUserCredentials() {
        AuthenticationService.setAuthenticatedUser(nameTextField.getText());
    }

    private void goToMenu() {
        MenuUI menu = new MenuUI(eventCenter);
        menu.setVisible(true);
        this.dispose();
    }
}
