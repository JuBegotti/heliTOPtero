package com.networks.test.esi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.networks.test.esi.BD.BDFuncoesTransacoes;
import com.networks.test.esi.BD.Transacoes;
import com.networks.test.esi.auxiliares.ListViewTodas;

import java.util.List;

public class RelatorioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(R.string.relat_vendas_string);

        final ListView  listView = (ListView) findViewById(R.id.relatorio_listView);

        final List<Transacoes> transacoes = BDFuncoesTransacoes.listaTransacoes(this);
        ListViewTodas adapter = new ListViewTodas(null, null, transacoes, this);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                intent = new Intent(listView.getContext(), VerTransacaoActivity.class);
                intent.putExtra("data", ((Transacoes) listView.getItemAtPosition(position)).getData());
                startActivity(intent);
            }
        });

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
}
