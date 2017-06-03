/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Event;
import lapr.project.model.EventCenter;
import lapr.project.model.FAE;
import lapr.project.model.User;
import lapr.project.states.EventCreatedState;
import lapr.project.states.EventStateDefinedFAE;

/**
 *
 * @author RuiSL
 */
public class DefineFAEController {
    private final EventCenter eventCenter;
    private Event event;
    private FAE fae;
    
    
    public DefineFAEController(EventCenter eventCenter){
        this.eventCenter=eventCenter;
    }
    
    public List<Event> getOrganizerEvents(String username){
        User u = eventCenter.getUserRegistration().getUser(username);
        return eventCenter.getEventRegistration().getOrganizerEvents(u);       
    }
    public void selectEvent(Event e){
        if((this.event=eventCenter.getEventRegistration().getEvent(e))==null){
            System.out.println("No matching event");
            throw new NullPointerException();
        }
    }
    public List<User> getUserList(){
        return eventCenter.getUserRegistration().getUserList();
    }
    
    public FAE newFAE(User u){
        FAE fae=event.getFaeList().newFAE();
        fae.setUser(u);
        return fae;
    }
    
    public boolean registerFae(FAE fae){
        if(!event.getFaeList().hasFAE(fae.getUser())){
            return event.getFaeList().registerFAEMember(fae);
        }
        return false;
    }
    
    public boolean setEventStateToDefinedFae(){
        if(event.getEventState() instanceof EventCreatedState){
            event.setEventState(new EventStateDefinedFAE());
            return true;
        }
        return false;
    }
    
}
