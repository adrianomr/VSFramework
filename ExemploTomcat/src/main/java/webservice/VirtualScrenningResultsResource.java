/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.ListVirtualScrenning;
import model.Util;
import model.VirtualScrenning;
import org.apache.tomcat.util.codec.binary.Base64;

/**
 * REST Web Service
 *
 * @author adriano
 */
@Path("/results/virtualscrenning/")
public class VirtualScrenningResultsResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of VirtualScrenningResultsResource
     */
    public VirtualScrenningResultsResource() {
    }

    @GET
    @Path("/{idVirtualScrenning}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getText(@PathParam("idVirtualScrenning") String idVirtualScrenning) {
        //TODO return proper representation object
        
        String json = "{";
        String caminho = System.getProperty("user.dir");
            String filePath = caminho + System.getProperty("file.separator") +"ExemploTomcat"+ System.getProperty("file.separator")+"src"+ System.getProperty("file.separator")+"main"+ System.getProperty("file.separator")+"java"+ System.getProperty("file.separator")+"outputpath"+ System.getProperty("file.separator");
            
        
        ArrayList<String> files = Util.getArquivosSaida(filePath, idVirtualScrenning);
        int count = 0;
        for (String file : files) {
            String virgula = "{".equals(json) ? "" : ", ";
            json += virgula + '\"'+count+"\": \""+file+"\"";
            count++;
        }
        json+="}";
        return json;
    }
    
    @GET
    @Path("/{idVirtualScrenning}/{index}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getText(@PathParam("idVirtualScrenning") String idVirtualScrenning,
    @PathParam("index") int index) throws IOException {
        //TODO return proper representation object
        VirtualScrenning virtualScrenning = ListVirtualScrenning.getVirtualScrenning(
                idVirtualScrenning);
        String fileText = "";
        String caminho = System.getProperty("user.dir");
            String filePath = caminho + System.getProperty("file.separator") +"ExemploTomcat"+ System.getProperty("file.separator")+"src"+ System.getProperty("file.separator")+"main"+ System.getProperty("file.separator")+"java"+ System.getProperty("file.separator")+"outputpath"+ System.getProperty("file.separator");
            
        
        ArrayList<String> files = Util.getArquivosSaida(filePath, idVirtualScrenning);
            fileText = Util.getFileText(filePath+files.get(index));
        byte[] encodedBytes = Base64.encodeBase64(fileText.getBytes());
        return new String(encodedBytes);
    }

    /**
     * PUT method for updating or creating an instance of VirtualScrenningResultsResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) throws IOException {
        HashMap<String, String> resultsList = Util.jsonToMap(content);
        String ip = resultsList.get("ip");
        String port = resultsList.get("port");
        String idVirtualScrenning = resultsList.get("idVirtualScrenning");
        VirtualScrenningResultsClient.createFile(idVirtualScrenning, ip, port);
    }
}
