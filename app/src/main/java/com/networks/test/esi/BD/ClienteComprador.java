package com.networks.test.esi.BD;

/**
 * Created by ju on 29/11/17.
 * class ClienteComprador
 */

public class ClienteComprador {

    private final int id;
    private final String nome;
    private final String cpf;
    private final String endereco;
    private final String telefone;

    ClienteComprador(int id, String nome, String cpf, String endereco, String telefone){
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    ClienteComprador(String nome, String cpf, String endereco, String telefone){
        id = 0;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }
}
