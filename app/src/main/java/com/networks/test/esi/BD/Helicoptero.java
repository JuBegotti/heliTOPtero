package com.networks.test.esi.BD;

/**
 * Created by Peterson on 30/10/2017.
 * class Helicoptero
 */

public class Helicoptero {

    private final String nome;
    private final String fabricante;
    private final int capacidade;
    private final float velocidade;
    private final float aceleracao;
    private final float controle;
    private final float frenagem;
    private final float precoCompra;
    private final float precoVendaSugerido;
    private final int unidades;
    private final String foto;

    public Helicoptero(String nome, String fabricante, float precoCompra, int capacidade,
                       float velocidade, float aceleracao, float controle, float frenagem){
        this.nome = nome;
        this.fabricante = fabricante;
        this.precoCompra = precoCompra;
        this.capacidade = capacidade;
        this.velocidade = velocidade;
        this.aceleracao = aceleracao;
        this.controle = controle;
        this.frenagem = frenagem;
        unidades = 0;
        precoVendaSugerido = precoCompra +2000;
        foto = null;
    }

    Helicoptero(String nome, String fabricante, float precoCompra, int capacidade,
                float velocidade, float aceleracao, float controle, float frenagem, int unidades, String foto){
        this.nome = nome;
        this.fabricante = fabricante;
        this.precoCompra = precoCompra;
        this.capacidade = capacidade;
        this.velocidade = velocidade;
        this.aceleracao = aceleracao;
        this.controle = controle;
        this.frenagem = frenagem;
        this.unidades = unidades;
        precoVendaSugerido = precoCompra +2000;
        this.foto = foto;
    }

    public String getNome() {
        return nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public float getVelocidade() {
        return velocidade;
    }

    public float getAceleracao() {
        return aceleracao;
    }

    public float getControle() {
        return controle;
    }

    public float getFrenagem() {
        return frenagem;
    }

    public float getPrecoCompra() {
        return precoCompra;
    }

    public int getUnidades() {
        return unidades;
    }

    public float getPrecoVendaSugerido() {
        return precoVendaSugerido;
    }

    public String getFoto() {
        return foto;
    }
}
