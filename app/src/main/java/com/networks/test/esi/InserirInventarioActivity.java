package com.networks.test.esi;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

public class InserirInventarioActivity extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = InserirInventarioActivity.this;

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
        initViews();
        initListeners();
        initObjects();
    }

    private void initViews(){
        constraintLayout = (ConstraintLayout) findViewById(R.id.insertConstraint);

        InputInsertName = (TextInputLayout) findViewById(R.id.InputInsertName);
        InputInsertManuf = (TextInputLayout) findViewById(R.id.InputInsertManuf);
        InputInsertCapacidade = (TextInputLayout) findViewById(R.id.InputInsertCapacidade);
        InputInsertVelocidade = (TextInputLayout) findViewById(R.id.InputInsertVelocidade);
        InputInsertAceleracao = (TextInputLayout) findViewById(R.id.InputInsertAceleracao);
        InputInsertControle = (TextInputLayout) findViewById(R.id.InputInsertControle);
        InputInsertFrenagem = (TextInputLayout) findViewById(R.id.InputInsertFrenagem);
        InputInsertPrice = (TextInputLayout) findViewById(R.id.InputInsertPrice);

        InsertName = (TextInputEditText) findViewById(R.id.InsertName);
        InsertManuf = (TextInputEditText) findViewById(R.id.InsertManuf);
        InsertCapacidade = (TextInputEditText) findViewById(R.id.InsertCapacidade);
        InsertVelocidade = (TextInputEditText) findViewById(R.id.InsertVelocidade);
        InsertAceleracao = (TextInputEditText) findViewById(R.id.InsertAceleracao);
        InsertControle = (TextInputEditText) findViewById(R.id.InsertControle);
        InsertFrenagem = (TextInputEditText) findViewById(R.id.InsertFrenagem);
        InsertPrice = (TextInputEditText) findViewById(R.id.InsertPrice);

        registerItem = (Button) findViewById(R.id.registrarItem);
    }

    private void initListeners(){
        registerItem.setOnClickListener(this);
    }

    private void initObjects(){
        databaseHelper = new DatabaseHelper(activity);
        heli = new Helicopter();
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
        postDataToSQLite();
        finish();
    }

    private void postDataToSQLite() {

        if (!databaseHelper.checkChoppa(InsertName.getText().toString().trim(), InsertManuf.getText().toString().trim())) {

            heli.setNome(InsertName.getText().toString().trim());
            heli.setFabricante(InsertManuf.getText().toString().trim());
            int capacidade = Integer.parseInt(InsertCapacidade.getText().toString().trim());
            System.out.println(capacidade);
            heli.setCapacidade(capacidade);
            heli.setVelocidade(Float.parseFloat(InsertVelocidade.getText().toString().trim()));
            heli.setAceleracao(Float.parseFloat(InsertAceleracao.getText().toString().trim()));
            heli.setFrenagem(Float.parseFloat(InsertFrenagem.getText().toString().trim()));
            heli.setControle(Float.parseFloat(InsertControle.getText().toString().trim()));
            heli.setPreco_compra(Integer.parseInt(InsertPrice.getText().toString().trim()));

            databaseHelper.addChoppa(heli);

            Snackbar.make(constraintLayout, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();
            emptyInputEditText();
            //Intent intent = new Intent(this, InserirInventarioActivity.class);
            //startActivity(intent);

        } else {
            Snackbar.make(constraintLayout, getString(R.string.error_email_exists), Snackbar.LENGTH_LONG).show();
        }
    }

    private void emptyInputEditText() {
        InsertName.setText(null);
        InsertManuf.setText(null);
        InsertCapacidade.setText(null);
        InsertVelocidade.setText(null);
        InsertAceleracao.setText(null);
        InsertFrenagem.setText(null);
        InsertControle.setText(null);
        InsertPrice.setText(null);
    }

}
