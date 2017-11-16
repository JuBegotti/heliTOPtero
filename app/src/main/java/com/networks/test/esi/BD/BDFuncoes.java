package com.networks.test.esi.BD;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import com.networks.test.esi.R;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by ju on 13/11/17.
 * class BDFuncoes
 */

class BDFuncoes {

    static void carregaTabelaHelinhos(SQLiteDatabase bd, Context context) throws IOException {
        final Resources resources = context.getResources();
        InputStream inHelinho = resources.openRawResource(R.raw.helinhos);
        BufferedReader readerHelinho = new BufferedReader(new InputStreamReader(inHelinho));
        String line;
        while ((line = readerHelinho.readLine()) != null) {
            String[] RowData = line.split(",");
            String nome = RowData[0];
            String fabricante = RowData[1];
            String preco = RowData[2];
            String capacidade = RowData[3];
            String velocidade = RowData[4];
            String aceleracao = RowData[5];
            String controle = RowData[6];
            String frenagem = RowData[7];
            ContentValues initialValues = new ContentValues();
            initialValues.put(BDTabelas.TabelaHelicoptero._NOME, nome);
            initialValues.put(BDTabelas.TabelaHelicoptero._FABRICANTE, fabricante);
            initialValues.put(BDTabelas.TabelaHelicoptero._PRECO_COMPRA, Float.parseFloat(preco));
            initialValues.put(BDTabelas.TabelaHelicoptero._CAPACIDADE, Integer.parseInt(capacidade));
            initialValues.put(BDTabelas.TabelaHelicoptero._VELOCIDADE, Float.parseFloat(velocidade));
            initialValues.put(BDTabelas.TabelaHelicoptero._ACELERACAO, Float.parseFloat(aceleracao));
            initialValues.put(BDTabelas.TabelaHelicoptero._CONTROLE, Float.parseFloat(controle));
            initialValues.put(BDTabelas.TabelaHelicoptero._FRENAGEM, Float.parseFloat(frenagem));
            bd.insert(BDTabelas.TabelaHelicoptero.HELICOPTERO, null, initialValues);
        }
        inHelinho.close();
        readerHelinho.close();
    }

    static void carregaTabelaUsuario(SQLiteDatabase bd, Context context) throws IOException {
        final Resources resources = context.getResources();
        InputStream inUsuario = resources.openRawResource(R.raw.usuarios);
        BufferedReader readerUsuario = new BufferedReader(new InputStreamReader(inUsuario));
        String line;
        while ((line = readerUsuario.readLine()) != null) {
            String[] RowData = line.split(",");
            String nome = RowData[0];
            String sobrenome = RowData[1];
            String funcao = RowData[2];
            String email = RowData[3];
            String senha = RowData[4];
            String nascimento = RowData[5];
            String endereco = RowData[6];
            String localizacao = RowData[7];
            ContentValues initialValues = new ContentValues();
            initialValues.put(BDTabelas.TabelaUsuario._NOME, nome);
            initialValues.put(BDTabelas.TabelaUsuario._SOBRENOME, sobrenome);
            initialValues.put(BDTabelas.TabelaUsuario._FUNCAO, funcao);
            initialValues.put(BDTabelas.TabelaUsuario._EMAIL, email);
            initialValues.put(BDTabelas.TabelaUsuario._SENHA, senha);
            initialValues.put(BDTabelas.TabelaUsuario._DATA_NASCIMENTO, nascimento);
            initialValues.put(BDTabelas.TabelaUsuario._ENDERECO, endereco);
            initialValues.put(BDTabelas.TabelaUsuario._CEP_CIDADE_ESTADO, localizacao);
            bd.insert(BDTabelas.TabelaUsuario.USUARIO, null, initialValues);
        }
        inUsuario.close();
        readerUsuario.close();
    }
}
