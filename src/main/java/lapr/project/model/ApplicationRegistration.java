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
    
    /**
     * submit application
     *
     * @param a
     * @return
     */
    public boolean submitApplication(Application a) {
        if (!checkIfApplicationExists(a)) {

            return this.applicationList.add(a);
        }
        return false;
    }

}
