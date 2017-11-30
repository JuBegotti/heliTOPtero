package com.networks.test.esi.BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ju on 14/11/17.
 * class BDFuncoesHeli
 */

public class BDFuncoesHeli {

    public static void addHelinho(Context context, Helicoptero helinho){
        BD bd = new BD(context);
        SQLiteDatabase sqLiteDatabase = bd.getWritableDatabase();

        ContentValues initialValues = new ContentValues();
        initialValues.put(BDTabelas.TabelaHelicoptero._NOME, helinho.getNome());
        initialValues.put(BDTabelas.TabelaHelicoptero._FABRICANTE, helinho.getFabricante());
        initialValues.put(BDTabelas.TabelaHelicoptero._PRECO_COMPRA, helinho.getPrecoCompra());
        initialValues.put(BDTabelas.TabelaHelicoptero._CAPACIDADE, helinho.getCapacidade());
        initialValues.put(BDTabelas.TabelaHelicoptero._VELOCIDADE, helinho.getVelocidade());
        initialValues.put(BDTabelas.TabelaHelicoptero._ACELERACAO, helinho.getAceleracao());
        initialValues.put(BDTabelas.TabelaHelicoptero._CONTROLE, helinho.getControle());
        initialValues.put(BDTabelas.TabelaHelicoptero._FRENAGEM, helinho.getFrenagem());
        initialValues.put(BDTabelas.TabelaHelicoptero._FOTO, helinho.getFoto());
        sqLiteDatabase.insert(BDTabelas.TabelaHelicoptero.HELICOPTERO, null, initialValues);

        bd.close();
        sqLiteDatabase.close();
    }

    public static List<Helicoptero> listaHelinhos(Context context){
        List<Helicoptero> helinhos = null;
        BD bd = new BD(context);
        SQLiteDatabase sqLiteDatabase = bd.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(
                "SELECT * FROM "+ BDTabelas.TabelaHelicoptero.HELICOPTERO, null);

        if(cursor.getCount()>0){
            cursor.moveToFirst();
            helinhos = new ArrayList<>();
            do {
                Helicoptero helinho = new Helicoptero(
                        cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaHelicoptero._NOME)),
                        cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaHelicoptero._FABRICANTE)),
                        cursor.getFloat(cursor.getColumnIndexOrThrow(BDTabelas.TabelaHelicoptero._PRECO_COMPRA)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(BDTabelas.TabelaHelicoptero._CAPACIDADE)),
                        cursor.getFloat(cursor.getColumnIndexOrThrow(BDTabelas.TabelaHelicoptero._VELOCIDADE)),
                        cursor.getFloat(cursor.getColumnIndexOrThrow(BDTabelas.TabelaHelicoptero._ACELERACAO)),
                        cursor.getFloat(cursor.getColumnIndexOrThrow(BDTabelas.TabelaHelicoptero._CONTROLE)),
                        cursor.getFloat(cursor.getColumnIndexOrThrow(BDTabelas.TabelaHelicoptero._FRENAGEM)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(BDTabelas.TabelaHelicoptero._ESTOQUE)),
                        cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaHelicoptero._FOTO)));
                helinhos.add(helinho);
            } while (cursor.moveToNext());
            cursor.close();
        }
        bd.close();
        sqLiteDatabase.close();
        return helinhos;
    }

    public static Helicoptero buscaHelinhoNome(Context context, String nome){
        Helicoptero helinho = null;
        BD bd = new BD(context);
        SQLiteDatabase sqLiteDatabase = bd.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(
                "SELECT * FROM "+ BDTabelas.TabelaHelicoptero.HELICOPTERO +
                        " WHERE " + BDTabelas.TabelaHelicoptero._NOME + " = '" + nome + "'", null);

        if(cursor.moveToFirst()){
             helinho = new Helicoptero(
                     cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaHelicoptero._NOME)),
                     cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaHelicoptero._FABRICANTE)),
                     cursor.getFloat(cursor.getColumnIndexOrThrow(BDTabelas.TabelaHelicoptero._PRECO_COMPRA)),
                     cursor.getInt(cursor.getColumnIndexOrThrow(BDTabelas.TabelaHelicoptero._CAPACIDADE)),
                     cursor.getFloat(cursor.getColumnIndexOrThrow(BDTabelas.TabelaHelicoptero._VELOCIDADE)),
                     cursor.getFloat(cursor.getColumnIndexOrThrow(BDTabelas.TabelaHelicoptero._ACELERACAO)),
                     cursor.getFloat(cursor.getColumnIndexOrThrow(BDTabelas.TabelaHelicoptero._CONTROLE)),
                     cursor.getFloat(cursor.getColumnIndexOrThrow(BDTabelas.TabelaHelicoptero._FRENAGEM)),
                     cursor.getInt(cursor.getColumnIndexOrThrow(BDTabelas.TabelaHelicoptero._ESTOQUE)),
                     cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaHelicoptero._FOTO)));
            cursor.close();
        }
        bd.close();
        sqLiteDatabase.close();
        return helinho;
    }

    public static Helicoptero buscaHelinhoFabricante(Context context, String fabricante){
        Helicoptero helinho = null;
        BD bd = new BD(context);
        SQLiteDatabase sqLiteDatabase = bd.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(
                "SELECT * FROM "+ BDTabelas.TabelaHelicoptero.HELICOPTERO +
                        " WHERE " + BDTabelas.TabelaHelicoptero._FABRICANTE+ " = '" + fabricante + "'", null);

        if(cursor.moveToFirst()){
            helinho = new Helicoptero(
                    cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaHelicoptero._NOME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaHelicoptero._FABRICANTE)),
                    cursor.getFloat(cursor.getColumnIndexOrThrow(BDTabelas.TabelaHelicoptero._PRECO_COMPRA)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(BDTabelas.TabelaHelicoptero._CAPACIDADE)),
                    cursor.getFloat(cursor.getColumnIndexOrThrow(BDTabelas.TabelaHelicoptero._VELOCIDADE)),
                    cursor.getFloat(cursor.getColumnIndexOrThrow(BDTabelas.TabelaHelicoptero._ACELERACAO)),
                    cursor.getFloat(cursor.getColumnIndexOrThrow(BDTabelas.TabelaHelicoptero._CONTROLE)),
                    cursor.getFloat(cursor.getColumnIndexOrThrow(BDTabelas.TabelaHelicoptero._FRENAGEM)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(BDTabelas.TabelaHelicoptero._ESTOQUE)),
                    cursor.getString(cursor.getColumnIndexOrThrow(BDTabelas.TabelaHelicoptero._FOTO)));
            cursor.close();
        }
        bd.close();
        sqLiteDatabase.close();
        return helinho;
    }

    public static void updateHelinhoEstoque(Context context, Helicoptero helicoptero, int novaQt) {
        BD bd = new BD(context);
        SQLiteDatabase sqLiteDatabase = bd.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(BDTabelas.TabelaHelicoptero._ESTOQUE, novaQt);

        sqLiteDatabase.update(BDTabelas.TabelaHelicoptero.HELICOPTERO, values,
                BDTabelas.TabelaHelicoptero._NOME+ " = ?",
                new String[]{helicoptero.getNome()});
        sqLiteDatabase.close();
    }
}
