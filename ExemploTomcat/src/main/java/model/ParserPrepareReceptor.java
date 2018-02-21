/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author SCADI
 */
public class ParserPrepareReceptor extends Parser{
    
    public ParserPrepareReceptor(VirtualScrenning virtualScrenning) {
        super(virtualScrenning);
    }
    
    public PythonBuilder getPrepareReceptor(){
        String q = "\"";
    String qlinha = "\\n";
    String cifrao = "$";
        getPythonBuilder().addLinha("\n\n#Creation of file .sh to convert");
        if(isMultipleReceptors()){
            getPythonBuilder().addLinha("for receptor in lista_receptores:");
            getPythonBuilder().addPythonIdentationBlock();
            getPythonBuilder().addLinha("aux_receptor = " + q + "" + q + "");
            getPythonBuilder().addLinha("aux_receptor = receptor.replace(" + q + "." + getVirtualScrenning().getReceptor().getFileType()+ "" + q + "," + q + "" + q + ")");
        }else{
            getPythonBuilder().addLinha("receptor = \""+getVirtualScrenning().getReceptor().getFileName()+"."+getVirtualScrenning().getReceptor().getFileType()+"\"");
            getPythonBuilder().addLinha("aux_receptor = \""+getVirtualScrenning().getReceptor().getFileName()+"\"");
        }
	getPythonBuilder().addLinha("f = open(" + q + "" + getVirtualScrenning().getReceptor().getFilePath() + "executa_prepare_receptor4.sh" + q + "," + q + "w" + q + ")");
	getPythonBuilder().addLinha("f.write(" + q + "export PATH=" + getVirtualScrenning().getMGLPath() + "bin:" + cifrao + "PATH" + qlinha + "" + q + ")");
	getPythonBuilder().addLinha("f.write(" + q + "pythonsh " + getVirtualScrenning().getMGLPath() + "MGLToolsPckgs/AutoDockTools/Utilities24/prepare_receptor4.py -A 'checkhydrogens' -r " + getVirtualScrenning().getReceptor().getFilePath() + q + "+receptor+" + q + " -o " + getVirtualScrenning().getReceptor().getFilePath() + q + "+aux_receptor+" + q + ".pdbqt" + q + ")");	
	getPythonBuilder().addLinha("f.close()");
	getPythonBuilder().addLinha("os.system(" + q + "chmod 777 " + getVirtualScrenning().getReceptor().getFilePath() + "executa_prepare_receptor4.sh" + q + ")");
	getPythonBuilder().addLinha("os.system(" + q + "" + getVirtualScrenning().getReceptor().getFilePath() + "executa_prepare_receptor4.sh" + q + ")");
        getPythonBuilder().removePythonIdentationBlock();
        getPythonBuilder().addLinha("#-----------------------------------------\n");
        return getPythonBuilder();
    }
    private boolean isMultipleReceptors(){
        return this.getVirtualScrenning().getReceptor().isMultipleReceptors();
    }

    @Override
    public PythonBuilder executeParser(PythonBuilder pythonBuilder) {
        super.executeParser(pythonBuilder);
        return getPrepareReceptor();
    }
    
    
}
