package com.networks.test.esi.BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ju on 29/11/17.
 * class BDFuncoesClienteVendedor
 */

public class BDFuncoesClienteVendedor {

    public static void addClienteVendedor(Context context, ClienteVendedor clienteComprador){
        BD bd = new BD(context);
        SQLiteDatabase sqLiteDatabase = bd.getWritableDatabase();

        ContentValues initialValues = new ContentValues();
        initialValues.put(BDTabelas.TabelaClienteVendedor._NOME, clienteComprador.getNome());
        initialValues.put(BDTabelas.TabelaClienteVendedor._CNPJ, clienteComprador.getCnpj());
        initialValues.put(BDTabelas.TabelaClienteVendedor._ENDERECO, clienteComprador.getEndereco());
        initialValues.put(BDTabelas.TabelaClienteVendedor._TELEFONE, clienteComprador.getTelefone());
        sqLiteDatabase.insert(BDTabelas.TabelaClienteVendedor.CLIENTE_VENDEDOR, null, initialValues);

        bd.close();
        sqLiteDatabase.close();
    }

    public static List<ClienteVendedor> listaClienteVendedor(Context context){
        List<ClienteVendedor> clienteVendedores = null;

        BD bd = new BD(context);
        SQLiteDatabase sqLiteDatabase = bd.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(
                "SELECT * FROM "+ BDTabelas.TabelaClienteVendedor.CLIENTE_VENDEDOR, null);

        if(cursor.getCount()>0){
            cursor.moveToFirst();
            clienteVendedores = new ArrayList<>();
            do {
                ClienteVendedor clienteVendedor = new ClienteVendedor(
                        cursor.getInt(cursor.getColumnIndexOrThrow(BDTabelas.TabelaClienteVendedor._ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaClienteVendedor._NOME)),
                        cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaClienteVendedor._CNPJ)),
                        cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaClienteVendedor._ENDERECO)),
                        cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaClienteVendedor._TELEFONE)));
                clienteVendedores.add(clienteVendedor);
            } while (cursor.moveToNext());
            cursor.close();
        }
        bd.close();
        sqLiteDatabase.close();
        return clienteVendedores;
    }

    public static ClienteVendedor buscaClienteVendedor(Context context, String nome){
        ClienteVendedor clienteVendedor = null;

        BD bd = new BD(context);
        SQLiteDatabase sqLiteDatabase = bd.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(
                "SELECT * FROM "+ BDTabelas.TabelaClienteVendedor.CLIENTE_VENDEDOR + " WHERE "+ BDTabelas.TabelaClienteVendedor._NOME + " = " + nome, null);

        if(cursor.getCount()>0){
            cursor.moveToFirst();
            clienteVendedor = new ClienteVendedor(
                    cursor.getInt(cursor.getColumnIndexOrThrow(BDTabelas.TabelaClienteVendedor._ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaClienteVendedor._NOME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaClienteVendedor._CNPJ)),
                    cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaClienteVendedor._ENDERECO)),
                    cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaClienteVendedor._TELEFONE)));
            cursor.close();
        }
        bd.close();
        sqLiteDatabase.close();
        return clienteVendedor;
    }
}
