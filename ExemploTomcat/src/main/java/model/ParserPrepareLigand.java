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
public class ParserPrepareLigand extends Parser {
    String q = "\"";
    String qlinha = "\\n";
    String cifrao = "$";
    public ParserPrepareLigand(VirtualScrenning virtualScrenning) {
        super(virtualScrenning);
    }

    public PythonBuilder getPrepareLigand() {
        
        getPythonBuilder().addLinha("\n\n#Creation of file .sh to convert");
        prepareLigandMultipleLigands();
        getPythonBuilder().addLinha("f.write(" + q + "export PATH=" + getVirtualScrenning().getMGLPath() + "bin:" + cifrao + "PATH" + qlinha + "" + q + ")");
        getPythonBuilder().addLinha("str_path_ligand = " + q + "pythonsh " + getVirtualScrenning().getMGLPath() + "MGLToolsPckgs" + this.getPathSeparator() + "AutoDockTools" + this.getPathSeparator() + "Utilities24" + this.getPathSeparator() + "prepare_ligand4.py "+getRigidLigandText()+"-l " + getVirtualScrenning().getPath() + q + "+ str_ligand_name +" + q + " -d ligand_dict.py -o " + getVirtualScrenning().getPath() + q + "+ str_ligand_name_without_type +" + q + ".pdbqt" + q + "");
        getPythonBuilder().addLinha("f.write(str_path_ligand)");
        getPythonBuilder().addLinha("f.close()");
        getPythonBuilder().addLinha("os.system(" + q + "chmod 777 " + getVirtualScrenning().getPath()  + "executa_prepare_ligand4"+ this.getSystemFileExtension() + q + ")");
        getPythonBuilder().addLinha("os.system(" + q + "" + getVirtualScrenning().getPath()  + "executa_prepare_ligand4" + this.getSystemFileExtension() + q + ")");
        getPythonBuilder().removePythonIdentationBlock();
        getPythonBuilder().addLinha("#-----------------------------------------\n");
        return getPythonBuilder();
    }
    private String getRigidLigandText(){
        String texto = getVirtualScrenning().getLigand().isRigidLigand() ?
                "-Z " 
                :
                "";
        return texto;
    }

    private void prepareLigandMultipleLigands() {
        if(isMultipleLigands()){
            getPythonBuilder().addLinha("for elem_name_ligand in lista_nomes_lig:");
            getPythonBuilder().addPythonIdentationBlock();
            getPythonBuilder().addLinha("f = open(" + q + "" + getVirtualScrenning().getPath() +  "executa_prepare_ligand4"+ this.getSystemFileExtension() + q + "," + q + "w" + q + ")");
            getPythonBuilder().addLinha("str_ligand_name = elem_name_ligand");
            getPythonBuilder().addLinha("str_ligand_name_without_type = elem_name_ligand.split('.')");
            getPythonBuilder().addLinha("str_ligand_name_without_type = str_ligand_name_without_type[0]");

        }else{
            getPythonBuilder().addLinha("f = open(" + q + "" + getVirtualScrenning().getPath() +  "executa_prepare_ligand4"+ this.getSystemFileExtension() + q + "," + q + "w" + q + ")");
            getPythonBuilder().addLinha("str_ligand_name = "+getLigandName());
//            getPythonBuilder().addLinha("str_ligand_name_without_type = "+getLigandNameWithoutType());
            getPythonBuilder().addLinha("str_ligand_name_without_type = "+getLigandNameWithoutType());
        }
    }
    
    private boolean isMultipleLigands(){
        return getVirtualScrenning().getLigand().isMultipleLigands();
    }
    
    private String getLigandName(){
        String ligandName = 
                getVirtualScrenning().getLigand().getFileName() + "." +
                getVirtualScrenning().getLigand().getFileType();
        return ligandName;
    }
    private String getLigandNameWithoutType(){
        String ligandName = 
                getVirtualScrenning().getLigand().getFileName();
        return ligandName;
    }

    @Override
    public PythonBuilder executeParser(PythonBuilder pythonBuilder) {
        super.executeParser(pythonBuilder);
        return getPrepareLigand(); //To change body of generated methods, choose Tools | Templates.
    }

    

}
