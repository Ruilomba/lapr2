/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;
import lapr.project.states.EventCreatedState;
import lapr.project.states.StartingEventState;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author RuiSL
 */
public class EventTest {
    @Test
    public void containsFaeTest(){
        User u= new User();
        u.setUsername("Rui");
        FAE fae= new FAE(u);
        Event e= new Event();
        e.getFaeList().registerFAEMember(fae);
        boolean answer=e.containsFae(u);
        assertEquals(true,answer);
    }
    @Test
    public void belongsToOrganizerTest(){
        User u= new User();
        u.setUsername("Rui");
        Organizer o = new Organizer();
        o.setUser(u);
        Event e= new Event();
        e.getOrganizerRegistration().registerOrganizer(o);
        boolean answer=e.belongsToOrganizer(u);
        assertEquals(true,answer);
    }
    @Test
    public void isInStateTest(){
        Event e= new Event();
        e.setEventState(new EventCreatedState());
        boolean answer=e.isInState(new EventCreatedState());
        assertEquals(true, answer);
    }
    @Test
    public void setCreatedTest(){
        Event e= new Event();
        e.setEventState(new StartingEventState());
        e.setCreated();
        boolean answer=e.isInState(new EventCreatedState());
        assertEquals(true, answer);
    }
    @Test
    public void getApplicationsWithoutAtribuitionTest(){
        User u= new User();
        u.setUsername("Rui");
        FAE fae= new FAE(u);
        Event e= new Event();
        List<FAE> faeList= new ArrayList<>();
        e.getFaeList().registerFAEMember(fae);
        Application a= new Application();
        Application ap1= new Application();
        ap1.setDescription("candidatura1");
        e.getApplicationRegistration().addApplication(a);
        e.getApplicationRegistration().addApplication(ap1);
        Atribuition at=e.getAtribuitionList().newAtribuition(a, faeList);
        e.registerAtribuition(at);
        List<Application> expectedList= new ArrayList<>();
        expectedList.add(ap1);
        List<Application> applicationList=e.getApplicationsWithoutAtribuition();
        assertEquals(expectedList, applicationList);
    }
}
