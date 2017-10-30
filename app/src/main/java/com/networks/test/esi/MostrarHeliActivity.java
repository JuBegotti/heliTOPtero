package com.networks.test.esi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MostrarHeliActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_heli);
    }
    public void irVerFotoHelinho(View view) {
        //startActivity(new Intent(this, PreferenciasActivity.class));
    }
}
