/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Miguel Barros
 */
public class AssignmentStandTest {

    public AssignmentStandTest() {

    }

    @BeforeClass
    public void setUpClass() {

    }

    @AfterClass
    public void tearDownClass() {

    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    /**
     * Test of valid method, of class AssignmentStand
     */
    @Test
    public void testValid() {

        System.out.println("Valid");
        AssignmentStand instance = null;
        boolean expectResult = false;
        boolean result = instance.valida();
        assertEquals(expectResult, result);
        fail("the case test its a exemple");

    }

}
