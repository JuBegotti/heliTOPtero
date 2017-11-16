package com.networks.test.esi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.networks.test.esi.BD.BDFuncoesUsuario;
import com.networks.test.esi.BD.BDTabelas;
import com.networks.test.esi.BD.Usuario;
import com.networks.test.esi.auxiliares.UsuarioAtivo;

public class InicioActivity extends AppCompatActivity implements View.OnClickListener{

    private Button perfil;
    private Button inserir;
    private Button buscar;
    private Button relatorio;
    Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        usuario = BDFuncoesUsuario.buscaUsuario(UsuarioAtivo.email,this);

        initViews();
        initListeners();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bot_perf_inicio:
                Intent accountsIntent = new Intent(this, PerfilActivity.class);
                accountsIntent.putExtra(BDTabelas.TabelaUsuario._ID, usuario.getId());
                accountsIntent.putExtra(BDTabelas.TabelaUsuario._NOME, usuario.getNome());
                accountsIntent.putExtra(BDTabelas.TabelaUsuario._SOBRENOME, usuario.getSobrenome());
                accountsIntent.putExtra(BDTabelas.TabelaUsuario._FUNCAO, usuario.getFuncao());
                accountsIntent.putExtra(BDTabelas.TabelaUsuario._EMAIL, usuario.getEmail());
                accountsIntent.putExtra(BDTabelas.TabelaUsuario._DATA_NASCIMENTO, usuario.getNascimento());
                accountsIntent.putExtra(BDTabelas.TabelaUsuario._ENDERECO, usuario.getEndereco());
                accountsIntent.putExtra(BDTabelas.TabelaUsuario._CEP_CIDADE_ESTADO, usuario.getCep_cidade_estado());
                startActivity(accountsIntent);
                break;
            case R.id.bot_inserir_inicio:
                startActivity(new Intent(this, InserirInventarioActivity.class));
                break;
            case R.id.bot_busc_inicio:
                startActivity(new Intent(this, BuscarInventarioActivity.class));
                break;
            case R.id.bot_relatorio_inicio:
                startActivity(new Intent(this, RelatorioActivity.class));
                break;
            default:
                break;
        }
    }

    private void initListeners() {
        perfil.setOnClickListener(this);
        inserir.setOnClickListener(this);
        buscar.setOnClickListener(this);
        relatorio.setOnClickListener(this);
    }

    private void initViews() {
        perfil = (Button) findViewById(R.id.bot_perf_inicio);
        inserir = (Button) findViewById(R.id.bot_inserir_inicio);
        buscar = (Button) findViewById(R.id.bot_busc_inicio);
        relatorio = (Button) findViewById(R.id.bot_relatorio_inicio);
    }
}
