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
    //private ApplicationRegistration appRegistration;
    private StandRegistration stdRegistration;
    private Event event;
    
    public AssignmentStandController (EventCenter eventCenter) {
        this.eventCenter = eventCenter;
        this.eventRegistration = eventCenter.getEventRegistration();
//        this.appRegistration = eventCenter.
        this.stdRegistration = eventCenter.getStandRegistration();
    }
        
    /*
    
    public void getEventList(Organizer o){
        ArrayList<Event> eventlist = new ArrayList();
        
        
            
            
        
        
    }
    
            
            
    public void getListaExposicoes(Organizador o){
        ArrayList<Exposicao> lexp = new ArrayList();
        re = ce.getRegistoExposicoes();
        //Fazer estado
        re.getListaExposicoesDecididas(o);
    }
    
    public void setExposicao(Exposicao exp){
        this.exp = exp;
    }
    
    public void getCandidaturasAceites(){
        rc = exp.getRegistoCandidaturas();
        rc.getListaCandidaturasAceites();
    }
    
    public ArrayList<Stand> getListaStands(){
        rs = ce.getRegistoStands();
        return rs.getListaStands();
    }
    
    public void setStands(Stand s){
        exp.novaAtribuicao(exp,s);
    }
    
    public void registaDados(){
        exp.registaDados();
    }
*/
}
