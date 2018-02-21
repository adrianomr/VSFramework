/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author adriano
 */
public class ListNode {

    private static final List<Node> nodeList = new ArrayList();
    
    private ListNode() {

    }

    public static List<Node> getInstance() {
        return nodeList;
    }

    public static void addNode(Node node) {
        nodeList.add(node);
    }

    public static void addNodes(String idVirtualScrenning, String file) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            int cont = 1;
            while (line != null) {
                addNode(new Node(""+cont, idVirtualScrenning, line));
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
                cont++;
            }
            String everything = sb.toString();
        } finally {
            br.close();
        }
    }
    
    public static Node getNode(String id, String idVirtualScrenning){
        for (Iterator<Node> iterator = nodeList.iterator(); iterator.hasNext();) {
            Node next = iterator.next();
            if (idVirtualScrenning.equals(next.getIdVirtualScrenning())
                    && id.equals(next.getId())) {
                return next;
            }
        }
        return null;
    }
}
