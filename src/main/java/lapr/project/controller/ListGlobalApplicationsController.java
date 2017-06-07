/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Application;
import lapr.project.model.EventCenter;

/**
 *
 * @author RuiSL
 */
public class ListGlobalApplicationsController {
    private final EventCenter eventCenter;
    
    public ListGlobalApplicationsController(EventCenter eventCenter){
        this.eventCenter=eventCenter;
    }
    
    public List<Application> getGlobalApplicationList(){
        return eventCenter.getEventRegistration().getGlobalApplicationList();
    }
    
    public String[] getApplicationsAsStrings() {
        List<Application> applications = getGlobalApplicationList();
        String[] data = new String[applications.size()];
        for (Application application : applications) {
            data[data.length] = application.getCompanyName() + " " + application.getAddress();
        }
        return data;
    }
}
