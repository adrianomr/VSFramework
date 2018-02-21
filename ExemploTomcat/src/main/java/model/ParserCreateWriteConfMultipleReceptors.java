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
public class ParserCreateWriteConfMultipleReceptors extends Parser{
    
    public ParserCreateWriteConfMultipleReceptors(VirtualScrenning virtualScrenning) {
        super(virtualScrenning);
    }
    
    public PythonBuilder getCreateWriteConfMultipleLigands(){
        String q = "\"";
        String qlinha = "\\n";
        ParserCreateConf parserCreateConf = new ParserCreateConf(getVirtualScrenning());
        ParserWriteConf parserWriteConf = new ParserWriteConf(getVirtualScrenning());
        getPythonBuilder().addLinha("");
        getPythonBuilder().addLinha("for receptor in lista_receptores:");
        getPythonBuilder().addPythonIdentationBlock();
        getPythonBuilder().addLinha( "aux_out_receptor = " + q + "" + q + "");
        getPythonBuilder().addLinha( "aux_conf_receptor = " + q + "" + q + "");
        getPythonBuilder().addLinha( "aux_receptor = " + q + "" + q + "");
        getPythonBuilder().addLinha( "aux_receptor = receptor.replace(" + q + "." + getVirtualScrenning().getReceptor().getFileType() + "" + q + "," + q + "" + q + ")");
        getPythonBuilder().addLinha( "aux_out_receptor = receptor");
        getPythonBuilder().addLinha( "aux_out_receptor = aux_out_receptor.replace(" + q + "." + getVirtualScrenning().getReceptor().getFileType() + "" + q + "," + q + "" + q + ")");
        getPythonBuilder().addLinha( "aux_ligand.replace(" + q + "" + qlinha + "" + q + "," + q + "" + q + ")");
        getPythonBuilder().addLinha( "aux_conf_receptor = receptor.replace(" + q + "." + getVirtualScrenning().getReceptor().getFileType() + "" + q + "," + q + "" + q + ")");
        getPythonBuilder().addLinha( "aux_conf_receptor = aux_conf_receptor + " + q + ".pdbqt" + q + "");
        getPythonBuilder().addLinha( "receptor = " + q + "receptor = " + q + " + aux_conf_receptor + " + q + "" + qlinha + "" + q + "");
        parserCreateConf.setPythonBuilder(getPythonBuilder());
        parserWriteConf.setPythonBuilder(parserCreateConf.getCriaConf());
        
        setPythonBuilder(parserWriteConf.getWriteConf());
        getPythonBuilder().removePythonIdentationBlock();
        return getPythonBuilder();
    }
}
