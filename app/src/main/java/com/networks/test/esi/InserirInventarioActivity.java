package com.networks.test.esi;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.networks.test.esi.BD.BDFuncoesHeli;
import com.networks.test.esi.BD.Helicoptero;
import com.networks.test.esi.auxiliares.Mensagens;
import com.networks.test.esi.auxiliares.PutExtras;

public class InserirInventarioActivity extends AppCompatActivity implements View.OnClickListener {

    private ConstraintLayout constraintLayout;

    private TextInputEditText InsertName;
    private TextInputEditText InsertManuf;
    private TextInputEditText InsertVelocidade;
    private TextInputEditText InsertFrenagem;
    private TextInputEditText InsertCapacidade;
    private TextInputEditText InsertAceleracao;
    private TextInputEditText InsertControle;
    private TextInputEditText InsertPrice;

    private Button registerItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_inventario);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(R.string.inserir_inventario_string);

        initViews();
        initListeners();
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
    public void onClick(View v) {
        Helicoptero helinho = BDFuncoesHeli.buscaHelinhoNome(this,InsertName.getText().toString().trim());
        if(helinho==null){
            helinho = new Helicoptero(
                    InsertName.getText().toString().trim(),
                    InsertManuf.getText().toString().trim(),
                    Float.parseFloat(InsertPrice.getText().toString().trim()),
                    Integer.parseInt(InsertCapacidade.getText().toString().trim()),
                    Float.parseFloat(InsertVelocidade.getText().toString().trim()),
                    Float.parseFloat(InsertAceleracao.getText().toString().trim()),
                    Float.parseFloat(InsertControle.getText().toString().trim()),
                    Float.parseFloat(InsertFrenagem.getText().toString().trim()));
            BDFuncoesHeli.addHelinho(this,helinho);
            Snackbar.make(constraintLayout, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();
            Intent intent = new Intent(this, MostrarHeliActivity.class);
            PutExtras.putExtrasHelinho(helinho,intent);
            startActivity(intent);
        }
        else Mensagens.mensagem(this,R.string.erro_titulo,R.string.heli_existente_string);
    }

    private void initViews(){
        constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout_inserir);

        InsertName = (TextInputEditText) findViewById(R.id.nome_inserir);
        InsertManuf = (TextInputEditText) findViewById(R.id.fabricante_inserir);
        InsertCapacidade = (TextInputEditText) findViewById(R.id.capacidade_inserir);
        InsertVelocidade = (TextInputEditText) findViewById(R.id.velocidade_inserir);
        InsertAceleracao = (TextInputEditText) findViewById(R.id.aceleracao_inserir);
        InsertControle = (TextInputEditText) findViewById(R.id.controle_inserir);
        InsertFrenagem = (TextInputEditText) findViewById(R.id.frenagem_inserir);
        InsertPrice = (TextInputEditText) findViewById(R.id.preco_inserir);

        registerItem = (Button) findViewById(R.id.registrarItem);
    }

    private void initListeners(){
        registerItem.setOnClickListener(this);
    }

}
