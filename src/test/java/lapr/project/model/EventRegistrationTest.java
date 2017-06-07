/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lapr.project.controller.ListGlobalApplicationsController;
import lapr.project.states.EventCreatedState;
import lapr.project.states.EventStateDefinedFAE;
import lapr.project.states.StartingEventState;
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
        e1.setEventDescription("Ruizinho");
        e2.setEventDescription("Luisinho");
        e3.setEventDescription("Tiaguinho");
        e4.setEventDescription("Joaozinho");
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
//    @Test
//    public void getOrganizerEventsTest() throws IOException{
//        EventCenter eventCenter=new EventCenter();
//        User u = new User("Rui", "rui.s.lomba@hotmail.com", "Ruilomba", "1234");
//        eventCenter.getUserRegistration().addUserRegistration(u);
//        Event e= new Event();
//        e.setEventState(new StartingEventState());
//        Event e1= new Event();
//        e1.setEventState(new StartingEventState());
//        eventCenter.getEventRegistration().registerEvento(e);
//        eventCenter.getEventRegistration().registerEvento(e1);
//        e.setEventDescription("EventoDoRui");
//        Organizer o=e.getOrganizerRegistration().newOrganizer();
//        o.setUser(u);
//        //tenho que tentar isto de novo qando tiver a instanciaçao dos utilizadores correta
//        List<Event> organizerEventList=eventCenter.getEventRegistration().getOrganizerEvents(u, new StartingEventState());
//    }
    @Test
    public void getGlobalApplicationListTest(){
        EventCenter eventCenter= new EventCenter();
        Event e=eventCenter.getEventRegistration().newEvent();
        Event e1=eventCenter.getEventRegistration().newEvent();
        e1.setEventDescription("Bananas");
        Event e2=eventCenter.getEventRegistration().newEvent();
        e2.setEventDescription("Cenouras");
        Event e3=eventCenter.getEventRegistration().newEvent();
        Event e4=eventCenter.getEventRegistration().newEvent();
        Event e5=eventCenter.getEventRegistration().newEvent();
        Event e6=eventCenter.getEventRegistration().newEvent();
        eventCenter.getEventRegistration().registerEvento(e);
        eventCenter.getEventRegistration().registerEvento(e1);
        eventCenter.getEventRegistration().registerEvento(e2);
        eventCenter.getEventRegistration().registerEvento(e3);
        eventCenter.getEventRegistration().registerEvento(e4);
        eventCenter.getEventRegistration().registerEvento(e5);
        eventCenter.getEventRegistration().registerEvento(e6);
        Application a=new Application();
        a.setDescription("eventoNulo");
        Application a1=new Application();
        a1.setDescription("eventoDasBananas");
        Application a2=new Application();
        a2.setDescription("eventoDasCenouras");
        e.getApplicationRegistration().addApplication(a);
        e1.getApplicationRegistration().addApplication(a1);
        e2.getApplicationRegistration().addApplication(a2);
        e3.getApplicationRegistration().addApplication(new Application());
        e4.getApplicationRegistration().addApplication(new Application());
        e5.getApplicationRegistration().addApplication(new Application());
        ListGlobalApplicationsController cont= new ListGlobalApplicationsController(eventCenter);
        List<Application> applicationList=new ArrayList<>();
        applicationList=cont.getGlobalApplicationList();
        List<Application> expectedApplicationList= new ArrayList<>();
        expectedApplicationList.add(a);
        expectedApplicationList.add(a1);
        expectedApplicationList.add(a2);
        assertEquals(expectedApplicationList, applicationList);
    }
    
    @Test
    public void getEventOfApplicationTest(){
        EventCenter eventCenter= new EventCenter();
        Event e=eventCenter.getEventRegistration().newEvent();
        Event e1=eventCenter.getEventRegistration().newEvent();
        e1.setEventDescription("Bananas");
        Event e2=eventCenter.getEventRegistration().newEvent();
        e2.setEventDescription("Cenouras");
        Event e3=eventCenter.getEventRegistration().newEvent();
        Event e4=eventCenter.getEventRegistration().newEvent();
        Event e5=eventCenter.getEventRegistration().newEvent();
        Event e6=eventCenter.getEventRegistration().newEvent();
        eventCenter.getEventRegistration().registerEvento(e);
        eventCenter.getEventRegistration().registerEvento(e1);
        eventCenter.getEventRegistration().registerEvento(e2);
        eventCenter.getEventRegistration().registerEvento(e3);
        eventCenter.getEventRegistration().registerEvento(e4);
        eventCenter.getEventRegistration().registerEvento(e5);
        eventCenter.getEventRegistration().registerEvento(e6);
        Application a=new Application();
        a.setDescription("eventoNulo");
        Application a1=new Application();
        a1.setDescription("eventoDasBananas");
        Application a2=new Application();
        a2.setDescription("eventoDasCenouras");
        e.getApplicationRegistration().addApplication(a);
        e1.getApplicationRegistration().addApplication(a1);
        e2.getApplicationRegistration().addApplication(a2);
        e3.getApplicationRegistration().addApplication(new Application());
        e4.getApplicationRegistration().addApplication(new Application());
        e5.getApplicationRegistration().addApplication(new Application());
        Event ev=eventCenter.getEventRegistration().getEventOfApplication(a1);
        Event expectedEvent=e1;
        assertEquals(expectedEvent, ev);
    }
    @Test
    public void getEventTest(){
        EventCenter eventCenter= new EventCenter();
        Event e=eventCenter.getEventRegistration().newEvent();
        Event e1=eventCenter.getEventRegistration().newEvent();
        e1.setEventDescription("Bananas");
        Event e2=eventCenter.getEventRegistration().newEvent();
        e2.setEventDescription("Cenouras");
        Event e3=eventCenter.getEventRegistration().newEvent();
        Event e4=eventCenter.getEventRegistration().newEvent();
        Event e5=eventCenter.getEventRegistration().newEvent();
        Event e6=eventCenter.getEventRegistration().newEvent();
        eventCenter.getEventRegistration().registerEvento(e);
        eventCenter.getEventRegistration().registerEvento(e1);
        eventCenter.getEventRegistration().registerEvento(e2);
        eventCenter.getEventRegistration().registerEvento(e3);
        eventCenter.getEventRegistration().registerEvento(e4);
        eventCenter.getEventRegistration().registerEvento(e5);
        eventCenter.getEventRegistration().registerEvento(e6);
        Event ev=eventCenter.getEventRegistration().getEvent(e1);
        Event expected=e1;
        assertEquals(expected,ev);
    }
    @Test
    public void validatesEventTest(){
        EventCenter eventCenter= new EventCenter();
        Event e=eventCenter.getEventRegistration().newEvent();
        Event e1=eventCenter.getEventRegistration().newEvent();
        e1.setEventDescription("Bananas");
        Event e2=eventCenter.getEventRegistration().newEvent();
        e2.setEventDescription("Cenouras");
        Event e3=eventCenter.getEventRegistration().newEvent();
        Event e4=eventCenter.getEventRegistration().newEvent();
        Event e5=eventCenter.getEventRegistration().newEvent();
        Event e6=eventCenter.getEventRegistration().newEvent();
        eventCenter.getEventRegistration().registerEvento(e);
        eventCenter.getEventRegistration().registerEvento(e1);
        eventCenter.getEventRegistration().registerEvento(e2);
        eventCenter.getEventRegistration().registerEvento(e3);
        eventCenter.getEventRegistration().registerEvento(e4);
        eventCenter.getEventRegistration().registerEvento(e5);
        eventCenter.getEventRegistration().registerEvento(e6);
        boolean answer;
        answer = eventCenter.getEventRegistration().validatesEvent(e1);
        assertEquals(false, answer);
    }
}
