package lapr.project.ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import lapr.project.controller.ShowEventStandsInformationController;
import lapr.project.model.EventCenter;

/**
 *
 * @author Miguel Barros
 */
public class ShowEventStandsInformationUI extends JPanel {

    private static final long serialVersionUID = 1L;
    private EventCenter eventCenter;
    private final ShowEventStandsInformationController showStandsController;
    private final JList<String> standList;

    public ShowEventStandsInformationUI(EventCenter center, ShowEventStandsInformationController showStandsController) {
        this.eventCenter = center;
        this.showStandsController = showStandsController;
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        String[] standStrings = showStandsController.getStandAsStrings();
        standList = new JList<String>(standStrings);
        standList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        standList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        standList.setVisibleRowCount(10);
        JScrollPane listScroller = new JScrollPane(standList);
        listScroller.setPreferredSize(new Dimension(200, 200));
        this.add(listScroller);
        this.setVisible(true);
    }
}
