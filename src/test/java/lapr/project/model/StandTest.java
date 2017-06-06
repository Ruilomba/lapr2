/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Miguel Barros
 */
public class StandTest {

    public StandTest() {

    }

    public static void setUpClass() {

    }

    public static void tearDownClass() {

    }

    public static void setUp() {

    }

    public static void tearDown() {

    }

    /**
     * test setNome method of class Stand.
     */
    public void testSetName() {

        Stand stand = new Stand("hello", 25.2);
        String expected = "By";
        stand.setName("By");

        assertEquals(expected, stand.getName());

    }

    /**
     * test setArea method of class stand 
     */
    public void testSetArea() {

        Stand stand = new Stand("hello", 25.2);
        double expected = 25;
        stand.setArea(25);

        assertEquals(expected, stand.getArea(), 25);

    }

    /**
     * test toString method of class stand 
     */
    public void testToString() {
        Stand stand = new Stand("hello", 25.2);
        String expected = "Stand Name: " + "hello" + 25.2 + ".";
        assertEquals(expected, stand.toString());

    }

    /** test valid method of class stand 
     */
    public void testValid() {
        Stand stand = new Stand("", 25.2);
        boolean expected = false;
        assertEquals(expected, stand.valida());
    }


}
