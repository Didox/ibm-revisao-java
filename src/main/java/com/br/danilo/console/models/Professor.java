package com.br.danilo.console.models;

import java.util.List;

import com.br.danilo.console.interfaces.IEntidade;
import com.br.danilo.console.interfaces.IPersistencia;

public class Professor implements IEntidade{
    
    private String nome;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void salvar(IPersistencia persistencia) {
        persistencia.salvar(this);
    }

    public static List<IEntidade> all(IPersistencia persistencia){
        return persistencia.todos();
    }

    @Override    
    public String toString() {    
        return this.nome;    
    }  

}
