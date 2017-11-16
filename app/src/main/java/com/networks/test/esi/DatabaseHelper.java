package com.networks.test.esi;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class DatabaseHelper extends SQLiteOpenHelper{
    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

//    private static final int DATABASE_VERSION = 1;
//    private static final String DATABASE_NAME = "UserManager.db";
//
//    // Usuarios
//    private static final String TABLE_USER = "user";
//
//    private static final String COLUMN_USER_ID = "user_id";
//    private static final String COLUMN_USER_NAME = "user_name";
//    private static final String COLUMN_USER_EMAIL = "user_email";
//    private static final String COLUMN_USER_PASSWORD = "user_password";
//
//    //Helicopteros
//    private static final String TABLE_CHOPPA = "helicopters";
//
//    private static final String COLUMN_CHOPPA_ID = "heli_id";
//    private static final String COLUMN_CHOPPA_NOME = "heli_nome";
//    private static final String COLUMN_CHOPPA_FABRICANTE = "heli_fabricante";
//    private static final String COLUMN_CHOPPA_CAPACIDADE = "heli_capacidade";
//    private static final String COLUMN_CHOPPA_VELOCIDADE = "heli_velocidade";
//    private static final String COLUMN_CHOPPA_ACELERACAO = "heli_aceleracao";
//    private static final String COLUMN_CHOPPA_CONTROLE = "heli_controle";
//    private static final String COLUMN_CHOPPA_FRENAGEM = "heli_frenagem";
//    private static final String COLUMN_CHOPPA_MEDIA = "heli_media";
//    private static final String COLUMN_CHOPPA_COMPRA = "heli_compra";
//
//
//
//    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
//            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
//            + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_PASSWORD + " TEXT" + ")";
//
//    private String CREATE_CHOPPA_TABLE = "CREATE TABLE " + TABLE_CHOPPA + "("
//            + COLUMN_CHOPPA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+COLUMN_CHOPPA_NOME +" TEXT,"
//            + COLUMN_CHOPPA_FABRICANTE + " TEXT," + COLUMN_CHOPPA_CAPACIDADE + " INTEGER,"
//            + COLUMN_CHOPPA_VELOCIDADE + " FLOAT," + COLUMN_CHOPPA_ACELERACAO + " FLOAT,"
//            + COLUMN_CHOPPA_CONTROLE + " FLOAT," + COLUMN_CHOPPA_FRENAGEM + " FLOAT,"
//            + COLUMN_CHOPPA_MEDIA + " FLOAT," + COLUMN_CHOPPA_COMPRA + " FLOAT" + ")";
//
//    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;
//    private String DROP_CHOPPA_TABLE = "DROP TABLE IF EXISTS " + TABLE_CHOPPA;
//
//    Context contexto;
//
//    DatabaseHelper(Context contexto) {
//        super(contexto, DATABASE_NAME, null, DATABASE_VERSION);
//        this.contexto = contexto;
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        db.execSQL(CREATE_USER_TABLE);
//        db.execSQL(CREATE_CHOPPA_TABLE);
//        try {
//            carregaBD(contexto);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//
//
//        db.execSQL(DROP_USER_TABLE);
//        db.execSQL(DROP_CHOPPA_TABLE);
//
//        onCreate(db);
//
//    }
//
//
//    //USER
//    void addUser(User user) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_USER_NAME, user.getName());
//        values.put(COLUMN_USER_EMAIL, user.getEmail());
//        values.put(COLUMN_USER_PASSWORD, user.getSenha());
//
//
//        db.insert(TABLE_USER, null, values);
//        db.close();
//    }
//
//    List<User> getAllUser() {
//        String[] columns = {
//                COLUMN_USER_ID,
//                COLUMN_USER_EMAIL,
//                COLUMN_USER_NAME,
//                COLUMN_USER_PASSWORD
//        };
//
//        String sortOrder =
//                COLUMN_USER_NAME + " ASC";
//        List<User> userList = new ArrayList<>();
//
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursor = db.query(TABLE_USER,
//                columns,
//                null,
//                null,
//                null,
//                null,
//                sortOrder);
//
//        if (cursor.moveToFirst()) {
//            do {
//                User user = new User();
//                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_ID))));
//                user.setName(cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME)));
//                user.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_USER_EMAIL)));
//                user.setSenha(cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD)));
//                userList.add(user);
//            } while (cursor.moveToNext());
//        }
//        cursor.close();
//        db.close();
//
//        return userList;
//    }
//
//    public void updateUser(User user) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_USER_NAME, user.getName());
//        values.put(COLUMN_USER_EMAIL, user.getEmail());
//        values.put(COLUMN_USER_PASSWORD, user.getSenha());
//
//        db.update(TABLE_USER, values, COLUMN_USER_ID + " = ?",
//                new String[]{String.valueOf(user.getId())});
//        db.close();
//    }
//
//    void deleteUser(User user) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_USER, COLUMN_USER_ID + " = ?",
//                new String[]{String.valueOf(user.getId())});
//        db.close();
//    }
//
//    boolean checkUser(String email) {
//
//        String[] columns = {
//                COLUMN_USER_ID
//        };
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        String selection = COLUMN_USER_EMAIL + " = ?";
//
//        String[] selectionArgs = {email};
//
//        Cursor cursor = db.query(TABLE_USER,
//                columns,
//                selection,
//                selectionArgs,
//                null,
//                null,
//                null);
//        int cursorCount = cursor.getCount();
//        cursor.close();
//        db.close();
//
//        return cursorCount > 0;
//
//    }
//
//    boolean checkUser(String email, String password) {
//
//
//        String[] columns = {
//                COLUMN_USER_ID
//        };
//        SQLiteDatabase db = this.getReadableDatabase();
//        String selection = COLUMN_USER_EMAIL + " = ?" + " AND " + COLUMN_USER_PASSWORD + " = ?";
//
//        String[] selectionArgs = {email, password};
//
//
//        Cursor cursor = db.query(TABLE_USER,
//                columns,
//                selection,
//                selectionArgs,
//                null,
//                null,
//                null);
//
//        int cursorCount = cursor.getCount();
//
//        cursor.close();
//        db.close();
//        return cursorCount > 0;
//
//    }
//
//    //HELICOPTERS
//
//    private void carregaBD(Context context) throws IOException {
//        final Resources resources = context.getResources();
//        InputStream inHeli = resources.openRawResource(R.raw.helinhos);
//        BufferedReader headerHeli = new BufferedReader(new InputStreamReader(inHeli));
//        String line;
//        int i = 0;
//        while ((line = headerHeli.readLine()) != null) {
//            String[] RowData = line.split(",");
//            String nome = RowData[0];
//            String fabricante = RowData[1];
//            String preco = RowData[2];
//            String capacidade = RowData[3];
//            String velocidade = RowData[4];
//            String aceleracao = RowData[5];
//            String controle = RowData[6];
//            String frenagem = RowData[7];
//            Helicopter heli = new Helicopter(i, nome, fabricante, Float.parseFloat(preco),
//                    Integer.parseInt(capacidade), Float.parseFloat(velocidade), Float.parseFloat(aceleracao),
//                    Float.parseFloat(controle), Float.parseFloat(frenagem));
//            i++;
//            addChoppa(heli);
//        }
//        inHeli.close();
//        headerHeli.close();
//    }
//
//    void addChoppa(Helicopter heli){
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_CHOPPA_NOME, heli.getNome());
//        values.put(COLUMN_CHOPPA_FABRICANTE, heli.getFabricante());
//        values.put(COLUMN_CHOPPA_CAPACIDADE, heli.getCapacidade());
//        values.put(COLUMN_CHOPPA_VELOCIDADE, heli.getVelocidade());
//        values.put(COLUMN_CHOPPA_ACELERACAO, heli.getAceleracao());
//        values.put(COLUMN_CHOPPA_CONTROLE, heli.getControle());
//        values.put(COLUMN_CHOPPA_FRENAGEM, heli.getFrenagem());
//        values.put(COLUMN_CHOPPA_MEDIA, (heli.getVelocidade() + heli.getAceleracao() + heli.getControle() + heli.getFrenagem())/4);
//        values.put(COLUMN_CHOPPA_COMPRA, heli.getPreco_compra());
//
//        db.insert(TABLE_CHOPPA, null, values);
//        db.close();
//    }
//
//    boolean checkChoppa(String nome, String fabricante) {
//
//        String[] columns = {
//                COLUMN_CHOPPA_ID
//        };
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        String selection = COLUMN_CHOPPA_NOME + " = ? AND "+ COLUMN_CHOPPA_FABRICANTE +" = ?";
//
//        String[] selectionArgs = {nome, fabricante};
//
//        Cursor cursor = db.query(TABLE_CHOPPA,
//                columns,
//                selection,
//                selectionArgs,
//                null,
//                null,
//                null);
//        int cursorCount = cursor.getCount();
//        cursor.close();
//        db.close();
//
//        return cursorCount > 0;
//    }
//
//    Helicopter searchChoppa(String nome){
//
//        Helicopter heliAchado;
//
//        String[] columns = {COLUMN_CHOPPA_NOME, COLUMN_CHOPPA_COMPRA, COLUMN_CHOPPA_VELOCIDADE, COLUMN_CHOPPA_CAPACIDADE};
//        String selection = COLUMN_CHOPPA_NOME + " = ?";
//        String[] arguments = {nome};
//
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursor = db.query(TABLE_CHOPPA, columns, selection,arguments,null,null,null, null);
//
//        if(cursor.moveToFirst()){
//            heliAchado = new Helicopter();
//            heliAchado.setNome(cursor.getString(cursor.getColumnIndex(COLUMN_CHOPPA_NOME)));
//            heliAchado.setVelocidade(Float.parseFloat(cursor.getString(cursor.getColumnIndex(COLUMN_CHOPPA_VELOCIDADE))));
//            heliAchado.setCapacidade(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_CHOPPA_CAPACIDADE))));
//            heliAchado.setPreco_compra(Float.parseFloat(cursor.getString(cursor.getColumnIndex(COLUMN_CHOPPA_COMPRA))));
//            cursor.close();
//        }
//        else {
//            return null;
//        }
//        return heliAchado;
//    }
//
//    List<Helicopter> listaTodosHeli(){
//        List<Helicopter> helis = null;
//        SQLiteDatabase bd = this.getReadableDatabase();
//
//        Cursor cursor = bd.rawQuery(
//                "SELECT * FROM "+ TABLE_CHOPPA + " ORDER BY " + COLUMN_CHOPPA_NOME, null);
//
//        if(cursor.getCount()>0){
//            cursor.moveToFirst();
//            helis = new ArrayList<>();
//            do {
//                Helicopter heli = new Helicopter(cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_CHOPPA_ID)),
//                        cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHOPPA_NOME)),
//                        cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHOPPA_FABRICANTE)),
//                        cursor.getFloat(cursor.getColumnIndexOrThrow(COLUMN_CHOPPA_COMPRA)),
//                        cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_CHOPPA_CAPACIDADE)),
//                        cursor.getFloat(cursor.getColumnIndexOrThrow(COLUMN_CHOPPA_VELOCIDADE)),
//                        cursor.getFloat(cursor.getColumnIndexOrThrow(COLUMN_CHOPPA_ACELERACAO)),
//                        cursor.getFloat(cursor.getColumnIndexOrThrow(COLUMN_CHOPPA_CONTROLE)),
//                        cursor.getFloat(cursor.getColumnIndexOrThrow(COLUMN_CHOPPA_FRENAGEM)));
//                helis.add(heli);
//            } while (cursor.moveToNext());
//            cursor.close();
//        }
//        return helis;
//    }
//
//
//    Helicopter searchChoppa(String nome, String fabricante){
//
//        Helicopter heliAchado;
//
//        String[] columns = {COLUMN_CHOPPA_NOME, COLUMN_CHOPPA_FABRICANTE};
//        String selection = COLUMN_CHOPPA_NOME + " = ? AND " + COLUMN_CHOPPA_FABRICANTE + " = ?";
//        String[] arguments = {nome, fabricante};
//
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursor = db.query(true, TABLE_CHOPPA, columns, selection,arguments,null,null,null, null);
//
//        if(cursor.moveToFirst()){
//            heliAchado = new Helicopter();
//            heliAchado.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_CHOPPA_ID))));
//            heliAchado.setCapacidade(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_CHOPPA_CAPACIDADE))));
//            heliAchado.setPreco_compra(Float.parseFloat(cursor.getString(cursor.getColumnIndex(COLUMN_CHOPPA_COMPRA))));
//        }
//        else {
//            return null;
//        }
//
//        return heliAchado;
//    }
}