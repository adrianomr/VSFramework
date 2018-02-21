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
public class ParserBox extends Parser{


    private Box box;
    private String quotationMarks;
    private String path;
    private String newLine;
    private String makeDirCommand;
    private ParserFileName fileNameParser;
    private ExecuteVinaParser executeVinaParser;
    private boolean hasBoxVariation;

    public ParserBox(VirtualScrenning virtualScrenning) {
        super(virtualScrenning);
        this.box = virtualScrenning.getBox();
        this.quotationMarks = "\"";
        this.path = getVirtualScrenning().getPath();
        this.newLine = "\n";
        this.makeDirCommand = getVirtualScrenning().getOperationalSystem().getMakeDirCommand();
        this.fileNameParser = new ParserFileName(virtualScrenning);
        this.executeVinaParser = new ExecuteVinaParser(this.fileNameParser,virtualScrenning);
        hasBoxVariation = getVirtualScrenning().getBox().DoesXVariate()
                || getVirtualScrenning().getBox().DoesXVariate()
                || getVirtualScrenning().getBox().DoesXVariate();
    }

    public void getBoxHeader() {
        if (box.DoesXVariate()) {
            getPythonBuilder().addLinha("center_x_final = " + box.getBoxVariation().getEndCenter().getX());
            getPythonBuilder().addLinha("step_x = " + box.getBoxVariation().getxIncrement());
            getPythonBuilder().addLinha("auxiliar_x_final = center_x_final");
            getPythonBuilder().addLinha("auxiliar_inicio_x = center_x");
            getPythonBuilder().addLinha("lista_val_x = []");
        }
        if (box.DoesYVariate()) {
            getPythonBuilder().addLinha("center_y_final = " + box.getBoxVariation().getEndCenter().getY());
            getPythonBuilder().addLinha("step_y = " + box.getBoxVariation().getyIncrement());
            getPythonBuilder().addLinha("auxiliar_y_final = center_y_final");
            getPythonBuilder().addLinha("auxiliar_inicio_y = center_y");
            getPythonBuilder().addLinha("lista_val_y = []");
        }
        if (box.DoesZVariate()) {
            getPythonBuilder().addLinha("center_z_final = " + box.getBoxVariation().getEndCenter().getZ());
            getPythonBuilder().addLinha("step_z = " + box.getBoxVariation().getzIncrement());
            getPythonBuilder().addLinha("auxiliar_z_final = center_z_final");
            getPythonBuilder().addLinha("auxiliar_inicio_z = center_z");
            getPythonBuilder().addLinha("lista_val_z = []");
        }
    }

    public void getWhileX() {
        if (box.DoesXVariate()) {
            getPythonBuilder().addLinha("while(auxiliar_inicio_x <= auxiliar_x_final):");
            getPythonBuilder().addPythonIdentationBlock();
            getPythonBuilder().addLinha("lista_val_x.append(auxiliar_inicio_x)");
            getPythonBuilder().addLinha("print(auxiliar_inicio_x)");
            getPythonBuilder().addLinha("auxiliar_inicio_x = auxiliar_inicio_x + step_x\n");
            getPythonBuilder().removePythonIdentationBlock();
        }
    }

    public void getWhileY() {
        if (box.DoesYVariate()) {
            getPythonBuilder().addLinha("while(auxiliar_inicio_y <= auxiliar_y_final):");
            getPythonBuilder().addPythonIdentationBlock();
            getPythonBuilder().addLinha("lista_val_y.append(auxiliar_inicio_y)");
            getPythonBuilder().addLinha("print(auxiliar_inicio_y)");
            getPythonBuilder().addLinha("auxiliar_inicio_y = auxiliar_inicio_y + step_y\n");
            getPythonBuilder().removePythonIdentationBlock();
        }
    }

    public void getWhileZ() {
        if (box.DoesZVariate()) {
            getPythonBuilder().addLinha("while(auxiliar_inicio_z <= auxiliar_z_final):");;
            getPythonBuilder().addPythonIdentationBlock();
            getPythonBuilder().addLinha("lista_val_z.append(auxiliar_inicio_z)");
            getPythonBuilder().addLinha("print(auxiliar_inicio_z)");
            getPythonBuilder().addLinha("auxiliar_inicio_z = auxiliar_inicio_z + step_z\n");
            getPythonBuilder().removePythonIdentationBlock();
        }
    }

    public void escreveNoArquivoConf() {
        getPythonBuilder().addLinha("f = open(" + quotationMarks + "" + path  + "conf.txt"
                + quotationMarks + ", " + quotationMarks + "w" + quotationMarks + ")");
        getPythonBuilder().addLinha("for elem in lista_arquivo_2:");
        getPythonBuilder().addPythonIdentationBlock();
        getPythonBuilder().addLinha("f.write(" + quotationMarks + "%s" + quotationMarks + " % elem)");
        getPythonBuilder().removePythonIdentationBlock();
        getPythonBuilder().addLinha("f.close()");

    }

    public void printElementosCentro() {
        if (box.DoesXVariate()) {
            getPythonBuilder().addLinha("print (elem_x)");
        }
        if (box.DoesYVariate()) {
            getPythonBuilder().addLinha("print (elem_y)");
        }
        if (box.DoesZVariate()) {
            getPythonBuilder().addLinha("print (elem_z)");
        }
    }
    
    


    public void getForXYZ() {
        if (box.DoesXVariate()) {
            getPythonBuilder().addLinha("for elem_x in lista_val_x:");
            getPythonBuilder().addPythonIdentationBlock();
        }
        if (box.DoesYVariate()) {
            getPythonBuilder().addLinha("for elem_y in lista_val_y:");
            getPythonBuilder().addPythonIdentationBlock();
        }
        if (box.DoesZVariate()) {
            getPythonBuilder().addLinha("for elem_z in lista_val_z:");
            getPythonBuilder().addPythonIdentationBlock();
        }
        getConteudoForXYZ();
        if (box.DoesXVariate()) {
            getPythonBuilder().removePythonIdentationBlock();
        }
        if (box.DoesYVariate()) {
            getPythonBuilder().removePythonIdentationBlock();
        }
        if (box.DoesZVariate()) {
            getPythonBuilder().removePythonIdentationBlock();
        }
    }

    private void getConteudoForXYZ() {
//        getPythonBuilder().addLinha("string = " + quotationMarks + "center_y" + quotationMarks + "");
//        getPythonBuilder().addLinha("string_2 = " + quotationMarks + "center_z" + quotationMarks + "");
        
        if(hasBoxVariation){
            getPythonBuilder().addLinha("lista_arquivo = []");
            getPythonBuilder().addLinha("lista_arquivo_2 = []");
            getPythonBuilder().addLinha("lista_numero = []");
            getPythonBuilder().addLinha("lista_numero_2 = []");
            getPythonBuilder().addLinha("num =" + quotationMarks + "" + quotationMarks + "");
            getPythonBuilder().addLinha("num_2 =" + quotationMarks + "" + quotationMarks + " ");
            getPythonBuilder().addLinha("file = open(" + quotationMarks
                    + "" + path + "conf.txt" + quotationMarks + ", " + quotationMarks
                    + "r" + quotationMarks + ")");

            preencheListaCentros();
            escreveNoArquivoConf();
        }
        ParserCallVina parserCallVina = new ParserCallVina(getVirtualScrenning());
        parserCallVina.setPythonBuilder(getPythonBuilder());
        setPythonBuilder(parserCallVina.getParserCallVina());
    }

    private void preencheListaCentros() {

        getPythonBuilder().addLinha("for linha in file:");
        getPythonBuilder().addPythonIdentationBlock();
        getPythonBuilder().addLinha("lista_arquivo.append(linha)");
        getPythonBuilder().removePythonIdentationBlock();
        getPythonBuilder().addLinha("file.close()");
        getPythonBuilder().addLinha(""
                + "for elem in lista_arquivo:");
        getPythonBuilder().addPythonIdentationBlock();
        encontraCentroX();
        encontraCentroY();
        encontraCentroZ();
        getPythonBuilder().addLinha("lista_arquivo_2.append(elem)");
        getPythonBuilder().removePythonIdentationBlock();
        printElementosCentro();
    }

    private void encontraCentroX() {
        if (box.DoesXVariate()) {
            getPythonBuilder().addLinha("if(elem.find(" + quotationMarks + "center_x" + quotationMarks + ")!=-1):");
            getPythonBuilder().addPythonIdentationBlock();
            getPythonBuilder().addLinha("num = str(elem_x)");
            getPythonBuilder().addLinha("elem = " + quotationMarks + "center_x = " + quotationMarks + " + num");
            getPythonBuilder().removePythonIdentationBlock();
        }
    }

    private void encontraCentroY() {
        if (box.DoesYVariate()) {
            getPythonBuilder().addLinha("if(elem.find(" + quotationMarks + "center_y" + quotationMarks + ")!=-1):");
            getPythonBuilder().addPythonIdentationBlock();
            getPythonBuilder().addLinha("num = str(elem_y)");
            getPythonBuilder().addLinha("elem = " + quotationMarks + "center_y = " + quotationMarks + " + num");
            getPythonBuilder().removePythonIdentationBlock();
        }

    }

    private void encontraCentroZ() {
        if (box.DoesZVariate()) {
            getPythonBuilder().addLinha("if(elem.find(" + quotationMarks + "center_z" + quotationMarks + ")!=-1):");
            getPythonBuilder().addPythonIdentationBlock();
            getPythonBuilder().addLinha("num = str(elem_z)");
            getPythonBuilder().addLinha("elem = " + quotationMarks + "center_z = " + quotationMarks
                    + " + num");
            getPythonBuilder().removePythonIdentationBlock();
        }
    }
    
    public PythonBuilder getParserBox() {
        getBoxHeader();
        getWhileX();
        getWhileY();
        getWhileZ();
        getForXYZ();
//        getPythonBuilder().addLinha("number_of_times_to_exec = number_of_times_to_exec - 1");
//        getPythonBuilder().addLinha("number_of_times_executed = number_of_times_executed + 1");
        return getPythonBuilder();
    }

    @Override
    public PythonBuilder executeParser(PythonBuilder pythonBuilder) {
        super.executeParser(pythonBuilder);
        return getParserBox(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
