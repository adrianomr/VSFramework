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
public class ParserCreateConf extends Parser implements IParser{

    public ParserCreateConf(VirtualScrenning virtualScrenning) {
        super(virtualScrenning);
    }

    public PythonBuilder getCriaConf() {
        String q = "\"";
        String qlinha = "\\n";
        if(getVirtualScrenning().getNumberOfTimesToRepeat()>0){
            getPythonBuilder().addLinha("seed_rand = 0");
            getPythonBuilder().addLinha("seed_rand = randint(111111111,999999999)");
            getPythonBuilder().addLinha("seed_randomic = " + q + "" + q + "");
            getPythonBuilder().addLinha("seed_randomic = str(seed_rand)");
            getPythonBuilder().addLinha("first_dig = 0");
            getPythonBuilder().addLinha("first_dig = 1");
            getPythonBuilder().addLinha("first_digit = " + q + "" + q + "");
            getPythonBuilder().addLinha("first_digit = str(first_dig)");
            getPythonBuilder().addLinha("seed_randomic = first_digit + seed_randomic");
            getPythonBuilder().addLinha("seed_randomic_final=" + q + "" + q + "");
            getPythonBuilder().addLinha("seed_randomic_final = " + q + "seed = " + q + " + seed_randomic + " + q + "" + qlinha + "" + q + "");
        }
        getPythonBuilder().addLinha("\n#Creation of file conf.txt (it is necessary to AutoDock "
                + "Vina run)");
        getPythonBuilder().addLinha("lista = [receptor+\"\\n\" , ligand +\"\\n\", "
                + getSeed()+" , \"out = out.pdb\\n\\n\" , "
                + "\"center_x =  " + getVirtualScrenning().getBox().getBoxCenter().getX()
                + " \\n\" , \"center_y = " + getVirtualScrenning().getBox().getBoxCenter().getY() + "\\n\" "
                + ", \"center_z = " + getVirtualScrenning().getBox().getBoxCenter().getZ() + "\\n\\n\","
                + "\"size_x = " + getVirtualScrenning().getBox().getBoxSize().getX() + "\\n\""
                + " , \"size_y = " + getVirtualScrenning().getBox().getBoxSize().getY() + " \\n\" ,"
                + " \"size_z = " + getVirtualScrenning().getBox().getBoxSize().getZ() + "\\n\\n\" ,"
                + " \"exhaustiveness = " + getVirtualScrenning().getExhaustiveness() + "\"]\n");
        return getPythonBuilder();
    }
    private String getSeed(){
        if(getVirtualScrenning().getNumberOfTimesToRepeat() > 0){
            return "seed_randomic_final";
        }
        return "\"seed = 1234567891\\n\"";
    }

    @Override
    public PythonBuilder executeParser(PythonBuilder pythonBuilder) {
        setPythonBuilder(pythonBuilder);
        return getCriaConf(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
