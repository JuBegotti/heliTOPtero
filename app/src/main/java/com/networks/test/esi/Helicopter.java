package com.networks.test.esi;

/**
 * Created by Peterson on 30/10/2017.
 */

class Helicopter {

    private int id;
    private String nome;
    private String fabricante;
    private int capacidade;
    private float velocidade;
    private float aceleracao;
    private float controle;
    private float frenagem;
    private float media;
    private float preco_compra;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    float getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(float velocidade) {
        this.velocidade = velocidade;
    }

    float getAceleracao() {
        return aceleracao;
    }

    public void setAceleracao(float aceleracao) {
        this.aceleracao = aceleracao;
    }

    float getControle() {
        return controle;
    }

    public void setControle(float controle) {
        this.controle = controle;
    }

    float getFrenagem() {
        return frenagem;
    }

    public void setFrenagem(float frenagem) {
        this.frenagem = frenagem;
    }

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }

    float getPreco_compra() {
        return preco_compra;
    }

    public void setPreco_compra(float preco_compra) {
        this.preco_compra = preco_compra;
    }
}
