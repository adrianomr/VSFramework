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
import org.junit.Ignore;

/**
 *
 * @author adriano
 */
public class ParserVirtualScrenningTest {
    
    public ParserVirtualScrenningTest() {
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
     * Test of executeParser method, of class ParserVirtualScrenning.
     */
    @Test
    @Ignore
    public void testExecuteParser() {
        System.out.println("executeParser");
        String q = "\"";
        String qlinha = "\\n";
            String cifrao = "$";
    String aux_type = "pdbqt";
    String aux_rec = "PDBs";
    String MGLPath = "home";
    String path = "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/PDBs/";
    String aux_lig = "V20";
    Box box = new Box(new BoxCenter(-29.898, 101.527,
                39.444), new BoxSize(40d, 40d, 40d),
                new BoxVariation(new BoxCenter(-29.898, 101.527,
                39.444), 2d, 2d, 2d));
        Ligand ligand = new Ligand("/home/instala/"
                + "03_Silvia_UFPEL_Experimento_refazendo/V20.pdbqt", "pdbqt",
                true, false);
        Receptor receptor = new Receptor("/home/instala/"
                + "03_Silvia_UFPEL_Experimento_refazendo/PDBs/PDBs.pdbqt", "pdbqt", false);
        String outputPath = "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/V20_caixa_grande/";
        VirtualScrenning virtualScrenning = new VirtualScrenning("", "", "",box, 128, ligand, receptor, path, MGLPath, 0, new OSLinux(), outputPath);
        
    ParserVirtualScrenning instance = new ParserVirtualScrenning(virtualScrenning);
        String expResult = "";
        expResult +=  "#!/usr/bin/python\r\n" + "# -*- coding: utf-8 -*-\r\n" +
            "import subprocess\r\n" +
            "from subprocess import Popen\r\n" + "import os\r\n" +
            "import shlex\r\n" +
             "import time\nimport os\nfrom os import listdir\n"
                + "from os.path import isfile, join\nfrom random import randint\n\n";
        expResult += "receptor =\"PDBs.pdbqt\"\n" +
"ligand =\"V20.pdbqt\"\n" +
"aux_ligand =\"V20\"\n" +
"aux_receptor =\"PDBs\"\n" +
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
        expResult += "\n#Creation of file conf.txt (it is necessary to AutoDock "
                + "Vina run)\nlista = [receptor+\"\\n\" , ligand +\"\\n\","
                + " \"seed = 1234567891\\n\" , \"out = out.pdb\\n\\n\" , "
                +"\"center_x =  -29.898 \\n\" , \"center_y = 101.527\\n\" "
                + ", \"center_z = 39.444\\n\\n\","
                +"\"size_x = 40.0\\n\" , \"size_y = 40.0 \\n\" ,"
                + " \"size_z = 40.0\\n\\n\" , \"exhaustiveness = 128\"]\n\n";
        
        expResult += "f = open(" + q + "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/conf.txt" + q + " ," + q + "w" + q + ")\n";
        expResult += "for elem in lista:\n\tf.write(" + q + "%s" + q + " % elem)\n\n";
        expResult += "f.close()\n#-----------------------------------------\n";
        expResult +=  "\n\n#Creation of file .sh to convert\n"+
        "receptor = \""+aux_rec+"."+aux_type+"\"\n" +
        "aux_receptor = \""+aux_rec+"\"\n"+
	"f = open(" + q + "" + path + "executa_prepare_receptor4.sh" + q + "," + q + "w" + q + ")\n"+
	"f.write(" + q + "export PATH=" + MGLPath + "bin:" + cifrao + "PATH" + qlinha + "" + q + ")\n"+
	"f.write(" + q + "pythonsh " + MGLPath + "MGLToolsPckgs/AutoDockTools/Utilities24/prepare_receptor4.py -A 'checkhydrogens' -r " + path  + q + "+receptor+" + q + " -o " + path +  q + "+aux_receptor+" + q + ".pdbqt" + q + ")\n"+	
	"f.close()\n"+
	"os.system(" + q + "chmod 777 " + path + "executa_prepare_receptor4.sh" + q + ")\n"+
	"os.system(" + q + "" + path + "executa_prepare_receptor4.sh" + q + ")\n"+
"#-----------------------------------------\n\n";
        String _path = "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/";
              expResult += "\n\n#Creation of file .sh to convert\n"+
//"for elem_name_ligand in lista_nomes_lig:\n"+
	"f = open(" +  q +   "" +  _path +   "executa_prepare_ligand4.sh" +  q +   "," +  q +   "w" +  q +   ")\n"+
	"str_ligand_name = "+aux_lig+"."+aux_type+"\n"+
	"str_ligand_name_without_type = "+aux_lig+"\n"+
	"f.write(" +  q +   "export PATH=" +  MGLPath +  "bin:" +  cifrao +  "PATH" +  qlinha +  "" +  q +  ")\n"+
	"str_path_ligand = " +  q +  "pythonsh " +  MGLPath +  "/MGLToolsPckgs/AutoDockTools/Utilities24/prepare_ligand4.py -l " +  _path +  "/" +  q +  "+ str_ligand_name +" +  q +  " -d ligand_dict.py -o " +  _path +  "/" +  q +  "+ str_ligand_name_without_type +" +  q +  ".pdbqt" +  q +  "\n"+
	"f.write(str_path_ligand)\n"+
	"f.close()\n"+
	"os.system(" +  q +  "chmod 777 " +  _path +  "executa_prepare_ligand4.sh" +  q +  ")\n"+
	"os.system(" +  q +  "" +  _path +  "executa_prepare_ligand4.sh" +  q +  ")\n"+
"#-----------------------------------------\n\n";
        String result = instance.executeParser(new PythonBuilder()).getPythonCode();
        System.out.println(expResult);
        System.out.println(result);
        assertEquals(expResult, result);
    }
    @Test
    @Ignore
    public void testExecuteParserUmLiganteUmReceptor() {
        System.out.println("executeParser1x1");
        String q = "\"";
        String qlinha = "\\n";
            String cifrao = "$";
    String aux_type = "pdbqt";
    String aux_rec = "PDBs";
    String MGLPath = "home";
    String path = "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/PDBs/";
    String aux_lig = "V20";
        Ligand ligand = new Ligand("/home/instala/"
                + "03_Silvia_UFPEL_Experimento_refazendo/V20.pdbqt", "pdbqt",
                true, false);
        Receptor receptor = new Receptor("/home/instala/"
                + "03_Silvia_UFPEL_Experimento_refazendo/PDBs/PDBs.pdbqt", "pdbqt", false);
        String outputPath = "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/V20_caixa_grande/";
        VirtualScrenning virtualScrenning = new VirtualScrenning("", "", "",-29.898, 101.527,
                39.444, 40d, 40d, 40d, 128, ligand, receptor, path, MGLPath, 20, new OSLinux(), outputPath);
        
    ParserVirtualScrenning instance = new ParserVirtualScrenning(virtualScrenning);
        String expResult = "";
        expResult +=  "#!/usr/bin/python\r\n" + "# -*- coding: utf-8 -*-\r\n" +
            "import subprocess\r\n" +
            "from subprocess import Popen\r\n" + "import os\r\n" +
            "import shlex\r\n" +
             "import time\nimport os\nfrom os import listdir\n"
                + "from os.path import isfile, join\nfrom random import randint\n\n";
        expResult += "receptor =\"PDBs.pdbqt\"\n" +
"ligand =\"V20.pdbqt\"\n" +
"aux_ligand =\"V20\"\n" +
"aux_receptor =\"PDBs\"\n" +
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
        expResult += "\n#Creation of file conf.txt (it is necessary to AutoDock "
                + "Vina run)\nlista = [receptor+\"\\n\" , ligand +\"\\n\","
                + " \"seed = 1234567891\\n\" , \"out = out.pdb\\n\\n\" , "
                +"\"center_x =  -29.898 \\n\" , \"center_y = 101.527\\n\" "
                + ", \"center_z = 39.444\\n\\n\","
                +"\"size_x = 40.0\\n\" , \"size_y = 40.0 \\n\" ,"
                + " \"size_z = 40.0\\n\\n\" , \"exhaustiveness = 128\"]\n\n";
        
        expResult += "f = open(" + q + "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/conf.txt" + q + " ," + q + "w" + q + ")\n";
        expResult += "for elem in lista:\n\tf.write(" + q + "%s" + q + " % elem)\n\n";
        expResult += "f.close()\n#-----------------------------------------\n";
//        expResult +=  "\n\n#Creation of file .sh to convert\n"+
//        "receptor = \""+aux_rec+"."+aux_type+"\"\n" +
//        "aux_receptor = \""+aux_rec+"\"\n"+
//	"f = open(" + q + "" + path + "executa_prepare_receptor4.sh" + q + "," + q + "w" + q + ")\n"+
//	"f.write(" + q + "export PATH=" + MGLPath + "bin:" + cifrao + "PATH" + qlinha + "" + q + ")\n"+
//	"f.write(" + q + "pythonsh " + MGLPath + "MGLToolsPckgs/AutoDockTools/Utilities24/prepare_receptor4.py -A 'checkhydrogens' -r " + path  + q + "+receptor+" + q + " -o " + path +  q + "+aux_receptor+" + q + ".pdbqt" + q + ")\n"+	
//	"f.close()\n"+
//	"os.system(" + q + "chmod 777 " + path + "executa_prepare_receptor4.sh" + q + ")\n"+
//	"os.system(" + q + "" + path + "executa_prepare_receptor4.sh" + q + ")\n"+
//"#-----------------------------------------\n\n";
//        String _path = "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/";
//              expResult += "\n\n#Creation of file .sh to convert\n"+
////"for elem_name_ligand in lista_nomes_lig:\n"+
//	"f = open(" +  q +   "" +  _path +   "executa_prepare_ligand4.sh" +  q +   "," +  q +   "w" +  q +   ")\n"+
//	"str_ligand_name = "+aux_lig+"."+aux_type+"\n"+
//	"str_ligand_name_without_type = "+aux_lig+"\n"+
//	"f.write(" +  q +   "export PATH=" +  MGLPath +  "bin:" +  cifrao +  "PATH" +  qlinha +  "" +  q +  ")\n"+
//	"str_path_ligand = " +  q +  "pythonsh " +  MGLPath +  "/MGLToolsPckgs/AutoDockTools/Utilities24/prepare_ligand4.py -l " +  _path +  "/" +  q +  "+ str_ligand_name +" +  q +  " -d ligand_dict.py -o " +  _path +  "/" +  q +  "+ str_ligand_name_without_type +" +  q +  ".pdbqt" +  q +  "\n"+
//	"f.write(str_path_ligand)\n"+
//	"f.close()\n"+
//	"os.system(" +  q +  "chmod 777 " +  _path +  "executa_prepare_ligand4.sh" +  q +  ")\n"+
//	"os.system(" +  q +  "" +  _path +  "executa_prepare_ligand4.sh" +  q +  ")\n"+
//"#-----------------------------------------\n\n";
        String result = instance.executeParser(new PythonBuilder()).getPythonCode();
//        System.out.println(expResult);
//        System.out.println(result);
        assertEquals(expResult, result);
    }
    
}
