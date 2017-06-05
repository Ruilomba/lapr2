/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.awt.Event;
import java.io.Serializable;
import java.util.ArrayList;
import lapr.project.model.EventCenter;
import lapr.project.model.EventRegistration;
import lapr.project.model.StandRegistration;
import lapr.project.model.*;


/**
 *
 * @author Miguel Barros
 */
public class AssignmentStandController implements Serializable{
    
    private EventCenter eventCenter;
    private EventRegistration eventRegistration;
    private ApplicationRegistration appRegistration;
    private StandRegistration stdRegistration;
    private Event event;
    
    public AssignmentStandController (EventCenter eventCenter) {
        this.eventCenter = eventCenter;
        this.eventRegistration = eventCenter.getEventRegistration();
        this.appRegistration = eventCenter.getApplicationRegistration();
        this.stdRegistration = eventCenter.getStandRegistration();
    }
        
    
    
    public void getEventList(Organizer o){
        ArrayList<Event> eventlist = new ArrayList();
        eventRegistration = eventCenter.getEventRegistration();
        eventRegistration.getEventDecideList(o);
        
    }
    
        public void setEvent(Event e){
            
            this.event = e;
            eventRegistration = eventCenter.getEventRegistration();
            eventRegistration.getEventDecideList(null);
          
        }   
            
        public ArrayList<Stand> getStandList(){
            
            stdRegistration = eventCenter.getStandRegistration();
            return stdRegistration.getListStands();
                
        }
            
}
            
            
                
           
    
     