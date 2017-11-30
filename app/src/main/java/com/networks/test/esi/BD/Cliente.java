package com.networks.test.esi.BD;

/**
 * Created by ju on 29/11/17.
 * class Cliente
 */

public class Cliente {

    private final int id;
    private final String nome;
    private final String cpfCnpj;
    private final String endereco;
    private final String telefone;

    Cliente(int id,String nome, String cpfCnpj, String endereco, String telefone){
        this.id = id;
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public Cliente(String nome, String cpfCnpj, String endereco, String telefone){
        id = 0;
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

}
