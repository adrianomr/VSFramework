/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import interfaces.IOperationalSystem;
import java.util.ArrayList;
import model.Util;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author adriano
 */
public class UtilTest {
    
    public UtilTest() {
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

    /**
     * Test of getFileName method, of class Util.
     */
    @Test
    public void testGetFileName() {
        System.out.println("getFileName");
        String file = "adriano.pdb";
        String expResult = "adriano";
        String result = Util.getFileName(file);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetFileNameComBarra() {
        System.out.println("getFileNameComBarra");
        String file = "home/adriano.pdb";
        String expResult = "adriano";
        String result = Util.getFileName(file);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetFileNameComBarraDupla() {
        System.out.println("getFileNameComBarraDupla");
        String file = "home//adriano.pdb";
        String expResult = "adriano";
        String result = Util.getFileName(file);
        assertEquals(expResult, result);
    }

    /**
     * Test of getFileType method, of class Util.
     */
    @Test
    public void testGetFileType() {
        System.out.println("getFileType");
        String file = "adriano.pdb";
        String expResult = "pdb";
        String result = Util.getFileType(file);
        assertEquals(expResult, result);
    }
    @Test
    public void testGetFileTypeComBarra() {
        System.out.println("getFileTypeComBarra");
        String file = "home/adriano.pdb";
        String expResult = "pdb";
        String result = Util.getFileType(file);
        assertEquals(expResult, result);
    }
    @Test
    public void testGetFileTypeComBarraDupla() {
        System.out.println("getFileTypeComBarraDupla");
        String file = "home//adriano.pdb";
        String expResult = "pdb";
        String result = Util.getFileType(file);
        assertEquals(expResult, result);
    }
    @Test
    @Ignore
    public void testGetArquivos() {
        System.out.println("getFileTypeComBarraDupla");
        ArrayList<String> result;
        result = Util.getArquivos("/home/adriano/NetBeansProjects", "txt");
        if(result.isEmpty()){
            fail("Não foram encontrados arquivos");
        }
    }
}
