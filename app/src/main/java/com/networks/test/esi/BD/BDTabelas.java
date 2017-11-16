package com.networks.test.esi.BD;

import android.provider.BaseColumns;

/**
 * Created by Peterson on 30/10/2017.
 * class BDTabelas
 */

public class BDTabelas {

    private BDTabelas(){}

    public static class TabelaUsuario implements BaseColumns {

        static final String USUARIO = "usuario";

        public static final String _NOME = "nome";
        public static final String _SOBRENOME = "sobrenome";
        public static final String _FUNCAO = "funcao";
        public static final String _DATA_NASCIMENTO = "data_nascimento";
        public static final String _ENDERECO = "endereco";
        public static final String _CEP_CIDADE_ESTADO = "cep_cidade_estado";
        public static final String _EMAIL = "email";
        static final String _SENHA = "senha";
    }

    public static class TabelaHelicoptero implements BaseColumns {

        static final String HELICOPTERO = "helicoptero";

        public static final String _NOME = "nome";
        public static final String _FABRICANTE = "fabricante";
        public static final String _ESTOQUE = "estoque";
        public static final String _PRECO_COMPRA = "preco_compra";
        public static final String _PRECO_VENDA = "preco_venda";
        public static final String _CAPACIDADE = "capacidade";
        public static final String _VELOCIDADE = "_velocidade";
        public static final String _ACELERACAO = "aceleracao";
        public static final String _CONTROLE = "controle";
        public static final String _FRENAGEM = "frenagem";
        public static final String _FOTO = "foto";
    }

}
