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
public class ParserInputTest {

    private PythonBuilder pythonBuilder;
    
    public ParserInputTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pythonBuilder = new PythonBuilder();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInputParser method, of class InputParser.
     */
    @Test
    public void testGetInputParser() {
        System.out.println("getInputParser");
        Ligand ligand = new Ligand("/home/instala/03_Silvia_UFPEL_Experimento_refazendo/V20.pdbqt", "pdbqt", false, true);
        Receptor receptor = new Receptor("/home/instala/03_Silvia_UFPEL_Experimento_refazendo/PDBs/", "pdbqt", true);
        String path = "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/V20_caixa_grande/";
        Box box = new Box(new BoxCenter(-29.898, 101.527, 39.444),
                new BoxSize(40d, 40d, 40d));
        ParserInput instance = new ParserInput(Util.getVirtualScrenningForTests());
        String expResult = "receptor =\".pdbqt\"\n" +
"ligand =\"V20.pdbqt\"\n" +
"aux_ligand =\"V20\"\n" +
"aux_receptor =\"\"\n" +
"receptor_path = \"/home/instala/03_Silvia_UFPEL_Experimento_refazendo/PDBs/\"\n" +
"ligand_path = \"/home/instala/03_Silvia_UFPEL_Experimento_refazendo/\"\n" +
"output_path = \"/home/instala/03_Silvia_UFPEL_Experimento_refazendo/V20_caixa_grande/\"\n" +
"size_x = 40.0\n" +
"size_y = 40.0\n" +
"size_z = 40.0\n" +
"center_x = -29.898\n" +
"center_y = 101.527\n" +
"center_z = 39.444\n" +
"receptor = \"receptor = \"+receptor+\"\"\n" +
"ligand = \"ligand = \"+ligand+\"\""+"\n";
        String result = instance.getInputParser(ligand, receptor, path, box, "\"").getPythonCode();
        System.out.println(result);
        System.out.println(expResult);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    @Test
    public void testGetInputParserDistributed() {
        System.out.println("getInputParser");
        Ligand ligand = new Ligand("/home/instala/03_Silvia_UFPEL_Experimento_refazendo/V20.pdbqt", "pdbqt", false, true);
        Receptor receptor = new Receptor("/home/instala/03_Silvia_UFPEL_Experimento_refazendo/PDBs/", "pdbqt", true);
        String path = "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/V20_caixa_grande/";
        Box box = new Box(new BoxCenter(-29.898, 101.527, 39.444),
                new BoxSize(40d, 40d, 40d));
        String MGLPath = "/home/";
        String outputPath = "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/V20_caixa_grande/";
        VirtualScrenning testVS = new VirtualScrenning("", "", "distributed", -29.898, 101.527,
                39.444, 40d, 40d, 40d, 128, ligand, receptor, path, MGLPath, 20, new OSLinux(), outputPath);
        testVS.setNodeId("1");
        testVS.setTotalNodes("1");
        ParserInput instance = new ParserInput(testVS);
        
        String expResult = "receptor =\".pdbqt\"\n" +
        "ligand =\"V20.pdbqt\"\n" +
        "aux_ligand =\"V20\"\n" +
        "aux_receptor =\"\"\n" +
        "receptor_path = \"/home/instala/03_Silvia_UFPEL_Experimento_refazendo/PDBs/\"\n" +
        "ligand_path = \"/home/instala/03_Silvia_UFPEL_Experimento_refazendo/\"\n" +
        "output_path = \"/home/instala/03_Silvia_UFPEL_Experimento_refazendo/V20_caixa_grande/\"\n" +
        "size_x = 40.0\n" +
        "size_y = 40.0\n" +
        "size_z = 40.0\n" +
        "center_x = -29.898\n" +
        "center_y = 101.527\n" +
        "center_z = 39.444\n" +
        "receptor = \"receptor = \"+receptor+\"\"\n" +
        "ligand = \"ligand = \"+ligand+\"\""+"\n"+
        "node_id = 1\n"+
        "total_nodes = 1\n"+
        "count = 0\n";
        String result = instance.getInputParser(ligand, receptor, path, box, "\"").getPythonCode();
        System.out.println(result);
        System.out.println(expResult);
        assertEquals(expResult, result);
    }
}
