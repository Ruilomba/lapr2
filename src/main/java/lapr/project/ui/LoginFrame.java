package lapr.project.ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
import lapr.project.model.EventCenter;
import lapr.project.utils.AuthenticationService;

public class LoginFrame extends JFrame {

    private static final long serialVersionUID = 1L;
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
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,1));
        this.add(panel);
        createElements();
        addListenerForSubmitButton();
        addElementsToJPanel(panel);
        this.setVisible(true);
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
                    try {
                        if (AuthenticationService.loginUser(username, password)) {
                            // TODO: send success message to user
                        }
                    } catch (IOException e1) {
                        e1.printStackTrace();
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

    private void addElementsToJPanel(JPanel panel) {
        panel.add(mainLabel);
        panel.add(usernameLabel);
        panel.add(usernameTextField);
        panel.add(passwordLabel);
        panel.add(passwordTextField);
    }
}
