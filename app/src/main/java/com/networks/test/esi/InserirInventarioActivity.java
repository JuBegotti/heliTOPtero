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

    /*private TextInputLayout InputInsertName;
    private TextInputLayout InputInsertManuf;
    private TextInputLayout InputInsertVelocidade;
    private TextInputLayout InputInsertFrenagem;
    private TextInputLayout InputInsertCapacidade;
    private TextInputLayout InputInsertAceleracao;
    private TextInputLayout InputInsertControle;
    private TextInputLayout InputInsertPrice;*/

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
        constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout_inserir);

        /*InputInsertName = (TextInputLayout) findViewById(R.id.nome_inserir);
        InputInsertManuf = (TextInputLayout) findViewById(R.id.fabricante_inserir);
        InputInsertCapacidade = (TextInputLayout) findViewById(R.id.capacidade_inserir);
        InputInsertVelocidade = (TextInputLayout) findViewById(R.id.velocidade_inserir);
        InputInsertAceleracao = (TextInputLayout) findViewById(R.id.aceleracao_inserir);
        InputInsertControle = (TextInputLayout) findViewById(R.id.controle_inserir);
        InputInsertFrenagem = (TextInputLayout) findViewById(R.id.frenagem_inserir);
        InputInsertPrice = (TextInputLayout) findViewById(R.id.preco_inserir);*/

        InsertName = (TextInputEditText) findViewById(R.id.nome_inserir);
        InsertManuf = (TextInputEditText) findViewById(R.id.fabricante_inserir);
        InsertCapacidade = (TextInputEditText) findViewById(R.id.capacidade_inserir);
        InsertVelocidade = (TextInputEditText) findViewById(R.id.velocidade_inserir);
        InsertAceleracao = (TextInputEditText) findViewById(R.id.aceleracao_inserir);
        InsertControle = (TextInputEditText) findViewById(R.id.controle_inserir);
        InsertFrenagem = (TextInputEditText) findViewById(R.id.frenagem_inserir);
        InsertPrice = (TextInputEditText) findViewById(R.id.preco_inserir);

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
            heli.setCapacidade(Integer.parseInt(InsertCapacidade.getText().toString().trim()));
            heli.setVelocidade(Float.parseFloat(InsertVelocidade.getText().toString().trim()));
            heli.setAceleracao(Float.parseFloat(InsertAceleracao.getText().toString().trim()));
            heli.setFrenagem(Float.parseFloat(InsertFrenagem.getText().toString().trim()));
            heli.setControle(Float.parseFloat(InsertControle.getText().toString().trim()));
            heli.setPreco_compra(Integer.parseInt(InsertPrice.getText().toString().trim()));

            databaseHelper.addChoppa(heli);

            Snackbar.make(constraintLayout, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();
            emptyInputEditText();
            Intent intent = new Intent(this, InserirInventarioActivity.class);
            startActivity(intent);

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
