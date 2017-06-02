/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RuiSL
 */
public class OrganizerRegistration {
    private List<Organizer> organizerList;

    public OrganizerRegistration() {
        organizerList = new ArrayList<>();
    }
    
    public OrganizerRegistration(OrganizerRegistration otherRegister) {
        this.organizerList=new ArrayList<>(otherRegister.getListaOrganizadores());
    }

    public boolean registaOrganizador(Organizer o) {
        return this.organizerList.add(o);
    }

    public boolean validaOrganizador(Organizer O) {
        if(organizerList.contains(O)) {
            return false;
        }
        return true;
    }
    
    public boolean hasOrganizador(User u) {
        for(Organizer o : organizerList) {
            if(o.isUser(u)) {
                return true;
            }
        }
        return false;
    }
    public Organizer newOrganizer() {
        return new Organizer();
    }
    public List<Organizer> getListaOrganizadores() {
        return new ArrayList<>(this.organizerList);
    }
}
