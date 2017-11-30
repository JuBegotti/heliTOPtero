package com.networks.test.esi;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.networks.test.esi.BD.BDFuncoesHeli;
import com.networks.test.esi.BD.BDFuncoesTransacoes;
import com.networks.test.esi.BD.Helicoptero;
import com.networks.test.esi.BD.Transacoes;
import com.networks.test.esi.auxiliares.Mensagens;
import com.networks.test.esi.auxiliares.UsuarioAtivo;

import java.util.Date;

public class RealizarVendaActivity extends AppCompatActivity implements View.OnClickListener{

    Helicoptero helinho;

    private TextInputEditText quantidade;
    private TextInputEditText precoCompra;

    private TextView nome;
    private TextView fabricante;
    private TextView cliente;
    private TextView estoque;
    private TextView preco;

    private String clienteString = null;
    private String nomeString;

    private Button buscar;
    private Button cancelar;
    private Button realizarVenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realizar_venda);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(R.string.realizar_venda_string);

        clienteString = getIntent().getStringExtra("cliente");
        nomeString = getIntent().getStringExtra("nome");
        helinho = BDFuncoesHeli.buscaHelinhoNome(this, nomeString);

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
        switch (v.getId()) {
            case R.id.venda_botao_cancelar:
                startActivity(new Intent(this, BuscarInventarioActivity.class));
                break;
            case R.id.venda_botBuscaCli:
                Intent i = new Intent(this, BuscarClienteActivity.class);
                i.putExtra("nome",nomeString);
                i.putExtra("ComprarVender","vender");
                startActivity(i);
                break;
            case R.id.venda_botao_venda:
                String qtS = quantidade.getText().toString().trim();
                String pcS = precoCompra.getText().toString().trim();
                int qt = 0;
                int pc = 0;
                if(!qtS.isEmpty() && !pcS.isEmpty()){
                    qt = Integer.parseInt(qtS);
                    pc = Integer.parseInt(pcS);
                }
                if(clienteString!=null && pc!=0 && qt!=0 && qt<=helinho.getUnidades()){
                    Transacoes transacoes = new Transacoes(nomeString, helinho.getFabricante(), 2,
                            new Date().toString(), clienteString, UsuarioAtivo.email, qt, pc);
                    BDFuncoesTransacoes.addTransacao(this,transacoes);
                    BDFuncoesHeli.updateHelinhoEstoque(this, helinho,helinho.getUnidades()-qt);
                    startActivity(new Intent(this, InicioActivity.class));
                }
                else Mensagens.mensagem(this, R.string.erro_titulo,R.string.parametros_incorretos_string);
                break;
            default:
                break;
        }
    }

    private void initViews(){
        nome = (TextView) findViewById(R.id.venda_heliNome);
        fabricante = (TextView) findViewById(R.id.venda_heliFabricante);
        cliente = (TextView) findViewById(R.id.venda_clienteDaCompra);
        estoque = (TextView) findViewById(R.id.venda_estoque);
        preco = (TextView) findViewById(R.id.venda_precoSugerido);
        buscar = (Button) findViewById(R.id.venda_botBuscaCli);
        cancelar = (Button) findViewById(R.id.venda_botao_cancelar);
        realizarVenda = (Button) findViewById(R.id.venda_botao_venda);
        quantidade = (TextInputEditText) findViewById(R.id.venda_quantidade);
        precoCompra = (TextInputEditText) findViewById(R.id.venda_preco);
    }

    private void initListeners(){
        buscar.setOnClickListener(this);
        realizarVenda.setOnClickListener(this);
        cancelar.setOnClickListener(this);
    }

    private void getValues(){
        nome.setText(helinho.getNome());
        fabricante.setText(helinho.getFabricante());
        if(!clienteString.isEmpty()) cliente.setText(clienteString);
        estoque.setText(Integer.toString(helinho.getUnidades()));
        preco.setText(Float.toString(helinho.getPrecoVendaSugerido()));
    }
}
