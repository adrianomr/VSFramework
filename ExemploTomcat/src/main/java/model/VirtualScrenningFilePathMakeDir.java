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
public class VirtualScrenningFilePathMakeDir {

    private VirtualScrenning virtualScrenning;

    public VirtualScrenningFilePathMakeDir(VirtualScrenning virtualScrenning) {
        this.virtualScrenning = virtualScrenning;
    }

    public String getVirtualScrenningFilePath() {
        String filePath = "";
        if (getVirtualScrenning().doesBoxVariates()) {
            String outputPath = isSimpleLigandSimpleReceptorWhithoutVariation()
                    ? "%s"
                    : getVirtualScrenning().getOutputPath();

            String receptor = virtualScrenning.getReceptor().isMultipleReceptors()
                    && virtualScrenning.getLigand().isMultipleLigands()
                    ? "%s"
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
            String coord = getVirtualScrenning().doesBoxVariates()
                    ? "_%s_coord"
                    : "";
            filePath += outputPath + receptor + coord + xVariation
                    + yVariation + zVariation + numberOfTimes
                    + getVirtualScrenning().getOperationalSystem().getPathSeparator();
            return filePath;
        }
        return getVirtualScrenning().getOutputPath();
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
