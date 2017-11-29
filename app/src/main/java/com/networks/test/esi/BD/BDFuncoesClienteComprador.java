package com.networks.test.esi.BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ju on 29/11/17.
 * class BDFuncoesClienteComprador
 */

public class BDFuncoesClienteComprador {

    public static void addClienteComprador(Context context, ClienteComprador clienteComprador){
        BD bd = new BD(context);
        SQLiteDatabase sqLiteDatabase = bd.getWritableDatabase();

        ContentValues initialValues = new ContentValues();
        initialValues.put(BDTabelas.TabelaClienteComprador._NOME, clienteComprador.getNome());
        initialValues.put(BDTabelas.TabelaClienteComprador._CPF, clienteComprador.getCpf());
        initialValues.put(BDTabelas.TabelaClienteComprador._ENDERECO, clienteComprador.getEndereco());
        initialValues.put(BDTabelas.TabelaClienteComprador._TELEFONE, clienteComprador.getTelefone());
        sqLiteDatabase.insert(BDTabelas.TabelaClienteComprador.CLIENTE_COMPRADOR, null, initialValues);

        bd.close();
        sqLiteDatabase.close();
    }

    public static List<ClienteComprador> listaClienteComprador(Context context){
        List<ClienteComprador> clienteCompradores = null;

        BD bd = new BD(context);
        SQLiteDatabase sqLiteDatabase = bd.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(
                "SELECT * FROM "+ BDTabelas.TabelaClienteComprador.CLIENTE_COMPRADOR, null);

        if(cursor.getCount()>0){
            cursor.moveToFirst();
            clienteCompradores = new ArrayList<>();
            do {
                ClienteComprador clienteComprador = new ClienteComprador(
                        cursor.getInt(cursor.getColumnIndexOrThrow(BDTabelas.TabelaClienteComprador._ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaClienteComprador._NOME)),
                        cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaClienteComprador._CPF)),
                        cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaClienteComprador._ENDERECO)),
                        cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaClienteComprador._TELEFONE)));
                clienteCompradores.add(clienteComprador);
            } while (cursor.moveToNext());
            cursor.close();
        }
        bd.close();
        sqLiteDatabase.close();
        return clienteCompradores;
    }

    public static ClienteComprador buscaClienteComprador(Context context, String nome){
        ClienteComprador clienteComprador = null;

        BD bd = new BD(context);
        SQLiteDatabase sqLiteDatabase = bd.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(
                "SELECT * FROM "+ BDTabelas.TabelaClienteComprador.CLIENTE_COMPRADOR + " WHERE "+ BDTabelas.TabelaClienteComprador._NOME + " = " + nome, null);

        if(cursor.getCount()>0){
            cursor.moveToFirst();
            clienteComprador = new ClienteComprador(
                    cursor.getInt(cursor.getColumnIndexOrThrow(BDTabelas.TabelaClienteComprador._ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaClienteComprador._NOME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaClienteComprador._CPF)),
                    cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaClienteComprador._ENDERECO)),
                    cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaClienteComprador._TELEFONE)));
            cursor.close();
        }
        bd.close();
        sqLiteDatabase.close();
        return clienteComprador;
    }

}
