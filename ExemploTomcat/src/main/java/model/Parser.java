/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import interfaces.IParser;
import java.util.ArrayList;

/**
 *
 * @author adriano
 */
public class Parser implements IParser{
    private PythonBuilder pythonBuilder;
    private VirtualScrenning virtualScrenning;
    private String pathSeparator;
    private ArrayList<IParser> compositeParsers;

    public Parser(VirtualScrenning virtualScrenning) {
        this.pythonBuilder = new PythonBuilder();
        compositeParsers = new ArrayList<IParser>();
        this.virtualScrenning = virtualScrenning;
        this.pathSeparator = getVirtualScrenning().getOperationalSystem().getPathSeparator();
    }

    public PythonBuilder getPythonBuilder() {
        return pythonBuilder;
    }
    
    public void setPythonBuilder(PythonBuilder pythonBuilder){
        if(pythonBuilder != null){
            this.pythonBuilder = pythonBuilder;
        }
    }

    public VirtualScrenning getVirtualScrenning() {
        return virtualScrenning;
    }

    public String getPathSeparator() {
        return pathSeparator;
    }
    public String getSystemFileExtension() {
        return this.virtualScrenning.getOperationalSystem().getExecutavelExtension();
    }
    
    public Parser addParser(IParser parser){
        compositeParsers.add(parser);
        return this;
    }

    @Override
    public PythonBuilder executeParser(PythonBuilder pythonBuilder) {
        for (IParser compositeParser : compositeParsers) {
            compositeParser.executeParser(pythonBuilder);
        }
        setPythonBuilder(pythonBuilder);
        return getPythonBuilder();
    }
    
    
    
}
