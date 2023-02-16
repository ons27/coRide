/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author MSI
 */
public class trajetTest {
    
    public trajetTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
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
        assertEquals(expResult, result);
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
        assertEquals(expResult, result);
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
        assertEquals(expResult, result);
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
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNb_place method, of class trajet.
     */
    @Test
    public void testGetNb_place() {
        System.out.println("getNb_place");
        trajet instance = null;
        int expResult = 0;
        int result = instance.getNb_place();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrix method, of class trajet.
     */
    @Test
    public void testGetPrix() {
        System.out.println("getPrix");
        trajet instance = null;
        float expResult = 0.0F;
        float result = instance.getPrix();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId_trajet method, of class trajet.
     */
    @Test
    public void testSetId_trajet() {
        System.out.println("setId_trajet");
        int id_trajet = 0;
        trajet instance = null;
        instance.setId_trajet(id_trajet);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

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

    /**
     * Test of setNb_place method, of class trajet.
     */
    @Test
    public void testSetNb_place() {
        System.out.println("setNb_place");
        int nb_place = 0;
        trajet instance = null;
        instance.setNb_place(nb_place);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrix method, of class trajet.
     */
    @Test
    public void testSetPrix() {
        System.out.println("setPrix");
        float prix = 0.0F;
        trajet instance = null;
        instance.setPrix(prix);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
