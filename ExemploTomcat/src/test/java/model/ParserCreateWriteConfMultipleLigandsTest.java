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
 * @author adriano
 */
public class ParserCreateWriteConfMultipleLigandsTest {
    
    public ParserCreateWriteConfMultipleLigandsTest() {
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
     * Test of getCreateWriteConfMultipleLigands method, of class ParserCreateWriteConfMultipleLigands.
     */
    @Test
    public void testGetCreateWriteConfMultipleLigands() {
        System.out.println("testGetCreateWriteConfMultipleLigands");
        VirtualScrenning virtualScrenning = Util.getVirtualScrenningForTests();
        virtualScrenning.getLigand().setMultipleLigands(true);
        virtualScrenning.getReceptor().setMultipleReceptors(false);
        virtualScrenning.setNumberOfTimesToReapeat(0);
        ParserCreateWriteConfMultipleLigands instance = new ParserCreateWriteConfMultipleLigands(virtualScrenning);
        String expResult = "";
        String q = "\"";
        String qlinha = "\\n";

    expResult += "for ligand in lista_nomes_lig_sem_ext:\n";
    expResult += "\taux_ligand = ligand\n";
    expResult += "\tligand = " + q + "ligand = " + q + " + ligand + " + q + ".pdbqt" 
            + q + " + " + q + "" + qlinha + "" + q + "\n\t\n";
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
    
     @Test
    public void testGetCreateWriteConfMultipleLigandsSingleReceptor() {
        System.out.println("testGetCreateWriteConfMultipleLigandsSingleReceptor");
        VirtualScrenning virtualScrenning = Util.getVirtualScrenningForTests();
        virtualScrenning.getLigand().setMultipleLigands(true);
        virtualScrenning.getReceptor().setMultipleReceptors(true);
        virtualScrenning.setNumberOfTimesToReapeat(0);
        ParserCreateWriteConfMultipleLigands instance = new ParserCreateWriteConfMultipleLigands(virtualScrenning);
        String expResult = "";
        String q = "\"";
        String qlinha = "\\n";

    expResult += "\tfor ligand in lista_nomes_lig_sem_ext:\n";
    expResult += "\t\taux_ligand = ligand\n";
    expResult += "\t\tligand = " + q + "ligand = " + q + " + ligand + " + q + ".pdbqt" 
            + q + " + " + q + "" + qlinha + "" + q + "\n\t\t\n";
    expResult += "#Creation of file conf.txt (it is necessary to AutoDock Vina run)\n"
            + "\t\tlista = [receptor+\"\\n\" , ligand +\"\\n\", " + q + "seed = 1234567891" + qlinha + 
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
    expResult += "\t\tf = open(" + q + "" + virtualScrenning.getPath() + "conf.txt" + q + 
            " ," + q + "w" + q +
            ")\n";
    expResult += "\t\tfor elem in lista:\n\t\t\tf.write(" + q + "%s" + q + " % elem)\n\n";
    expResult += "\t\tf.close()\n\t\t#-----------------------------------------\n";
        String result = instance.getCreateWriteConfMultipleLigands().getPythonCode();
        System.out.println(expResult);
        System.out.println(result);
        assertEquals(expResult, result);
    }
    
}
