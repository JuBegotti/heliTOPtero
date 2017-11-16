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

    private static final String DELETA_TABELA_USUARIO =
            "DROP TABLE IF EXISTS " + BDTabelas.TabelaUsuario.USUARIO;

    private static final String DELETA_TABELA_HELICOPTERO =
            "DROP TABLE IF EXISTS " + BDTabelas.TabelaHelicoptero.HELICOPTERO;

    public BD(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL(CRIA_TABELA_USUARIO);
        bd.execSQL(CRIA_TABELA_HELICOPTERO);

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
        onCreate(bd);
    }
}
