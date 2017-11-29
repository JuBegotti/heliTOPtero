package com.networks.test.esi.BD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.IOException;

/**
 * Created by Peterson on 16/9/2017.
 * BD extends SQLiteOpenHelper
 */

public class BD extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "HeliTOPtero_BD.db";
    private Context context;

    private static final String CRIA_TABELA_USUARIO =
            "CREATE TABLE " + BDTabelas.TabelaUsuario.USUARIO + " (" +
                    BDTabelas.TabelaUsuario._ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                    BDTabelas.TabelaUsuario._NOME + " TEXT, " +
                    BDTabelas.TabelaUsuario._SOBRENOME + " TEXT, " +
                    BDTabelas.TabelaUsuario._FUNCAO + " TEXT, " +
                    BDTabelas.TabelaUsuario._DATA_NASCIMENTO + " TEXT, " +
                    BDTabelas.TabelaUsuario._ENDERECO + " TEXT, " +
                    BDTabelas.TabelaUsuario._CEP_CIDADE_ESTADO + " TEXT, " +
                    BDTabelas.TabelaUsuario._EMAIL + " TEXT, " +
                    BDTabelas.TabelaUsuario._SENHA + " TEXT " +
                    " )";

    private static final String CRIA_TABELA_HELICOPTERO =
            "CREATE TABLE " + BDTabelas.TabelaHelicoptero.HELICOPTERO + " (" +
                    BDTabelas.TabelaHelicoptero._ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                    BDTabelas.TabelaHelicoptero._NOME + " TEXT, " +
                    BDTabelas.TabelaHelicoptero._FABRICANTE + " TEXT, " +
                    BDTabelas.TabelaHelicoptero._ESTOQUE + " INTEGER, " +
                    BDTabelas.TabelaHelicoptero._PRECO_COMPRA + " FLOAT, " +
                    BDTabelas.TabelaHelicoptero._PRECO_VENDA + " FLOAT, " +
                    BDTabelas.TabelaHelicoptero._CAPACIDADE + " INTEGER, " +
                    BDTabelas.TabelaHelicoptero._VELOCIDADE + " FLOAT, " +
                    BDTabelas.TabelaHelicoptero._ACELERACAO + " FLOAT, " +
                    BDTabelas.TabelaHelicoptero._CONTROLE + " FLOAT, " +
                    BDTabelas.TabelaHelicoptero._FRENAGEM + " FLOAT, " +
                    BDTabelas.TabelaHelicoptero._FOTO + " TEXT " +
                    " )";

    private static final String CRIA_TABELA_TRANSACOES =
            "CREATE TABLE " + BDTabelas.TabelaTransacoes.TRANSACOES + " (" +
                    BDTabelas.TabelaTransacoes._ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                    BDTabelas.TabelaTransacoes._COMPRA_VENDA + " INTEGER, " +
                    BDTabelas.TabelaTransacoes._DATA + " DATE, " +
                    BDTabelas.TabelaTransacoes._CLIENTE + " TEXT, " +
                    BDTabelas.TabelaTransacoes._FUNCIONARIO + " TEXT, " +
                    BDTabelas.TabelaTransacoes._QUANTIDADE + " INTEGER, " +
                    BDTabelas.TabelaTransacoes._PRECO + " FLOAT " +
                    " )";

    private static final String CRIA_TABELA_CLIENTE_COMPRADOR =
            "CREATE TABLE " + BDTabelas.TabelaClienteComprador.CLIENTE_COMPRADOR + " (" +
                    BDTabelas.TabelaClienteComprador._ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                    BDTabelas.TabelaClienteComprador._NOME + " TEXT, " +
                    BDTabelas.TabelaClienteComprador._CPF + " TEXT, " +
                    BDTabelas.TabelaClienteComprador._ENDERECO + " TEXT, " +
                    BDTabelas.TabelaClienteComprador._TELEFONE + " TEXT " +
                    " )";

    private static final String CRIA_TABELA_CLIENTE_VENDEDOR =
            "CREATE TABLE " + BDTabelas.TabelaClienteVendedor.CLIENTE_VENDEDOR + " (" +
                    BDTabelas.TabelaClienteVendedor._ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                    BDTabelas.TabelaClienteVendedor._NOME + " TEXT, " +
                    BDTabelas.TabelaClienteVendedor._CNPJ + " TEXT, " +
                    BDTabelas.TabelaClienteVendedor._ENDERECO + " TEXT, " +
                    BDTabelas.TabelaClienteVendedor._TELEFONE + " TEXT " +
                    " )";

    private static final String DELETA_TABELA_USUARIO =
            "DROP TABLE IF EXISTS " + BDTabelas.TabelaUsuario.USUARIO;

    private static final String DELETA_TABELA_HELICOPTERO =
            "DROP TABLE IF EXISTS " + BDTabelas.TabelaHelicoptero.HELICOPTERO;

    private static final String DELETA_TABELA_TRANSACOES =
            "DROP TABLE IF EXISTS " + BDTabelas.TabelaTransacoes.TRANSACOES;

    private static final String DELETA_TABELA_CLIENTE_COMPRADOR =
            "DROP TABLE IF EXISTS " + BDTabelas.TabelaClienteComprador.CLIENTE_COMPRADOR;

    private static final String DELETA_TABELA_CLIENTE_VENDEDOR =
            "DROP TABLE IF EXISTS " + BDTabelas.TabelaClienteVendedor.CLIENTE_VENDEDOR;

    public BD(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL(CRIA_TABELA_USUARIO);
        bd.execSQL(CRIA_TABELA_HELICOPTERO);
        bd.execSQL(CRIA_TABELA_TRANSACOES);
        bd.execSQL(CRIA_TABELA_CLIENTE_COMPRADOR);
        bd.execSQL(CRIA_TABELA_CLIENTE_VENDEDOR);

        try {
            BDFuncoes.carregaTabelaHelinhos(bd, context);
            BDFuncoes.carregaTabelaUsuario(bd,context);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int i, int i1) {
        bd.execSQL(DELETA_TABELA_USUARIO);
        bd.execSQL(DELETA_TABELA_HELICOPTERO);
        bd.execSQL(DELETA_TABELA_TRANSACOES);
        bd.execSQL(DELETA_TABELA_CLIENTE_COMPRADOR);
        bd.execSQL(DELETA_TABELA_CLIENTE_VENDEDOR);
        onCreate(bd);
    }
}
