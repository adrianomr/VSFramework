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
public class BoxCenter {
    Double x, y, z;

    public BoxCenter(Double x, Double y, Double z) {
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

    @Override
    public String toString() {
        return "{" + "\"x\": \"" + x + "\", \"y\": \"" + y + "\", \"z\": \"" + z + "\"}";
    }
    
    
}
