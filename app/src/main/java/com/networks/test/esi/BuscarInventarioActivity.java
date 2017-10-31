package com.networks.test.esi;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class BuscarInventarioActivity extends AppCompatActivity implements View.OnClickListener{

    private final AppCompatActivity activity = BuscarInventarioActivity.this;

    private ConstraintLayout constraintLayout;
    private android.widget.SearchView searchView;
    private Button buscaItem;

    private DatabaseHelper databaseHelper;
    private Helicopter heli;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_inventario);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(R.string.busca_inventario);

        initViews();
        initListeners();
        initObjects();
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

    private void initViews(){
        constraintLayout = (ConstraintLayout) findViewById(R.id.constraint_busca);
        buscaItem = (Button) findViewById(R.id.botao_busca);
        searchView = (android.widget.SearchView) findViewById(R.id.searchView);
    }

    private void initListeners(){
        buscaItem.setOnClickListener(this);
    }

    private void initObjects(){
        databaseHelper = new DatabaseHelper(activity);
        heli = new Helicopter();
    }

    public void irVerHelinho(View view) {
        Intent mostrar = new Intent(this, MostrarHeliActivity.class);
        mostrar.putExtra("HELI_ID", heli.getId());
        mostrar.putExtra("HELI_NOME", heli.getNome());
        mostrar.putExtra("HELI_PRECO", heli.getPreco_compra());
        mostrar.putExtra("HELI_CAP", heli.getCapacidade());
        mostrar.putExtra("HELI_VEL", heli.getVelocidade());
        startActivity(mostrar);
    }

    @Override
    public void onClick(View v) {
        searchSQL(v);
    }

    private void searchSQL(View v){

        String nome = searchView.getQuery().toString().trim();

        heli = databaseHelper.searchChoppa(nome);

        if(heli == null){
            Snackbar.make(constraintLayout, getString(R.string.error_valid_email_password), Snackbar.LENGTH_LONG).show();
            finish();
        }
        else{
            irVerHelinho(v);
        }


    }

}
