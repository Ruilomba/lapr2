/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import lapr.project.controller.SubmitApplicationController;
import lapr.project.model.Event;
import lapr.project.model.EventCenter;

/**
 *
 * @author teixe
 */
public class SubmitApplicationUI extends JDialog {

    private final SubmitApplicationController submitApplicationController;

    private JPanel firstPanel;
    private CardLayout cardLayout;
    private JList eventList;

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
        this.setVisible(true);

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

        JPanel list = createEventListPanel();
        list.setBorder(BorderFactory.createEmptyBorder(0,
                LEFT_MARGIN, 0, RIGHT_MARGIN));
        p.add(list, BorderLayout.CENTER);

        JPanel btn = createBtnPanelPageOne();
        btn.setBorder(BorderFactory.createEmptyBorder(TOP_MARGIN, LEFT_MARGIN, INFERIOR_MARGIN, RIGHT_MARGIN));

        p.add(title, BorderLayout.NORTH);
        p.add(btn, BorderLayout.SOUTH);

        return p;

    }

    private JPanel titleGenerate(String text) {
        JPanel p = new JPanel(new BorderLayout());
        p.add(new JLabel(text), BorderLayout.WEST);
        return p;
    }

    private JPanel createEventListPanel() {
        eventList = new JList();
        eventList.setVisibleRowCount(10);
        eventList.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus
            ) {
                Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                if (renderer instanceof JLabel) {
                    ((JLabel) renderer).setText(((Event) value).getTitle());
                }
                return renderer;
            }
        });
        JPanel p = new JPanel(new BorderLayout());
        p.add(eventList, BorderLayout.CENTER);
        return p;

    }

    private JPanel createBtnPanelPageOne() {
        JPanel p = new JPanel();

        JButton btnNext = CreateBtnNext();
        JButton btnCancel = CreateBtnCancel();

        p.add(btnCancel);
        p.add(btnNext);
        return p;
    }

    private JButton CreateBtnCancel() {
              JButton btn = new JButton("Cancel");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
            }
        });

        return btn;
    }

    private JButton CreateBtnNext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public void run(){
        List<Event> el = submitApplicationController.getEventListInSubmissionPeriod();
        eventList.setListData(el.toArray());
        setVisible(true);
    }
}
