/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import interfaces.IParser;

/**
 *
 * @author adriano
 */
public class ParserLiganteProteina implements IParser{
    String texto = "ParserLiganteProteina";
    
    @Override
    public PythonBuilder executeParser(PythonBuilder pythonBuilder) {
//        String textoAux = texto;
        return new PythonBuilder();
    }
    
}
