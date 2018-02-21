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
public class OSLinux implements IOperationalSystem{
    private String pathSepartor;
    private String executavelExtension;
    private String makeDirCommand;
    private String OSName;
    private OperationalSystems operatinalSystem;
    
    public OSLinux(){
        this.pathSepartor = "/";
        this.executavelExtension = ".sh";
        this.makeDirCommand = "mkdir";
        this.OSName = "Linux";
        this.operatinalSystem = OperationalSystems.Linux;
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
