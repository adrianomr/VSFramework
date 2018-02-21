/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import interfaces.IOperationalSystem;
import java.util.ArrayList;

/**
 *
 * @author adriano
 */
public class VirtualScrenning {
    private String id;
    private String name;
    private String distributionConfig;
    private Box box;
    private int exhaustiveness;
    private Ligand ligand;
    private Receptor receptor;
    private final String path;
    private final String MGLPath;
    private int numberOfTimesToRepeat;
    private IOperationalSystem operationalSystem;
    private String outputPath;
    private String nodeId;
    private int totalNodes;
    public VirtualScrenning(String id, String name, String ditributionConfig, Double boxCenterX, Double boxCenterY, Double boxCenterZ,
    Double boxsizeX, Double boxSizeY, Double boxSizeZ, int exhaustiveness, Ligand ligand,
    Receptor receptor, String path, String MGLPath, int numberOfTimesToRepeat, IOperationalSystem operationalSystem, String outputPath) {
        BoxCenter boxCenter = new BoxCenter(boxCenterX, boxCenterY, boxCenterZ);
        BoxSize boxSize = new BoxSize(boxSizeZ, boxSizeY, boxSizeZ);
        box = new Box(boxCenter, boxSize);
        this.exhaustiveness = exhaustiveness;
        this.ligand = ligand;
        this.receptor = receptor;
        this.path = path;
        this.MGLPath = MGLPath;
        this.numberOfTimesToRepeat = numberOfTimesToRepeat;
        this.operationalSystem = operationalSystem;
        this.outputPath = outputPath;
        this.id= id;
        this.name = name;
        this.distributionConfig = ditributionConfig;
        this.nodeId = "";
        this.totalNodes = 0;
    }
    
    public VirtualScrenning(String id, String name, String distributionConfig, 
            Box box, int exhaustiveness, Ligand ligand,
    Receptor receptor, String path, String MGLPath, int numberOfTimesToRepeat, IOperationalSystem operationalSystem, String outputPath) {
        this.box = box;
        this.exhaustiveness = exhaustiveness;
        this.ligand = ligand;
        this.receptor = receptor;
        this.path = path;
        this.MGLPath = MGLPath;
        this.numberOfTimesToRepeat = numberOfTimesToRepeat;
        this.operationalSystem = operationalSystem;
        this.outputPath = outputPath;
        this.id= id;
        this.name = name;
        this.distributionConfig = distributionConfig;
        this.nodeId = "";
        this.totalNodes = 0;
    }
    
    
    public IOperationalSystem getOperationalSystem(){
        return operationalSystem;
    }

    public Box getBox() {
        return box;
    }

    public int getExhaustiveness() {
        return exhaustiveness;
    }

    public Ligand getLigand() {
        return ligand;
    }
    
    public Receptor getReceptor(){
        return receptor;
    }

    public String getPath() {
        return path;
    }

    public String getMGLPath() {
        return MGLPath;
    }

    public int getNumberOfTimesToRepeat() {
        return numberOfTimesToRepeat;
    }

    public void setNumberOfTimesToReapeat(int numberOfTimesToRepeat) {
        this.numberOfTimesToRepeat = numberOfTimesToRepeat;
    }
    
    public String getGeneratePythonCode(){
        String pythonCode = "";
//        ParseHeader parseHeader = new ParseHeader(get)
        ParserVirtualScrenning parserVirtualScrenning = new ParserVirtualScrenning(this);
        parserVirtualScrenning.executeParser(new PythonBuilder());
        return parserVirtualScrenning.getPythonBuilder().getPythonCode();
    }
    public String getOutputPath(){
        return outputPath;
    }

    boolean doesBoxVariates() {
        return getBox().DoesXVariate() || getBox().DoesYVariate() || getBox().DoesZVariate();
    }

    public String getID() {
        return this.id; //To change body of generated methods, choose Tools | Templates.
    }

    public String getName() {
        return this.name; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "VirtualScrenning{" + "id=" + id + ", name=" + name + ", box=" + box + ", exhaustiveness=" + exhaustiveness + ", ligand=" + ligand + ", receptor=" + receptor + ", path=" + path + ", MGLPath=" + MGLPath + ", numberOfTimesToRepeat=" + numberOfTimesToRepeat + ", operationalSystem=" + operationalSystem + ", outputPath=" + outputPath + '}';
    }
    
    public String toJson() {
        return "{" + "\"id\" : \"" + id + "\", \"name\" : \"" + name + "\", "+
                "\"distributionConfig\" : \"" + distributionConfig + "\", "
                + "\"box\":" + box.toString() + ", "
                + "\"exhaustiveness\" : \"" + exhaustiveness + "\", "
                + "\"ligand\" : " + ligand.toString() + ", \"receptor\" : " + receptor.toString() + ", "
                + "\"path\" : \"" + path + "\", \"MGLPath\" : \"" + MGLPath + "\", "
                + "\"numberOfTimesToRepeat\" : \"" + numberOfTimesToRepeat + "\", "
                + "\"operationalSystem\" : \"" + operationalSystem.getOSName() + "\", "
                + "\"totalNodes\" : \"" + totalNodes + "\", "
                + "\"nodeId\" : \"" + nodeId + "\", "
                + "\"outputPath\" : \"" + outputPath + "\"}";
    }

    public String getDistributionConfig() {
        return distributionConfig;
    }

    public void setDistributionConfig(String distributionConfig) {
        this.distributionConfig = distributionConfig;
    }

    public VirtualScrenning setNodeId(String nodeId) {
        this.nodeId = nodeId;
        return this;
    }

    public void setTotalNodes(String totalNodes) {
        this.totalNodes = Integer.parseInt(totalNodes);
    }

    public String getNodeId() {
        return nodeId;
    }

    public int getTotalNodes() {
        return totalNodes;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }
    
    

    
}
