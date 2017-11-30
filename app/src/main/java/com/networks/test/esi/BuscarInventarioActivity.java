package com.networks.test.esi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import com.networks.test.esi.BD.BDFuncoesHeli;
import com.networks.test.esi.BD.Helicoptero;
import com.networks.test.esi.auxiliares.ListViewTodas;
import com.networks.test.esi.auxiliares.Mensagens;
import java.util.List;

public class BuscarInventarioActivity extends AppCompatActivity implements View.OnClickListener{

    // TODO deixar menos feiinhoo

    private Button botaoBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_inventario);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(R.string.busca_inventario_string);

        botaoBuscar = (Button) findViewById(R.id.botao_busca);
        botaoBuscar.setOnClickListener(this);

        List<Helicoptero> helinhos = BDFuncoesHeli.listaHelinhos(this);
        final ListView todosHelinhos = (ListView) findViewById(R.id.buscaInve_listView);
        ListViewTodas adapter = new ListViewTodas(helinhos,null, null, this);
        todosHelinhos.setAdapter(adapter);

        todosHelinhos.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(todosHelinhos.getContext(), MostrarHeliActivity.class);
                intent.putExtra("nome", ((Helicoptero) todosHelinhos.getItemAtPosition(position)).getNome());
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, InicioActivity.class));
                break;
            default:break;
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        android.widget.SearchView searchView = (android.widget.SearchView) findViewById(R.id.searchView);
        String entrada = searchView.getQuery().toString().trim();
        Helicoptero helinho = BDFuncoesHeli.buscaHelinhoNome(this,entrada);
        if(helinho==null) BDFuncoesHeli.buscaHelinhoFabricante(this,entrada);
        if(helinho==null) Mensagens.mensagem(this,R.string.erro_titulo, R.string.heli_n_encontrado_string);
        else{
            Intent intent = new Intent(this, MostrarHeliActivity.class);
            intent.putExtra("nome", helinho.getNome());
            startActivity(intent);
        }
    }
}
