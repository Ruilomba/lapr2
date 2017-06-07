/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.model.Application;
import lapr.project.model.Event;
import lapr.project.model.EventCenter;
import lapr.project.model.User;

/**
 *
 * @author RuiSL
 */
public class ChangeApplicationController {
    private final EventCenter eventCenter;
    private Application application;
    private Event event;

    
    public ChangeApplicationController(EventCenter eventCenter){
        this.eventCenter=eventCenter;
    }
    
    
    public List<Application> getApplicationsValidForSubmission(String username){
        User u= eventCenter.getUserRegistration().getUserWithUsername(username);
        return eventCenter.getEventRegistration().getApplicationsVaidForSubmission(u);
    }
    public void selectApplication(Application a){
        this.application=a;
        this.event=eventCenter.getEventRegistration().getEventOfApplication(a);
    }
    



    public void registerChange(Application ap){
        this.application=ap;
    }
}
