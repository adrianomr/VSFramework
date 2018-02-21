/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author adriano
 */
public class BoxSizeTest {
    BoxSize boxSize;
    public BoxSizeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testIsValidShouldReturnTrue() {
        System.out.println("isValidShouldReturnTrue");
        boxSize = new BoxSize(10d, 20d, 30d);
        boolean expResult = true;
        boolean result = boxSize.isValid();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsValidShouldReturnFalseBecauseX() {
        System.out.println("isValidShouldReturnFalseBecauseX");
        boxSize = new BoxSize(-10d, 20d, 30d);
        boolean expResult = false;
        boolean result = boxSize.isValid();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsValidShouldReturnFalseBecauseY() {
        System.out.println("isValidReturnFalseBecauseY");
        boxSize = new BoxSize(10d, -20d, 30d);
        boolean expResult = false;
        boolean result = boxSize.isValid();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsValidShouldReturnFalseBecauseZ() {
        System.out.println("isValidShouldReturnFalseBecauseZ");
        boxSize = new BoxSize(10d, 20d, -30d);
        boolean expResult = false;
        boolean result = boxSize.isValid();
        assertEquals(expResult, result);
    }
    
}
