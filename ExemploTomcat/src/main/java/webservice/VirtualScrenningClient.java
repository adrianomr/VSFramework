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
import java.util.Iterator;
import java.util.List;
import model.ListNode;
import model.Node;

/**
 *
 * @author adriano
 */
public class VirtualScrenningClient {

    public static void distributeScrenning(String id, String json) throws IOException {
        List<Node> nodes = ListNode.getInstance();
        int totalNodes = 0;
        for (Iterator<Node> iterator = nodes.iterator(); iterator.hasNext();) {
            Node next = iterator.next();
            if ("ok".equals(next.getStatus())) {
                totalNodes++;
            }
        }
        int count = 0;
        for (Iterator<Node> iterator = nodes.iterator(); iterator.hasNext();) {
            Node next = iterator.next();
            if ("ok".equals(next.getStatus())) {
                sendVirtualScrenning(count, totalNodes, next, json);
                count++;
            }
        }
    }

    public static String sendVirtualScrenning(int nodesId, int totalNodes, Node node, String json) throws MalformedURLException, IOException {
        String fileTex = "";
            URL url = new URL("http://" + node.getIp() + ":" + node.getPort() + "/webresources/"
                    + "virtualscrenning"+"/"+nodesId+"/"+totalNodes);
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
            httpCon.setDoOutput(true);
            httpCon.setRequestMethod("PUT");
            OutputStreamWriter out = new OutputStreamWriter(
                    httpCon.getOutputStream());
            out.write(json);
            out.close();
            httpCon.getInputStream();
        
        return null;
    }

    static void executeScrenning(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
