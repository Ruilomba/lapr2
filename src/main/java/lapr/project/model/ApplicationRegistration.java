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
    
    public List<Application> getApplicationsFromFAE(FAE FAE, Event e) {
        List<Application> output = new ArrayList<>();
        List<FAE> listaFaes = e.getFaeList().getFaeListElements();

        for (Application a : applicationList) {

            if (listaFaes.contains(FAE)) {
                output.add(a);
            }
        }

        return output;
    }

    public List<Application> getApplicationListElements() {
        return new ArrayList<>(this.applicationList);
    }

    
    public boolean registerApplication(Application a) {
        if (!applicationList.contains(a)) {
            return this.applicationList.add(a);
        }
        return false;
    }

    public boolean validateApplication(Application a) {
        if (applicationList.contains(a)) {
            return false;
        }
        return true;
    }

    public List<Application> getApplicationList() {
        return applicationList;
    }

    public boolean isEmpty() {
        return applicationList.isEmpty();
    }

    
    public void addApplication(Application a) {
        if (validateApplication(a)) {
            applicationList.add(a);
        }
    }

}
