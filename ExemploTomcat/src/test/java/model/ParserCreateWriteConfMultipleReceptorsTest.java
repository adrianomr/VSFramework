/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SCADI
 */
public class ParserCreateWriteConfMultipleReceptorsTest {
    
    public ParserCreateWriteConfMultipleReceptorsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCreateWriteConfMultipleLigands method, of class ParserCreateWriteConfMultipleReceptors.
     */
    @Test
    public void testGetCreateWriteConfMultipleLigands() {
        VirtualScrenning virtualScrenning = Util.getVirtualScrenningForTests();
        virtualScrenning.getLigand().setMultipleLigands(true);
        virtualScrenning.getReceptor().setMultipleReceptors(false);
        virtualScrenning.setNumberOfTimesToReapeat(0);
        ParserCreateWriteConfMultipleReceptors instance = new ParserCreateWriteConfMultipleReceptors(virtualScrenning);
        String expResult = "";
        String q = "\"";
        String qlinha = "\\n";

    expResult += "\nfor receptor in lista_receptores:\n";
    expResult += "\taux_out_receptor = " + q + "" + q + "";
    expResult += "\n\taux_conf_receptor = " + q + "" + q + "";
    expResult += "\n\taux_receptor = " + q + "" + q + "";
    expResult += "\n\taux_receptor = receptor.replace(" + q + "." + virtualScrenning.getReceptor().getFileType() + "" + q + "," + q + "" + q + ")";
    expResult += "\n\taux_out_receptor = receptor";
    expResult += "\n\taux_out_receptor = aux_out_receptor.replace(" + q + "." + virtualScrenning.getReceptor().getFileType() + "" + q + "," + q + "" + q + ")\n";
    expResult += "\taux_ligand.replace(" + q + "" + qlinha + "" + q + "," + q + "" + q + ")\n";
    expResult += "\taux_conf_receptor = receptor.replace(" + q + "." + virtualScrenning.getReceptor().getFileType() + "" + q + "," + q + "" + q + ")\n";
    expResult += "\taux_conf_receptor = aux_conf_receptor + " + q + ".pdbqt" + q + "\n";
    expResult += "\treceptor = " + q + "receptor = " + q + " + aux_conf_receptor + " + q + "" + qlinha + "" + q + "\n\t\n";
    expResult += "#Creation of file conf.txt (it is necessary to AutoDock Vina run)\n"
            + "\tlista = [receptor+\"\\n\" , ligand +\"\\n\", " + q + "seed = 1234567891" + qlinha + 
            "" + q + " , " + q + "out = out.pdb" + qlinha + "" + qlinha + "" + q +
            " , " + q + "center_x =  " + virtualScrenning.getBox().getBoxCenter().getX() +
            " " + qlinha + "" + q +
            " , " + q + "center_y = " + virtualScrenning.getBox().getBoxCenter().getY() 
            + "" + qlinha +
            "" + q + " , " + q + "center_z = " + virtualScrenning.getBox().getBoxCenter().getZ()
            +
            "" + qlinha + "" + qlinha + "" + q + "," + q + "size_x = " 
            + virtualScrenning.getBox().getBoxSize().getX() + "" + qlinha + "" 
            + q + " , " + q + "size_y = " + virtualScrenning.getBox().getBoxSize().getY() +
            " " + qlinha + "" + q + " , " + q + "size_z = " 
            + virtualScrenning.getBox().getBoxSize().getZ() +"" + qlinha + "" + qlinha + 
            "" + q +
            " , " + q + "exhaustiveness = " 
            + virtualScrenning.getExhaustiveness() + q + "]\n\n";
    expResult += "\tf = open(" + q + "" + virtualScrenning.getPath() + "conf.txt" + q + 
            " ," + q + "w" + q +
            ")\n";
    expResult += "\tfor elem in lista:\n\t\tf.write(" + q + "%s" + q + " % elem)\n\n";
    expResult += "\tf.close()\n\t#-----------------------------------------\n";
        String result = instance.getCreateWriteConfMultipleLigands().getPythonCode();
        System.out.println(expResult);
        System.out.println(result);
        assertEquals(expResult, result);
    }
    
}
