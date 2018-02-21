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
public class VirtualScrenningFileNameInputs {

    private VirtualScrenning virtualScrenning;

    public VirtualScrenningFileNameInputs(VirtualScrenning virtualScrenning) {
        this.virtualScrenning = virtualScrenning;
    }

    public String getFileNameInputs() {
        String outputPathInput = isSimpleLigandSimpleReceptorWhithoutVariation()
                ? ", aux_ligand"
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
        String fileNameInputs = "";// output_path\"";//"ligand_path, aux_ligand, receptor_path, aux_receptor, output_path";
        fileNameInputs += outputPathInput
                + receptorInput
                + (!virtualScrenning.doesBoxVariates() 
                && !isSimpleLigandSimpleReceptorWhithoutVariation()
                && !(getVirtualScrenning().getLigand().isMultipleLigands()
                &&  getVirtualScrenning().getReceptor().isMultipleReceptors())?
                receptorInput
                + receptorLigandInput : "")
                +(!virtualScrenning.doesBoxVariates() 
                && !isSimpleLigandSimpleReceptorWhithoutVariation()
                && (getVirtualScrenning().getLigand().isMultipleLigands()
                &&  getVirtualScrenning().getReceptor().isMultipleReceptors()) ? 
                receptorLigandInput
                +receptorInput : "")
                + numberOfTimes
                + receptorLigandOutInput
                + xVarition
                + yVarition
                + zVarition
                + numberOfTimes;
        return fileNameInputs;
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
