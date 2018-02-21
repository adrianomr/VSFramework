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
public class ParserCallVinaTest {

    public ParserCallVinaTest() {
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
     * Test of getParserCallVina method, of class ParserCallVina.
     */
    @Test
    public void testGetParserCallVina() {
        System.out.println("getParserCallVina");
        Box box = new Box(new BoxCenter(0d, 0d, 0d), new BoxSize(10d, 10d, 10d),
                new BoxVariation(new BoxCenter(0d, 0d, 0d), 0d, 0d, 0d));
        Ligand ligand = new Ligand("/home/instala/03_Silvia_UFPEL_Experimento_refazendo/V20.pdbqt", "pdbqt",false, false);
        Receptor receptor = new Receptor("/home/instala/03_Silvia_UFPEL_Experimento_refazendo/PDBs/PDBs.pdbqt", "pdbqt", false);
        String path = "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/";
        String MGLPath = "home"; 
        String outputPath = "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/V20_caixa_grande/";
        VirtualScrenning virtualScrenning = new VirtualScrenning("1","adriano","none",box, 128, ligand, receptor, path, MGLPath, 0, new OSLinux(), outputPath);
        
        ParserCallVina instance = new ParserCallVina(virtualScrenning);
        String expResult = "";
        String q = "\""; //aspa dupla
        String qlinha = "\n";
        String barra = "\\";
        expResult
                += "#Creation of file .sh to play the autodock vina\n\n"
                + "f = open(" + q + "" + virtualScrenning.getPath() + "executa_vina.sh" + q + "," + q + "w" + q + ")\n"
                + "f.write(" + q + "vina --config " + virtualScrenning.getPath() + "conf.txt --ligand %s%s.pdbqt --receptor %s%s.pdbqt --out "+ virtualScrenning.getOutputPath() +"out_%s.pdbqt --log "+ virtualScrenning.getOutputPath() +"log_%s.txt" + q + " % (ligand_path, aux_ligand, receptor_path, aux_receptor, aux_ligand, aux_ligand))\n"
                + "f.close()\n"
                + "#-----------------------------------------\n"
                + "os.system(" + q + "chmod 777 " + virtualScrenning.getPath() + "executa_vina.sh" + q + ")\n"
                + "print (" + q + "Vina is Running" + q + ")\n"
                + "os.system(" + q + "" + virtualScrenning.getPath() + "executa_vina.sh" + q + ")#Call to execution of AutoDock Vina\n";
        String result = instance.getParserCallVina().getPythonCode();
//        System.out.println(expResult);
//        System.out.println(result);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetParserCallVinaLigandReceptor() {
        System.out.println("getParserCallVinaLigandReceptor");
        Box box = new Box(new BoxCenter(0d, 0d, 0d), new BoxSize(10d, 10d, 10d),
                new BoxVariation(new BoxCenter(0d, 0d, 0d), 0d, 0d, 0d));
        Ligand ligand = new Ligand("/home/instala/03_Silvia_UFPEL_Experimento_refazendo/V20.pdbqt", "pdbqt", false, true);
        Receptor receptor = new Receptor("/home/instala/03_Silvia_UFPEL_Experimento_refazendo/PDBs/PDBs.pdbqt", "pdbqt", true);
        String path = "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/";
        String MGLPath = "home"; 
        String outputPath = "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/V20_caixa_grande/";
        VirtualScrenning virtualScrenning = new VirtualScrenning("1","adriano","none",box, 128, ligand, receptor, path, MGLPath, 0, new OSLinux(), outputPath);
     ParserCallVina instance = new ParserCallVina(virtualScrenning);
        String expResult = "";
        String q = "\""; //aspa dupla
        String qlinha = "\n";
        String barra = "\\";
        expResult += "#Creation of file .sh to play the autodock vina\n\n"
                + "f = open(" + q + "" + virtualScrenning.getPath() + "executa_vina.sh" + q + "," + q + "w" + q + ")\n"
                + "f.write(" + q + "vina --config " + virtualScrenning.getPath()
                + "conf.txt --ligand %s%s.pdbqt --receptor %s%s.pdbqt --out "
                + virtualScrenning.getOutputPath() 
                + "out_%s_%s.pdbqt --log "
                + virtualScrenning.getOutputPath() 
                + "log_%s_%s.txt" + q
                + " % (ligand_path, aux_ligand, receptor_path, aux_receptor, aux_receptor, aux_ligand, aux_receptor, aux_ligand))\n"
                + "f.close()\n"
                + "#-----------------------------------------\n"
                +"os.system(" + q + "chmod 777 " + virtualScrenning.getPath() + "executa_vina.sh" + q + ")\n"
                
                + "print (" + q + "Vina is Running" + q + ")\n"
                + "os.system(" + q + "" + virtualScrenning.getPath() + "executa_vina.sh" + q + ")#Call to execution of AutoDock Vina\n";
        String result = instance.getParserCallVina().getPythonCode();
        System.out.println(expResult);
        System.out.println(result);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetParserCallVinaRepeatingNTimes() {
        System.out.println("getParserCallVinaLigandReceptor");
        Box box = new Box(new BoxCenter(0d, 0d, 0d), new BoxSize(10d, 10d, 10d),
                new BoxVariation(new BoxCenter(0d, 0d, 0d), 0d, 0d, 0d));
        Ligand ligand = new Ligand("/home/instala/03_Silvia_UFPEL_Experimento_refazendo/V20.pdbqt", "pdbqt", false, false);
        Receptor receptor = new Receptor("/home/instala/03_Silvia_UFPEL_Experimento_refazendo/PDBs/PDBs.pdbqt", "pdbqt", false);
        String path = "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/";
        String MGLPath = "home"; 
        String outputPath = "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/V20_caixa_grande/";
        VirtualScrenning virtualScrenning = new VirtualScrenning("1","adriano","none",box, 128, ligand, receptor, path, MGLPath, 20, new OSLinux(), outputPath);
     
//        ParserCreateWriteConfMultipleReceptors instance = new ParserCreateWriteConfMultipleReceptors(virtualScrenning);
        ParserCallVina instance = new ParserCallVina(virtualScrenning);
        String expResult = "";
        String q = "\""; //aspa dupla
        String qlinha = "\n";
        String barra = "\\";
        expResult += "#Creation of file .sh to play the autodock vina\n\n";
	expResult += "f = open(" + q + "" + virtualScrenning.getPath() + "executa_vina.sh" + q + "," + q + "w" + q + ")\n";
	expResult += "f.write(" + q + "vina --config " + virtualScrenning.getPath() + "conf.txt --ligand %s%s.pdbqt --receptor %s%s.pdbqt --out " + virtualScrenning.getOutputPath() + "out_%s_time_%i.pdbqt --log " + virtualScrenning.getOutputPath() + "log_%s_time_%i.txt" + q + " % (ligand_path, aux_ligand, receptor_path, aux_receptor, aux_ligand, number_of_times_executed, aux_ligand, number_of_times_executed))\n";
	
        expResult += "f.close()\n";
        expResult += "#-----------------------------------------\n";
        expResult += "os.system(" + q + "chmod 777 " + virtualScrenning.getPath() + "executa_vina.sh" + q + ")\n";
	expResult += "os.system(" + q + "chmod 777 " + virtualScrenning.getPath() + "conf.txt" + q + ")\n";
	
        expResult += "print (" + q + "Vina is Running" + q + ")\n";
	expResult += "os.system(" + q + "" + virtualScrenning.getPath() + "executa_vina.sh" + q + ")#Call to execution of AutoDock Vina\n";
	expResult += "number_of_times_to_exec = number_of_times_to_exec - 1\n";
	expResult += "number_of_times_executed = number_of_times_executed + 1\n";
	expResult += "";
        String result = instance.getParserCallVina().getPythonCode();
//        System.out.println(expResult);
//        System.out.println(result);
        assertEquals(expResult, result);
    }
    @Test
    public void testGetParserCallVinaMultipleLigands() {
        System.out.println("testGetParserCallVinaMultipleLigands");
        Box box = new Box(new BoxCenter(0d, 0d, 0d), new BoxSize(10d, 10d, 10d),
                new BoxVariation(new BoxCenter(0d, 0d, 0d), 0d, 0d, 0d));
        Ligand ligand = new Ligand("/home/instala/03_Silvia_UFPEL_Experimento_refazendo/V20.pdbqt", "pdbqt", false, true);
        Receptor receptor = new Receptor("/home/instala/03_Silvia_UFPEL_Experimento_refazendo/PDBs/PDBs.pdbqt", "pdbqt", false);
        String path = "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/";
        String MGLPath = "home"; 
        String outputPath = "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/V20_caixa_grande/";
        VirtualScrenning virtualScrenning = new VirtualScrenning("1","adriano","none",box, 128, ligand, receptor, path, MGLPath, 0, new OSLinux(), outputPath);
    
//        ParserCreateWriteConfMultipleReceptors instance = new ParserCreateWriteConfMultipleReceptors(virtualScrenning);
        ParserCallVina instance = new ParserCallVina(virtualScrenning);
        String expResult = "";
        String q = "\""; //aspa dupla
        String qlinha = "\n";
        String barra = "\\";
        expResult += "#Creation of file .sh to play the autodock vina\n\n";
	
        expResult += "f = open(" + q + "" + virtualScrenning.getPath() + "executa_vina.sh" + q + "," + q + "w" + q + ")\n";
	
        expResult += "f.write(" + q + "vina --config " + virtualScrenning.getPath() + "conf.txt --ligand %s%s.pdbqt --receptor %s%s.pdbqt --out "+virtualScrenning.getOutputPath()+"out_%s.pdbqt --log "+virtualScrenning.getOutputPath()+"log_%s.txt" + q + " % (ligand_path, aux_ligand, receptor_path, aux_receptor, aux_ligand, aux_ligand))\n";

	expResult += "f.close()\n";
        expResult += "#-----------------------------------------\n";
	expResult += "os.system(" + q + "chmod 777 " + virtualScrenning.getPath() + "executa_vina.sh" + q + ")\n";
	
	expResult += "print (" + q + "Vina is Running" + q + ")\n";
	expResult += "os.system(" + q + "" + virtualScrenning.getPath() + "executa_vina.sh" + q + ")#Call to execution of AutoDock Vina\n";
        String result = instance.getParserCallVina().getPythonCode();
//        System.out.println(expResult);
//        System.out.println(result);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetParserCallVinaMultipleReceptors() {
        System.out.println("testGetParserCallVinaMultipleLigands");
        Box box = new Box(new BoxCenter(0d, 0d, 0d), new BoxSize(10d, 10d, 10d),
                new BoxVariation(new BoxCenter(0d, 0d, 0d), 0d, 0d, 0d));
        Ligand ligand = new Ligand("/home/instala/03_Silvia_UFPEL_Experimento_refazendo/V20.pdbqt", "pdbqt", false, false);
        Receptor receptor = new Receptor("/home/instala/03_Silvia_UFPEL_Experimento_refazendo/PDBs/PDBs.pdbqt", "pdbqt", true);
        String path = "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/";
        String MGLPath = "home"; 
        String outputPath = "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/V20_caixa_grande/";
        VirtualScrenning virtualScrenning = new VirtualScrenning("1","adriano","none",box, 128, ligand, receptor, path, MGLPath, 0, new OSLinux(), outputPath);
    
//        ParserCreateWriteConfMultipleReceptors instance = new ParserCreateWriteConfMultipleReceptors(virtualScrenning);
        ParserCallVina instance = new ParserCallVina(virtualScrenning);
        String expResult = "";
        String q = "\""; //aspa dupla
        String qlinha = "\n";
        String barra = "\\";
        expResult += "#Creation of file .sh to play the autodock vina\n\n"+
	"f = open(" + q + "" + virtualScrenning.getPath() + "executa_vina.sh" + q + "," + q + "w" + q + ")\n"+
        
	"f.write(" + q + "vina --config " + virtualScrenning.getPath() + "conf.txt --ligand %s%s.pdbqt --receptor %s%s.pdbqt --out " + virtualScrenning.getOutputPath() + "out_%s.pdbqt --log " + virtualScrenning.getOutputPath() + "log_%s.txt" + q + " % (ligand_path, aux_ligand, receptor_path, aux_receptor, aux_receptor, aux_out_receptor))\n"+
	"f.close()\n"+
        "#-----------------------------------------\n"+
	"os.system(" + q + "chmod 777 " + virtualScrenning.getPath() + "executa_vina.sh" + q + ")\n"+
	"os.system(" + q + "chmod 777 " + virtualScrenning.getPath() + "conf.txt" + q + ")\n"+
	
	"print (" + q + "Vina is Running" + q + ")\n"+
	"os.system(" + q + "" + virtualScrenning.getPath() + "executa_vina.sh" + q + ")#Call to execution of AutoDock Vina\n";
        String result = instance.getParserCallVina().getPythonCode();
//        System.out.println(expResult);
//        System.out.println(result);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetParserCallVinaMultipleReceptorsDistributed() {
        System.out.println("testGetParserCallVinaMultipleLigands");
        Box box = new Box(new BoxCenter(0d, 0d, 0d), new BoxSize(10d, 10d, 10d),
                new BoxVariation(new BoxCenter(0d, 0d, 0d), 0d, 0d, 0d));
        Ligand ligand = new Ligand("/home/instala/03_Silvia_UFPEL_Experimento_refazendo/V20.pdbqt", "pdbqt", false, false);
        Receptor receptor = new Receptor("/home/instala/03_Silvia_UFPEL_Experimento_refazendo/PDBs/PDBs.pdbqt", "pdbqt", true);
        String path = "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/";
        String MGLPath = "home"; 
        String outputPath = "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/V20_caixa_grande/";
        VirtualScrenning virtualScrenning = new VirtualScrenning("1","adriano","file",box, 128, ligand, receptor, path, MGLPath, 0, new OSLinux(), outputPath);
    
//        ParserCreateWriteConfMultipleReceptors instance = new ParserCreateWriteConfMultipleReceptors(virtualScrenning);
        ParserCallVina instance = new ParserCallVina(virtualScrenning);
        String expResult = "";
        String q = "\""; //aspa dupla
        String qlinha = "\n";
        String barra = "\\";
        expResult += "if(count%total_nodes == node_id):\n"+
        "\t#Creation of file .sh to play the autodock vina\n\n"+
	"\tf = open(" + q + "" + virtualScrenning.getPath() + "executa_vina.sh" + q + "," + q + "w" + q + ")\n"+
        
	"\tf.write(" + q + "vina --config " + virtualScrenning.getPath() + "conf.txt --ligand %s%s.pdbqt --receptor %s%s.pdbqt --out " + virtualScrenning.getOutputPath() + "out_%s.pdbqt --log " + virtualScrenning.getOutputPath() + "log_%s.txt" + q + " % (ligand_path, aux_ligand, receptor_path, aux_receptor, aux_receptor, aux_out_receptor))\n"+
	"\tf.close()\n"+
        "\t#-----------------------------------------\n"+
	"\tos.system(" + q + "chmod 777 " + virtualScrenning.getPath() + "executa_vina.sh" + q + ")\n"+
	"\tos.system(" + q + "chmod 777 " + virtualScrenning.getPath() + "conf.txt" + q + ")\n"+
	
	"\tprint (" + q + "Vina is Running" + q + ")\n"+
	"\tos.system(" + q + "" + virtualScrenning.getPath() + "executa_vina.sh" + q + ")#Call to execution of AutoDock Vina\n";
        String result = instance.getParserCallVina().getPythonCode();
        System.out.println(expResult);
        System.out.println(result);
        assertEquals(expResult, result);
    }

}
