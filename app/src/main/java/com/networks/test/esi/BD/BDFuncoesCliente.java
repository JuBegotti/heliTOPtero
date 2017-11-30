package com.networks.test.esi.BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ju on 29/11/17.
 * class BDFuncoesCliente
 */

public class BDFuncoesCliente {

    public static void addCliente(Context context, Cliente cliente){
        BD bd = new BD(context);
        SQLiteDatabase sqLiteDatabase = bd.getWritableDatabase();

        ContentValues initialValues = new ContentValues();
        initialValues.put(BDTabelas.TabelaCliente._NOME, cliente.getNome());
        initialValues.put(BDTabelas.TabelaCliente._CPF_CNPJ, cliente.getCpfCnpj());
        initialValues.put(BDTabelas.TabelaCliente._ENDERECO, cliente.getEndereco());
        initialValues.put(BDTabelas.TabelaCliente._TELEFONE, cliente.getTelefone());
        sqLiteDatabase.insert(BDTabelas.TabelaCliente.CLIENTE, null, initialValues);

        bd.close();
        sqLiteDatabase.close();
    }

    public static List<Cliente> listaCliente(Context context){
        List<Cliente> clienteCompradores = null;

        BD bd = new BD(context);
        SQLiteDatabase sqLiteDatabase = bd.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(
                "SELECT * FROM "+ BDTabelas.TabelaCliente.CLIENTE, null);

        if(cursor.getCount()>0){
            cursor.moveToFirst();
            clienteCompradores = new ArrayList<>();
            do {
                Cliente cliente = new Cliente(
                        cursor.getInt(cursor.getColumnIndexOrThrow(BDTabelas.TabelaCliente._ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaCliente._NOME)),
                        cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaCliente._CPF_CNPJ)),
                        cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaCliente._ENDERECO)),
                        cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaCliente._TELEFONE)));
                clienteCompradores.add(cliente);
            } while (cursor.moveToNext());
            cursor.close();
        }
        bd.close();
        sqLiteDatabase.close();
        return clienteCompradores;
    }

    public static Cliente buscaCliente(Context context, String nome){
        Cliente cliente = null;

        BD bd = new BD(context);
        SQLiteDatabase sqLiteDatabase = bd.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(
                "SELECT * FROM "+ BDTabelas.TabelaCliente.CLIENTE + " WHERE "+ BDTabelas.TabelaCliente._NOME + " = '" + nome + "'", null);

        if(cursor.getCount()>0){
            cursor.moveToFirst();
            cliente = new Cliente(
                    cursor.getInt(cursor.getColumnIndexOrThrow(BDTabelas.TabelaCliente._ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaCliente._NOME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaCliente._CPF_CNPJ)),
                    cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaCliente._ENDERECO)),
                    cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaCliente._TELEFONE)));
            cursor.close();
        }
        bd.close();
        sqLiteDatabase.close();
        return cliente;
    }

}
