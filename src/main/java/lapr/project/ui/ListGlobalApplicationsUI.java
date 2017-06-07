/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import lapr.project.controller.ListGlobalApplicationsController;
import lapr.project.controller.UserRegistrationController;
import lapr.project.model.Application;
import lapr.project.model.EventCenter;

/**
 *
 * @author RuiSL
 */
public class ListGlobalApplicationsUI extends JPanel {

    private static final long serialVersionUID = 1L;
    private final EventCenter eventCenter;
    private final ListGlobalApplicationsController controller;
    private JList applicationsList;
            
    public ListGlobalApplicationsUI(EventCenter eventCenter, ListGlobalApplicationsController controller){
       this.eventCenter = eventCenter;
       this.controller = controller;
       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
       this.setSize(screenSize.width, screenSize.height);
       this.setLayout(new FlowLayout());
       
       String[] applicationStrings = controller.getApplicationsAsStrings();
       applicationsList = new JList(applicationStrings);
       applicationsList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
       applicationsList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
       applicationsList.setVisibleRowCount(-1);
       JScrollPane listScroller = new JScrollPane(applicationsList);
       listScroller.setPreferredSize(new Dimension(200, 200));
       
       this.add(listScroller);
       this.setVisible(true);
    }
}
