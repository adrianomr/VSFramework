/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
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
public class ReceptorTest {
    
    public ReceptorTest() {
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
     * Test of setFile method, of class Receptor.
     */
    @org.junit.Test
    public void testGetFilesList() {
        System.out.println("testGetFilesList");
        
        ArrayList<String> expectedFiles = new ArrayList<String>();
        expectedFiles.add("00_align_1s4f_ChainA.pdbqt");
        expectedFiles.add("00_align_1s48.pdbqt");
        expectedFiles.add("00_align_1S4F_Phyre.pdbqt");
        expectedFiles.add("00_align_1S48_Phyre.pdbqt");
        String caminho = System.getProperty("user.dir");
        String filePath = caminho + System.getProperty("file.separator")+"src"+System.getProperty("file.separator")+"main"+System.getProperty("file.separator")+"java"+System.getProperty("file.separator")+"testReceptor";
        System.out.println("FilePath"+filePath);
        Receptor instance = new Receptor(filePath, "pdbqt", true);
        ArrayList<String> files = instance.getFiles();
        for (int i = 0; i < files.size(); i++) {
            String file = files.get(i);
            String expectedFile = expectedFiles.get(i);
            assertEquals(expectedFile, file);
        }
    }

    
}
