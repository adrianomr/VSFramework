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
public class Box {

    private BoxCenter boxCenter;
    private BoxSize boxSize;
    private BoxVariation boxVariation;
//    private ParserBox boxParser;
//    private PythonBuilder pythonBuilder;
    String newLine = "\n";
    String quotationMarks = "\"";
    private String path = "";

    public Box(BoxCenter boxCenter, BoxSize boxSize) {
        this.boxCenter = boxCenter;
        this.boxSize = boxSize;
//        this.boxParser = boxParser;
        this.boxVariation = new BoxVariation();
//        this.pythonBuilder = new PythonBuilder();
//        this.boxParser = new ParserBox(this, pythonBuilder, quotationMarks, path, newLine, "md");
    }

    public Box(BoxCenter boxCenter, BoxSize boxSize,
            BoxVariation boxVariation) {
        this.boxCenter = boxCenter;
        this.boxSize = boxSize;
        this.boxVariation = boxVariation;
//        this.pythonBuilder = new PythonBuilder();
//        this.boxParser = new ParserBox(this, pythonBuilder, quotationMarks, path, newLine, "md");
    }

//    public void addPythonIdentationBlock(){
//        pythonIdentation += "\t";
//    }
    

//    public String getStringPython(String path) {
//        this.path = path;
//        boxParser.getBoxHeader();
//        boxParser.getWhileX();
//        boxParser.getWhileY();
//        boxParser.getWhileZ();
//        boxParser.getForXYZ();
//        pythonBuilder.addLinha("number_of_times_to_exec = number_of_times_to_exec - 1");
//        pythonBuilder.addLinha("number_of_times_executed = number_of_times_executed + 1");
//        return pythonBuilder.getPythonCode();
//    }

    /*
        ----------------Getters and Setters------------------
     */
    public BoxCenter getBoxCenter() {
        return boxCenter;
    }

    public void setBoxCenter(BoxCenter boxCenter) {
        this.boxCenter = boxCenter;
    }

    public BoxSize getBoxSize() {
        return boxSize;
    }

    public void setBoxSize(BoxSize boxSize) {
        this.boxSize = boxSize;
    }

    public BoxVariation getBoxVariation() {
        return boxVariation;
    }

    public void setBoxVariation(BoxVariation boxVariation) {
        this.boxVariation = boxVariation;
    }

    

    public boolean DoesXVariate() {
        return this.getBoxVariation().doesXVariate(this.getBoxCenter().getX());
    }

    public boolean DoesYVariate() {
        return this.getBoxVariation().doesYVariate(this.getBoxCenter().getY());
    }

    public boolean DoesZVariate() {
        return this.getBoxVariation().doesZVariate(this.getBoxCenter().getZ());
    }

//    public ParserBox getBoxParser() {
//        return boxParser;
//    }

    @Override
    public String toString() {
        return "{" + "\"boxCenter\": " + boxCenter.toString() + 
                ", \"boxSize\":" + boxSize.toString() + 
                ", \"boxVariation\":" + boxVariation.toString() + 
                "}";
    }

    

}
