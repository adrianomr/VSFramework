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
public class ParserHeaderTest {
    
    public ParserHeaderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pythonBuilder = new PythonBuilder();
    }
    
    @After
    public void tearDown() {
    }
    
    PythonBuilder pythonBuilder;

    /**
     * Test of getParseHeader method, of class ParseHeader.
     */
    @Test
    public void testGetParseHeader() {
        System.out.println("getParseHeader");
        
        ParseHeader instance = new ParseHeader();
        String expResult = "";
        expResult +=  "#!/usr/bin/python\r\n" + "# -*- coding: utf-8 -*-\r\n" +
            "import subprocess\r\n" +
            "from subprocess import Popen\r\n" + "import os\r\n" +
            "import shlex\r\n" +
             "import time\nimport os\nfrom os import listdir\n"
                + "from os.path import isfile, join\nfrom random import randint\n\n";
        

        String result = instance.executeParser(new PythonBuilder()).getPythonCode();
        assertEquals(expResult, result);
    }
    
}
