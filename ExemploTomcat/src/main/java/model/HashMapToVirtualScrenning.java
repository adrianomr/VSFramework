/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import interfaces.IFabricateOperationalSystem;
import java.util.HashMap;

/**
 *
 * @author adriano
 */
public class HashMapToVirtualScrenning {
    public static VirtualScrenning getVirtualScrenning(HashMap<String, String> mapVirtualScrenning){
        BoxCenter boxCenter = new BoxCenter(
                Double.parseDouble(mapVirtualScrenning.get("boxCenterX")),
                Double.parseDouble(mapVirtualScrenning.get("boxCenterY")),
                Double.parseDouble(mapVirtualScrenning.get("boxCenterZ")));
        BoxSize boxSize = new BoxSize(
                Double.parseDouble(mapVirtualScrenning.get("boxSizeX")),
                Double.parseDouble(mapVirtualScrenning.get("boxSizeY")),
                Double.parseDouble(mapVirtualScrenning.get("boxSizeZ")));
        BoxCenter boxEndCenter = new BoxCenter(
                Double.parseDouble(mapVirtualScrenning.get("boxEndCenterX")),
                Double.parseDouble(mapVirtualScrenning.get("boxEndCenterY")),
                Double.parseDouble(mapVirtualScrenning.get("boxEndCenterZ")));
        if("false".equals(mapVirtualScrenning.get("boxVariation"))){
            boxEndCenter = new BoxCenter( Double.parseDouble(mapVirtualScrenning.get("boxCenterX")),
                Double.parseDouble(mapVirtualScrenning.get("boxCenterY")),
                Double.parseDouble(mapVirtualScrenning.get("boxCenterZ")));
        }
        BoxVariation boxVariation = new BoxVariation(
                boxEndCenter,
                Double.parseDouble(mapVirtualScrenning.get("boxStepX")),
                Double.parseDouble(mapVirtualScrenning.get("boxStepY")),
                Double.parseDouble(mapVirtualScrenning.get("boxStepZ")));
        Box box = new Box(boxCenter, boxSize, boxVariation);
        
        Ligand ligand = new Ligand(
                mapVirtualScrenning.get("ligandPath"), 
                mapVirtualScrenning.get("ligandType"),
                "true".equals(mapVirtualScrenning.get("rigidLigand")),
                "true".equals(mapVirtualScrenning.get("multipleLigands")));
        Receptor receptor = new Receptor(
                mapVirtualScrenning.get("receptorPath"),
                mapVirtualScrenning.get("receptorType"),
                "true".equals(mapVirtualScrenning.get("flexibleReceptor")));
        
        
        
        VirtualScrenning virtualScrenning = new VirtualScrenning(
                mapVirtualScrenning.get("id"),
                mapVirtualScrenning.get("name"),
                mapVirtualScrenning.get("ditributionType"),
                box,
                Integer.parseInt(mapVirtualScrenning.get("exhaustiviness")),
                ligand,
                receptor,
                receptor.getFilePath(),
                mapVirtualScrenning.get("MGLPath"),
                Integer.parseInt(mapVirtualScrenning.get("timeToRepeat")),
                new OSLinux(),
                mapVirtualScrenning.get("outputPath"));
        return virtualScrenning;
    }
}
