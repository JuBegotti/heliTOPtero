package com.networks.test.esi.BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Peterson on 30/10/2017.
 * class BDFuncoesUsuario
 */

public class BDFuncoesUsuario {

    public static void addUsuario(Context context, Usuario usuario){
        BD bd = new BD(context);
        SQLiteDatabase sqLiteDatabase = bd.getWritableDatabase();

        ContentValues initialValues = new ContentValues();
        initialValues.put(BDTabelas.TabelaUsuario._NOME, usuario.getNome());
        initialValues.put(BDTabelas.TabelaUsuario._SOBRENOME, usuario.getSobrenome());
        initialValues.put(BDTabelas.TabelaUsuario._DATA_NASCIMENTO, usuario.getNascimento());
        initialValues.put(BDTabelas.TabelaUsuario._ENDERECO, usuario.getEndereco());
        initialValues.put(BDTabelas.TabelaUsuario._CEP_CIDADE_ESTADO, usuario.getCep_cidade_estado());
        initialValues.put(BDTabelas.TabelaUsuario._EMAIL, usuario.getEmail());
        initialValues.put(BDTabelas.TabelaUsuario._SENHA, usuario.getSenha());
        sqLiteDatabase.insert(BDTabelas.TabelaUsuario.USUARIO, null, initialValues);

        bd.close();
        sqLiteDatabase.close();
    }

    public static void updateUsuario(Context context, Usuario usuario){
        BD bd = new BD(context);
        SQLiteDatabase sqLiteDatabase = bd.getWritableDatabase();

        ContentValues initialValues = new ContentValues();
        initialValues.put(BDTabelas.TabelaUsuario._NOME, usuario.getNome());
        initialValues.put(BDTabelas.TabelaUsuario._SOBRENOME, usuario.getSobrenome());
        initialValues.put(BDTabelas.TabelaUsuario._DATA_NASCIMENTO, usuario.getNascimento());
        initialValues.put(BDTabelas.TabelaUsuario._ENDERECO, usuario.getEndereco());
        initialValues.put(BDTabelas.TabelaUsuario._CEP_CIDADE_ESTADO, usuario.getCep_cidade_estado());
        initialValues.put(BDTabelas.TabelaUsuario._EMAIL, usuario.getEmail());
        initialValues.put(BDTabelas.TabelaUsuario._SENHA, usuario.getSenha());

        sqLiteDatabase.update(BDTabelas.TabelaUsuario.USUARIO, initialValues, BDTabelas.TabelaUsuario._ID + " = ?",
                new String[]{String.valueOf(usuario.getId())});

        bd.close();
        sqLiteDatabase.close();
    }

    public static Usuario buscaUsuario(String email, Context context){
        BD bd = new BD(context);
        SQLiteDatabase sqLiteDatabase = bd.getReadableDatabase();

        Usuario usuario = null;
        Cursor cursor = sqLiteDatabase.rawQuery(
                "SELECT * FROM "+ BDTabelas.TabelaUsuario.USUARIO +
                        " WHERE " + BDTabelas.TabelaUsuario._EMAIL + " = '" + email + "'", null);

        if(cursor.moveToFirst()){
            usuario = new Usuario(
                    cursor.getInt(cursor.getColumnIndexOrThrow(BDTabelas.TabelaUsuario._ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaUsuario._NOME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaUsuario._SOBRENOME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaUsuario._FUNCAO)),
                    cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaUsuario._DATA_NASCIMENTO)),
                    cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaUsuario._ENDERECO)),
                    cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaUsuario._CEP_CIDADE_ESTADO)),
                    cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaUsuario._EMAIL)),
                    cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaUsuario._SENHA)));
        }

        cursor.close();
        sqLiteDatabase.close();
        bd.close();

        return usuario;
    }

    public static boolean checarUsuarioEmail(String email, Context context){
        BD bd = new BD(context);
        SQLiteDatabase sqLiteDatabase = bd.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(
                "SELECT * FROM "+ BDTabelas.TabelaUsuario.USUARIO +
                        " WHERE " + BDTabelas.TabelaUsuario._EMAIL + " = '" + email + "'", null);

        if(cursor.moveToFirst()) return true;

        cursor.close();
        sqLiteDatabase.close();
        bd.close();

        return false;
    }

    public static boolean checarUsuarioEmailSenha(String email, String senha, Context context){
        BD bd = new BD(context);
        SQLiteDatabase sqLiteDatabase = bd.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(
                "SELECT * FROM "+ BDTabelas.TabelaUsuario.USUARIO +
                        " WHERE " + BDTabelas.TabelaUsuario._EMAIL + " = '" + email + "'" +
                " AND " + BDTabelas.TabelaUsuario._SENHA + " = '" + senha + "'", null);

        if(cursor.moveToFirst()) return true;

        cursor.close();
        sqLiteDatabase.close();
        bd.close();

        return false;
    }
}
