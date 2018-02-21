/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/**
 *
 * @author adriano
 */
public class Node {

    String id;
    String idVirtualScrenning;
    String ip;
    String port;

    public Node(String id, String idVirtualScrenning, String ip, String port) {
        this.id = id;
        this.idVirtualScrenning = idVirtualScrenning;
        this.ip = ip;
        this.port = port;
    }

    public Node(String id, String idVirtualScrenning, String line) {
        this.id = id;
        this.idVirtualScrenning = idVirtualScrenning;
        String[] arguments = line.split(";");
        if (arguments.length > 1) {
            this.ip = arguments[0];
            this.port = arguments[1];
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdVirtualScrenning() {
        return idVirtualScrenning;
    }

    public void setIdVirtualScrenning(String id) {
        this.idVirtualScrenning = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getStatus() {
        String json = "unavailable";
        try {
            URL url = new URL("http://" + this.getIp() + ":" + this.getPort() + "/webresources/"
                    + "nodes/node/status/"+Servidor.getPort());
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
                HashMap<String,String> status = Util.jsonToMap(output);
                json = status.get("status");
                System.out.println(output);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return json;
    }

}
