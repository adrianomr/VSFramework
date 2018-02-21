/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SCADI
 */
public class ExecuteShellCommandTest {
    
    public ExecuteShellCommandTest() {
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
    public void testExecuteRunPythonCode() throws IOException, InterruptedException{
                System.out.println("TestRunPythonCOde");
		String domainName = "google.com";

		//in mac oxs
//		String command = "ping -c 3 " + domainName;

		//in windows
                String caminho = System.getProperty("user.dir");
        String filePath = caminho + System.getProperty("file.separator")+"src"+System.getProperty("file.separator")+"main"+System.getProperty("file.separator")+"java"+System.getProperty("file.separator")+"pythonCodeForTests"+System.getProperty("file.separator");
        
		String command = "python " + filePath+"testPython.py";

		String output = ExecuteShellCommand.executeCommand(command);

		System.out.println(output);
    }
//    @Test
//    public void testExecuteZipOutputFolder() throws IOException, InterruptedException{
//                System.out.println("TestRunPythonCOde");
//		String domainName = "google.com";
//
//		//in mac oxs
////		String command = "ping -c 3 " + domainName;
//
//		//in windows
//                String caminho = System.getProperty("user.dir");
//        String filePath = caminho + System.getProperty("file.separator");//+"outputpath"+System.getProperty("file.separator");
//		String command = "tar -zcvf "+filePath+"output.tar.gz "+filePath+"outputpath";
//
//		String output = ExecuteShellCommand.executeCommand(command);
//
////		System.out.println(output);
//    }
//    tar -zcvf output.tar.gz Dropbox/Adriano/ExemploTomcat/src/main/java/outputpath/ 

    
}
