package com.networks.test.esi.BD;

import android.provider.BaseColumns;

import java.util.Calendar;

/**
 * Created by Peterson on 30/10/2017.
 * class BDTabelas
 */

public class BDTabelas {

    private BDTabelas(){}

    static class TabelaUsuario implements BaseColumns {

        static final String USUARIO = "usuario";

        static final String _NOME = "nome";
        static final String _SOBRENOME = "sobrenome";
        static final String _FUNCAO = "funcao";
        static final String _DATA_NASCIMENTO = "data_nascimento";
        static final String _ENDERECO = "endereco";
        static final String _CEP_CIDADE_ESTADO = "cep_cidade_estado";
        static final String _EMAIL = "email";
        static final String _SENHA = "senha";
    }

    static class TabelaHelicoptero implements BaseColumns {

        static final String HELICOPTERO = "helicoptero";

        static final String _NOME = "nome";
        static final String _FABRICANTE = "fabricante";
        static final String _ESTOQUE = "estoque";
        static final String _PRECO_COMPRA = "preco_compra";
        static final String _PRECO_VENDA = "preco_venda";
        static final String _CAPACIDADE = "capacidade";
        static final String _VELOCIDADE = "_velocidade";
        static final String _ACELERACAO = "aceleracao";
        static final String _CONTROLE = "controle";
        static final String _FRENAGEM = "frenagem";
        static final String _FOTO = "foto";
    }

    static class TabelaTransacoes implements BaseColumns {

        static final String TRANSACOES = "transacoes";

        static final String _NOME_HELINHO = "nome_helinho";
        static final String _NOME_FABRICANTE = "nome_fabricante";
        static final String _COMPRA_VENDA = "compra_venda";
        static final String _DATA = "data";
        static final String _CLIENTE = "cliente";
        static final String _FUNCIONARIO = "funcionario";
        static final String _QUANTIDADE = "quantidade";
        static final String _PRECO = "preco";
    }

    static class TabelaCliente implements BaseColumns {

        static final String CLIENTE = "cliente";

        static final String _COMPRADOR_VENDEDOR = "comprador_vendedor";
        static final String _NOME = "nome";
        static final String _CPF_CNPJ = "cpf_cnpj";
        static final String _ENDERECO = "endereco";
        static final String _TELEFONE = "telefone";
    }

}
