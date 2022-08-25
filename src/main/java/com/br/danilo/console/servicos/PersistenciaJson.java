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
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class PersistenciaJson implements IPersistencia{

    public PersistenciaJson(IEntidade entidade){
        this.entidade = entidade;
    }

    private IEntidade entidade;

    @Override
    public void salvar(IEntidade entidade) {
        try {
            FileWriter myWriter = new FileWriter(this.entidade.getClass().getName() + ".json");
            var lista = this.todos();
            lista.add(entidade);
            String entidadesJson = new Gson().toJson(lista);
            myWriter.write(entidadesJson);
            myWriter.close();
        } 
        catch (IOException e) { }
        
    }

    @Override
    public List<IEntidade> todos() {
        var lista = new ArrayList<IEntidade>();

        try {
            File myObj = new File( this.entidade.getClass().getName() + ".json");
            Scanner myReader = new Scanner(myObj);
            String entidadesJson = "";
            while (myReader.hasNextLine()) {
                entidadesJson += myReader.nextLine();
            }
            myReader.close();

            lista = new Gson().fromJson(entidadesJson,  new TypeToken<List<IEntidade>>(){}.getType());
        } catch (FileNotFoundException e) {
        }

        return lista == null ? new ArrayList<IEntidade>() : lista;
    }

    @Override
    public IEntidade getEntidade() {
        return this.entidade;
    }
    
}
