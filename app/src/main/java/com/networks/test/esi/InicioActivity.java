package com.networks.test.esi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class InicioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
    }

    public void irPreferencias(View view) {
        startActivity(new Intent(this, PreferenciasActivity.class));
    }
    public void irPerfil(View view) {
        startActivity(new Intent(this, PerfilActivity.class));
    }
    public void irInserir(View view) {
        startActivity(new Intent(this, InserirInventarioActivity.class));
    }
    public void irInventario(View view) {
        startActivity(new Intent(this, BuscarInventarioActivity.class));
    }
    public void irRelatorio(View view) {
        startActivity(new Intent(this, RelatorioActivity.class));
    }
}
