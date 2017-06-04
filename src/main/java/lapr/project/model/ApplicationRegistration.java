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
public class ApplicationRegistration {
    private List<Application> applicationList;

    /**
     * cria uma lista de candidaturas
     */
    public ApplicationRegistration() {
        this.applicationList = new ArrayList<>();
    }

    /**
     * cria uma nova cópia de lista de candidaturas
     * @param outroRegisto 
     */
    public ApplicationRegistration(ApplicationRegistration otherRegister) {
        this.applicationList = new ArrayList<>(otherRegister.getApplicationListElements());
    }
    

    public List<Application> getApplicationListElements(){
        return this.applicationList;
    }

}
