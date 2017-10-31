package com.networks.test.esi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MostrarHeliActivity extends AppCompatActivity {


    private TextView nome_heli_id;
    private TextView capacidade_mostrar;
    private TextView velocidade_mostrar;
    private TextView preco_mostrar;
    private TextView unidades_mostrar;
    private TextView fabricante_mostrar;
    private TextView controle_mostrar;
    private TextView aceleracao_mostrar;
    private TextView frenagem_mostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_heli);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(R.string.busca_inventario_string);

        initViews();
        getValues();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, BuscarInventarioActivity.class));
                finishAffinity();
                break;
            default:break;
        }
        return true;
    }

    private void initViews(){
        nome_heli_id = (TextView) findViewById(R.id.nome_vizu);
        capacidade_mostrar = (TextView) findViewById(R.id.capacidade_conteudo_texto);
        velocidade_mostrar = (TextView) findViewById(R.id.velocidade_conteudo_texto);
        preco_mostrar = (TextView) findViewById(R.id.preco_vizu);
    }

    private void getValues(){

        nome_heli_id.setText(getIntent().getStringExtra("HELI_NOME"));
        capacidade_mostrar.setText(Integer.toString(getIntent().getIntExtra("HELI_CAP", 6)));
        velocidade_mostrar.setText(Float.toString(getIntent().getFloatExtra("HELI_VEL", 0)));
        preco_mostrar.setText(Float.toString(getIntent().getFloatExtra("HELI_PRECO", 0)));
    }

    public void irVerFotoHelinho(View view) {
        //startActivity(new Intent(this, PreferenciasActivity.class));
    }
    public void irRealizaCompra(View view) {
        startActivity(new Intent(this, RealizarCompraActivity.class));
    }
    public void irRealizaVenda(View view) {
        startActivity(new Intent(this, RealizarVendaActivity.class));
    }
}
