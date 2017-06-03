package lapr.project.ui;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import lapr.project.model.*;
import lapr.project.utils.*;

public class UserLoginUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private final EventCenter eventCenter;
    private JLabel mainLabel;
    private JLabel usernameOrEmailLabel;
    private JTextField usernameOrEmailTextField;
    private JLabel passwordLabel;
    private JTextField passwordTextField;
    private JButton submitFormButton;
    private JLabel errorMessageLabel;
    private JButton goToRegistrationButton;

    public UserLoginUI(EventCenter center) {
        super("User Authentication");
        eventCenter = center;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,1));
        this.add(panel);
        createElements();
        addListenersToButtons();
        addElementsToJPanel(panel);
        this.setVisible(true);
    }

    private void createElements() {
        mainLabel = new JLabel("Login");
        usernameOrEmailLabel = new JLabel("Enter username or email");
        usernameOrEmailTextField = new JTextField(20);
        passwordLabel = new JLabel("Enter password");
        passwordTextField = new JTextField(25);
        submitFormButton = new JButton("Login");
        errorMessageLabel = new JLabel();
        goToRegistrationButton = new JButton("Not registered yet?");
    }

    private void addListenersToButtons() {
        submitFormButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (formIsValid()) {
                    String usernameOrEmail = usernameOrEmailTextField.getText();
                    String password = passwordTextField.getText();
                    try {
                        if (AuthenticationService.loginUser(usernameOrEmail, password)) {
                            goToMenu();
                        }
                        else {
                            showErrorAlert();
                        }
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        goToRegistrationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goToRegistration();
            }
        });
    }

    private boolean formIsValid() {
        String usernameOrEmail = usernameOrEmailTextField.getText();
        String password = passwordTextField.getText();
        if (usernameOrEmail == null || usernameOrEmail.isEmpty()) {
            errorMessageLabel.setText("Username or email is invalid");
            return false;
        }
        else if (password == null || password.isEmpty()) {
            errorMessageLabel.setText("Email is invalid");
            return false;
        }
        return true;
    }

    private void addElementsToJPanel(JPanel panel) {
        panel.add(mainLabel);
        panel.add(usernameOrEmailLabel);
        panel.add(usernameOrEmailTextField);
        panel.add(passwordLabel);
        panel.add(passwordTextField);
        panel.add(submitFormButton);
        panel.add(goToRegistrationButton);
    }
    
    private void goToRegistration() {
        UserRegistrationUI registration;
        registration = new UserRegistrationUI(eventCenter);
        registration.setVisible(true);
        this.dispose();
    }
    
    private void showSuccessAlert() {
        JOptionPane.showMessageDialog(this, "User was registrated successfully", "Success", JOptionPane.PLAIN_MESSAGE);
    }

    private void showErrorAlert() {
        JOptionPane.showMessageDialog(this, "Login was unsuccessful, please check username and password", "Error", JOptionPane.WARNING_MESSAGE);
    }
    
    private void showErrorAlertWithMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.WARNING_MESSAGE);
    }
    
    private void goToMenu() {
        MenuUI menu = new MenuUI(eventCenter);
        menu.setVisible(true);
        this.dispose();
    }
}
