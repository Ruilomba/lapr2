package lapr.project.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class FAERatingTest {

    @Test
    public void setValidRating(){
        User user = new User("Reinhardt Wilhelm", "reinhardt@overwatch.com", "TheTester", "uheuheuhe");
        FAE fae = new FAE(user);
        List<RatingParameter> ratingParameterList = new ArrayList<RatingParameter>();
        RatingParameter p1 = new RatingParameter("FAE’s knowledge about the event topic", 0, 5, 0);
        RatingParameter p2 = new RatingParameter("Application adequacy for the event", 0, 5, 0);
        RatingParameter p3 = new RatingParameter("Invitations quantity adequacy for the application", 0, 5, 0);
        ratingParameterList.add(p1);
        ratingParameterList.add(p2);
        ratingParameterList.add(p3);

        FAERating rating = new FAERating(fae, ratingParameterList);

        rating.applyRating(p1, 3.4f);
        assertEquals(rating.getParameterByName(p1.getName()).getValue(), 3.4f, 0);
    }

    @Test
    public void getAverageRating(){
        User user = new User("Reinhardt Wilhelm", "reinhardt@overwatch.com", "TheTester", "uheuheuhe");
        FAE fae = new FAE(user);
        List<RatingParameter> ratingParameterList = new ArrayList<RatingParameter>();
        RatingParameter p1 = new RatingParameter("FAE’s knowledge about the event topic", 0, 5, 0);
        RatingParameter p2 = new RatingParameter("Application adequacy for the event", 0, 5, 0);
        RatingParameter p3 = new RatingParameter("Invitations quantity adequacy for the application", 0, 5, 0);
        ratingParameterList.add(p1);
        ratingParameterList.add(p2);
        ratingParameterList.add(p3);

        FAERating rating = new FAERating(fae, ratingParameterList);

        rating.applyRating(p1, 4.5f);
        rating.applyRating(p2, 2f);
        rating.applyRating(p3, 4f);

        assertEquals(rating.getAverageRating(), 0.0f, 0);
    }
    @Test
    public void testGetParameterByName(){
        User user = new User("Reinhardt Wilhelm", "reinhardt@overwatch.com", "TheTester", "uheuheuhe");
        FAE fae = new FAE(user);
        List<RatingParameter> ratingParameterList = new ArrayList<RatingParameter>();
        RatingParameter p1 = new RatingParameter("FAE’s knowledge about the event topic", 0, 5, 0);
        RatingParameter p2 = new RatingParameter("Application adequacy for the event", 0, 5, 0);
        RatingParameter p3 = new RatingParameter("Invitations quantity adequacy for the application", 0, 5, 0);
        ratingParameterList.add(p1);
        ratingParameterList.add(p2);
        ratingParameterList.add(p3);

        FAERating rating = new FAERating(fae, ratingParameterList);

        assertEquals(rating.getParameterByName(p1.getName()), p1);
    }

    @Test
    public void testGetParameterByNameNotFount(){
        User user = new User("Reinhardt Wilhelm", "reinhardt@overwatch.com", "TheTester", "uheuheuhe");
        FAE fae = new FAE(user);
        List<RatingParameter> ratingParameterList = new ArrayList<RatingParameter>();
        RatingParameter p1 = new RatingParameter("FAE’s knowledge about the event topic", 0, 5, 0);
        RatingParameter p2 = new RatingParameter("Application adequacy for the event", 0, 5, 0);
        RatingParameter p3 = new RatingParameter("Invitations quantity adequacy for the application", 0, 5, 0);
        ratingParameterList.add(p2);
        ratingParameterList.add(p3);

        FAERating rating = new FAERating(fae, ratingParameterList);

        assertEquals(rating.getParameterByName(p1.getName()), null);
    }

}
