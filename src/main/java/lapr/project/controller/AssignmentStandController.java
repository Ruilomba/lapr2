/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lapr.project.model.EventCenter;
import lapr.project.model.EventRegistration;
import lapr.project.model.StandRegistration;
import lapr.project.model.*;


/**
 *
 * @author Miguel Barros
 */
public class AssignmentStandController implements Serializable{
    private static final long serialVersionUID =1L;
    private EventCenter eventCenter;
    private EventRegistration eventRegistration;
    private ApplicationRegistration appRegistration;
    private StandRegistration stdRegistration;
    private Event event;
    
    public AssignmentStandController (EventCenter eventCenter) {
        this.eventCenter = eventCenter;
        this.eventRegistration = eventCenter.getEventRegistration();
        this.stdRegistration = eventCenter.getStandRegistration();
    }

    public void getEventList(Organizer o){
        List<Event> eventlist = new ArrayList<Event>();
        eventRegistration = eventCenter.getEventRegistration();
        eventRegistration.getEventDecideList(o);
    }
    
        public void setEvent(Event e){
            
            this.event = e;
            eventRegistration = eventCenter.getEventRegistration();
            eventRegistration.getEventDecideList(null);
            this.appRegistration=event.getApplicationRegistration();
        }   
            
        public ArrayList<Stand> getStandList(){
            
            stdRegistration = eventCenter.getStandRegistration();
            return stdRegistration.getListStands();
                
        }
            
}
            
            
                
           
    
     