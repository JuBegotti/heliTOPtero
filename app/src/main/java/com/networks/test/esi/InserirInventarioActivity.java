package com.networks.test.esi;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class InserirInventarioActivity extends AppCompatActivity implements View.OnClickListener {

    private ConstraintLayout constraintLayout;

    private TextInputLayout InputInsertName;
    private TextInputLayout InputInsertManuf;
    private TextInputLayout InputInsertVelocidade;
    private TextInputLayout InputInsertFrenagem;
    private TextInputLayout InputInsertCapacidade;
    private TextInputLayout InputInsertAceleracao;
    private TextInputLayout InputInsertControle;
    private TextInputLayout InputInsertPrice;

    private TextInputEditText InsertName;
    private TextInputEditText InsertManuf;
    private TextInputEditText InsertVelocidade;
    private TextInputEditText InsertFrenagem;
    private TextInputEditText InsertCapacidade;
    private TextInputEditText InsertAceleracao;
    private TextInputEditText InsertControle;
    private TextInputEditText InsertPrice;


    private Button registerItem;

    private DatabaseHelper databaseHelper;
    private Helicopter heli;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_inventario);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(R.string.inserir_inventario);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, InicioActivity.class));
                finishAffinity();
                break;
            default:break;
        }
        return true;
    }

    @Override
    public void onClick(View v) {

    }
}
