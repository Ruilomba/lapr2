/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.model.Atribuition;
import lapr.project.model.AtribuitionRegistration;
import lapr.project.model.Event;
import lapr.project.model.EventCenter;
import lapr.project.model.EventRegistration;
import lapr.project.model.FAE;
import lapr.project.model.User;

/**
 *
 * @author teixe
 */
public class DecideApplicationController {
    
    
    private final EventCenter eventCenter;
    private Event event;
    
    private EventRegistration eventRegistration;
    private List<Event> FaeEventList;
    private AtribuitionRegistration atribuitionRegistration;
    private List<Atribuition> atribuitionListToEvaluate;
    
    
    public DecideApplicationController(EventCenter eventCenter){
        this.eventCenter = eventCenter;
    }
    
        /**
     * Select the desired event
     *
     * @param e
     * @throws EventoException
     */
    public void selectEvent(Event e) {
        if ((this.event = eventCenter.getEventRegistration().getEvent(e)) == null) {
            System.out.println("No matching event");
            throw new NullPointerException();
        }
    }
    
    public List<Event> getFaeEvents(User u){
        this.eventRegistration = this.eventCenter.getEventRegistration();
        this.FaeEventList = this.eventRegistration.getEventListOfFae(u);
        return FaeEventList;
    };
    
    public List<Atribuition> getListAtribuitionToEvaluate(FAE fae){
        this.atribuitionRegistration = this.event.getAtribuitionList();
        this.atribuitionListToEvaluate = this.atribuitionRegistration.getAtribuitionListOfFae(fae);
        return atribuitionListToEvaluate;
    }
}
