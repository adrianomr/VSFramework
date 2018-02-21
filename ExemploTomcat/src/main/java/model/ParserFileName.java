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
public class ParserFileName extends Parser{
    
    private String fileName = "";
    private String fileNameInputs = "";
    String quotationMarks = "\"";
    String makeDirCommand;
    Box box;
    public ParserFileName(VirtualScrenning virtualScrenning){
        super(virtualScrenning);
        this.box = virtualScrenning.getBox();
        this.makeDirCommand = virtualScrenning.getOperationalSystem().getMakeDirCommand();
    }
    public String getCreateFileString() {
        String fileNameCommand = quotationMarks
                + makeDirCommand ;
        String fileNameInputsCommand = " % (";
        fileNameCommand += getFileName(true);
        fileNameCommand +=  quotationMarks;
        fileNameInputsCommand += getFileNameInputs(true);
        fileNameInputsCommand += ")";
        return fileNameCommand+fileNameInputsCommand;
    }
    public String getFileName(boolean addOutputPath){
        parseFileHandleStrings(addOutputPath);
        return fileName;
    }
    public String getFileNameInputs(boolean addOutputPath){
        parseFileHandleStrings(addOutputPath);
        return fileNameInputs;
    }
    private void parseFileHandleStrings(boolean addOutputPath) {
//        fileName = quotationMarks
//                + makeDirCommand;
        fileName = "";
        fileNameInputs = "";
        if(addOutputPath){
            fileName += " %s" + getPathSeparator();
            fileNameInputs += ",output_path";
        }
        fileName += "%s";
        fileNameInputs += ",aux_ligand";
        
//        if(box.DoesXVariate()||box.DoesYVariate()||box.DoesZVariate())
            
        if (box.DoesXVariate()) {
            fileName += "_coord_x_%i";
            fileNameInputs += ",elem_x";
        }
        if (box.DoesYVariate()) {
            fileName += "_y_%i";
            fileNameInputs += ",elem_y";
        }
        if (box.DoesZVariate()) {
            fileName += "_z_%i";
            fileNameInputs += ",elem_z";
        }
        if(getVirtualScrenning().getNumberOfTimesToRepeat() > 0){
            fileName += "_time_%i";
            fileNameInputs += ",number_of_times_executed";
        }
    }
}
