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
public class ParserCreateWriteConfMultipleLigands extends Parser{
    
    public ParserCreateWriteConfMultipleLigands(VirtualScrenning virtualScrenning) {
        super(virtualScrenning);
    }
    
    public PythonBuilder getCreateWriteConfMultipleLigands(){
        String q = "\"";
        String qlinha = "\\n";
        ParserCreateConf parserCreateConf = new ParserCreateConf(getVirtualScrenning());
        ParserWriteConf parserWriteConf = new ParserWriteConf(getVirtualScrenning());
        if(getVirtualScrenning().getLigand().isMultipleLigands()&&getVirtualScrenning().getReceptor().isMultipleReceptors()){
            getPythonBuilder().addPythonIdentationBlock();
        }
        
        getPythonBuilder().addLinha("for ligand in lista_nomes_lig_sem_ext:");
        getPythonBuilder().addPythonIdentationBlock();
        getPythonBuilder().addLinha("aux_ligand = ligand");
        getPythonBuilder().addLinha("ligand = " + q + "ligand = " + q + " + ligand + " + q + ".pdbqt" 
            + q + " + " + q + "" + qlinha + "" + q);
        parserCreateConf.setPythonBuilder(getPythonBuilder());
        parserWriteConf.setPythonBuilder(parserCreateConf.getCriaConf());
        
        setPythonBuilder(parserWriteConf.getWriteConf());
        getPythonBuilder().removePythonIdentationBlock();
        return getPythonBuilder();
    }
}
