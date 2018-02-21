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
public class BoxVariation {
    BoxCenter endCenter;
    Double xIncrement, yIncrement, zIncrement;

    public BoxVariation(BoxCenter endCenter) {
        this.endCenter = endCenter;
        this.xIncrement = 1d;
        this.yIncrement = 1d;
        this.zIncrement = 1d;
    }

    public BoxVariation(BoxCenter endCenter, Double xIncrement, Double yIncrement, Double zIncrement) {
        this.endCenter = endCenter;
        this.xIncrement = xIncrement;
        this.yIncrement = yIncrement;
        this.zIncrement = zIncrement;
    }

    BoxVariation() {
        this.endCenter = new BoxCenter(0d, 0d, 0d);
        this.xIncrement = 0d;
        this.yIncrement = 0d;
        this.zIncrement = 0d;
    }
    
    public boolean doesXVariate(Double x){
        if(x.doubleValue() != endCenter.getX().doubleValue()){
            return true;
        }
        return false;
    }
    
    public boolean doesYVariate(Double y){
        if(y.doubleValue() != endCenter.getY().doubleValue()){
            return true;
        }
        return false;
    }
    
    public boolean doesZVariate(Double z){
        if(z.doubleValue() != endCenter.getZ().doubleValue()){
            return true;
        }
        return false;
    }

    public Double getxIncrement() {
        return xIncrement;
    }

    public void setxIncrement(Double xIncrement) {
        this.xIncrement = xIncrement;
    }

    public Double getyIncrement() {
        return yIncrement;
    }

    public void setyIncrement(Double yIncrement) {
        this.yIncrement = yIncrement;
    }

    public Double getzIncrement() {
        return zIncrement;
    }

    public void setzIncrement(Double zIncrement) {
        this.zIncrement = zIncrement;
    }

    public BoxCenter getEndCenter() {
        return endCenter;
    }

    public void setEndCenter(BoxCenter endCenter) {
        this.endCenter = endCenter;
    }

    @Override
    public String toString() {
        return "{" + "\"endCenter\": " + endCenter.toString() + 
                ", \"xIncrement\": \"" + xIncrement +
                "\", \"yIncrement\": \"" + yIncrement +
                "\", \"zIncrement\": \"" + zIncrement + "\"}";
    }
    
    
    
}
