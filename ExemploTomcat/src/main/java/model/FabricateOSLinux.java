/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import interfaces.IFabricateOperationalSystem;
import interfaces.IOperationalSystem;

/**
 *
 * @author adriano
 */
public class FabricateOSLinux implements IFabricateOperationalSystem{

    @Override
    public IOperationalSystem getOperationalSystem() {
        return new OSLinux();
    }
    
}
