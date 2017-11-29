package com.networks.test.esi.BD;

/**
 * Created by Peterson on 30/10/2017.
 * class Usuario
 */

public class Usuario {

    private int id;
    private final String nome;
    private final String sobrenome;
    private final String nascimento;
    private final String endereco;
    private final String cep_cidade_estado;
    private final String email;
    private final String senha;
    private final String funcao;

    public Usuario(String nome, String sobrenome, String funcao, String nascimento, String endereco,
                   String cep_cidade_estado, String email, String senha){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.nascimento = nascimento;
        this.endereco = endereco;
        this.cep_cidade_estado = cep_cidade_estado;
        this.email = email;
        this.senha = senha;
        this.funcao = funcao;
    }

    Usuario(int id, String nome, String sobrenome, String funcao, String nascimento, String endereco,
            String cep_cidade_estado, String email, String senha){
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.nascimento = nascimento;
        this.endereco = endereco;
        this.cep_cidade_estado = cep_cidade_estado;
        this.email = email;
        this.senha = senha;
        this.funcao = funcao;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getNascimento(){
        return nascimento;
    }

    public String getEndereco(){
        return endereco;
    }

    public String getCep_cidade_estado(){
        return cep_cidade_estado;
    }

    public String getEmail() {
        return email;
    }

    String getSenha() {
        return senha;
    }

    public String getFuncao() {
        return funcao;
    }
}
