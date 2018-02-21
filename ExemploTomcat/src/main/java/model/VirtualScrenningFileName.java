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
public class VirtualScrenningFileName {

    private VirtualScrenning virtualScrenning;

    public VirtualScrenningFileName(VirtualScrenning virtualScrenning) {
        this.virtualScrenning = virtualScrenning;
    }

    public String getVirtualScrenningFileName() {
        String fileName = "";

        String receptor = virtualScrenning.getReceptor().isMultipleReceptors()
                && virtualScrenning.getLigand().isMultipleLigands() 
                ? "%s_"
                : "";
        String numberOfTimes = getVirtualScrenning().getNumberOfTimesToRepeat() > 0
                ? "_time_%i"
                : "";
        String xVariation = getVirtualScrenning().getBox().DoesXVariate()
                ? "_x_%i"
                : "";
        String yVariation = getVirtualScrenning().getBox().DoesYVariate()
                ? "_y_%i"
                : "";
        String zVariation = getVirtualScrenning().getBox().DoesZVariate()
                ? "_z_%i"
                : "";
        String coord = getVirtualScrenning().doesBoxVariates() ?
                "%s_coord"
                :
                "%s";
        fileName += receptor + coord + xVariation
                + yVariation + zVariation + numberOfTimes ;
        return fileName;
    }

    public VirtualScrenning getVirtualScrenning() {
        return virtualScrenning;
    }

    public void setVirtualScrenning(VirtualScrenning virtualScrenning) {
        this.virtualScrenning = virtualScrenning;
    }

    public boolean isSimpleLigandSimpleReceptorWhithoutVariation() {
//        return (!getVirtualScrenning().getLigand().isMultipleLigands())
                return ((!getVirtualScrenning().getReceptor().isMultipleReceptors())
                && (getVirtualScrenning().getNumberOfTimesToRepeat() == 0)
                || getVirtualScrenning().doesBoxVariates());
    }

}
