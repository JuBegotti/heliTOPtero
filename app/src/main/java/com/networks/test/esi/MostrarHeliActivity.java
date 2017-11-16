package com.networks.test.esi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.networks.test.esi.BD.BDTabelas;
import com.networks.test.esi.auxiliares.Mensagens;

public class MostrarHeliActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView nome;
    private TextView capacidade;
    private TextView velocidade;
    private TextView precoVenda;
    private TextView unidades;
    private TextView fabricante;
    private TextView controle;
    private TextView aceleracao;
    private TextView frenagem;
    private int unidadesInt;
    private ImageButton foto;
    private Button compra;
    private Button venda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_heli);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(R.string.busca_inventario_string);

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
            case R.id.helinho_imagem:
                break;
            case R.id.realizar_venda:
                if(unidadesInt>0) startActivity(new Intent(getApplicationContext(), RealizarVendaActivity.class));
                else Mensagens.mensagem(this, R.string.erro_titulo,R.string.estoque_vazio_string);
                break;
            case R.id.realizar_compra:
                startActivity(new Intent(getApplicationContext(), RealizarCompraActivity.class));
                break;
            default:
                break;
        }
    }

    private void initViews(){
        nome = (TextView) findViewById(R.id.nome_vizu);
        capacidade = (TextView) findViewById(R.id.capacidade_conteudo_texto);
        velocidade = (TextView) findViewById(R.id.velocidade_conteudo_texto);
        precoVenda = (TextView) findViewById(R.id.preco_vizu);
        unidades = (TextView) findViewById(R.id.unidade_vizu);
        fabricante = (TextView) findViewById(R.id.fabricante_conteudo_texto);
        controle = (TextView) findViewById(R.id.controle_conteudo_texto);
        aceleracao = (TextView) findViewById(R.id.aceleracao_conteudo_texto);
        frenagem = (TextView) findViewById(R.id.frenagem_conteudo_texto);
        foto = (ImageButton) findViewById(R.id.helinho_imagem);
        compra = (Button) findViewById(R.id.realizar_compra);
        venda = (Button) findViewById(R.id.realizar_venda);
    }

    private void initListeners(){
        foto.setOnClickListener(this);
        compra.setOnClickListener(this);
        venda.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    private void getValues(){

        // TODO foto do helinho?
        //String fotooo = "R.drawable."+getIntent().getStringExtra(BDTabelas.TabelaHelicoptero._FOTO);

        nome.setText(getIntent().getStringExtra(BDTabelas.TabelaHelicoptero._NOME));
        fabricante.setText(getIntent().getStringExtra(BDTabelas.TabelaHelicoptero._FABRICANTE));
        capacidade.setText(Integer.toString(getIntent().getIntExtra(BDTabelas.TabelaHelicoptero._CAPACIDADE, 0)));
        velocidade.setText(Float.toString(getIntent().getFloatExtra(BDTabelas.TabelaHelicoptero._VELOCIDADE, 0)));
        precoVenda.setText(Float.toString(getIntent().getFloatExtra(BDTabelas.TabelaHelicoptero._PRECO_VENDA, 0)));
        controle.setText(Float.toString(getIntent().getFloatExtra(BDTabelas.TabelaHelicoptero._CONTROLE, 0)));
        aceleracao.setText(Float.toString(getIntent().getFloatExtra(BDTabelas.TabelaHelicoptero._ACELERACAO, 0)));
        frenagem.setText(Float.toString(getIntent().getFloatExtra(BDTabelas.TabelaHelicoptero._FRENAGEM, 0)));
        unidades.setText(Integer.toString(getIntent().getIntExtra(BDTabelas.TabelaHelicoptero._ESTOQUE, 0)));
        unidadesInt = getIntent().getIntExtra(BDTabelas.TabelaHelicoptero._ESTOQUE,0);
        //foto.setImageDrawable(R.drawable.);
    }
}
