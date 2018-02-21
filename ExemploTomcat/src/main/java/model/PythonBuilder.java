/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author adriano
 */
public class PythonBuilder {
    private String pythonIdentation;
    private String pythonCode;

    public PythonBuilder() {
        this.pythonIdentation = "";
        this.pythonCode = "";
    }
    
    
    
    public void addPythonIdentationBlock(){
        pythonIdentation += "\t";
    }
    
    public void removePythonIdentationBlock(){
        if(pythonIdentation.length()>=1)
            pythonIdentation = pythonIdentation.substring(0, pythonIdentation.length()-1);
    }
    
    public String getPythonIdentation(){
        return pythonIdentation;
    }
    
    public void addLinha(String linha){
        pythonCode += getPythonIdentation() + linha +"\n";
    }
    
    public String getPythonCode(){
        return pythonCode;
    }
}
