/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import java.util.Set;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author adriano
 */

@javax.ws.rs.ApplicationPath("/webresources")
public class ApplicationConfig extends javax.ws.rs.core.Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(org.glassfish.jersey.server.wadl.internal.WadlResource.class);
        resources.add(webservice.LigandResource.class);
        resources.add(webservice.NodesResource.class);
        resources.add(webservice.ReceptorResource.class);
        resources.add(webservice.VirtualScrenningResource.class);
        resources.add(webservice.VirtualScrenningResultsResource.class);
    }
    
}
