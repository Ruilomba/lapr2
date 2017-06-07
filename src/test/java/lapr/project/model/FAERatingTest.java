package lapr.project.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class FAERatingTest {

    @Test
    public void testEquals(){
        User user = new User("Gastão", "gastao@fdv.com", "ogastao", "gaston");
        FAE fae = new FAE(user);

        FAERating faeRating = new FAERating(fae, 2, 2, 2, 2);

        assertEquals(faeRating, faeRating);
    }

    @Test
    public void testAverageRating(){
        User user = new User("Gastão", "gastao@fdv.com", "ogastao", "gaston");
        FAE fae = new FAE(user);

        FAERating faeRating = new FAERating(fae, 2, 2, 2, 2);

        assertEquals(2.0, faeRating.getAverageRating(),0);
    }

}
