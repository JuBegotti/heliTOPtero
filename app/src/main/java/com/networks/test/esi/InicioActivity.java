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
        Intent intent = new Intent(this, PreferenciasActivity.class);
        startActivity(intent);
    }
    public void irPerfil(View view) {
        Intent intent = new Intent(this, PerfilActivity.class);
        startActivity(intent);
    }
    public void irInserir(View view) {
        Intent intent = new Intent(this, InserirInventarioActivity.class);
        startActivity(intent);
    }
    public void irInventario(View view) {
        Intent intent = new Intent(this, BuscarInventarioActivity.class);
        startActivity(intent);
    }
    public void irRelatorio(View view) {
        Intent intent = new Intent(this, RelatorioActivity.class);
        startActivity(intent);
    }
}
