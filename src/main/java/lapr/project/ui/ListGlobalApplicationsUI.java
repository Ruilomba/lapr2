/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.awt.*;
import java.util.*;
import static java.util.Collections.list;
import javax.swing.*;
import javax.swing.*;
import lapr.project.controller.*;
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
    private final JList<String> applicationsList;
            
    public ListGlobalApplicationsUI(EventCenter center, ListGlobalApplicationsController controller){
       this.eventCenter = center;
       this.controller = controller;

       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
       this.setSize(screenSize.width, screenSize.height);
       this.setLayout(new FlowLayout());
       
       String[] applicationStrings = controller.getApplicationsAsStrings();
       applicationsList = new JList<String>(applicationStrings);
       applicationsList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
       applicationsList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
       applicationsList.setVisibleRowCount(-1);
       JScrollPane listScroller = new JScrollPane(applicationsList);
       listScroller.setPreferredSize(new Dimension(200, 200));
       
       this.add(applicationsList);
       this.setVisible(true);
    }
}
