package com.networks.test.esi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.MenuItem;
import android.view.View;
import com.networks.test.esi.BD.BDFuncoesUsuario;
import com.networks.test.esi.BD.Usuario;
import com.networks.test.esi.auxiliares.InputValidation;
import com.networks.test.esi.auxiliares.Mensagens;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = RegisterActivity.this;

    private NestedScrollView nestedScrollView;

    private TextInputLayout textInputLayoutName;
    private TextInputLayout textInputLayoutLastName;
    private TextInputLayout textInputLayoutNascimento;
    private TextInputLayout textInputLayoutEndereco;
    private TextInputLayout textInputLayoutLocalizacao;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;
    private TextInputLayout textInputLayoutConfirmPassword;

    private TextInputEditText textInputEditTextName;
    private TextInputEditText textInputEditTextLastName;
    private TextInputEditText textInputEditTextNascimento;
    private TextInputEditText textInputEditTextEndereco;
    private TextInputEditText textInputEditTextLocalizacao;
    private TextInputEditText textInputEditTextEmail;
    private TextInputEditText textInputEditTextPassword;
    private TextInputEditText textInputEditTextConfirmPassword;

    private AppCompatButton appCompatButtonRegister;
    private AppCompatTextView appCompatTextViewLoginLink;

    Usuario usuario;
    private InputValidation inputValidation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(R.string.cadastro_string);

        initViews();
        initListeners();
        initObjects();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, LoginActivity.class));
                finishAffinity();
                break;
            default:break;
        }
        return true;
    }

    private void initViews() {
        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);

        textInputLayoutName = (TextInputLayout) findViewById(R.id.textInputLayoutName);
        textInputLayoutLastName = (TextInputLayout) findViewById(R.id.textInputLayoutLastName);
        textInputLayoutNascimento = (TextInputLayout) findViewById(R.id.textInputLayoutDate);
        textInputLayoutEndereco = (TextInputLayout) findViewById(R.id.textInputLayoutEndereco);
        textInputLayoutLocalizacao = (TextInputLayout) findViewById(R.id.textInputLayoutLocalizacao);
        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);
        textInputLayoutConfirmPassword = (TextInputLayout) findViewById(R.id.textInputLayoutConfirmPassword);

        textInputEditTextName = (TextInputEditText) findViewById(R.id.textInputEditTextName);
        textInputEditTextLastName = (TextInputEditText) findViewById(R.id.textInputEditTextLastName);
        textInputEditTextNascimento = (TextInputEditText) findViewById(R.id.textInputEditTextDate);
        textInputEditTextEndereco = (TextInputEditText) findViewById(R.id.textInputEditTextEndereco);
        textInputEditTextLocalizacao = (TextInputEditText) findViewById(R.id.textInputEditTextLocalizacao);
        textInputEditTextEmail = (TextInputEditText) findViewById(R.id.textInputEditTextEmail);
        textInputEditTextPassword = (TextInputEditText) findViewById(R.id.textInputEditTextPassword);
        textInputEditTextConfirmPassword = (TextInputEditText) findViewById(R.id.textInputEditTextConfirmPassword);

        appCompatButtonRegister = (AppCompatButton) findViewById(R.id.appCompatButtonRegister);

        appCompatTextViewLoginLink = (AppCompatTextView) findViewById(R.id.appCompatTextViewLoginLink);

    }

    private void initListeners() {
        appCompatButtonRegister.setOnClickListener(this);
        appCompatTextViewLoginLink.setOnClickListener(this);

    }

    private void initObjects() {
        inputValidation = new InputValidation(activity);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.appCompatButtonRegister:
                postDataToSQLite();
                break;

            case R.id.appCompatTextViewLoginLink:
                finish();
                break;
        }
    }

    private void postDataToSQLite() {
        if (!inputValidation.isInputEditTextFilled(textInputEditTextName, textInputLayoutName, getString(R.string.error_invalid_name)))
            return;
        if (!inputValidation.isInputEditTextFilled(textInputEditTextLastName, textInputLayoutLastName, getString(R.string.error_invalid_last_name)))
            return;
        if (!inputValidation.isInputEditTextFilled(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_invalid_email)))
            return;
        if (!inputValidation.isInputEditTextEmail(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_invalid_email)))
            return;
        if (!inputValidation.isInputEditTextFilled(textInputEditTextPassword, textInputLayoutPassword, getString(R.string.error_invalid_password)))
            return;
        if (!inputValidation.isInputEditTextMatches(textInputEditTextPassword, textInputEditTextConfirmPassword,
                textInputLayoutConfirmPassword, getString(R.string.error_password_match)))
            return;

        if (!BDFuncoesUsuario.checarUsuarioEmail(textInputEditTextEmail.getText().toString().trim(),this)) {
            usuario = new Usuario(
                    textInputEditTextName.getText().toString().trim(),
                    textInputEditTextLastName.getText().toString().trim(),
                    "Funcionário",
                    textInputEditTextNascimento.getText().toString().trim(),
                    textInputEditTextEndereco.getText().toString().trim(),
                    textInputEditTextLocalizacao.getText().toString().trim(),
                    textInputEditTextEmail.getText().toString().trim(),
                    textInputEditTextPassword.getText().toString().trim()
                    );

            BDFuncoesUsuario.addUsuario(this, usuario);

            Snackbar.make(nestedScrollView, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();
            emptyInputEditText();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);

        } else {
            Mensagens.mensagem(this,R.string.erro_titulo,R.string.error_email_exists);
        }
    }

    private void emptyInputEditText() {
        textInputEditTextName.setText(null);
        textInputEditTextEmail.setText(null);
        textInputEditTextPassword.setText(null);
        textInputEditTextConfirmPassword.setText(null);
    }
}