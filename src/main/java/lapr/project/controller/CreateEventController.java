/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.states.EventState;
import lapr.project.model.EventCenter;
import lapr.project.model.Event;
import lapr.project.model.Organizer;
import lapr.project.model.OrganizerRegistration;
import lapr.project.model.UserRegistration;
import lapr.project.model.User;
import java.util.Date;
import java.util.List;

/**
 *
 * @author RuiSL
 */
public class CreateEventController {

    private EventCenter eventCenter;

    public CreateEventController(EventCenter eventCenter) {
        this.eventCenter = eventCenter;
    }

    public Event novoEvento() {
        return eventCenter.getEventRegistration().newEvent();
    }

    public void setDados(Event evento,String titulo, String descricao, Date dataInicio, Date dataFimEvento,
            Date dataInicioSubmissao, Date dataFimSubmissao, String local) {
        evento.setTitulo(titulo);
        evento.setTextoDescritivo(descricao);
        evento.setDataInicio(dataInicio);
        evento.setDataFim(dataFimEvento);
        evento.setDataInicioSubCandidatura(dataInicioSubmissao);
        evento.setDataFimSubCandidatura(dataFimSubmissao);
        evento.setLocal(local);
    }

    public RegistoUtilizadores getListaUtilizadores() {
        return centroEventos.getRegistoUtilizadores();
    }

    public boolean associaOrganizador(Evento evento,RegistoUtilizadores registoUtilizadores, String username) {
        RegistoOrganizadores registoOrganizadores = evento.getRegistoOrganizadores();
        for (Utilizador u : registoUtilizadores.getListaUtilizadores()) {
            if (username.equalsIgnoreCase(u.getUsername())) {
                Organizador o = registoOrganizadores.newOrganizador();
                if(registoOrganizadores.validaOrganizador(o)){
                    o.setUtilizador(u);
                    registoOrganizadores.registaOrganizador(o);
                    return true;
                }
            }
        }
        return false;
    }
    public boolean validaEvento(Evento e){
        return centroEventos.getRegistoEventos().validaEvento(e);
    }
    public boolean registaEvento(Evento e) {
        if(e.setCriado()){
            centroEventos.getRegistoEventos().registaEvento(e);
            return true;
        }     
        return false;
    }
    
    
}
