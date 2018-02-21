/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author SCADI
 */
public class ExecuteShellCommand {
    
    public static String executeCommand(String command) throws IOException, InterruptedException {

		StringBuffer output = new StringBuffer();
                System.out.println("command: "+command);
		Process p;
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader =
                            new BufferedReader(new InputStreamReader(p.getInputStream()));

                        String line = "";
			while ((line = reader.readLine())!= null) {
                                System.out.println("line:"+line);
				output.append(line + "\n");
			}
		return output.toString();
	}
    
}
