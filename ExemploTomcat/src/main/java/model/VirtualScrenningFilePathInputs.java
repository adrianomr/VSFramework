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
public class VirtualScrenningFilePathInputs {

    private VirtualScrenning virtualScrenning;

    public VirtualScrenningFilePathInputs(VirtualScrenning virtualScrenning) {
        this.virtualScrenning = virtualScrenning;
    }

    public String getFilePathInputs() {
        String outputPathInput = isSimpleLigandSimpleReceptorWhithoutVariation()
                ? ", output_path"
                : "";
        String receptorInput = getVirtualScrenning().getReceptor().isMultipleReceptors()
                && virtualScrenning.getLigand().isMultipleLigands()
                ? ", aux_receptor"
                : "";
        String numberOfTimes = getVirtualScrenning().getNumberOfTimesToRepeat() > 0
                ? ", number_of_times_executed"
                : "";
        String receptorLigandInput = getVirtualScrenning().getReceptor().isMultipleReceptors()
                && !virtualScrenning.getLigand().isMultipleLigands()
                ? ", aux_receptor"
                : ", aux_ligand";
        String receptorLigandOutInput = getVirtualScrenning().getReceptor().isMultipleReceptors()
                && !virtualScrenning.getLigand().isMultipleLigands()
                ? ", aux_out_receptor"
                : ", aux_ligand";
        String xVarition = getVirtualScrenning().getBox().DoesXVariate()?
                ", elem_x"
                :
                "";
        String yVarition = getVirtualScrenning().getBox().DoesYVariate()?
                ", elem_y"
                :
                "";
        String zVarition = getVirtualScrenning().getBox().DoesZVariate()?
                ", elem_z"
                :
                "";
        String filePathInputs = "";
        filePathInputs += outputPathInput
                + receptorInput
                + receptorLigandInput
                + outputPathInput
                + numberOfTimes
                + xVarition
                + yVarition
                + zVarition
                + numberOfTimes;
        return filePathInputs;
    }

    public boolean isSimpleLigandSimpleReceptorWhithoutVariation() {
//        return (!getVirtualScrenning().getLigand().isMultipleLigands())
                return (!getVirtualScrenning().getReceptor().isMultipleReceptors())
                && (getVirtualScrenning().getNumberOfTimesToRepeat() == 0);
    }

    public VirtualScrenning getVirtualScrenning() {
        return virtualScrenning;
    }

    public void setVirtualScrenning(VirtualScrenning virtualScrenning) {
        this.virtualScrenning = virtualScrenning;
    }

}
