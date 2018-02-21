/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import interfaces.IParser;

/**
 *
 * @author adriano
 */
public class ParserInput extends Parser implements IParser {

    public ParserInput(VirtualScrenning virtualScrenning) {
        super(virtualScrenning);
    }

    public PythonBuilder getInputParser(Ligand ligand, Receptor receptor, String path, Box box, String quotationMarks) {
        String q = "\"";
        String qlinha = "\n";
        getPythonBuilder().addLinha("receptor =" + quotationMarks + receptor.getFileName() + "." + receptor.getFileType() + quotationMarks);
        getPythonBuilder().addLinha("ligand =" + quotationMarks + ligand.getFileName() + "." + ligand.getFileType() + quotationMarks);
        getPythonBuilder().addLinha("aux_ligand =" + quotationMarks + ligand.getFileName() + quotationMarks);
        getPythonBuilder().addLinha("aux_receptor =" + quotationMarks + receptor.getFileName() + quotationMarks);
        getPythonBuilder().addLinha("receptor_path = " + quotationMarks + receptor.getFilePath() + quotationMarks);
        getPythonBuilder().addLinha("ligand_path = " + quotationMarks + ligand.getFilePath() + quotationMarks);
        getPythonBuilder().addLinha("output_path = " + quotationMarks + getVirtualScrenning().getOutputPath() + quotationMarks);
        getPythonBuilder().addLinha("size_x = " + box.getBoxSize().getX());
        getPythonBuilder().addLinha("size_y = " + box.getBoxSize().getY());
        getPythonBuilder().addLinha("size_z = " + box.getBoxSize().getZ());
        getPythonBuilder().addLinha("center_x = " + box.getBoxCenter().getX());
        getPythonBuilder().addLinha("center_y = " + box.getBoxCenter().getY());
        getPythonBuilder().addLinha("center_z = " + box.getBoxCenter().getZ());
        getPythonBuilder().addLinha("receptor = " + quotationMarks + "receptor = " + quotationMarks + "+receptor+" + quotationMarks + "" + quotationMarks);
        getPythonBuilder().addLinha("ligand = " + quotationMarks + "ligand = " + quotationMarks + "+ligand+" + quotationMarks + "" + quotationMarks);
        if ("distributed".equals(getVirtualScrenning().getDistributionConfig().toLowerCase())) {
            getPythonBuilder().addLinha("node_id = " + getVirtualScrenning().getNodeId());
            getPythonBuilder().addLinha("total_nodes = " + getVirtualScrenning().getTotalNodes());
            getPythonBuilder().addLinha("count = 0");
        }

        return getPythonBuilder();
    }

    @Override
    public PythonBuilder executeParser(PythonBuilder pythonBuilder) {
        setPythonBuilder(pythonBuilder);
        return getInputParser(getVirtualScrenning().getLigand(),
                getVirtualScrenning().getReceptor(), getVirtualScrenning().getPath(),
                 getVirtualScrenning().getBox(), "\""); //To change body of generated methods, choose Tools | Templates.
    }

}
