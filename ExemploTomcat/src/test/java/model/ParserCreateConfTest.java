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
public class ParserCreateConfTest {
    
    public ParserCreateConfTest() {
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
     * Test of getCriaConf method, of class ParserCriaConf.
     */
    @Test
    public void testGetCriaConf() {
        System.out.println("getCriaConf");
        VirtualScrenning virtualScreanning = Util.getVirtualScrenningForTests();
        virtualScreanning.setNumberOfTimesToReapeat(0);
        ParserCreateConf instance = new ParserCreateConf(virtualScreanning);
//        function python_cria_conf($arquivo_python) {
//    $q = "\"";
//    $qlinha = '\n';
//    expResult += "\n#Creation of file conf.txt (it is necessary to AutoDock Vina run)\nlista = [receptor , ligand , " + q + "seed = 1234567891" . $qlinha . "" + q + " , " + q + "out = out.pdb" . $qlinha . "" . $qlinha . "" + q + " , 
//" + q + "center_x = " . $_POST['box_center_x'] . "" . $qlinha . "" + q + " , " + q + "center_y = " . $_POST['box_center_y'] . "" . $qlinha . "" + q + " , " + q + "center_z = " . $_POST['box_center_z'] . "" . $qlinha . "" . $qlinha . "" + q + ",
//" + q + "size_x = " . $_POST['box_x'] . "" . $qlinha . "" + q + " , " + q + "size_y = " . $_POST['box_y'] . "" . $qlinha . "" + q + " , " + q + "size_z = " . $_POST['box_z'] . "" . $qlinha . "" . $qlinha . "" + q + " , " + q + "exhaustiveness = " . $_POST['exhaustiveness'] + q + "]\n\n";
//
//    return $arquivo_python;
//}

        String expResult = "\n#Creation of file conf.txt (it is necessary to AutoDock "
                + "Vina run)\nlista = [receptor+\"\\n\" , ligand +\"\\n\","
                + " \"seed = 1234567891\\n\" , \"out = out.pdb\\n\\n\" , "
                +"\"center_x =  -29.898 \\n\" , \"center_y = 101.527\\n\" "
                + ", \"center_z = 39.444\\n\\n\","
                +"\"size_x = 40.0\\n\" , \"size_y = 40.0 \\n\" ,"
                + " \"size_z = 40.0\\n\\n\" , \"exhaustiveness = 128\"]\n\n";
        String result = instance.getCriaConf().getPythonCode();
        System.out.println(result);
        System.out.println(expResult);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetCriaConfCasoEspecial() {
        System.out.println("getCriaConf");
        ParserCreateConf instance = new ParserCreateConf(Util.getVirtualScrenningForTests());
        instance.getPythonBuilder().addPythonIdentationBlock();
        String q = "\"";
    String qlinha = "\\n";
    String expResult = "\tseed_rand = 0";
    expResult += "\n\tseed_rand = randint(111111111,999999999)";
    expResult += "\n\tseed_randomic = " + q + "" + q + "";
    expResult += "\n\tseed_randomic = str(seed_rand)";
    expResult += "\n\tfirst_dig = 0";
    expResult += "\n\tfirst_dig = 1";
    expResult += "\n\tfirst_digit = " + q + "" + q + "";
    expResult += "\n\tfirst_digit = str(first_dig)";
    expResult += "\n\tseed_randomic = first_digit + seed_randomic";
    expResult += "\n\tseed_randomic_final=" + q + "" + q + "";
    expResult += "\n\tseed_randomic_final = " + q + "seed = " + q + " + seed_randomic + " + q + "" + qlinha + "" + q + "";
    
        expResult += "\n\t\n#Creation of file conf.txt (it is necessary to AutoDock "
                + "Vina run)\n\tlista = [receptor+\"\\n\" , ligand +\"\\n\","
                + " seed_randomic_final , \"out = out.pdb\\n\\n\" , "
                +"\"center_x =  -29.898 \\n\" , \"center_y = 101.527\\n\" "
                + ", \"center_z = 39.444\\n\\n\","
                +"\"size_x = 40.0\\n\" , \"size_y = 40.0 \\n\" ,"
                + " \"size_z = 40.0\\n\\n\" , \"exhaustiveness = 128\"]\n\n";
        String result = instance.getCriaConf().getPythonCode();
        System.out.println(result);
        System.out.println(expResult);
        assertEquals(expResult, result);
    }
    
}
