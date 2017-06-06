/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.model.Application;
import lapr.project.model.AtribuitionAlgorithm;
import lapr.project.model.AtribuitionList;
import lapr.project.model.Event;
import lapr.project.model.EventCenter;
import lapr.project.model.User;
import lapr.project.states.EventStateClosedApplications;

/**
 *
 * @author RuiSL
 */
public class AssingApplicationController {
    private final EventCenter eventCenter;
    private Application application;
    private Event event;
    
    public AssingApplicationController(EventCenter eventCenter){
        this.eventCenter=eventCenter;
    }
    
    public List<Event> getValidOrganizerEvents(String username){
        User u = eventCenter.getUserRegistration().getUserWithUsername(username);
        return eventCenter.getEventRegistration().getOrganizerEvents(u, new EventStateClosedApplications());
    }
    
    public void selectEvent(Event e){
        if ((this.event = eventCenter.getEventRegistration().getEvent(e)) == null) {
            System.out.println("No matching event");
            throw new NullPointerException();
        }
    }
    
    public List<AtribuitionAlgorithm> getAlgorithmList(){
        return eventCenter.getAlgorithmRegistration().getAlgorithmList();
    }
    
    public AtribuitionList selectAlgoritmo(AtribuitionAlgorithm a) {
        AtribuitionList atribuitionList= new AtribuitionList();
        atribuitionList = a.getAlgorithmAtribuitionList(event);
        return atribuitionList;
    }
    
    public void registerAtribuitions(AtribuitionList list) {
        event.setAtribuitionList(list);
    }
    
    public void registerApplicatin(Application a){
        this.application = a;
    }
    
}
