/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import interfaces.*;
import java.io.File;
import java.util.*;

/**
 *
 * @author Joaquim
 */
public class Reflection {

    ArrayList<String> classes;

    public ArrayList<String> getClasses() {
        
        //Package pack = (Package.getPackage("classes").get);
        this.classes = new ArrayList<String>();
        String caminho = System.getProperty("user.dir");

        File diretorio = new File(caminho + System.getProperty("file.separator")+"src"+System.getProperty("file.separator")+"model");
        String classes[] = diretorio.list();
        for (int x = 0; x < classes.length; x++) {
            classes[x] = classes[x].replace(".java", "").trim();
            //if(!"Personagem".equals(classes[x])&&!"Reflection".equals(classes[x])&&!"MyClassLoader".equals(classes[x]))
            System.out.println("Item " + x + ": " + classes[x]);
            this.classes.add(classes[x]);
        }
                
        return this.classes;

    }

    public IFabricaParser Instancia(String classe) throws ClassNotFoundException,
            IllegalAccessException,
            InstantiationException {
        //Package pack = (Package.getPackage("classes").get);
        //File diretorio = new File("C:\\Users\\Joaquim\\Dropbox\\SIPIIstrategy\\src\\itens");
        String caminho = System.getProperty("user.dir");

        File diretorio = new File(caminho + System.getProperty("file.separator")+"src"+System.getProperty("file.separator")+"model");
        String[] classes = diretorio.list();
        ClassLoader parentClassLoader = MyClassLoader.class.getClassLoader();
        MyClassLoader classLoader = new MyClassLoader(parentClassLoader);
        IFabricaParser item = null;
        for (int x = 0; x < classes.length; x++) {
            classes[x] = classes[x].replace(".java", "").trim();
            if (classes[x].equals(classe)) {
                System.out.println(classes[x]);
                Class itemclass = classLoader.loadClass("model."+classe);
                item =  (IFabricaParser) itemclass.newInstance();
            }
        }
        if (item != null) {
            System.out.println("Item criado");
            return item;
        } else {
            System.out.println("Item nao encontrado.");
        }
        return null;

    }
}
