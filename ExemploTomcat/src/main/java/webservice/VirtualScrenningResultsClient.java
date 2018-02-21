/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import model.ListVirtualScrenning;
import model.Node;
import model.Servidor;
import model.Util;
import org.apache.tomcat.util.codec.binary.Base64;

/**
 *
 * @author adriano
 */
public class VirtualScrenningResultsClient {

    public static HashMap<String, String> getFiles(String idVirtualScrenning, String ip, String port) {
        String fileTex = "";
        try {
            URL url = new URL("http://" + ip + ":" + port + "/webresources/"
                    + "results/virtualscrenning/" + idVirtualScrenning);
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

    public static String getFileText(String idVirtualScrenning, String ip, String port, int index) {
        String fileTex = "";
        try {
            URL url = new URL("http://" + ip + ":" + port + "/webresources/"
                    + "results/virtualscrenning/" + idVirtualScrenning + "/" + index);
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
            return new String(Base64.decodeBase64(sb.toString()));
        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return null;
    }
    
    public static String sendFinishedScript(String idVirtualScrenning, String ip, String port) throws MalformedURLException, IOException {
        String fileTex = "";
            URL url = new URL("http://" + Servidor.getIp() + ":" + Servidor.getPort() + "/webresources/"
                    + "results/virtualscrenning/");
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
            httpCon.setDoOutput(true);
            httpCon.setRequestMethod("PUT");
            OutputStreamWriter out = new OutputStreamWriter(
                    httpCon.getOutputStream());
            out.write("{\"ip\":\""+ip+"\", \"port\":\""+port+"\", \"idVirtualScrenning\":\""+idVirtualScrenning+"\"}");
            out.close();
            httpCon.getInputStream();
        
        return null;
    }

    public static void createFile(String idVirtualScrenning, String ip, String port) throws IOException {
        HashMap<String, String> files = getFiles(idVirtualScrenning, ip, port);
        for (String key : files.keySet()) {
            String texto = getFileText(idVirtualScrenning, ip, port, Integer.parseInt(key));
            String filePath = ListVirtualScrenning.getVirtualScrenning(idVirtualScrenning).getOutputPath();

            System.out.println("recaqui ------- " + filePath + files.get(key));
            Util.writeFile(filePath + files.get(key), texto);
        }
    }
}
