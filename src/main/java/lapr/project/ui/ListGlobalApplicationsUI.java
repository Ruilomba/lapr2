/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import lapr.project.controller.ListGlobalApplicationsController;
import lapr.project.controller.UserRegistrationController;
import lapr.project.model.EventCenter;

/**
 *
 * @author RuiSL
 */
public class ListGlobalApplicationsUI extends JPanel{
    private static final long serialVersionUID = 1L;
    private final EventCenter eventCenter;
    private final ListGlobalApplicationsController controller;
            
    public ListGlobalApplicationsUI(EventCenter eventCenter,ListGlobalApplicationsController controller){
       this.eventCenter=eventCenter;
       this.controller=controller;
    }
}
