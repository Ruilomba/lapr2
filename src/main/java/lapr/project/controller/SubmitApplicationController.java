/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Application;
import lapr.project.model.ApplicationRegistration;
import lapr.project.model.Event;
import lapr.project.model.EventCenter;
import lapr.project.model.EventRegistration;
import lapr.project.model.User;
import lapr.project.states.EventStateReceivingApplications;

/**
 *
 * @author teixe
 */
public class SubmitApplicationController {

    private final EventCenter eventCenter;
    private Application application;
    private Event event;
    private EventRegistration eventRegistration;
    private ApplicationRegistration ApplicationRegistration;

    public SubmitApplicationController(EventCenter ec) {
        this.eventCenter = ec;
    }

    /**
     * Returns list of event titles that are within the submission period of
     * applications as list of strings
     * @return 
     */
    public String[] getEventListInSubmissionPeriodAsStrings() {
        List<Event> eventsInSubmissionPeriod = getEventListInSubmissionPeriod();
        String[] eventsAsStrings = new String[eventsInSubmissionPeriod.size()];
        for (Event e : eventsInSubmissionPeriod) {
            eventsAsStrings[eventsAsStrings.length - 1] = e.getTitle();
        }
        return eventsAsStrings;
    }
    /**
     * Returns list of events that are within the submission period of
     * applications
     *
     * @return
     */
    public List<Event> getEventListInSubmissionPeriod() {
        return eventCenter.getEventRegistration().getEventListInState(new EventStateReceivingApplications());
    }

    /**
     * Select the desired event
     *
     * @param e
     * @throws EventoException
     */
    public void selectEvent(Event e) {
        if ((this.event = eventCenter.getEventRegistration().getEvent(e)) == null) {
            System.out.println("No matching event");
            throw new NullPointerException();
        }
    }

    
    public boolean AplicationRegister() {
        return event.getApplicationRegistration().registerApplication(application);
    }
}
