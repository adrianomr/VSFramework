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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.ListNode;
import model.ListVirtualScrenning;
import model.Node;
import model.Servidor;
import model.Util;
import model.VirtualScrenning;

/**
 * REST Web Service
 *
 * @author adriano
 */
@Path("nodes")
public class NodesResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of NodesResource
     */
    public NodesResource() {
    }

    /**
     * Retrieves representation of an instance of webservice.NodesResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        String json = "[";
        ArrayList<String> idList = new ArrayList<>();
        ArrayList<Node> virtualScrenningList = (ArrayList<Node>) ListNode.getInstance();
        for (Iterator<Node> iterator = virtualScrenningList.iterator(); iterator.hasNext();) {
            Node next = iterator.next();
            if (!idList.contains(next.getIdVirtualScrenning())) {
                String addVirgula = "[".equals(json) ? "" : ", ";
                json += addVirgula + "{\"idVirtualScrenning\": \"" + 
                        next.getIdVirtualScrenning() + "\"}";
                idList.add(next.getIdVirtualScrenning());
            }
        }
        json += "]";
        return json;
    }

    @GET
    @Path("/{idVirtualScrenning}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("idVirtualScrenning") String idVirtualScrenning) {
        String json = "[";
        ArrayList<Node> virtualScrenningList = (ArrayList<Node>) ListNode.getInstance();
        for (Iterator<Node> iterator = virtualScrenningList.iterator(); iterator.hasNext();) {
            Node next = iterator.next();
            if (idVirtualScrenning.equals(next.getIdVirtualScrenning())) {
                String addVirgula = "[".equals(json) ? "" : ", ";
                json += addVirgula + "{\"id\": \"" + next.getId() + "\", "
                        + "\"ip\": \"" + next.getIp() + "\", "
                        + "\"port\": \"" + next.getPort() + "\", "
                        + " \"status\": \"" + next.getStatus() + "\"}";
            }
        }
        json += "]";
        return json;
    }

    @GET
    @Path("/{idVirtualScrenning}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("idVirtualScrenning") String idVirtualScrenning,
            @PathParam("id") String id) {
        String json = "{\"status\":\"unavailable\"}";
        Node node = ListNode.getNode(id, idVirtualScrenning);
        if (node != null) {
            json = "{\"status\":\""+node.getStatus()+"\"}";
        }
        return json;
    }
    
    //get status of the current node
    @GET
    @Path("/node/status/{port}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getNodeStatusJson(@Context HttpServletRequest request,
            @PathParam("port") String port) {
        String json = "{\"status\":\"ok\"}";
        System.out.println(request.getRemoteAddr()+":"+port);
        Servidor.setIp(request.getRemoteAddr());
        Servidor.setPort(port);
        return json;
    }
    

    /**
     * PUT method for updating or creating an instance of NodesResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) throws IOException {
        HashMap<String, String> mapNodesInput = Util.jsonToMap(content);
        ListNode.addNodes(mapNodesInput.get("idVirtualScrenning"), mapNodesInput.get("file"));
    }
}
