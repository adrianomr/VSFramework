/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import interfaces.IOperationalSystem;

/**
 *
 * @author adriano
 */
public class OSWindows implements IOperationalSystem{
private String pathSepartor;
    private String executavelExtension;
    private String makeDirCommand;
    private String OSName;
    private OperationalSystems operatinalSystem;
    public OSWindows(){
        this.pathSepartor = "\\";
        this.executavelExtension = ".bat";
        this.makeDirCommand = "md";
        this.OSName = "Windows";
        this.operatinalSystem = OperationalSystems.Windows;
    }
    
    @Override
    public String getPathSeparator() {
        return this.pathSepartor; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getExecutavelExtension() {
        return this.executavelExtension; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getMakeDirCommand() {
        return this.makeDirCommand; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getOSName() {
        return OSName;
    }
    
    @Override
    public OperationalSystems getOperationalSystem() {
        return operatinalSystem;
    }
    
}
