package lapr.project.ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import lapr.project.model.EventCenter;
import lapr.project.utils.AuthenticationService;

public class LoginFrame extends JFrame {

    private final EventCenter eventCenter;
    private JLabel mainLabel;
    private JLabel usernameLabel;
    private JTextField usernameTextField;
    private JLabel passwordLabel;
    private JTextField passwordTextField;
    private JButton submitFormButton;
    private JLabel errorMessageLabel;

    public LoginFrame(EventCenter center) {
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
        mainLabel = new JLabel("Login");
        usernameLabel = new JLabel("Enter username");
        usernameTextField = new JTextField(20);
        passwordLabel = new JLabel("Enter password");
        passwordTextField = new JTextField(25);
        submitFormButton = new JButton("Login");
        errorMessageLabel = new JLabel();
    }

    private void addListenerForSubmitButton() {
        submitFormButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (formIsValid()) {
                    String username = usernameTextField.getText();
                    String password = passwordTextField.getText();
                    if (AuthenticationService.loginUser(username, password)) {
                        // TODO: send success message to user
                    }
                }
            }
        });
    }

    private boolean formIsValid() {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();
        if (username == null || username.isEmpty()) {
            errorMessageLabel.setText("Username is invalid");
            return false;
        }
        else if (password == null || password.isEmpty()) {
            errorMessageLabel.setText("Email is invalid");
            return false;
        }
        return true;
    }

    private void addElementsToContentPane() {
        add(mainLabel);
        add(usernameLabel);
        add(usernameTextField);
        add(passwordLabel);
        add(passwordTextField);
    }
}
