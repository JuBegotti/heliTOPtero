package com.networks.test.esi;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.networks.test.esi.BD.BDFuncoesCliente;
import com.networks.test.esi.BD.Cliente;
import com.networks.test.esi.auxiliares.Mensagens;

public class AdicionarClienteActivity extends AppCompatActivity implements View.OnClickListener{

    String nome;
    String compraVenda;

    Button cancelar;
    Button adicionar;

    TextInputEditText nomeIn;
    TextInputEditText enderecoIn;
    TextInputEditText cnpjCpfIn;
    TextInputEditText telefoneIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_cliente);   getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(R.string.acicionar_cliente_string);

        initViews();
        getValues();
        initListeners();
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
        Intent i = new Intent(getApplicationContext(), BuscarClienteActivity.class);
        switch (v.getId()) {
            case R.id.addCliente_botSalvar:
                String nomeS = nomeIn.getText().toString().trim();
                String enderecoS = nomeIn.getText().toString().trim();
                String telefoneS = nomeIn.getText().toString().trim();
                String cpfCnpjS = nomeIn.getText().toString().trim();
                if(!nomeS.isEmpty() && !enderecoS.isEmpty() && !telefoneS.isEmpty() && !cpfCnpjS.isEmpty()){
                    Cliente cliente = BDFuncoesCliente.buscaCliente(this,nomeS);
                    if(cliente==null){
                        cliente = new Cliente(nomeS,cpfCnpjS,enderecoS,telefoneS);
                        BDFuncoesCliente.addCliente(this,cliente);
                    }
                    else {
                        Mensagens.mensagem(this,R.string.erro_titulo,R.string.cliente_existente_string);
                        return;
                    }
                }
                else {
                    Mensagens.mensagem(this,R.string.erro_titulo,R.string.parametros_incorretos_string);
                    return;
                }
                break;
            case R.id.addCliente_botCancelar:
                break;
            default:
                break;
        }
        i.putExtra("nome",nome);
        i.putExtra("ComprarVender",compraVenda);
        startActivity(i);
    }

    private void initViews(){
        adicionar = (Button) findViewById(R.id.addCliente_botSalvar);
        cancelar = (Button) findViewById(R.id.addCliente_botCancelar);
        nomeIn = (TextInputEditText) findViewById(R.id.addCliente_nome);
        enderecoIn = (TextInputEditText) findViewById(R.id.addCliente_endereco);
        cnpjCpfIn = (TextInputEditText) findViewById(R.id.addCliente_cpf_cnpj);
        telefoneIn = (TextInputEditText) findViewById(R.id.addCliente_telefone);
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
