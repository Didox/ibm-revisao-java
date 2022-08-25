package com.br.danilo.console.servicos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.br.danilo.console.interfaces.IEntidade;
import com.br.danilo.console.interfaces.IPersistencia;

public class PersistenciaCSV implements IPersistencia{

    public PersistenciaCSV(IEntidade entidade){
        this.entidade = entidade;
    }

    private IEntidade entidade;

    @Override
    public void salvar(IEntidade entidade) {
        try {
            FileWriter myWriter = new FileWriter(this.entidade.getClass().getName() + ".csv");
            var lista = this.todos();
            lista.add(entidade);

            String csv = "";
            for (IEntidade iEntidade : lista) {
                csv += iEntidade.getNome() + ";\n";
            }
            myWriter.write(csv);
            myWriter.close();
        } 
        catch (IOException e) { }
        
    }

    @Override
    public List<IEntidade> todos() {
        var lista = new ArrayList<IEntidade>();

        try {
            File myObj = new File( this.entidade.getClass().getName() + ".csv");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                var ent = this.entidade;
                ent.setNome(myReader.nextLine());
                lista.add(ent);
            }
            myReader.close();

        } catch (FileNotFoundException e) {
        }

        return lista == null ? new ArrayList<IEntidade>() : lista;
    }

    @Override
    public IEntidade getEntidade() {
        return this.entidade;
    }
    
}
