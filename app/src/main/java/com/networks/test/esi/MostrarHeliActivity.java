package com.networks.test.esi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.networks.test.esi.BD.BD;
import com.networks.test.esi.BD.BDFuncoesHeli;
import com.networks.test.esi.BD.BDTabelas;
import com.networks.test.esi.BD.Helicoptero;
import com.networks.test.esi.auxiliares.Mensagens;

public class MostrarHeliActivity extends AppCompatActivity implements View.OnClickListener{

    Helicoptero helinho;

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

    private ProgressBar progCapacidade;
    private ProgressBar progVelocidade;
    private ProgressBar progControle;
    private ProgressBar progAceleracao;
    private ProgressBar progFrenagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_heli);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(R.string.busca_inventario_string);

        helinho = BDFuncoesHeli.buscaHelinhoNome(this,getIntent().getStringExtra("nome"));

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
                if(unidadesInt>0) {
                    Intent i = new Intent(getApplicationContext(), RealizarVendaActivity.class);
                    i.putExtra("nome",helinho.getNome());
                    i.putExtra("cliente","");
                    startActivity(i);
                }
                else Mensagens.mensagem(this, R.string.erro_titulo,R.string.estoque_vazio_string);
                break;
            case R.id.realizar_compra:
                Intent i = new Intent(getApplicationContext(), RealizarCompraActivity.class);
                i.putExtra("nome",helinho.getNome());
                i.putExtra("cliente","");
                startActivity(i);
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

        progCapacidade = (ProgressBar) findViewById(R.id.progressBar);
        progVelocidade = (ProgressBar) findViewById(R.id.progressBar1);
        progControle = (ProgressBar) findViewById(R.id.progressBar2);
        progAceleracao = (ProgressBar) findViewById(R.id.progressBar3);
        progFrenagem = (ProgressBar) findViewById(R.id.progressBar4);
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

        nome.setText(helinho.getNome());
        fabricante.setText(helinho.getFabricante());
        capacidade.setText(Integer.toString(helinho.getCapacidade()));
        velocidade.setText(Float.toString(helinho.getVelocidade()));
        precoVenda.setText(Float.toString(helinho.getPrecoVendaSugerido()));
        controle.setText(Float.toString(helinho.getControle()));
        aceleracao.setText(Float.toString(helinho.getAceleracao()));
        frenagem.setText(Float.toString(helinho.getFrenagem()));
        unidades.setText(Integer.toString(helinho.getUnidades()));
        unidadesInt = helinho.getUnidades();
        //foto.setImageDrawable(getResources().getDrawable(R.drawable.ah64apache));

        progCapacidade.setProgress(helinho.getCapacidade());
        progVelocidade.setProgress((int)helinho.getVelocidade());
        progControle.setProgress((int)helinho.getControle());
        progAceleracao.setProgress((int)helinho.getAceleracao());
        progFrenagem.setProgress((int)helinho.getFrenagem());
    }
}
