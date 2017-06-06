/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.io.Serializable;

/**
 *
 * @author Miguel Barros
 */
public class AssignmentStand implements Serializable {
    private static final long serialVersionUID = 1L;
    private Event event;
    private Stand std;

    /**
     *
     * @param event
     * @param std
     */
    public AssignmentStand(Event event, Stand std) {

        this.event = event;

        this.std = std;

    }

    /**
     *
     */
    public AssignmentStand() {

    }

    public Event getEvent() {
        return event;
    }

    public Stand getStd() {
        return std;
    }

    public boolean valida() {

        return true;

    }

}
