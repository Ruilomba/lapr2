package lapr.project.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.*;
import lapr.project.controller.SubmitApplicationController;
import lapr.project.model.Event;
import lapr.project.model.EventCenter;

/**
 *
 * @author teixe
 */

public class SubmitApplicationUI extends JPanel {

    public static final long serialVersionUID = 1L;
    private final SubmitApplicationController submitApplicationController;
    private final JPanel firstPanel;
    private CardLayout cardLayout;
    //private JList eventList;
    private JTextArea informationLbl;
    private static int TOP_MARGIN = 20, INFERIOR_MARGIN = 20;
    private static int LEFT_MARGIN = 20, RIGHT_MARGIN = 20;

    public SubmitApplicationUI(JFrame p, EventCenter ec) {
        this.submitApplicationController = new SubmitApplicationController(ec);
        firstPanel = createFirstPanel();
        this.add(firstPanel);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
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
        /*
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
        */
        JPanel p = new JPanel(new BorderLayout());
        //p.add(eventList, BorderLayout.CENTER);
        return p;
    }

    private JPanel createBtnPanelPageOne() {
        JPanel p = new JPanel();
        JButton btnNext = CreateBtnNext();
        p.add(btnNext);
        return p;
    }

    private JButton CreateBtnNext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    public void run(){
        List<Event> el = submitApplicationController.getEventListInSubmissionPeriod();
        //eventList.setListData(el.toArray());
        setVisible(true);
    }
}