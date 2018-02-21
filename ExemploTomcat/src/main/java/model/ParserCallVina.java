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
public class ParserCallVina extends Parser {

    private VirtualScrenningFileName virtualScrenningFileName;
    private VirtualScrenningFileNameInputs virtualScrenningFileNameInputs;
    private VirtualScrenningFilePathMakeDir virtualScrenningFilePathMakeDir;
    private VirtualScrenningFilePathInputs virtualScrenningFilePathInputs;
    public ParserCallVina(VirtualScrenning virtualScrenning) {
        super(virtualScrenning);
        this.virtualScrenningFileName = new VirtualScrenningFileName(virtualScrenning);
        this.virtualScrenningFileNameInputs = new VirtualScrenningFileNameInputs(virtualScrenning);
        this.virtualScrenningFilePathMakeDir = new VirtualScrenningFilePathMakeDir(virtualScrenning);
        this.virtualScrenningFilePathInputs = new VirtualScrenningFilePathInputs(virtualScrenning);
    }

    public PythonBuilder getParserCallVina() {
        String q = "\""; //aspa dupla
        String qlinha = "\n";
        String barra = "\\";
        if("file".equals(getVirtualScrenning().getDistributionConfig().toLowerCase())){
            getPythonBuilder().addLinha("if(count%total_nodes == node_id):");
            getPythonBuilder().addPythonIdentationBlock();
        }
        getPythonBuilder().addLinha("#Creation of file .sh to play the autodock vina\n");
        getPythonBuilder().addLinha("f = open(" + q + "" + getVirtualScrenning().getPath() + "executa_vina.sh" + q + "," + q + "w" + q + ")");
        
        
        getPythonBuilder().addLinha("f.write(" + q + "vina --config " + getVirtualScrenning().getPath() + "conf.txt --ligand %s%s.pdbqt --receptor %s%s.pdbqt --out "
                
                + virtualScrenningFilePathMakeDir.getVirtualScrenningFilePath()
                + "out_" 
                + virtualScrenningFileName.getVirtualScrenningFileName() + ".pdbqt --log "
                + virtualScrenningFilePathMakeDir.getVirtualScrenningFilePath()
                +"log_"
                + virtualScrenningFileName.getVirtualScrenningFileName() + ".txt" + q
                + " % ("+ "ligand_path, aux_ligand, receptor_path, aux_receptor"
                + (getVirtualScrenning().doesBoxVariates() ? ", output_path"
                + virtualScrenningFilePathInputs.getFilePathInputs() : "")
                + virtualScrenningFileNameInputs.getFileNameInputs()
                + (getVirtualScrenning().doesBoxVariates() ? ", output_path"
                + virtualScrenningFilePathInputs.getFilePathInputs()
                + virtualScrenningFileNameInputs.getFileNameInputs() : "")+ "))");
        getPythonBuilder().addLinha("f.close()");
        getPythonBuilder().addLinha("#-----------------------------------------");
        if(getVirtualScrenning().doesBoxVariates()){
            getPythonBuilder().addLinha("os.system(\"mkdir "+ virtualScrenningFilePathMakeDir.getVirtualScrenningFilePath() +"\" % (output_path"+ virtualScrenningFilePathInputs.getFilePathInputs()+"))");
        }
        getPythonBuilder().addLinha("os.system(" + q + "chmod 777 " + getVirtualScrenning().getPath() + "executa_vina.sh" + q + ")");
        if(getVirtualScrenning().getNumberOfTimesToRepeat() > 0 
                || (getVirtualScrenning().getReceptor().isMultipleReceptors()
                && !getVirtualScrenning().getLigand().isMultipleLigands())){
            getPythonBuilder().addLinha("os.system(" + q + "chmod 777 " + getVirtualScrenning().getPath() + "conf.txt" + q + ")");
        }
        getPythonBuilder().addLinha("print (" + q + "Vina is Running" + q + ")");
//        if(getVirtualScrenning().doesBoxVariates())
//            getPythonBuilder().addLinha("os.system(" + q + "" + getVirtualScrenning().getPath() + "executa_vina.sh" + q + ")#Call to execution of AutoDock Vina");
        getPythonBuilder().addLinha("os.system(" + q + "" + getVirtualScrenning().getPath() + "executa_vina.sh" + q + ")#Call to execution of AutoDock Vina");
        if(getVirtualScrenning().getNumberOfTimesToRepeat()>0){
            getPythonBuilder().addLinha("number_of_times_to_exec = number_of_times_to_exec - 1");
            getPythonBuilder().addLinha("number_of_times_executed = number_of_times_executed + 1");
        }
        if("file".equals(getVirtualScrenning().getDistributionConfig().toLowerCase())){
            getPythonBuilder().removePythonIdentationBlock();
        }
        return getPythonBuilder();
    }

}
