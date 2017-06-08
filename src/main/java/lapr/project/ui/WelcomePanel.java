package lapr.project.ui;

import java.awt.*;
import java.io.IOException;
import javax.swing.*;

public class WelcomePanel extends JPanel {

    private static final long serialVersionUID = 1L;

    public WelcomePanel() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
        this.setLayout(new GridBagLayout());
        JLabel mainLabel = new JLabel("Exibition Fair Center Management Software");
        mainLabel.setAlignmentX(CENTER_ALIGNMENT);
        mainLabel.setAlignmentY(CENTER_ALIGNMENT);
        mainLabel.setFont(new Font(mainLabel.getFont().getName(), mainLabel.getFont().getStyle(), 25));
        this.add(mainLabel);
        this.setVisible(true);
    }
}
