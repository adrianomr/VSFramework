/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class MyClassLoader extends ClassLoader {

    public MyClassLoader(ClassLoader parent) {
        //parent.getResource("/");
        super(parent);
    }

    public Class loadClass(String name) throws ClassNotFoundException {

        return super.loadClass(name);

    }

}