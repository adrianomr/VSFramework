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
public class ParseHeader implements IParser{ 

    public ParseHeader() {
    }
    
    
    public PythonBuilder getParseHeader(){
        return new PythonBuilder();
    }

    @Override
    public PythonBuilder executeParser(PythonBuilder pythonBuilder) {
        pythonBuilder.addLinha("#!/usr/bin/python\r\n" + 
            "# -*- coding: utf-8 -*-\r\n" +
            "import subprocess\r\n" +
            "from subprocess import Popen\r\n" + "import os\r\n" +
            "import shlex\r\n" +
            "import time\nimport os\nfrom os import listdir\n"
            + "from os.path import isfile, join\nfrom random import randint\n");
        return pythonBuilder;
    }
}
