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
public class ParserPrepareLigandTest {
    
    public ParserPrepareLigandTest() {
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
     * Test of getPrepareLigand method, of class ParserPrepareLigand.
     */
    
    /**
     * Test of getPrepareLigand method, of class ParserPrepareLigand.
     */
    @Test
    public void testGetPrepareLigandSingleLigand() {
        System.out.println("testGetPrepareLigandMultiplosReceptores");
        Ligand ligand = new Ligand("/home/instala/"
                + "03_Silvia_UFPEL_Experimento_refazendo/V20.pdbqt", "pdbqt",
                false, false);
        Receptor receptor = new Receptor("/home/instala/"
                + "03_Silvia_UFPEL_Experimento_refazendo/PDBs/PDBs.pdbqt", "pdbqt", true);
        String path = "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/";
        String MGLPath = "/home/";
        String outputPath = "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/V20_caixa_grande/";
        VirtualScrenning testVS = new VirtualScrenning("1","adriano","none",-29.898, 101.527,
                39.444, 40d, 40d, 40d, 128, ligand, receptor, path, MGLPath, 0, new OSLinux(), outputPath);
        ParserPrepareLigand instance = new ParserPrepareLigand(testVS);
        String q = "\"";
    String qlinha = "\n";
    String barra = "/";
    String aux_type = "pdbqt";
    String aux_lig = "V20";
    String ligand_name = aux_lig +  "." +  aux_type;
    String MGL_path = "/home/";
    String _path = "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/";
    String cifrao = "$";
            String expResult = "\n\n#Creation of file .sh to convert\n"+
//"for elem_name_ligand in lista_nomes_lig:\n"+
	"f = open(" +  q +   "" +  _path +   "executa_prepare_ligand4.sh" +  q +   "," +  q +   "w" +  q +   ")\n"+
	"str_ligand_name = "+aux_lig+"."+aux_type+"\n"+
	"str_ligand_name_without_type = "+aux_lig+"\n"+
	"f.write(" +  q +   "export PATH=" +  MGL_path +  "bin:" +  cifrao +  "PATH" +  "\\n" +  q +  ")\n"+
	"str_path_ligand = " +  q +  "pythonsh " +  MGL_path +  "MGLToolsPckgs/AutoDockTools/Utilities24/prepare_ligand4.py -l " +  _path +  q +  "+ str_ligand_name +" +  q +  " -d ligand_dict.py -o " +  _path +  q +  "+ str_ligand_name_without_type +" +  q +  ".pdbqt" +  q +  "\n"+
	"f.write(str_path_ligand)\n"+
	"f.close()\n"+
	"os.system(" +  q +  "chmod 777 " +  _path +  "executa_prepare_ligand4.sh" +  q +  ")\n"+
	"os.system(" +  q +  "" +  _path +  "executa_prepare_ligand4.sh" +  q +  ")\n"+
"#-----------------------------------------\n\n";
        String result = instance.getPrepareLigand().getPythonCode();
        System.out.println(expResult);
        System.out.println(result);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetPrepareLigandSingleRigidLigand() {
        System.out.println("testGetPrepareLigandMultiplosReceptores");
        Ligand ligand = new Ligand("/home/instala/"
                + "03_Silvia_UFPEL_Experimento_refazendo/V20.pdbqt", "pdbqt", true, false);
        Receptor receptor = new Receptor("/home/instala/"
                + "03_Silvia_UFPEL_Experimento_refazendo/PDBs/PDBs.pdbqt", "pdbqt", true);
        String path = "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/";
        String MGLPath = "/home/";
        String outputPath = "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/V20_caixa_grande/";
        VirtualScrenning testVS = new VirtualScrenning("", "", "", -29.898, 101.527,
                39.444, 40d, 40d, 40d, 128, ligand, receptor, path, MGLPath, 0, new OSLinux(), outputPath);
        ParserPrepareLigand instance = new ParserPrepareLigand(testVS);
        String q = "\"";
    String qlinha = "\n";
    String barra = "/";
    String aux_type = "pdbqt";;
    String aux_lig = "V20";
    String ligand_name = aux_lig +  "." +  aux_type;
    String MGL_path = "/home/";
    String _path = "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/";
    String cifrao = "$";
        String expResult = "\n\n#Creation of file .sh to convert\n"+
//"for elem_name_ligand in lista_nomes_lig:\n"+
	"f = open(" +  q +   "" +  _path +   "executa_prepare_ligand4.sh" +  q +   "," +  q +   "w" +  q +   ")\n"+
	"str_ligand_name = "+aux_lig+"."+aux_type+"\n"+
	"str_ligand_name_without_type = "+aux_lig+"\n"+
        "f.write(" +  q +   "export PATH=" +  MGL_path +  "bin:" +  cifrao +  "PATH" +  "\\n" +  q +  ")\n"+
	"str_path_ligand = " +  q +  "pythonsh " +  MGL_path +  "MGLToolsPckgs/AutoDockTools/Utilities24/prepare_ligand4.py -Z -l " +  _path +  q +  "+ str_ligand_name +" +  q +  " -d ligand_dict.py -o " + path +  q +  "+ str_ligand_name_without_type +" +  q +  ".pdbqt" +  q +  "\n"+
	"f.write(str_path_ligand)\n"+
	"f.close()\n"+
	"os.system(" +  q +  "chmod 777 " +  _path +  "executa_prepare_ligand4.sh" +  q +  ")\n"+
	"os.system(" +  q +  "" +  _path +  "executa_prepare_ligand4.sh" +  q +  ")\n"+
"#-----------------------------------------\n\n";
        String result = instance.getPrepareLigand().getPythonCode();
//        System.out.println(expResult);
//        System.out.println(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of getPrepareLigand method, of class ParserPrepareLigand.
     */
    @Test
    public void testGetPrepareLigandMultipleLigands() {
        System.out.println("testGetPrepareLigandMultiplosReceptores");
        ParserPrepareLigand instance = new ParserPrepareLigand(Util.getVirtualScrenningForTests());
        String q = "\"";
    String qlinha = "\n";
    String barra = "/";
    String aux_type = "pdbqt";;
    String aux_lig = "V20";
    String ligand_name = aux_lig +  "." +  aux_type;
    String MGL_path = "/home/";
    String _path = "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/";
    String cifrao = "$";
        String expResult = "\n\n#Creation of file .sh to convert\n"+
"for elem_name_ligand in lista_nomes_lig:\n"+
	"\tf = open(" +  q +   "" +  _path +   "executa_prepare_ligand4.sh" +  q +   "," +  q +   "w" +  q +   ")\n"+
	"\tstr_ligand_name = elem_name_ligand\n"+
	"\tstr_ligand_name_without_type = elem_name_ligand.split('.')\n"+
	"\tstr_ligand_name_without_type = str_ligand_name_without_type[0]\n"+
	"\tf.write(" +  q +   "export PATH=" +  MGL_path +  "bin:" +  cifrao +  "PATH" +  "\\n" +  q +  ")\n"+
	"\tstr_path_ligand = " +  q +  "pythonsh " +  MGL_path +  "MGLToolsPckgs/AutoDockTools/Utilities24/prepare_ligand4.py -l " +  _path +  q +  "+ str_ligand_name +" +  q +  " -d ligand_dict.py -o " +  _path +  q +  "+ str_ligand_name_without_type +" +  q +  ".pdbqt" +  q +  "\n"+
	"\tf.write(str_path_ligand)\n"+
	"\tf.close()\n"+
	"\tos.system(" +  q +  "chmod 777 " +  _path +  "executa_prepare_ligand4.sh" +  q +  ")\n"+
	"\tos.system(" +  q +  "" +  _path +  "executa_prepare_ligand4.sh" +  q +  ")\n"+
"#-----------------------------------------\n\n";
        String result = instance.getPrepareLigand().getPythonCode();
//        System.out.println(expResult);
//        System.out.println(result);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetPrepareLigandMultipleRigidLigands() {
        System.out.println("testGetPrepareLigandMultiplosReceptores");
        Ligand ligand = new Ligand("/home/instala/"
                + "03_Silvia_UFPEL_Experimento_refazendo/V20.pdbqt", "pdbqt", true, true);
        Receptor receptor = new Receptor("/home/instala/"
                + "03_Silvia_UFPEL_Experimento_refazendo/PDBs/PDBs.pdbqt", "pdbqt", true);
        String path = "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/";
        String MGLPath = "/home/";
        String outputPath = "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/V20_caixa_grande/";
        VirtualScrenning testVS = new VirtualScrenning("1","adriano","none",-29.898, 101.527,
                39.444, 40d, 40d, 40d, 128, ligand, receptor, path, MGLPath, 0, new OSLinux(), outputPath);
        ParserPrepareLigand instance = new ParserPrepareLigand(testVS);
        String q = "\"";
    String qlinha = "\n";
    String barra = "/";
    String aux_type = "pdbqt";;
    String aux_lig = "V20";
    String ligand_name = aux_lig +  "." +  aux_type;
    String MGL_path = "/home/";
    String _path = "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/";
    String cifrao = "$";
        String expResult = "\n\n#Creation of file .sh to convert\n"+
"for elem_name_ligand in lista_nomes_lig:\n"+
	"\tf = open(" +  q +   "" +  _path +   "executa_prepare_ligand4.sh" +  q +   "," +  q +   "w" +  q +   ")\n"+
	"\tstr_ligand_name = elem_name_ligand\n"+
	"\tstr_ligand_name_without_type = elem_name_ligand.split('.')\n"+
	"\tstr_ligand_name_without_type = str_ligand_name_without_type[0]\n"+
	"\tf.write(" +  q +   "export PATH=" +  MGL_path +  "bin:" +  cifrao +  "PATH" +  "\\n" +  q +  ")\n"+
	"\tstr_path_ligand = " +  q +  "pythonsh " +  MGL_path +  "MGLToolsPckgs/AutoDockTools/Utilities24/prepare_ligand4.py -Z -l " +  _path + q +  "+ str_ligand_name +" +  q +  " -d ligand_dict.py -o " +  _path  +  q +  "+ str_ligand_name_without_type +" +  q +  ".pdbqt" +  q +  "\n"+
	"\tf.write(str_path_ligand)\n"+
	"\tf.close()\n"+
	"\tos.system(" +  q +  "chmod 777 " +  _path +  "executa_prepare_ligand4.sh" +  q +  ")\n"+
	"\tos.system(" +  q +  "" +  _path +  "executa_prepare_ligand4.sh" +  q +  ")\n"+
"#-----------------------------------------\n\n";
        String result = instance.getPrepareLigand().getPythonCode();
//        System.out.println(expResult);
//        System.out.println(result);
        assertEquals(expResult, result);
    }
    
}
