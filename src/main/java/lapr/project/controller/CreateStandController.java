/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.awt.Event;
import lapr.project.model.EventCenter;
import lapr.project.model.Stand;
import lapr.project.model.StandRegistration;
import lapr.project.model.Event;

/**
 *
 * @author Miguel Barros
 */
public class CreateStandController {

    private Stand std;

    private StandRegistration rstand;

    private Event event;

    private EventCenter eventCenter;

    public CreateStandController(Stand std, EventCenter eventCenter) {

        this.std = std;

        this.eventCenter = eventCenter;

        this.event = eventCenter.getEventRegistration().getEventList().get(0);

    }

    public CreateStandController(Stand std, Event event) {
        this.std = std;
        this.event = event;
    }

    public Stand getStd() {
        return std;
    }

    public void setStd(Stand std) {
        this.std = std;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    /**
     * Retorna uma lista de Eventos
     */
    /**
     * Retorna uma lista de Eventos
     *
     * @param name
     * @param area
     */
    public void newStand(String name, double area) {

        std.setName(name);
        std.setArea(area);

    }

    public boolean RegistStand() {

        boolean st = rstand.RegistStand(std);

        return st;

    }

}
