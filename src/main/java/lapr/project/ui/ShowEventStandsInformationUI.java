/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import lapr.project.controller.ShowEventStandInformationController;
import lapr.project.model.EventCenter;

/**
 *
 * @author Miguel Barros
 */
public class ShowEventStandsInformationUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private EventCenter eventCenter;
    private final ShowEventStandInformationController showStandsController;
    private final JList<String> standList;

    public ShowEventStandsInformationUI(EventCenter center, ShowEventStandInformationController showStandsController) {

        this.eventCenter = center;
        this.showStandsController = showStandsController;

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
        this.setLayout(new FlowLayout());

        String[] standStrings = showStandsController.getStandAsStrings();
        standList = new JList<String>(standStrings);
        standList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        standList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        standList.setVisibleRowCount(-1);
        JScrollPane listScroller = new JScrollPane(standList);
        listScroller.setPreferredSize(new Dimension(200, 200));

        this.add(standList);
        this.setVisible(true);
    }
}
