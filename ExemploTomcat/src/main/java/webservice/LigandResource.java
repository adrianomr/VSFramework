/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import java.io.IOException;
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
@Path("ligand")
public class LigandResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LigandResource
     */
    public LigandResource() {
    }

    /**
     * Retrieves representation of an instance of webservice.LigandResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/{idVirtualScrenning}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getText(@PathParam("idVirtualScrenning") String idVirtualScrenning) throws IOException {
        //TODO return proper representation object
        VirtualScrenning virtualScrenning = ListVirtualScrenning.getVirtualScrenning(
                idVirtualScrenning);
        String fileText = "";
        System.out.println(virtualScrenning.getLigand().getFilePath()+
                virtualScrenning.getLigand().getFileName()+"."+virtualScrenning.getLigand().getFileType().toLowerCase());
        fileText = Util.getFileText(virtualScrenning.getLigand().getFilePath()+
                virtualScrenning.getLigand().getFileName()+"."+virtualScrenning.getLigand().getFileType().toLowerCase());
        return fileText;
    }
    /**
     * PUT method for updating or creating an instance of LigandResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
