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
public class ParserSplitMol2Test {
    
    public ParserSplitMol2Test() {
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
     * Test of getSplitMol2 method, of class ParserSplitMol2.
     */
    @Test
    public void testGetSplitMol2() {
        System.out.println("getSplitMol2");
        ParserSplitMol2 instance = new ParserSplitMol2(Util.getVirtualScrenningForTests());
        String expResult = null;
        String q = "\""; //aspa dupla
        String barra = "/";
        String qlinha = "\\n";
        String _path = "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/";
        String ligand_name = "V20";
        expResult = "#Split the file .mol2 in many small files\n"+
"count = 0\n"+
"lista_nomes_lig = []\n"+
"lista_nomes_lig_sem_ext = []\n"+
"file_mol2 = open(" + q + "" + _path + ligand_name + ".mol2" + q + "," + q + "r" + q + ")\n"+
"file = open(" + q + "" + _path + "" + ligand_name + ".mol2" + q + "," + q + "r" + q + ")\n"+
"for linha in file_mol2:\n"+
	"\tif(linha==" + q + "@<TRIPOS>MOLECULE" + qlinha + "" + q + "):\n"+
		"\t\tfile.close()\n"+
		"\t\tcount = count + 1\n"+
		"\t\taux_count = str(count)\n"+
		"\t\tpath_lig_name = " + q + "" + _path + ligand_name + "" + q + " + aux_count + " + q + ".mol2" + q + "\n"+
		"\t\tlig_name = " + q + "" + ligand_name + "" + q + " + aux_count + " + q + ".mol2" + q + "\n"+
		"\t\tlista_nomes_lig.append(lig_name)\n"+
		"\t\tlig_name_sem_ext = " + q + "" + ligand_name + "" + q + " + aux_count\n"+
		"\t\tlista_nomes_lig_sem_ext.append(lig_name_sem_ext)\n"+
		"\t\tprint lig_name_sem_ext\n"+
		"\t\tfile = open(path_lig_name," + q + "w" + q + ")\n"+
		"\t\tfile.write(linha)\n"+
	"\telse:\n"+
		"\t\tfile.write(linha)\n"+
"file.close()\n"+		
"file_mol2.close()\n";
        String result = instance.getSplitMol2().getPythonCode();
        System.out.println(expResult);
        System.out.println(result);
        assertEquals(expResult, result);
    }
    
}
