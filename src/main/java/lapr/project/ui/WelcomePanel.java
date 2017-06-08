package lapr.project.ui;

import java.awt.*;
import java.io.IOException;
import javax.swing.*;

public class WelcomePanel extends JPanel {

    private static final long serialVersionUID = 1L;
    
    public WelcomePanel() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
        this.setLayout(new BorderLayout());
        
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridBagLayout());
        JLabel mainLabel = new JLabel("Exibition Fair Center Management Software");
        mainLabel.setFont(new Font(mainLabel.getFont().getName(), mainLabel.getFont().getStyle(), 25));
        labelPanel.add(mainLabel);
        this.add(labelPanel, BorderLayout.NORTH);
        
        JPanel authorsContainerPanel = new JPanel();
        authorsContainerPanel.setLayout(new GridBagLayout());
        JPanel authorsPanel = new JPanel();
        authorsPanel.setLayout(new GridLayout(0, 1));
        
        JLabel authors = new JLabel("Authors");
        authorsPanel.add(authors);
        JLabel author1 = new JLabel("Francisco Loureiro - 1100904");
        authorsPanel.add(author1);        
        JLabel author2 = new JLabel("Ines Martins - 1151037");
        authorsPanel.add(author2);
        JLabel author3 = new JLabel("José Teixeira - 1101240");
        authorsPanel.add(author3);
        JLabel author4 = new JLabel("Luis Barros - 1091237");
        authorsPanel.add(author4);
        JLabel author5 = new JLabel("Rui Lomba - 1151168");
        authorsPanel.add(author5);
        authorsContainerPanel.add(authorsPanel);
        this.add(authorsContainerPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }
}
