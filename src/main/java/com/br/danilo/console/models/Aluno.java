package com.br.danilo.console.models;

import java.util.List;

import com.br.danilo.console.interfaces.IEntidade;
import com.br.danilo.console.interfaces.IPersistencia;

public class Aluno implements IEntidade{
    
    private String nome;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    private List<Float> notas;
    public List<Float> getNotas() {
        return notas;
    }
    public void setNotas(List<Float> notas) {
        this.notas = notas;
    }

    public String situacao(){
        var media = this.media();
        if(media < 5) return "Reprovado";
        else if(media >=5 && media < 7) return "Recuperação";
        else return "Aprovado";
    }

    public float media(){
        float mediaCalculada = (float) 0.0;

        if(this.notas != null){
            for (Float nota : this.notas) {
                mediaCalculada += nota;
            }

            mediaCalculada = mediaCalculada / this.notas.size();
        }

        return mediaCalculada;
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
