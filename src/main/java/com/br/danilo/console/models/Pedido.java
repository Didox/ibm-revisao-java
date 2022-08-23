package com.br.danilo.console.models;

import java.util.List;

public class Pedido {
    private Cliente cliente;
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    private List<Produto> produtos;
    public List<Produto> getProdutos() {
        return produtos;
    }
    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public float valorTotal(){
        float valor = 0;

        if(this.produtos != null){
            for (Produto produto : this.produtos) {
                valor += produto.getValor();
            }
        }

        return valor;
    }
}
