/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;

/**
 *
 * @author Miguel Barros
 */
public class ListAssignmentStand {

    private ArrayList<AssignmentStand> listAssignmentStand;

    /**
     *
     * Constructor
     */
    public ListAssignmentStand(ArrayList<AssignmentStand> lstAssignmentStand) {

        this.listAssignmentStand = lstAssignmentStand;
    }

    /**
     * 
     */
    public ListAssignmentStand() {

        this.listAssignmentStand = new ArrayList<>(listAssignmentStand);
    }

    /**
     * 
     * @return 
     */
    public ArrayList<AssignmentStand> GetListAssignmentStand() {

        return listAssignmentStand;
    }

    /**
     * 
     * @param listAssignmentStand 
     */
    public void setListAssignmentStand(ArrayList<AssignmentStand> listAssignmentStand) {
        this.listAssignmentStand = listAssignmentStand;
    }

    /**
     * 
     * @param event
     * @param std 
     */
    public void newAssignment(Event event, Stand std) {

        AssignmentStand astd = new AssignmentStand(event, std);

        if (astd.valida()) {
            GetListAssignmentStand().add(astd);

        }

    }

}
