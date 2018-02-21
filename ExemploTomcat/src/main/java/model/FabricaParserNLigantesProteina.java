/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import interfaces.IFabricaParser;
import interfaces.IParser;

/**
 *
 * @author adriano
 */
public class FabricaParserNLigantesProteina implements IFabricaParser{

    @Override
    public IParser criarParser() {
        return new ParserNLigantesProteina();
    }
    
}
