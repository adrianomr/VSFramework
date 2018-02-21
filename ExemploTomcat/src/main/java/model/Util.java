/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import static model.ListNode.addNode;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author adriano
 */
public class Util {

    public static String getFileName(String file) {
        String name = "";
        String[] var;
        var = file.split("/");
        name = (var[var.length - 1].split("\\."))[0];
        return name;
    }

    public static String getFileType(String file) {
        String type = "";
        String[] var;
        var = file.split("/");
        type = (var[var.length - 1].split("\\."))[(var[var.length - 1].split("\\.")).length - 1];
        return type;
    }

    public static ArrayList<String> getArquivos(String path, String fileType) {

        ArrayList<String> listClasses = new ArrayList<String>();

        File diretorio = new File(path);
        String classes[] = diretorio.list();
        for (int x = 0; x < classes.length; x++) {
            if (classes[x].endsWith(fileType)) {
                listClasses.add(classes[x]);
            }
        }

        return listClasses;

    }
    
    public static ArrayList<String> getArquivosSaida(String path, String idVirtualScrenning) {

        ArrayList<String> listClasses = new ArrayList<String>();

        File diretorio = new File(path);
        String classes[] = diretorio.list();
        for (int x = 0; x < classes.length; x++) {
            if (classes[x].contains("_vs_"+idVirtualScrenning)) {
                listClasses.add(classes[x]);
            }
        }

        return listClasses;

    }

    public static VirtualScrenning getVirtualScrenningForTests() {
        Ligand ligand = new Ligand("/home/instala/03_Silvia_UFPEL_Experimento_refazendo/V20.pdbqt", "pdbqt", false, true);
        Receptor receptor = new Receptor("/home/instala/03_Silvia_UFPEL_Experimento_refazendo/PDBs/PDBs.pdbqt", "pdbqt", true);
        String path = "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/";
        String MGLPath = "/home/";
        String outputPath = "/home/instala/03_Silvia_UFPEL_Experimento_refazendo/V20_caixa_grande/";
        VirtualScrenning testVS = new VirtualScrenning("", "", "", -29.898, 101.527,
                39.444, 40d, 40d, 40d, 128, ligand, receptor, path, MGLPath, 20, new OSLinux(), outputPath);
        return testVS;
    }

    public static HashMap jsonToMap(String t) throws JSONException {

        HashMap<String, String> map = new HashMap<String, String>();
        JSONObject jObject = new JSONObject(t);
        Iterator<?> keys = jObject.keys();

        while (keys.hasNext()) {
            String key = (String) keys.next();
            String value = jObject.getString(key);
            map.put(key, value);

        }

        System.out.println("json : " + jObject);
        System.out.println("map : " + map);
        return map;
    }

    public static String getFileText(String file) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            int cont = 1;
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
                cont++;
            }
            String everything = sb.toString();
            return everything;
        } finally {
            br.close();
        }
    }

    public static void writeFile(String FileName, String text) throws IOException {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(FileName), "utf-8"))) {
            writer.write(text);
        }
    }

}
