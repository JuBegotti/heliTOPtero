package com.networks.test.esi.BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by ju on 29/11/17.
 * class BDFuncoesVenda
 */

public class BDFuncoesTransacoes {

    public static void addTransacao(Context context, Transacoes transacoes){
        BD bd = new BD(context);
        SQLiteDatabase sqLiteDatabase = bd.getWritableDatabase();

        ContentValues initialValues = new ContentValues();
        initialValues.put(BDTabelas.TabelaTransacoes._COMPRA_VENDA, transacoes.getCompra_venda());
        initialValues.put(BDTabelas.TabelaTransacoes._DATA, transacoes.getData());
        initialValues.put(BDTabelas.TabelaTransacoes._CLIENTE, transacoes.getCliente());
        initialValues.put(BDTabelas.TabelaTransacoes._FUNCIONARIO, transacoes.getFuncionario());
        initialValues.put(BDTabelas.TabelaTransacoes._QUANTIDADE, transacoes.getQuantidade());
        initialValues.put(BDTabelas.TabelaTransacoes._PRECO, transacoes.getPreco());
        sqLiteDatabase.insert(BDTabelas.TabelaTransacoes.TRANSACOES, null, initialValues);

        bd.close();
        sqLiteDatabase.close();
    }

    public static List<Transacoes> listaTransacoes(Context context){
        List<Transacoes> transacoes = null;

        BD bd = new BD(context);
        SQLiteDatabase sqLiteDatabase = bd.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(
                "SELECT * FROM "+ BDTabelas.TabelaTransacoes.TRANSACOES, null);

        if(cursor.getCount()>0){
            cursor.moveToFirst();
            transacoes = new ArrayList<>();
            do {
                Transacoes transacao = new Transacoes(
                        cursor.getInt(cursor.getColumnIndexOrThrow(BDTabelas.TabelaTransacoes._ID)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(BDTabelas.TabelaTransacoes._COMPRA_VENDA)),
                        cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaTransacoes._DATA)),
                        cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaTransacoes._CLIENTE)),
                        cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaTransacoes._FUNCIONARIO)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(BDTabelas.TabelaTransacoes._QUANTIDADE)),
                        cursor.getFloat(cursor.getColumnIndexOrThrow(BDTabelas.TabelaTransacoes._PRECO)));
                transacoes.add(transacao);
            } while (cursor.moveToNext());
            cursor.close();
        }
        bd.close();
        sqLiteDatabase.close();
        return transacoes;
    }

    public static Transacoes buscaTransacoes(Context context, int id){
        Transacoes transacao = null;

        BD bd = new BD(context);
        SQLiteDatabase sqLiteDatabase = bd.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(
                "SELECT * FROM "+ BDTabelas.TabelaTransacoes.TRANSACOES + " WHERE "+ BDTabelas.TabelaTransacoes._ID + " = " + id, null);

        if(cursor.getCount()>0){
            cursor.moveToFirst();
                transacao = new Transacoes(
                    cursor.getInt(cursor.getColumnIndexOrThrow(BDTabelas.TabelaTransacoes._ID)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(BDTabelas.TabelaTransacoes._COMPRA_VENDA)),
                    cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaTransacoes._DATA)),
                    cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaTransacoes._CLIENTE)),
                    cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaTransacoes._FUNCIONARIO)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(BDTabelas.TabelaTransacoes._QUANTIDADE)),
                    cursor.getFloat(cursor.getColumnIndexOrThrow(BDTabelas.TabelaTransacoes._PRECO)));
            cursor.close();
        }
        bd.close();
        sqLiteDatabase.close();
        return transacao;
    }
}
