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
import lapr.project.model.FAERating;
import lapr.project.model.Keyword;
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
    public String[] getApplicationsAsString(String username){
        List<Application> applicationList=getApplicationsValidForSubmission(username);
        String[] applicationAsString= new String[applicationList.size()];
        for(Application a : applicationList){
            Event e=eventCenter.getEventRegistration().getEventOfApplication(a);
            applicationAsString[applicationAsString.length]=a.toString()+". from event "+e.getEventDescription();
        }
        return applicationAsString;
    }
    
    public Application getApplication(String applicationAsString){
        String[]msg= applicationAsString.trim().split(".");
        String applicationString=msg[0];
        List<Application> applicationList= eventCenter.getEventRegistration().getGlobalApplicationList();
        for(Application a : applicationList){
            if(a.toString().equalsIgnoreCase(applicationString)){
                return a;
            }
        }
        return null;
    }
    
    public Application newApplication(List<FAERating> ratings, String description, 
                List<Keyword> keywordList, String adress, String companyName, 
                int intendedBoothArea, int inviatation,String phone){
        return eventCenter.getApplicationRegistration().newApplication(ratings, description, keywordList, adress, companyName, intendedBoothArea, inviatation, phone);
    }



    public void registerChange(Application ap){
        this.application=ap;
    }
}
