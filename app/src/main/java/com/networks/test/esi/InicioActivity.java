package com.networks.test.esi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class InicioActivity extends AppCompatActivity implements View.OnClickListener{

    private Button perfil;
    private Button inserir;
    private Button buscar;
    private Button relatorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        initViews();
        initListeners();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bot_perf_inicio:
                startActivity(new Intent(this, PerfilActivity.class));
                break;
            case R.id.bot_inserir_inicio:
                startActivity(new Intent(this, InserirInventarioActivity.class));
                break;
            case R.id.bot_busc_inicio:
                startActivity(new Intent(this, BuscarInventarioActivity.class));
                break;
            case R.id.bot_relatorio_inicio:
                startActivity(new Intent(this, RelatorioActivity.class));
                break;
            default:
                break;
        }
    }

    private void initListeners() {
        perfil.setOnClickListener(this);
        inserir.setOnClickListener(this);
        buscar.setOnClickListener(this);
        relatorio.setOnClickListener(this);
    }

    private void initViews() {
        perfil = (Button) findViewById(R.id.bot_perf_inicio);
        inserir = (Button) findViewById(R.id.bot_inserir_inicio);
        buscar = (Button) findViewById(R.id.bot_busc_inicio);
        relatorio = (Button) findViewById(R.id.bot_relatorio_inicio);
    }
}
