/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.ListVirtualScrenning;
import model.Util;
import model.VirtualScrenning;

/**
 * REST Web Service
 *
 * @author adriano
 */
@Path("receptor")
public class ReceptorResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ReceptorResource
     */
    public ReceptorResource() {
    }

    /**
     * Retrieves representation of an instance of webservice.ReceptorResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/{idVirtualScrenning}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getText(@PathParam("idVirtualScrenning") String idVirtualScrenning) {
        //TODO return proper representation object
        VirtualScrenning virtualScrenning = ListVirtualScrenning.getVirtualScrenning(idVirtualScrenning);
        System.out.println(virtualScrenning.getReceptor().toString());
        
        String json = "{";//new Gson().toJson(virtualScrenning.getReceptor().getFiles());
        ArrayList<String> files = virtualScrenning.getReceptor().getFiles();
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
        if(virtualScrenning.getReceptor().isMultipleReceptors()){
            fileText = Util.getFileText(virtualScrenning.getReceptor().getFilePath()+
                    System.getProperty("file.separator")+virtualScrenning.getReceptor()
                    .getFiles().get(index));
        }else{
            fileText = Util.getFileText(virtualScrenning.getReceptor().getFilePath()+virtualScrenning.getReceptor().getFileName()+"."+virtualScrenning.getReceptor().getFileType().toLowerCase());
        }
        return fileText;
    }
    
    /**
     * PUT method for updating or creating an instance of ReceptorResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public void putText(String content) {
    }
}
