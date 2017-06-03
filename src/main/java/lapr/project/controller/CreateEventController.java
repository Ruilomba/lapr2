/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.EventCenter;
import lapr.project.model.Event;
import lapr.project.model.Organizer;
import lapr.project.model.OrganizerRegistration;
import lapr.project.model.UserRegistration;
import lapr.project.model.User;
import java.util.Date;
import lapr.project.model.EventType;
import lapr.project.utils.Data;

/**
 *
 * @author RuiSL
 */
public class CreateEventController {

    private final EventCenter eventCenter;
    private Event event;

    public CreateEventController(EventCenter eventCenter) {
        this.eventCenter = eventCenter;
    }

    private Event newEventAux() {
        return eventCenter.getEventRegistration().newEvent();
    }
    public void startNewEvent(){
        this.event=newEventAux();
    }
    
    public void setEventType(EventType eventType){
        event.setEventType(eventType);
    }
    public Event getControllerEvent(){
        return this.event;
    }

    public void setData(String titulo, String descricao, Data dataInicio, Data dataFimEvento,
            Data dataInicioSubmissao, Data dataFimSubmissao, String local) {
        event.setTitle(titulo);
        event.setEventDescription(descricao);
        event.setStartDate(dataInicio);
        event.setEndDate(dataFimEvento);
        event.setStartingSubmissionDate(dataInicioSubmissao);
        event.setEndingSubmissionDate(dataFimSubmissao);
        event.setLocal(local);
    }

    public UserRegistration getUserList() {
        return eventCenter.getUserRegistration();
    }

    public boolean associateOrganizer(UserRegistration userRegistration, String username) {
        OrganizerRegistration registoOrganizadores = event.getOrganizerRegistration();
        for (User u : userRegistration.getUserList()) {
            if (username.equalsIgnoreCase(u.getUsername())) {
                Organizer o = registoOrganizadores.newOrganizer();
                if(registoOrganizadores.validateOrganizer(o)){
                    o.setUser(u);
                    registoOrganizadores.registerOrganizer(o);
                    return true;
                }
            }
        }
        return false;
    }
    public boolean validateEvento(Event e){
        return eventCenter.getEventRegistration().validatesEvent(e);
    }
    
    public boolean registerEvent(Event e) {
        if(e.setCreated()){
            eventCenter.getEventRegistration().registerEvento(e);
            return true;
        }
        e.autoSetToClosedApplications();
        e.autoSetToReceivingApplications();
        return false;
    }
    
    
}
