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
public class BoxSize {
    Double x, y, z;

    public BoxSize(Double x, Double y, Double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getZ() {
        return z;
    }

    public void setZ(Double z) {
        this.z = z;
    }
    
    public boolean isValid(){
        if(getX() < 0d)
            return false;
        if(getY() < 0d)
            return false;
        if(getZ() < 0d)
            return false;
        
        return true;
    }

    @Override
    public String toString() {
        return "{" + "\"x\": \"" + x + "\", \"y\": \"" + y + "\", \"z\": \"" + z + "\"}";
    }
    
}
