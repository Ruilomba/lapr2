/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import lapr.project.controller.SubmitApplicationController;
import lapr.project.model.EventCenter;

/**
 *
 * @author teixe
 */
public class SubmitApplicationUI extends JDialog {

    private final SubmitApplicationController submitApplicationController;

    private JPanel firstPanel;
    private CardLayout cardLayout;
    
    JTextArea informationLbl;

    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_HEIGHT = 300;
    private static int TOP_MARGIN = 20, INFERIOR_MARGIN = 20;
    private static int LEFT_MARGIN = 20, RIGHT_MARGIN = 20;

    public SubmitApplicationUI(JFrame p, EventCenter ec) {
        super(p, "Submit Application", true);
        this.submitApplicationController = new SubmitApplicationController(ec);

        firstPanel = createFirstPanel();
        add(firstPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setMinimumSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        setLocationRelativeTo(null);

    }

    private JPanel createFirstPanel() {
        cardLayout = new CardLayout();
        JPanel p = new JPanel(cardLayout);

        JPanel pageOne = createPageOne();

        p.add(pageOne);

        return p;
    }

    private JPanel createPageOne() {
        JPanel p = new JPanel(new BorderLayout());

        JPanel title = titleGenerate("Select the event to apply:");
        title.setBorder(BorderFactory.createEmptyBorder(TOP_MARGIN,
                LEFT_MARGIN, INFERIOR_MARGIN, RIGHT_MARGIN));

        JPanel pInformation = new JPanel();
        informationLbl = new JTextArea();
        informationLbl.setEditable(false);
        pInformation.add(informationLbl);

        p.add(title, BorderLayout.NORTH);
        p.add(pInformation);
//        p.add(btn, BorderLayout.SOUTH);

        return p;

    }

    private JPanel titleGenerate(String text) {
        JPanel p = new JPanel(new BorderLayout());
        p.add(new JLabel(text), BorderLayout.WEST);
        return p;
    }
}
