package com.networks.test.esi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TextView;

import com.networks.test.esi.BD.BDFuncoesTransacoes;
import com.networks.test.esi.BD.Transacoes;

public class VerTransacaoActivity extends AppCompatActivity {

    Transacoes transacao;

    TextView nomeHelinho;
    TextView nomeFabricante;
    TextView compra_venda;
    TextView data;
    TextView cliente;
    TextView funcionario;
    TextView quantidade;
    TextView preco;
    TextView precoTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_transacao);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(R.string.relat_vendas_string);

        transacao = BDFuncoesTransacoes.buscaTransacoes(this, getIntent().getStringExtra("data"));

        initViews();
        getValues();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, RelatorioActivity.class));
                finishAffinity();
                break;
            default:break;
        }
        return true;
    }

    private void getValues() {
        nomeHelinho.setText(transacao.getNomeHelinho());
        nomeFabricante.setText(transacao.getNomeFabricante());
        if(transacao.getCompra_venda()==1) compra_venda.setText(R.string.compra);
        else compra_venda.setText(R.string.venda);
        data.setText(transacao.getData());
        cliente.setText(transacao.getCliente());
        funcionario.setText(transacao.getFuncionario());
        quantidade.setText(Integer.toString(transacao.getQuantidade()));
        preco.setText(Float.toString(transacao.getPreco()));
        precoTotal.setText(Float.toString(transacao.getQuantidade()*transacao.getPreco()));
    }

    private void initViews() {
        nomeHelinho = (TextView) findViewById(R.id.verTransacao_nomeHelinho);
        nomeFabricante = (TextView) findViewById(R.id.verTransacao_FabricanteHelinho);
        compra_venda = (TextView) findViewById(R.id.verTransacao_compraVenda);
        data = (TextView) findViewById(R.id.verTransacao_data);
        cliente = (TextView) findViewById(R.id.verTransacao_cliente);
        funcionario = (TextView) findViewById(R.id.verTransacao_vendedor);
        quantidade = (TextView) findViewById(R.id.verTransacao_quantidade);
        preco = (TextView) findViewById(R.id.verTransacao_valor);
        precoTotal = (TextView) findViewById(R.id.verTransacao_valorTotal);
    }
}
