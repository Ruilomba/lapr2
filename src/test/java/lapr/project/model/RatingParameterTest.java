package lapr.project.model;

import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.IllegalArgumentException;

/**
 * Created by francisco on 01-06-2017.
 */
public class RatingParameterTest {

    @Test
    public void setValidRating(){
        final float value = 3.0f;
        RatingParameter parameter = new RatingParameter("FAE’s knowledge about the event topic:", 0, 5, 0);
        parameter.applyRating(value);
        assertEquals("rating values are not correct", value, parameter.getValue(),0);
    }

    @Test(expected=IllegalArgumentException.class)
    public void setRatingBellowRange(){
        final float value = -1.0f;
        RatingParameter parameter = new RatingParameter("FAE’s knowledge about the event topic:", 0, 5, 0);
        parameter.applyRating(value);
    }

    @Test(expected=IllegalArgumentException.class)
    public void setRatingAboveRange(){
        final float value = 6.0f;
        RatingParameter parameter = new RatingParameter("FAE’s knowledge about the event topic:", 0, 5, 0);
        parameter.applyRating(value);
    }

}
