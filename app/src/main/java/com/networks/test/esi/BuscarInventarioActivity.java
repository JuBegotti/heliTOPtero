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
import com.networks.test.esi.auxiliares.ListViewHeli;
import com.networks.test.esi.auxiliares.Mensagens;
import com.networks.test.esi.auxiliares.PutExtras;
import java.util.List;

public class BuscarInventarioActivity extends AppCompatActivity implements View.OnClickListener{

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
        ListViewHeli adapter = new ListViewHeli(helinhos, this);
        todosHelinhos.setAdapter(adapter);
        todosHelinhos.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Helicoptero helinho = (Helicoptero) todosHelinhos.getItemAtPosition(position);
                Intent intent = new Intent(todosHelinhos.getContext(), MostrarHeliActivity.class);
                PutExtras.putExtrasHelinho(helinho,intent);
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

    @Override
    public void onClick(View view) {
        android.widget.SearchView searchView = (android.widget.SearchView) findViewById(R.id.searchView);
        String entrada = searchView.getQuery().toString().trim();
        Helicoptero helinho = BDFuncoesHeli.buscaHelinhoNome(this,entrada);
        if(helinho==null) BDFuncoesHeli.buscaHelinhoFabricante(this,entrada);
        if(helinho==null) Mensagens.mensagem(this,R.string.erro_titulo, R.string.heli_n_encontrado_string);
        else{
            Intent intent = new Intent(this, MostrarHeliActivity.class);
            PutExtras.putExtrasHelinho(helinho, intent);
            startActivity(intent);
        }
    }

    private void initListeners(){
        botaoBuscar.setOnClickListener(this);
    }
}
