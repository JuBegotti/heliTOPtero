package com.networks.test.esi;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.networks.test.esi.BD.BDFuncoesUsuario;
import com.networks.test.esi.BD.BDTabelas;
import com.networks.test.esi.BD.Usuario;
import com.networks.test.esi.auxiliares.UsuarioAtivo;

public class PerfilActivity extends AppCompatActivity implements View.OnClickListener{

    private int id;

    Usuario usuario;

    private TextView nome;
    private TextView sobrenome;
    private TextView funcao;
    private TextView email;
    private TextView nascimento;
    private TextView endereco;
    private TextView localizacao;

    private ImageButton editarFoto;
    private ImageButton editarEmail;
    private ImageButton editarNascimento;
    private ImageButton editarEndereco;
    private ImageButton editarLocalizacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(R.string.perfil_string);

        usuario = BDFuncoesUsuario.buscaUsuario(UsuarioAtivo.email,this);

        initViews();
        getValues();
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
        // TODO alterar coisas?
        switch (v.getId()) {
            case R.id.botao_alterar_foto:
                break;
            case R.id.botao_alterar_email:
                break;
            case R.id.botao_alterar_nascimento:
                break;
            case R.id.botao_alterar_endereco:
                break;
            case R.id.botao_alterar_localizacao:
                break;
            default:
                break;
        }
    }

    private void initListeners() {
        editarFoto.setOnClickListener(this);
        editarEmail.setOnClickListener(this);
        editarNascimento.setOnClickListener(this);
        editarEndereco.setOnClickListener(this);
        editarLocalizacao.setOnClickListener(this);
    }

    private void getValues() {
        id = usuario.getId();
        nome.setText(usuario.getNome());
        sobrenome.setText(usuario.getSobrenome());
        funcao.setText(usuario.getFuncao());
        email.setText(usuario.getEmail());
        nascimento.setText(usuario.getNascimento());
        endereco.setText(usuario.getEndereco());
        localizacao.setText(usuario.getCep_cidade_estado());
    }

    private void initViews() {

        // TODO alterar foto perfil?

        editarFoto = (ImageButton) findViewById(R.id.botao_alterar_foto);
        editarEmail = (ImageButton) findViewById(R.id.botao_alterar_email);
        editarNascimento = (ImageButton) findViewById(R.id.botao_alterar_nascimento);
        editarEndereco = (ImageButton) findViewById(R.id.botao_alterar_endereco);
        editarLocalizacao = (ImageButton) findViewById(R.id.botao_alterar_localizacao);

        nome = (TextView) findViewById(R.id.nome_id);
        sobrenome = (TextView) findViewById(R.id.sobrenome_id);
        funcao = (TextView) findViewById(R.id.cargo_id);
        email = (TextView) findViewById(R.id.email_id);
        nascimento = (TextView) findViewById(R.id.nascimento_id);
        endereco = (TextView) findViewById(R.id.endereco_id);
        localizacao = (TextView) findViewById(R.id.localizacao_id);
    }
}
