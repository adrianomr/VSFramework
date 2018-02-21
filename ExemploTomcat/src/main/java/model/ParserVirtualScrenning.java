package model;


import interfaces.IParser;
import model.Parser;
import model.VirtualScrenning;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adriano
 */
public class ParserVirtualScrenning extends Parser implements IParser{
    private ParseHeader parserHeader;
    private ParserInput parserInput;
    public ParserVirtualScrenning(VirtualScrenning virtualScrenning) {
        super(virtualScrenning);
        parserHeader = new ParseHeader();
        parserInput = new ParserInput(virtualScrenning);
        addParser(parserHeader).addParser(parserInput);
        if("mol2".equals(getVirtualScrenning().getLigand().getFileType().toLowerCase().trim())){
            addParser(new ParserSplitMol2(getVirtualScrenning()));
        }
        if(!getVirtualScrenning().getLigand().isMultipleLigands() &&
                !getVirtualScrenning().getReceptor().isMultipleReceptors()){
            addParser(new ParserCreateConf(getVirtualScrenning()))
                    .addParser(new ParserWriteConf(getVirtualScrenning()));
        }
        if(getVirtualScrenning().getLigand().isMultipleLigands()){
            addParser(new ParserPrepareReceptor(getVirtualScrenning()));
        }
        if(getVirtualScrenning().getReceptor().isMultipleReceptors()){
            addParser(new ParserPrepareLigand(getVirtualScrenning()));
        }
        addParser(new ParserBox(getVirtualScrenning()));
    }

    @Override
    public PythonBuilder executeParser(PythonBuilder pythonBuilder) {
        
        return super.executeParser(getPythonBuilder());
    }
    
}
