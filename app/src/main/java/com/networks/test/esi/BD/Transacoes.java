package com.networks.test.esi.BD;

import java.util.Calendar;

/**
 * Created by ju on 29/11/17.
 * class Transacoes
 */

public class Transacoes {

    private final int id;
    private final String nomeHelinho;
    private final String nomeFabricante;
    private final int compra_venda;
    private final String data;
    private final String cliente;
    private final String funcionario;
    private final int quantidade;
    private final Float preco;

    Transacoes(int id, String nomeHelinho, String nomeFabricante, int compra_venda, String data,
               String cliente, String funcionario, int quantidade, float preco){
        this.id = id;
        this.nomeHelinho = nomeHelinho;
        this.nomeFabricante = nomeFabricante;
        this.compra_venda = compra_venda;
        this.data = data;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Transacoes(String nomeHelinho, String nomeFabricante, int compra_venda, String data,
                      String cliente, String funcionario, int quantidade, float preco){
        this.nomeHelinho = nomeHelinho;
        this.nomeFabricante = nomeFabricante;
        id = 0;
        this.compra_venda = compra_venda;
        this.data = data;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public String getData() {
        return data;
    }

    public String getCliente() {
        return cliente;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public float getPreco() {
        return preco;
    }

    public int getCompra_venda() {
        return compra_venda;
    }

    public int getId() {
        return id;
    }

    public String getNomeHelinho() {
        return nomeHelinho;
    }

    public String getNomeFabricante() {
        return nomeFabricante;
    }
}
