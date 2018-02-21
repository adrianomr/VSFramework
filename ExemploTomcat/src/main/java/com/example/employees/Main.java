
package com.example.employees;

import java.util.Optional;
import model.Servidor;

import org.apache.catalina.startup.Tomcat;

public class Main {
    
    public static final Optional<String> PORT = Optional.ofNullable(System.getenv("PORT"));
    public static final Optional<String> HOSTNAME = Optional.ofNullable(System.getenv("HOSTNAME"));
    public static String getIp(){
        return HOSTNAME.orElse("localhost");
    }
    
    public static String getPort(){
//        return PORT.orElse("8080");
        return PORT.orElse("8081");
    }
    public static void main(String[] args) throws Exception {
        String contextPath = "/" ;
        String appBase = ".";
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(Integer.valueOf(PORT.orElse("8081") ));
//        tomcat.setPort(Integer.valueOf(PORT.orElse("8080") ));
        tomcat.setHostname(HOSTNAME.orElse("localhost"));
        Servidor.setIp(HOSTNAME.orElse("localhost"));
        Servidor.setPort(PORT.orElse("8080"));
        tomcat.getHost().setAppBase(appBase);
        tomcat.addWebapp(contextPath, appBase);
        tomcat.start();
        tomcat.getServer().await();
    }
}