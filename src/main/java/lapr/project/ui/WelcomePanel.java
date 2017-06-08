package lapr.project.ui;

import java.awt.*;
import java.io.IOException;
import javax.swing.*;

public class WelcomePanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private final JLabel mainLabel;
    private final JLabel author1;
    private final JLabel author2;
    private final JLabel author3;
    private final JLabel author4;
    private final JLabel author5;
    
    public WelcomePanel() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
        this.setLayout(new BorderLayout());
        
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridBagLayout());
        mainLabel = new JLabel("Exibition Fair Center Management Software");
        mainLabel.setFont(new Font(mainLabel.getFont().getName(), mainLabel.getFont().getStyle(), 25));
        labelPanel.add(mainLabel);
        this.add(labelPanel, BorderLayout.NORTH);
        
        JPanel authorsContainerPanel = new JPanel();
        authorsContainerPanel.setLayout(new GridBagLayout());
        JPanel authorsPanel = new JPanel();
        authorsPanel.setLayout(new GridLayout(0, 1));
        author1 = new JLabel("Author name 1 + number");
        authorsPanel.add(author1);        
        author2 = new JLabel("Author name 2 + number");
        authorsPanel.add(author2);
        author3 = new JLabel("Author name 3 + number");
        authorsPanel.add(author3);
        author4 = new JLabel("Author name 4 + number");
        authorsPanel.add(author4);
        author5 = new JLabel("Author name 5 + number");
        authorsPanel.add(author5);
        authorsContainerPanel.add(authorsPanel);
        this.add(authorsContainerPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }
}
