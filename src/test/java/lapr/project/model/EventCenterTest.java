package lapr.project.model;

import lapr.project.utils.Data;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import java.util.ArrayList;

/**
 * Created by francisco on 05-06-2017.
 */
public class EventCenterTest {

    @Test
    public void testGlobalAverageRating(){
        float expected = 4.5f;

        FAEList faeList = new FAEList();
        OrganizerRegistration organizerRegistration = new OrganizerRegistration();

        FAE f1 = new FAE(new User("Gastao", "gasta@email.com", "gastao", "aaa"));
        FAE f2 = new FAE(new User("Gusto", "gusto@email.com", "gusto", "aaa"));
        FAE f3 = new FAE(new User("Gusto", "gusto@email.com", "gusto", "aaa"));

        faeList.registerFAEMember(f1);
        faeList.registerFAEMember(f2);
        faeList.registerFAEMember(f3);

        FAERating e1r1 = new FAERating(f1, 5, 3, 1, 4);
        FAERating e1r2 = new FAERating(f2, 3, 2, 3, 2);
        FAERating e1r3 = new FAERating(f3, 0, 1.9f, 4.5f, 3.1f);

        ArrayList<FAERating> rating = new ArrayList<FAERating>();

        rating.add(e1r1);
        rating.add(e1r2);
        rating.add(e1r3);

        Event e1 = new Event(new Congress(), "evento1", "evento teste", "Porto", new Data(2017,02,1),
                new Data(2017,12, 31), new Data(2017,10,12), new Data(2017,10,19), organizerRegistration, faeList);

        e1.getApplicationRegistration().registerApplication(new Application(rating, "desc1", new ArrayList<Keyword>()));
        e1.getApplicationRegistration().registerApplication(new Application(rating, "desc2", new ArrayList<Keyword>()));
        e1.getApplicationRegistration().registerApplication(new Application(rating, "desc3", new ArrayList<Keyword>()));

        Event e2 = new Event(new Congress(), "evento2", "evento teste", "Porto", new Data(2017,02,1),
                new Data(2017,12, 31), new Data(2017,10,12), new Data(2017,10,19), organizerRegistration, faeList);

        e2.getApplicationRegistration().registerApplication(new Application(rating, "desc1", new ArrayList<Keyword>()));
        e2.getApplicationRegistration().registerApplication(new Application(rating, "desc2", new ArrayList<Keyword>()));
        e2.getApplicationRegistration().registerApplication(new Application(rating, "desc3", new ArrayList<Keyword>()));

        Event e3 = new Event(new Congress(), "evento3", "evento teste", "Porto", new Data(2017,02,1),
                new Data(2017,12, 31), new Data(2017,10,12), new Data(2017,10,19), organizerRegistration, faeList);

        e3.getApplicationRegistration().registerApplication(new Application(rating, "desc1", new ArrayList<Keyword>()));
        e3.getApplicationRegistration().registerApplication(new Application(rating, "desc2", new ArrayList<Keyword>()));
        e3.getApplicationRegistration().registerApplication(new Application(rating, "desc3", new ArrayList<Keyword>()));

        EventCenter c = new EventCenter();
        c.getEventRegistration().registerEvento(e1);
        c.getEventRegistration().registerEvento(e2);
        c.getEventRegistration().registerEvento(e3);

        assertEquals(c.getGlobalSubmissionAverageRating(),2.7083333f);
    }
    @Test
    public void testGlobalAverageInvitationQuantityRating(){
        float expected = 4.5f;

        FAEList faeList = new FAEList();
        OrganizerRegistration organizerRegistration = new OrganizerRegistration();

        FAE f1 = new FAE(new User("Gastao", "gasta@email.com", "gastao", "aaa"));
        FAE f2 = new FAE(new User("Gusto", "gusto@email.com", "gusto", "aaa"));
        FAE f3 = new FAE(new User("Gusto", "gusto@email.com", "gusto", "aaa"));

        faeList.registerFAEMember(f1);
        faeList.registerFAEMember(f2);
        faeList.registerFAEMember(f3);

        FAERating e1r1 = new FAERating(f1, 5, 3, 1, 4);
        FAERating e1r2 = new FAERating(f2, 3, 2, 3, 2);
        FAERating e1r3 = new FAERating(f3, 0, 1.9f, 4.5f, 3.1f);

        ArrayList<FAERating> rating = new ArrayList<FAERating>();

        rating.add(e1r1);
        rating.add(e1r2);
        rating.add(e1r3);

        Event e1 = new Event(new Congress(), "evento1", "evento teste", "Porto", new Data(2017,02,1),
                new Data(2017,12, 31), new Data(2017,10,12), new Data(2017,10,19), organizerRegistration, faeList);

        e1.getApplicationRegistration().registerApplication(new Application(rating, "desc1", new ArrayList<Keyword>()));
        e1.getApplicationRegistration().registerApplication(new Application(rating, "desc2", new ArrayList<Keyword>()));
        e1.getApplicationRegistration().registerApplication(new Application(rating, "desc3", new ArrayList<Keyword>()));

        Event e2 = new Event(new Congress(), "evento2", "evento teste", "Porto", new Data(2017,02,1),
                new Data(2017,12, 31), new Data(2017,10,12), new Data(2017,10,19), organizerRegistration, faeList);

        e2.getApplicationRegistration().registerApplication(new Application(rating, "desc1", new ArrayList<Keyword>()));
        e2.getApplicationRegistration().registerApplication(new Application(rating, "desc2", new ArrayList<Keyword>()));
        e2.getApplicationRegistration().registerApplication(new Application(rating, "desc3", new ArrayList<Keyword>()));

        Event e3 = new Event(new Congress(), "evento3", "evento teste", "Porto", new Data(2017,02,1),
                new Data(2017,12, 31), new Data(2017,10,12), new Data(2017,10,19), organizerRegistration, faeList);

        e3.getApplicationRegistration().registerApplication(new Application(rating, "desc1", new ArrayList<Keyword>()));
        e3.getApplicationRegistration().registerApplication(new Application(rating, "desc2", new ArrayList<Keyword>()));
        e3.getApplicationRegistration().registerApplication(new Application(rating, "desc3", new ArrayList<Keyword>()));

        EventCenter c = new EventCenter();
        c.getEventRegistration().registerEvento(e1);
        c.getEventRegistration().registerEvento(e2);
        c.getEventRegistration().registerEvento(e3);

        assertEquals(c.getGlobalSubmissionAverageInvitationQuantityRating(), 2.3000002f);
    }
    @Test
    public void testGlobalAverageOverallRating(){
        float expected = 4.5f;

        FAEList faeList = new FAEList();
        OrganizerRegistration organizerRegistration = new OrganizerRegistration();

        FAE f1 = new FAE(new User("Gastao", "gasta@email.com", "gastao", "aaa"));
        FAE f2 = new FAE(new User("Gusto", "gusto@email.com", "gusto", "aaa"));
        FAE f3 = new FAE(new User("Gusto", "gusto@email.com", "gusto", "aaa"));

        faeList.registerFAEMember(f1);
        faeList.registerFAEMember(f2);
        faeList.registerFAEMember(f3);

        FAERating e1r1 = new FAERating(f1, 5, 3, 1, 4);
        FAERating e1r2 = new FAERating(f2, 3, 2, 3, 2);
        FAERating e1r3 = new FAERating(f3, 0, 1.9f, 4.5f, 3.1f);

        ArrayList<FAERating> rating = new ArrayList<FAERating>();

        rating.add(e1r1);
        rating.add(e1r2);
        rating.add(e1r3);

        Event e1 = new Event(new Congress(), "evento1", "evento teste", "Porto", new Data(2017,02,1),
                new Data(2017,12, 31), new Data(2017,10,12), new Data(2017,10,19), organizerRegistration, faeList);

        e1.getApplicationRegistration().registerApplication(new Application(rating, "desc1", new ArrayList<Keyword>()));
        e1.getApplicationRegistration().registerApplication(new Application(rating, "desc2", new ArrayList<Keyword>()));
        e1.getApplicationRegistration().registerApplication(new Application(rating, "desc3", new ArrayList<Keyword>()));

        Event e2 = new Event(new Congress(), "evento2", "evento teste", "Porto", new Data(2017,02,1),
                new Data(2017,12, 31), new Data(2017,10,12), new Data(2017,10,19), organizerRegistration, faeList);

        e2.getApplicationRegistration().registerApplication(new Application(rating, "desc1", new ArrayList<Keyword>()));
        e2.getApplicationRegistration().registerApplication(new Application(rating, "desc2", new ArrayList<Keyword>()));
        e2.getApplicationRegistration().registerApplication(new Application(rating, "desc3", new ArrayList<Keyword>()));

        Event e3 = new Event(new Congress(), "evento3", "evento teste", "Porto", new Data(2017,02,1),
                new Data(2017,12, 31), new Data(2017,10,12), new Data(2017,10,19), organizerRegistration, faeList);

        e3.getApplicationRegistration().registerApplication(new Application(rating, "desc1", new ArrayList<Keyword>()));
        e3.getApplicationRegistration().registerApplication(new Application(rating, "desc2", new ArrayList<Keyword>()));
        e3.getApplicationRegistration().registerApplication(new Application(rating, "desc3", new ArrayList<Keyword>()));

        EventCenter c = new EventCenter();
        c.getEventRegistration().registerEvento(e1);
        c.getEventRegistration().registerEvento(e2);
        c.getEventRegistration().registerEvento(e3);

        assertEquals(c.getGlobalSubmissionAverageOverallRating(), 3.033333f);
    }
    @Test
    public void testGlobalAverageApplicationAdequencyRating(){
        float expected = 4.5f;

        FAEList faeList = new FAEList();
        OrganizerRegistration organizerRegistration = new OrganizerRegistration();

        FAE f1 = new FAE(new User("Gastao", "gasta@email.com", "gastao", "aaa"));
        FAE f2 = new FAE(new User("Gusto", "gusto@email.com", "gusto", "aaa"));
        FAE f3 = new FAE(new User("Gusto", "gusto@email.com", "gusto", "aaa"));

        faeList.registerFAEMember(f1);
        faeList.registerFAEMember(f2);
        faeList.registerFAEMember(f3);

        FAERating e1r1 = new FAERating(f1, 5, 3, 1, 4);
        FAERating e1r2 = new FAERating(f2, 3, 2, 3, 2);
        FAERating e1r3 = new FAERating(f3, 0, 1.9f, 4.5f, 3.1f);

        ArrayList<FAERating> rating = new ArrayList<FAERating>();

        rating.add(e1r1);
        rating.add(e1r2);
        rating.add(e1r3);

        Event e1 = new Event(new Congress(), "evento1", "evento teste", "Porto", new Data(2017,02,1),
                new Data(2017,12, 31), new Data(2017,10,12), new Data(2017,10,19), organizerRegistration, faeList);

        e1.getApplicationRegistration().registerApplication(new Application(rating, "desc1", new ArrayList<Keyword>()));
        e1.getApplicationRegistration().registerApplication(new Application(rating, "desc2", new ArrayList<Keyword>()));
        e1.getApplicationRegistration().registerApplication(new Application(rating, "desc3", new ArrayList<Keyword>()));

        Event e2 = new Event(new Congress(), "evento2", "evento teste", "Porto", new Data(2017,02,1),
                new Data(2017,12, 31), new Data(2017,10,12), new Data(2017,10,19), organizerRegistration, faeList);

        e2.getApplicationRegistration().registerApplication(new Application(rating, "desc1", new ArrayList<Keyword>()));
        e2.getApplicationRegistration().registerApplication(new Application(rating, "desc2", new ArrayList<Keyword>()));
        e2.getApplicationRegistration().registerApplication(new Application(rating, "desc3", new ArrayList<Keyword>()));

        Event e3 = new Event(new Congress(), "evento3", "evento teste", "Porto", new Data(2017,02,1),
                new Data(2017,12, 31), new Data(2017,10,12), new Data(2017,10,19), organizerRegistration, faeList);

        e3.getApplicationRegistration().registerApplication(new Application(rating, "desc1", new ArrayList<Keyword>()));
        e3.getApplicationRegistration().registerApplication(new Application(rating, "desc2", new ArrayList<Keyword>()));
        e3.getApplicationRegistration().registerApplication(new Application(rating, "desc3", new ArrayList<Keyword>()));

        EventCenter c = new EventCenter();
        c.getEventRegistration().registerEvento(e1);
        c.getEventRegistration().registerEvento(e2);
        c.getEventRegistration().registerEvento(e3);

        assertEquals(c.getGlobalSubmissionAverageApplicationAdequancyRating(), 2.3000002f);
    }
    @Test
    public void testGlobalAverageTopicKnowledgeRating(){
        float expected = 4.5f;

        FAEList faeList = new FAEList();
        OrganizerRegistration organizerRegistration = new OrganizerRegistration();

        FAE f1 = new FAE(new User("Gastao", "gasta@email.com", "gastao", "aaa"));
        FAE f2 = new FAE(new User("Gusto", "gusto@email.com", "gusto", "aaa"));
        FAE f3 = new FAE(new User("Gusto", "gusto@email.com", "gusto", "aaa"));

        faeList.registerFAEMember(f1);
        faeList.registerFAEMember(f2);
        faeList.registerFAEMember(f3);

        FAERating e1r1 = new FAERating(f1, 5, 3, 1, 4);
        FAERating e1r2 = new FAERating(f2, 3, 2, 3, 2);
        FAERating e1r3 = new FAERating(f3, 0, 1.9f, 4.5f, 3.1f);

        ArrayList<FAERating> rating = new ArrayList<FAERating>();

        rating.add(e1r1);
        rating.add(e1r2);
        rating.add(e1r3);

        Event e1 = new Event(new Congress(), "evento1", "evento teste", "Porto", new Data(2017,02,1),
                new Data(2017,12, 31), new Data(2017,10,12), new Data(2017,10,19), organizerRegistration, faeList);

        e1.getApplicationRegistration().registerApplication(new Application(rating, "desc1", new ArrayList<Keyword>()));
        e1.getApplicationRegistration().registerApplication(new Application(rating, "desc2", new ArrayList<Keyword>()));
        e1.getApplicationRegistration().registerApplication(new Application(rating, "desc3", new ArrayList<Keyword>()));

        Event e2 = new Event(new Congress(), "evento2", "evento teste", "Porto", new Data(2017,02,1),
                new Data(2017,12, 31), new Data(2017,10,12), new Data(2017,10,19), organizerRegistration, faeList);

        e2.getApplicationRegistration().registerApplication(new Application(rating, "desc1", new ArrayList<Keyword>()));
        e2.getApplicationRegistration().registerApplication(new Application(rating, "desc2", new ArrayList<Keyword>()));
        e2.getApplicationRegistration().registerApplication(new Application(rating, "desc3", new ArrayList<Keyword>()));

        Event e3 = new Event(new Congress(), "evento3", "evento teste", "Porto", new Data(2017,02,1),
                new Data(2017,12, 31), new Data(2017,10,12), new Data(2017,10,19), organizerRegistration, faeList);

        e3.getApplicationRegistration().registerApplication(new Application(rating, "desc1", new ArrayList<Keyword>()));
        e3.getApplicationRegistration().registerApplication(new Application(rating, "desc2", new ArrayList<Keyword>()));
        e3.getApplicationRegistration().registerApplication(new Application(rating, "desc3", new ArrayList<Keyword>()));

        EventCenter c = new EventCenter();
        c.getEventRegistration().registerEvento(e1);
        c.getEventRegistration().registerEvento(e2);
        c.getEventRegistration().registerEvento(e3);

        assertEquals(c.getGlobalSubmissionAverageTopicKnowledgeRating(),2.6666667f);
    }
}
