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

/**
 *
 * @author RuiSL
 */
public class CreateEventController {

    private final EventCenter eventCenter;

    public CreateEventController(EventCenter eventCenter) {
        this.eventCenter = eventCenter;
    }

    public Event newEvent() {
        return eventCenter.getEventRegistration().newEvent();
    }

    public void setData(Event evento,String titulo, String descricao, Date dataInicio, Date dataFimEvento,
            Date dataInicioSubmissao, Date dataFimSubmissao, String local) {
        evento.setTitle(titulo);
        evento.setEventDescription(descricao);
        evento.setStartDate(dataInicio);
        evento.setEndDate(dataFimEvento);
        evento.setStartingSubmissionDate(dataInicioSubmissao);
        evento.setEndingSubmissionDate(dataFimSubmissao);
        evento.setLocal(local);
    }

    public UserRegistration getUserList() {
        return eventCenter.getUserRegistration();
    }

    public boolean associateOrganizer(Event event,UserRegistration userRegistration, String username) {
        OrganizerRegistration registoOrganizadores = event.getOrganizerRegistration();
        for (User u : userRegistration.getUserList()) {
            if (username.equalsIgnoreCase(u.getUsername())) {
                Organizer o = registoOrganizadores.newOrganizer();
                if(registoOrganizadores.validaOrganizador(o)){
                    o.setUser(u);
                    registoOrganizadores.registaOrganizador(o);
                    return true;
                }
            }
        }
        return false;
    }
    public boolean validateEvento(Event e){
        return eventCenter.getEventRegistration().validatesEvent(e);
    }
    
    public boolean registEvent(Event e) {
        if(e.setCreated()){
            eventCenter.getEventRegistration().registerEvento(e);
            return true;
        }     
        return false;
    }
    
    
}
