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
public class ParserPrepareReceptorTest {

    public ParserPrepareReceptorTest() {
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
     * Test of getPrepareReceptor method, of class ParserPrepareReceptor.
     */
    @Test
    public void testGetPrepareReceptor() {
        System.out.println("getPrepareReceptor");

        Ligand ligand = new Ligand("/home/instala/03_Silvia_UFPEL_Experimento_refazendo/V20.pdbqt", "pdbqt", false, true);
        Receptor receptor = new Receptor("/home/instala/03_Silvia_UFPEL_Experimento_refazendo/PDBs/", "pdbqt", true);
        String pathvs = "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/";
        String MGLPath = "/home/";
        String outputPath = "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/V20_caixa_grande/";
        VirtualScrenning testVS = new VirtualScrenning("", "", "", -29.898, 101.527,
                39.444, 40d, 40d, 40d, 128, ligand, receptor, pathvs, MGLPath, 20, new OSLinux(), outputPath);

        ParserPrepareReceptor instance = new ParserPrepareReceptor(testVS);

        String q = "\"";
        String qlinha = "\\n";
        String cifrao = "$";
        String aux_type = "pdbqt";
        String aux_rec = "PDBs";
        String path = "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/PDBs/";
        String expResult = "\n\n#Creation of file .sh to convert\n"
                + "for receptor in lista_receptores:\n"
                + "\taux_receptor = " + q + "" + q + "\n"
                + "\taux_receptor = receptor.replace(" + q + "." + aux_type + "" + q + "," + q + "" + q + ")\n"
                + "\tf = open(" + q + "" + path + "executa_prepare_receptor4.sh" + q + "," + q + "w" + q + ")\n"
                + "\tf.write(" + q + "export PATH=" + MGLPath + "bin:" + cifrao + "PATH" + qlinha + "" + q + ")\n"
                + "\tf.write(" + q + "pythonsh " + MGLPath + "MGLToolsPckgs/AutoDockTools/Utilities24/prepare_receptor4.py -A 'checkhydrogens' -r " + path + q + "+receptor+" + q + " -o " + path + q + "+aux_receptor+" + q + ".pdbqt" + q + ")\n"
                + "\tf.close()\n"
                + "\tos.system(" + q + "chmod 777 " + path + "executa_prepare_receptor4.sh" + q + ")\n"
                + "\tos.system(" + q + "" + path + "executa_prepare_receptor4.sh" + q + ")\n"
                + "#-----------------------------------------\n\n";
        String result = instance.getPrepareReceptor().getPythonCode();
        System.out.println(expResult);
        System.out.println(result);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPrepareReceptorSingleReceptor() {
        System.out.println("getPrepareReceptor");
        Ligand ligand = new Ligand("/home/instala/03_Silvia_UFPEL_Experimento_refazendo/V20.pdbqt", "pdbqt", false, true);
        Receptor receptor = new Receptor("/home/instala/03_Silvia_UFPEL_Experimento_refazendo/PDBs/PDBs.pdbqt", "pdbqt", false);
        String pathvs = "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/";
        String MGLPath = "/home/";
        String outputPath = "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/V20_caixa_grande/";
        VirtualScrenning testVS = new VirtualScrenning("", "", "", -29.898, 101.527,
                39.444, 40d, 40d, 40d, 128, ligand, receptor, pathvs, MGLPath, 20, new OSLinux(), outputPath);

        ParserPrepareReceptor instance = new ParserPrepareReceptor(testVS);
//        function linux_python_chama_prepare_receptor4_apos_pega_nome_receptores($arquivo_python, $receptor_name, $receptor_type, $_path, $MGL_path) {
        String q = "\"";
        String qlinha = "\\n";
        String cifrao = "$";
        String aux_type = "pdbqt";
        String aux_rec = "PDBs";
        String path = "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/PDBs/";
        String expResult = "\n\n#Creation of file .sh to convert\n"
                + "receptor = \"" + aux_rec + "." + aux_type + "\"\n"
                + "aux_receptor = \"" + aux_rec + "\"\n"
                + "f = open(" + q + "" + path + "executa_prepare_receptor4.sh" + q + "," + q + "w" + q + ")\n"
                + "f.write(" + q + "export PATH=" + MGLPath + "bin:" + cifrao + "PATH" + qlinha + "" + q + ")\n"
                + "f.write(" + q + "pythonsh " + MGLPath + "MGLToolsPckgs/AutoDockTools/Utilities24/prepare_receptor4.py -A 'checkhydrogens' -r " + path + q + "+receptor+" + q + " -o " + path + q + "+aux_receptor+" + q + ".pdbqt" + q + ")\n"
                + "f.close()\n"
                + "os.system(" + q + "chmod 777 " + path + "executa_prepare_receptor4.sh" + q + ")\n"
                + "os.system(" + q + "" + path + "executa_prepare_receptor4.sh" + q + ")\n"
                + "#-----------------------------------------\n\n";
        String result = instance.getPrepareReceptor().getPythonCode();
//        System.out.println(expResult);
//        System.out.println(result);
        assertEquals(expResult, result);
    }
}
