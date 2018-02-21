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
public class ExecuteVinaParser extends Parser {

    ParserFileName fileNameParser;

    public ExecuteVinaParser(ParserFileName fileNameParser, VirtualScrenning virtualScrenning) {
        super(virtualScrenning);
        this.fileNameParser = fileNameParser;

    }

    public String getExecuteVinaString(String quotationMarks, String path) {
        String executeVina = "";
        executeVina += quotationMarks + "vina --config " + path
                + "conf.txt --ligand %s" + getPathSeparator()
                + "%s.pdbqt --receptor %s" + getPathSeparator()
                + "%s.pdbqt --out" + ""
                + fileNameParser.getFileName(getVirtualScrenning().getBox().DoesXVariate()
                || getVirtualScrenning().getBox().DoesYVariate()
                || getVirtualScrenning().getBox().DoesZVariate()) + ""
                + "out_" + fileNameParser.getFileName(false) + ".pdbqt "
                + "--log"
                + fileNameParser.getFileName(getVirtualScrenning().getBox().DoesXVariate()
                || getVirtualScrenning().getBox().DoesYVariate()
                || getVirtualScrenning().getBox().DoesZVariate()) + ""
                + "log_" + fileNameParser.getFileName(false) + ".txt" + quotationMarks
                + " %(ligand_path,aux_ligand,receptor_path,aux_receptor";
                 executeVina += fileNameParser.getFileNameInputs(getVirtualScrenning().getBox().DoesXVariate()
                || getVirtualScrenning().getBox().DoesYVariate()
                || getVirtualScrenning().getBox().DoesZVariate());
            executeVina += fileNameParser.getFileNameInputs(false);
        
        executeVina += fileNameParser.getFileNameInputs(getVirtualScrenning().getBox().DoesXVariate()
                || getVirtualScrenning().getBox().DoesYVariate()
                || getVirtualScrenning().getBox().DoesZVariate());
            executeVina += fileNameParser.getFileNameInputs(false);
        executeVina += ")";
        return executeVina;
    }
}
