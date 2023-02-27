/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package entity;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author MSI
 */
public class trajetNGTest {
    
    public trajetNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of toString method, of class trajet.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        trajet instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId_trajet method, of class trajet.
     */
    @Test
    public void testGetId_trajet() {
        System.out.println("getId_trajet");
        trajet instance = null;
        int expResult = 0;
        int result = instance.getId_trajet();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDepart method, of class trajet.
     */
    @Test
    public void testGetDepart() {
        System.out.println("getDepart");
        trajet instance = null;
        String expResult = "";
        String result = instance.getDepart();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDestination method, of class trajet.
     */
    @Test
    public void testGetDestination() {
        System.out.println("getDestination");
        trajet instance = null;
        String expResult = "";
        String result = instance.getDestination();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId_trajet method, of class trajet.
     */
    

    /**
     * Test of setDepart method, of class trajet.
     */
    @Test
    public void testSetDepart() {
        System.out.println("setDepart");
        String depart = "";
        trajet instance = null;
        instance.setDepart(depart);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDestination method, of class trajet.
     */
    @Test
    public void testSetDestination() {
        System.out.println("setDestination");
        String destination = "";
        trajet instance = null;
        instance.setDestination(destination);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
    
}
