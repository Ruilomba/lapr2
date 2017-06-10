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
import lapr.project.model.Keyword;
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
     * @return true if event exists in event registration
     */
    public boolean selectEvent(Event e) {
        return eventCenter.getEventRegistration().getEvent(e) != null;
    }
    
    /**
     * selects event with title selected in UI
     * @param eventTitle
     * @return 
     */
    public boolean selectEventWithTitle(String eventTitle) {
        List<Event> eventList = eventCenter.getEventRegistration().getEventList();
        for (Event e : eventList) {
            if (e.getTitle().equalsIgnoreCase(eventTitle)) {
                return selectEvent(e);
            }
        }
        return false;
    }
    
    public boolean AplicationRegister() {
        return event.getApplicationRegistration().addApplication(application);
    }

    public boolean submitApplication(String companyName, String companyAddress, String companyPhone, String description, String keywords, int area, int numberOfInvites) {
        ApplicationRegistration registration = event.getApplicationRegistration();
        List<Keyword> keywordList = new ArrayList<>();
        String[] keywordsAsStrings = keywords.split(", ");
        for (String s : keywordsAsStrings) {
            Keyword newKeyword = new Keyword(s);
            keywordList.add(newKeyword);
        }
        Application newApplication = registration.newApplication(null, description, keywordList, companyAddress, companyName, area, numberOfInvites, companyPhone);
        return registration.addApplication(newApplication);
    }
}
