/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;
import lapr.project.states.EventCreatedState;
import lapr.project.states.EventStateDefinedFAE;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author RuiSL
 */
public class EventRegistrationTest {
    @Test
    public void getEventListInStateTest(){
        EventCenter eventCenter = new EventCenter();Event e1 = new Event();
        Event e2 = new Event();
        Event e3 = new Event();
        Event e4 = new Event();
        e1.setEventState(new EventStateDefinedFAE());
        e2.setEventState(new EventCreatedState());
        e3.setEventState(new EventStateDefinedFAE());
        e4.setEventState(new EventCreatedState());
        eventCenter.getEventRegistration().registerEvento(e1);
        eventCenter.getEventRegistration().registerEvento(e2);
        eventCenter.getEventRegistration().registerEvento(e3);
        eventCenter.getEventRegistration().registerEvento(e4);
        List<Event> eventList=eventCenter.getEventRegistration().getEventListInState(new EventStateDefinedFAE());
        List<Event> eventListExpected= new ArrayList<>();
        eventListExpected.add(e1);
        eventListExpected.add(e3);
        
        assertEquals(eventListExpected, eventList);
    }
}
