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
public class StandRegistration {

    private ArrayList<Stand> listStand;

    /**
     *
     * @param listaStands
     */
    public StandRegistration(ArrayList<Stand> listStand) {

        this.listStand = new ArrayList<>(listStand);

    }

    /**
     *
     */
    public StandRegistration() {

        this.listStand = new ArrayList<>();

    }

    /**
     *
     * @return
     */
    public ArrayList<Stand> getListStands() {
        return listStand;
    }

    /**
     *
     * @param listStand
     */
    public void setListaStands(ArrayList<Stand> listStand) {
        this.listStand = listStand;
    }

    /**
     *
     * @param name
     * @param area
     * @return
     */
    public Stand newStand(String name, double area) {

        return new Stand(name, area);

    }

    /**
     *
     * @param s
     * @return
     */
    public boolean RegistStand(Stand s) {

        boolean st = validStand(s);

        if (st) {

            addStand(s);
        }
        return st;

    }

    /**
     *
     * @param s
     */
    public void addStand(Stand s) {

        listStand.add(s);

    }

    /**
     *
     * @param s
     * @return
     */
    public boolean validStand(Stand s) {

        for (Stand std : listStand) {

            if (std.getName().equalsIgnoreCase(s.getName()));
        }

        return true;

    }

}
