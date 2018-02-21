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
public class Receptor {
    private String fileName;
    private String fileType;
    private String filePath;
    private boolean multipleReceptors;
    
    public Receptor(String file, String fileType, boolean multipleReceptors){
        if(multipleReceptors){
            this.fileName = "";
            this.fileType = fileType;
            this.filePath = file;
        }else{
            System.out.println("RecName: "+Util.getFileName(file));
            System.out.println("File: "+file);
            this.fileName = Util.getFileName(file);
            this.fileType = fileType;
            this.filePath = file.substring(0, file.length()-this.fileName.length()-this.fileType.length()-1);
        }
        this.multipleReceptors = multipleReceptors;
    }
    
    public void setFile(String file){
        fileName = Util.getFileName(file);
        fileType = Util.getFileType(file);
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

    public boolean isMultipleReceptors() {
        return multipleReceptors;
    }

    public void setMultipleReceptors(boolean multipleReceptors) {
        this.multipleReceptors = multipleReceptors;
    }

    @Override
    public String toString() {
        return "{" + "\"fileName\": \"" + fileName + "\", \"fileType\": \"" + fileType + "\", \"filePath\":\"" + filePath + "\", \"multipleReceptors\": \"" + multipleReceptors + "\"}";
    }

    public ArrayList<String> getFiles() {
        return Util.getArquivos(filePath, fileType);
    }

    public void setFilePath(String caminhoReceptor) {
        this.filePath = caminhoReceptor;
    }
    
    
}
