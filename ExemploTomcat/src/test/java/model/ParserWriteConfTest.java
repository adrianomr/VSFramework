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
public class ParserWriteConfTest {
    
    public ParserWriteConfTest() {
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
     * Test of getWriteConf method, of class ParserWriteConf.
     */
    @Test
    public void testGetWriteConf() {
        System.out.println("getWriteConf");
        ParserWriteConf instance = new ParserWriteConf(Util.getVirtualScrenningForTests());
        String expResult = "";
        String q = "\"";
        String qlinha = "\\n";
        expResult += "f = open(" + q + "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/conf.txt" + q + " ," + q + "w" + q + ")\n";
        expResult += "for elem in lista:\n\tf.write(" + q + "%s" + q + " % elem)\n\n";
        expResult += "f.close()\n#-----------------------------------------\n";
        System.out.println(expResult);
        
        String result = instance.getWriteConf().getPythonCode();
        System.out.println(result);
        assertEquals(expResult, result);
    }
    
}
