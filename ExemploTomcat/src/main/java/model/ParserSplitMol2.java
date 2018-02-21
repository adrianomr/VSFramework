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
public class ParserSplitMol2 extends Parser {

    public ParserSplitMol2(VirtualScrenning virtualScrenning) {
        super(virtualScrenning);
    }

    public PythonBuilder getSplitMol2() {
        String q = "\"";
        String barra = "\\";
        String qlinha = "\\n";
        getPythonBuilder().addLinha("#Split the file .mol2 in many small files");
        getPythonBuilder().addLinha("count = 0");
        getPythonBuilder().addLinha("lista_nomes_lig = []");
        getPythonBuilder().addLinha("lista_nomes_lig_sem_ext = []");
        getPythonBuilder().addLinha("file_mol2 = open(" + q + "" + getVirtualScrenning().getLigand().getFilePath() + getVirtualScrenning().getLigand().getFileName() + ".mol2" + q + "," + q + "r" + q + ")");
        getPythonBuilder().addLinha("file = open(" + q + "" + getVirtualScrenning().getLigand().getFilePath() + getVirtualScrenning().getLigand().getFileName() + ".mol2" + q + "," + q + "r" + q + ")");
        getPythonBuilder().addLinha("for linha in file_mol2:");
        getPythonBuilder().addPythonIdentationBlock();
        getPythonBuilder().addLinha("if(linha==" + q + "@<TRIPOS>MOLECULE" + qlinha + "" + q + "):");
        getPythonBuilder().addPythonIdentationBlock();
        getPythonBuilder().addLinha("file.close()");
        getPythonBuilder().addLinha("count = count + 1");
        getPythonBuilder().addLinha("aux_count = str(count)");
        getPythonBuilder().addLinha("path_lig_name = " + q + "" + getVirtualScrenning().getLigand().getFilePath() + getVirtualScrenning().getLigand().getFileName() + "" + q + " + aux_count + " + q + ".mol2" + q);
        getPythonBuilder().addLinha("lig_name = " + q + "" + getVirtualScrenning().getLigand().getFileName() + "" + q + " + aux_count + " + q + ".mol2" + q);
        getPythonBuilder().addLinha("lista_nomes_lig.append(lig_name)");
        getPythonBuilder().addLinha("lig_name_sem_ext = " + q + "" + getVirtualScrenning().getLigand().getFileName() + "" + q + " + aux_count");
        getPythonBuilder().addLinha("lista_nomes_lig_sem_ext.append(lig_name_sem_ext)");
        getPythonBuilder().addLinha("print lig_name_sem_ext");
        getPythonBuilder().addLinha("file = open(path_lig_name," + q + "w" + q + ")");
        getPythonBuilder().addLinha("file.write(linha)");
        getPythonBuilder().removePythonIdentationBlock();
        getPythonBuilder().addLinha("else:");
        getPythonBuilder().addPythonIdentationBlock();
        getPythonBuilder().addLinha("file.write(linha)");
        getPythonBuilder().removePythonIdentationBlock();
        getPythonBuilder().removePythonIdentationBlock();
        getPythonBuilder().addLinha("file.close()");
        getPythonBuilder().addLinha("file_mol2.close()");
        return getPythonBuilder();
    }

    @Override
    public PythonBuilder executeParser(PythonBuilder pythonBuilder) {
        super.executeParser(pythonBuilder); 
        return getSplitMol2();
    }
    
    
}
