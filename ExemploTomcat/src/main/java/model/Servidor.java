/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author adriano
 */
public class Servidor {
    private static String ip = "localhost";
    private static String port = "8080";

    public static String getIp() {
        return ip;
    }

    public static void setIp(String ip) {
        Servidor.ip = ip;
    }

    public static String getPort() {
        return port;
    }

    public static void setPort(String port) {
        Servidor.port = port;
    }
    
    
}
