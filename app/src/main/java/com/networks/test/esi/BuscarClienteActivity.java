package com.networks.test.esi;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.networks.test.esi.BD.BDFuncoesCliente;
import com.networks.test.esi.BD.Cliente;
import com.networks.test.esi.auxiliares.ListViewTodas;

import java.util.List;
import java.util.Objects;

public class BuscarClienteActivity extends AppCompatActivity implements View.OnClickListener{

    String nome;
    String compraVenda;

    ListView listView;

    Button adicionar;
    Button cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_cliente);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(R.string.buscar_cliente_string);

        initViews();
        getValues();
        initListeners();

        List<Cliente> clientes = BDFuncoesCliente.listaCliente(this);
        if(clientes!=null){
            final ListView todosClientes = (ListView) findViewById(R.id.buscarCliente_listview);
            ListViewTodas adapter = new ListViewTodas(null,clientes, null, this);
            todosClientes.setAdapter(adapter);

            todosClientes.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent;
                    if(compraVenda.equals("vender")) intent = new Intent(todosClientes.getContext(), RealizarVendaActivity.class);
                    else intent = new Intent(todosClientes.getContext(), RealizarCompraActivity.class);
                    intent.putExtra("cliente", ((Cliente) todosClientes.getItemAtPosition(position)).getNome());
                    intent.putExtra("nome",nome);
                    intent.putExtra("ComprarVender",compraVenda);
                    startActivity(intent);
                }
            });
        }

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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buscarCliente_addCliente:
                Intent i = new Intent(getApplicationContext(), AdicionarClienteActivity.class);
                i.putExtra("nome",nome);
                i.putExtra("ComprarVender",compraVenda);
                startActivity(i);
                break;
            case R.id.buscarCliente_cancelar:
                startActivity(new Intent(this, BuscarInventarioActivity.class));
                break;
            default:
                break;
        }
    }

    private void initViews(){
        listView = (ListView) findViewById(R.id.buscarCliente_listview);
        adicionar = (Button) findViewById(R.id.buscarCliente_addCliente);
        cancelar = (Button) findViewById(R.id.buscarCliente_cancelar);
    }

    private void initListeners(){
        adicionar.setOnClickListener(this);
        cancelar.setOnClickListener(this);
    }

    private void getValues(){
        nome = getIntent().getStringExtra("nome");
        compraVenda = getIntent().getStringExtra("ComprarVender");
    }
}
