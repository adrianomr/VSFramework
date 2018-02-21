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
 * @author SCADI
 */
public class ParserBoxTest {
    
    public ParserBoxTest() {
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
     * Test of getBoxHeader method, of class ParserBox.
     */
    @Test
    @Ignore
    public void testGetBoxHeader() {
        System.out.println("getBoxHeader");
        ParserBox instance = null;
        instance.getBoxHeader();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWhileX method, of class ParserBox.
     */
    @Test
    @Ignore
    public void testGetWhileX() {
        System.out.println("getWhileX");
        ParserBox instance = null;
        instance.getWhileX();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWhileY method, of class ParserBox.
     */
    @Test
    @Ignore
    public void testGetWhileY() {
        System.out.println("getWhileY");
        ParserBox instance = null;
        instance.getWhileY();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWhileZ method, of class ParserBox.
     */
    @Test
    @Ignore
    public void testGetWhileZ() {
        System.out.println("getWhileZ");
        ParserBox instance = null;
        instance.getWhileZ();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of escreveNoArquivoConf method, of class ParserBox.
     */
    @Test
    @Ignore
    public void testEscreveNoArquivoConf() {
        System.out.println("escreveNoArquivoConf");
        ParserBox instance = null;
        instance.escreveNoArquivoConf();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printElementosCentro method, of class ParserBox.
     */
    @Test
    @Ignore
    public void testPrintElementosCentro() {
        System.out.println("printElementosCentro");
        ParserBox instance = null;
        instance.printElementosCentro();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getForXYZ method, of class ParserBox.
     */
    @Test
    @Ignore
    public void testGetForXYZ() {
        System.out.println("getForXYZ");
        ParserBox instance = null;
        instance.getForXYZ();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getParserBox method, of class ParserBox.
     */
    @Test
    public void testGetParserBox() {
        System.out.println("getParserBox");
        Box box = new Box(new BoxCenter(0d, 0d, 0d), new BoxSize(10d, 10d, 10d),
                new BoxVariation(new BoxCenter(20d, 20d, 20d), 2d, 2d, 2d));
        Ligand ligand = new Ligand("/home/instala/03_Silvia_UFPEL_Experimento_refazendo/V20.pdbqt", "pdbqt", false, true);
        Receptor receptor = new Receptor("/home/instala/03_Silvia_UFPEL_Experimento_refazendo/PDBs/PDBs.pdbqt", "pdbqt", true);
        String path = "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/";
        String MGLPath = "home"; 
        String outputPath = "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/V20_caixa_grande/";
        VirtualScrenning virtualScrenning = new VirtualScrenning("1", "Adriano", "none",box, 128, ligand, receptor, path, MGLPath, 0, new OSLinux(), outputPath);
        ParserBox instance = new ParserBox(virtualScrenning);
        instance.getPythonBuilder().addPythonIdentationBlock();
        String result = instance.getParserBox().getPythonCode();
        System.out.println(result);
//        assertTrue(!instance.getStringPython("path/to/file").isEmpty());
        String expected = "\tcenter_x_final = 20.0\n"
                + "\tstep_x = 2.0\n"
                + "\tauxiliar_x_final = center_x_final\n"
                + "\tauxiliar_inicio_x = center_x\n"
                + "\tlista_val_x = []\n"
                + "\tcenter_y_final = 20.0\n"
                + "\tstep_y = 2.0\n"
                + "\tauxiliar_y_final = center_y_final\n"
                + "\tauxiliar_inicio_y = center_y\n" + "\tlista_val_y = []\n"
                + "\tcenter_z_final = 20.0\n"
                + "\tstep_z = 2.0\n"
                + "\tauxiliar_z_final = center_z_final\n"
                + "\tauxiliar_inicio_z = center_z\n"
                + "\tlista_val_z = []\n"+
                "\twhile(auxiliar_inicio_x <= auxiliar_x_final):\n"
        + "\t\tlista_val_x.append(auxiliar_inicio_x)\n"
        + "\t\tprint(auxiliar_inicio_x)\n"
        + "\t\tauxiliar_inicio_x = auxiliar_inicio_x + step_x\n\n"

                + "\twhile(auxiliar_inicio_y <= auxiliar_y_final):\n"
                + "\t\tlista_val_y.append(auxiliar_inicio_y)\n"
                + "\t\tprint(auxiliar_inicio_y)\n"
                + "\t\tauxiliar_inicio_y = auxiliar_inicio_y + step_y\n"
                + "\n"
                + "\twhile(auxiliar_inicio_z <= auxiliar_z_final):\n"
                + "\t\tlista_val_z.append(auxiliar_inicio_z)\n"
                + "\t\tprint(auxiliar_inicio_z)\n"
                + "\t\tauxiliar_inicio_z = auxiliar_inicio_z + step_z\n"
                + "\n"
                + "\tfor elem_x in lista_val_x:\n"
                + "\t\tfor elem_y in lista_val_y:\n"
                + "\t\t\tfor elem_z in lista_val_z:\n"
                + "\t\t\t\tlista_arquivo = []\n"
                + "\t\t\t\tlista_arquivo_2 = []\n"
                + "\t\t\t\tlista_numero = []\n"
                + "\t\t\t\tlista_numero_2 = []\n"
                + "\t\t\t\tnum =\"\"\n"
                + "\t\t\t\tnum_2 =\"\" \n"
                + "\t\t\t\tfile = open(\""+path+"conf.txt\", \"r\")\n"
                + "\t\t\t\tfor linha in file:\n"
                + "\t\t\t\t\tlista_arquivo.append(linha)\n"
                + "\t\t\t\tfile.close()\n"
                + "\t\t\t\tfor elem in lista_arquivo:\n"
                + "\t\t\t\t\tif(elem.find(\"center_x\")!=-1):\n"
                + "\t\t\t\t\t\tnum = str(elem_x)\n"
                + "\t\t\t\t\t\telem = \"center_x = \" + num"
                + "\n"
                + "\t\t\t\t\tif(elem.find(\"center_y\")!=-1):\n"
                + "\t\t\t\t\t\tnum = str(elem_y)\n"
                + "\t\t\t\t\t\telem = \"center_y = \" + num"
                + "\n"
                + "\t\t\t\t\tif(elem.find(\"center_z\")!=-1):\n"
                + "\t\t\t\t\t\tnum = str(elem_z)\n"
                + "\t\t\t\t\t\telem = \"center_z = \" + num"
                + "\n"
                + "\t\t\t\t\tlista_arquivo_2.append(elem)\n"
                + "\t\t\t\tprint (elem_x)\n"
                + "\t\t\t\tprint (elem_y)\n"
                + "\t\t\t\tprint (elem_z)\n"
                + "\t\t\t\tf = open(\""+path+"conf.txt\", \"w\")\n"
                + "\t\t\t\tfor elem in lista_arquivo_2:\n"
                + "\t\t\t\t\tf.write(\"%s\" % elem)\n"
                + "\t\t\t\tf.close()\n"
                + "\t\t\t\t#Creation of file .sh to play the autodock vina\n\n"
                + "\t\t\t\tf = open(\""+path+"executa_vina.sh\",\"w\")\n"
                + "\t\t\t\tf.write(\"vina --config "+path+"conf.txt --ligand %s%s.pdbqt --receptor %s%s.pdbqt --out %s%s_%s_coord_x_%i_y_%i_z_%i/out_%s_%s_coord_x_%i_y_%i_z_%i.pdbqt --log %s%s_%s_coord_x_%i_y_%i_z_%i/log_%s_%s_coord_x_%i_y_%i_z_%i.txt\" % (ligand_path, aux_ligand, receptor_path, aux_receptor, output_path, aux_receptor, aux_ligand, elem_x, elem_y, elem_z, aux_receptor, aux_ligand, elem_x, elem_y, elem_z, output_path, aux_receptor, aux_ligand, elem_x, elem_y, elem_z, aux_receptor, aux_ligand, elem_x, elem_y, elem_z))\n"
                + "\t\t\t\tf.close()\n"
                + "\t\t\t\t#-----------------------------------------\n"
                + "\t\t\t\tos.system(\"mkdir %s%s_%s_coord_x_%i_y_%i_z_%i/\" "
                + "% (output_path, aux_receptor, aux_ligand, elem_x, elem_y, elem_z))\n"
                + "\t\t\t\tos.system(\"chmod 777 "+path+"executa_vina.sh"
                + "\")\n"
                + "\t\t\t\tprint (\"Vina is Running\")\n"
                + "\t\t\t\tos.system(\""+path+"executa_vina.sh\")#Call to execution of AutoDock Vina\n";
//                + "\tnumber_of_times_to_exec = number_of_times_to_exec - 1\n"
//                + "\tnumber_of_times_executed = number_of_times_executed + 1\n";
        System.out.println(expected);
        assertEquals(expected, result);
    }
    
}
