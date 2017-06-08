package lapr.project.ui;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import lapr.project.controller.*;
import lapr.project.model.*;
import lapr.project.utils.DataValidationService;

public class WelcomePanel extends JPanel {

    private static final long serialVersionUID = 1L;

    public WelcomePanel() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
        this.setLayout(new GridLayout(0, 1));
        JLabel mainLabel = new JLabel("Welcome to the jungle");
        mainLabel.setFont(new Font(mainLabel.getFont().getName(), mainLabel.getFont().getStyle(), 25));
        this.add(mainLabel);
        this.setVisible(true);
    }
}
