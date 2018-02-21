/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import com.example.employees.Main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import model.ExecuteShellCommand;
import model.HashMapToVirtualScrenning;
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
@Path("virtualscrenning")
public class VirtualScrenningResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of VirutalScrenningResource
     */
    public VirtualScrenningResource() {
    }

    /**
     * Retrieves representation of an instance of webservice.VirutalScrenningResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        String json = "[";
        ArrayList<VirtualScrenning> virtualScrenningList = (ArrayList<VirtualScrenning>) ListVirtualScrenning.getInstance();
        for (Iterator<VirtualScrenning> iterator = virtualScrenningList.iterator(); iterator.hasNext();) {
            VirtualScrenning next = iterator.next();
            json += "{\"id\": \""+next.getID()+"\","
                    + " \"name\": \""+next.getName()+"\"}" + (iterator.hasNext() ? ", ":"");
        }
        json += "]";
        return json;
    }
    
    @GET
    @Path("/{id}")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("id") String id) {
        //TODO return proper representation object
        String json = "{}";
        VirtualScrenning virtualScrenning  = ListVirtualScrenning.getVirtualScrenning(id);
        if(virtualScrenning != null){
            json = virtualScrenning.toJson();
        }
        return json;
    }
    
    @GET
    @Path("/execute/{id}")
    @Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
    public String getPythonCode(@PathParam("id") String id) {
        //TODO return proper representation object
        String response = "Running";
        VirtualScrenning virtualScrenning  = ListVirtualScrenning.getVirtualScrenning(id);
        if("none".equals(virtualScrenning.getDistributionConfig().toLowerCase().trim())){
            String pythonCode = "";
            if(virtualScrenning != null){
                System.out.println("Vsjson: "+virtualScrenning.toJson());
            }
            return ((virtualScrenning == null) ? "" : virtualScrenning.getGeneratePythonCode());
        }else{
            //VirtualScrenningClient.executeScrenning(id);
        }
        return response;
    }
    

    /**
     * PUT method for updating or creating an instance of VirutalScrenningResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public void putJson(String content) throws IOException {
        System.out.println(content);
        HashMap<String, String> mapVirtualScrenning = Util.jsonToMap(content);
        ListVirtualScrenning.addVirtualScrenning(
                HashMapToVirtualScrenning.getVirtualScrenning(mapVirtualScrenning));
        VirtualScrenningClient.distributeScrenning(mapVirtualScrenning.get("id"),
                content);
    }
    
    @PUT
    @Path("/{nodeId}/{totalNodes}")
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public void putJson(String content, @PathParam("nodeId") String nodeId,
        @PathParam("totalNodes") String totalNodes) throws IOException, InterruptedException {
        //limpar a pasta outputpath
        
        HashMap<String, String> mapVirtualScrenning = Util.jsonToMap(content);
        VirtualScrenning virtualScrenning = HashMapToVirtualScrenning.getVirtualScrenning(mapVirtualScrenning);
        String caminho = System.getProperty("user.dir");
        ExecuteShellCommand.executeCommand("rm -rf "+caminho + System.getProperty("file.separator") +"ExemploTomcat"+ System.getProperty("file.separator")+"src"+ System.getProperty("file.separator")+"main"+ System.getProperty("file.separator")+"java"+ System.getProperty("file.separator")+"outputpath"+ System.getProperty("file.separator")+"*");
        String caminhoLigand = caminho + System.getProperty("file.separator") +"ExemploTomcat"
                + System.getProperty("file.separator")+"src"+System.getProperty("file.separator")+"main"+System.getProperty("file.separator")+"java"+System.getProperty("file.separator")+"ligands";
        String caminhoReceptor = caminho + System.getProperty("file.separator") +"ExemploTomcat"
                + System.getProperty("file.separator")+"src"+System.getProperty("file.separator")+"main"+System.getProperty("file.separator")+"java"+System.getProperty("file.separator")+"receptors";
        virtualScrenning.setOutputPath(caminho + System.getProperty("file.separator") +"ExemploTomcat"+ System.getProperty("file.separator")+"src"+ System.getProperty("file.separator")+"main"+ System.getProperty("file.separator")+"java"+ System.getProperty("file.separator")+"outputpath"+ System.getProperty("file.separator"));
        virtualScrenning.getLigand().setFilePath(caminhoLigand);
        virtualScrenning.getReceptor().setFilePath(caminhoReceptor);
        ListVirtualScrenning.addVirtualScrenning(virtualScrenning);
        virtualScrenning.setNodeId(nodeId).setTotalNodes(totalNodes);
        LigandClient.createFile(mapVirtualScrenning.get("id"));
        ReceptorClient.createFile(mapVirtualScrenning.get("id"));
        String filePath = caminho + System.getProperty("file.separator") +"ExemploTomcat"
                + System.getProperty("file.separator")+"src"+System.getProperty("file.separator")+"main"+System.getProperty("file.separator")+"java"+System.getProperty("file.separator")+"ligands";
        
        String fileName = filePath+System.getProperty("file.separator")+"executeVina.py";
        Util.writeFile(fileName, virtualScrenning.getGeneratePythonCode());
        ExecuteShellCommand.executeCommand("python "+fileName);
        ExecuteShellCommand.executeCommand("tar -cvzf "+caminho + System.getProperty("file.separator") +"ExemploTomcat"+ System.getProperty("file.separator")+"src"+ System.getProperty("file.separator")+"main"+ System.getProperty("file.separator")+"java"+ System.getProperty("file.separator")+"outputpath"+ System.getProperty("file.separator")+"output_vs_"+virtualScrenning.getID()+"_task_"+virtualScrenning.getNodeId()+".tar.gz "+caminho + System.getProperty("file.separator") +"ExemploTomcat"+ System.getProperty("file.separator")+"src"+ System.getProperty("file.separator")+"main"+ System.getProperty("file.separator")+"java"+ System.getProperty("file.separator")+"outputpath");
        VirtualScrenningResultsClient.sendFinishedScript(mapVirtualScrenning.get("id"), Main.getIp(), Main.getPort());
    }
}
