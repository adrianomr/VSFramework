/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import interfaces.IParser;

/**
 *
 * @author adriano
 */
public class ParserWriteConf extends Parser implements IParser{
    
    public ParserWriteConf(VirtualScrenning virtualScrenning) {
        super(virtualScrenning);
    }
    
    public PythonBuilder getWriteConf(){
        String q = "\"";
        getPythonBuilder().addLinha("f = open(" + q + getVirtualScrenning().getPath() +"conf.txt" + q + " ," + q + "w" + q + ")");
        getPythonBuilder().addLinha("for elem in lista:");
        getPythonBuilder().addPythonIdentationBlock();
        getPythonBuilder().addLinha("f.write(" + q + "%s" + q + " % elem)\n");
        getPythonBuilder().removePythonIdentationBlock();
        getPythonBuilder().addLinha("f.close()");
        getPythonBuilder().addLinha("#-----------------------------------------");
        return getPythonBuilder();
    }

    @Override
    public PythonBuilder executeParser(PythonBuilder pythonBuilder) {
        setPythonBuilder(pythonBuilder);
        return getWriteConf(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
