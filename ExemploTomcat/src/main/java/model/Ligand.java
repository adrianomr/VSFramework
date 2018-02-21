/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author adriano
 */
public class Ligand {
    private String fileName;
    private String fileType;
    private String filePath;
    private boolean rigidLigand;
    private boolean multipleLigands;
    
    public Ligand(String file, String fileType,
            boolean rigidLigand, boolean multipleLigands){
        this.fileName = Util.getFileName(file);
        this.fileType = fileType;
        this.filePath = file.substring(0, file.length()-this.fileName.length()-this.fileType.length()-1);
        this.rigidLigand = rigidLigand;
        this.multipleLigands = multipleLigands;
    }
    
    public void setFile(String file, String filePath){
        fileName = Util.getFileName(file);
        fileType = Util.getFileType(file);
        this.filePath = filePath;
    }
    
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFilePath() {
        return filePath;
    }

    public boolean isRigidLigand() {
        return rigidLigand;
    }

    public boolean isMultipleLigands() {
        return multipleLigands;
    }
    
    
    public static ArrayList<String> listPermitedExtensions(){
        ArrayList<String> permitedExtensions = new ArrayList<String>();
        permitedExtensions.add("pdb");
        return permitedExtensions;
    }
    
    public static boolean isExtensionPermited(String fileName){
        if(listPermitedExtensions().contains(Util.getFileType(fileName))){
            return true;
        }
        return false;
    }

    void setMultipleLigands(boolean multipleLigands) {
        this.multipleLigands = multipleLigands;
    }

    @Override
    public String toString() {
        return "{" + "\"fileName\": \"" + fileName + "\", \"fileType\":\"" + fileType + "\", \"filePath\": \"" + filePath + "\", \"rigidLigand\": \"" + rigidLigand + "\", \"multipleLigands\": \"" + multipleLigands + "\"}";
    }

    public void setFilePath(String caminhoLigand) {
        this.filePath = caminhoLigand;
    }
    
    
}
