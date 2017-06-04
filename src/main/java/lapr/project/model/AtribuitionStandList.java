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
public class AtribuitionStandList {

    /**
     *
     */
    private ArrayList<AssignmentStand> atribuitionStandList;

    /**
     *
     * @param atribuitionstandlst
     */
    public AtribuitionStandList(ArrayList<AssignmentStand> atribuitionstandlst) {

        this.atribuitionStandList = atribuitionstandlst;

    }

    /**
     *
     */
    public AtribuitionStandList() {

        this.atribuitionStandList = new ArrayList<>();

    }

    /**
     *
     * @return
     */
    public ArrayList<AssignmentStand> getAtribuitionStandList() {
        return atribuitionStandList;
    }

    /**
     *
     * @param atribuitionStandList
     */
    public void setAtribuitionStandList(ArrayList<AssignmentStand> atribuitionStandList) {
        this.atribuitionStandList = atribuitionStandList;
    }

    /**
     *
     * @param ev
     * @param std
     */
    public void newAtribuition(Event ev, Stand std) {

        AssignmentStand astd = new AssignmentStand(ev, std);

        if (astd.valida()) {

            getAtribuitionStandList().add(astd);
        }

    }

}
