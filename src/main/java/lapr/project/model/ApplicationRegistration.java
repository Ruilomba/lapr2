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

    public ApplicationRegistration() {
        applicationList = new ArrayList<Application>();
    }

    /**
     * return an application list
     *
     * @return
     */
    public List<Application> getApplicationList() {
        return new ArrayList<>(this.applicationList);
    }

    public Application newApplication() {
        return new Application();
    }


    /**
     * check if application alredy axists
     * 
     * @param a
     * @return - true if there is
     */
    public boolean checkIfApplicationExists(Application a) {
        if (applicationList.contains(a)) {
            return true;
        }
        return false;
    }
    
    public boolean addApplication(Application a){
        if(!checkIfApplicationExists(a)){
            
        }
    }
    
<<<<<<< HEAD
    /**
     * submit application
     *
     * @param a
     * @return
     */
    public boolean submitApplication(Application a) {
        if (!checkIfApplicationExists(a)) {

=======
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

    
    public Application newApplication() {
        return new Application();
    }

    
    public boolean registerApplication(Application a) {
        if (!applicationList.contains(a)) {
>>>>>>> e8fa8dcb5f1a815af68a7770c72b5feb5221efc2
            return this.applicationList.add(a);
        }
        return false;
    }

<<<<<<< HEAD
=======
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

>>>>>>> e8fa8dcb5f1a815af68a7770c72b5feb5221efc2
}
