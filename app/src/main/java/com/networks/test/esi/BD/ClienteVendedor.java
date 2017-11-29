package com.networks.test.esi.BD;

/**
 * Created by ju on 29/11/17.
 * class ClienteVendedor
 */

public class ClienteVendedor {

    private final int id;
    private final String nome;
    private final String cnpj;
    private final String endereco;
    private final String telefone;

    ClienteVendedor(int id, String nome, String cnpj, String endereco, String telefone){
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    ClienteVendedor(String nome, String cnpj, String endereco, String telefone){
        id = 0;
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }
}
