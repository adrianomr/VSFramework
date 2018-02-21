/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import model.ListVirtualScrenning;
import model.Servidor;
import model.Util;
import static webservice.LigandClient.getFileText;

/**
 *
 * @author adriano
 */
public class ReceptorClient {

    public static HashMap<String, String> getFiles(String idVirtualScrenning) {
        String fileTex = "";
        try {
            URL url = new URL("http://" + Servidor.getIp() + ":" + Servidor.getPort() + "/webresources/"
                    + "receptor/" + idVirtualScrenning);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                HashMap<String, String> lista = Util.jsonToMap(output);
                System.out.println(output);
                return lista;
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return null;
    }

    public static String getFileText(String idVirtualScrenning, int index) {
        String fileTex = "";
        try {
            URL url = new URL("http://" + Servidor.getIp() + ":" + Servidor.getPort() + "/webresources/"
                    + "receptor/" + idVirtualScrenning + "/" + index);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "text/plain");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            StringBuilder sb = new StringBuilder();
            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
//                System.out.println(output);
                System.out.println(br.toString());
                sb.append(br.readLine());
//                return output;
            }
            conn.disconnect();
            return sb.toString();
        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return null;
    }

    public static void createFile(String idVirtualScrenning) throws IOException {
        HashMap<String, String> files = getFiles(idVirtualScrenning);
        if (ListVirtualScrenning.getVirtualScrenning(idVirtualScrenning).getReceptor().isMultipleReceptors()) {
            for (String key : files.keySet()) {
                String texto = getFileText(idVirtualScrenning, Integer.parseInt(key));
                String caminho = System.getProperty("user.dir");
                String filePath = caminho + System.getProperty("file.separator") + "ExemploTomcat"
                        + System.getProperty("file.separator") + "src" + System.getProperty("file.separator") + "main" + System.getProperty("file.separator") + "java" + System.getProperty("file.separator") + "receptors";

                System.out.println("recaqui ------- " + filePath
                        + System.getProperty("file.separator") + files.get(key));
                Util.writeFile(filePath
                        + System.getProperty("file.separator") + files.get(key), texto);
            }
        } else {
            String texto = getFileText(idVirtualScrenning, 0);
            String fileServer = ListVirtualScrenning.getVirtualScrenning(idVirtualScrenning).getReceptor().getFilePath();
            String[] split = fileServer.split(System.getProperty("file.separator"));
            String fileName = split[split.length - 1];
            String caminho = System.getProperty("user.dir");
            String filePath = caminho + System.getProperty("file.separator") + "ExemploTomcat"
                    + System.getProperty("file.separator") + "src" + System.getProperty("file.separator") + "main" + System.getProperty("file.separator") + "java" + System.getProperty("file.separator") + "receptors";
            System.out.println("recaqui ------- " + filePath
                    + System.getProperty("file.separator") + fileName);
            Util.writeFile(filePath + System.getProperty("file.separator") + fileName, texto);
        }
    }

}
