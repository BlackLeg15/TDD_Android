package com.example.loginactivity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private EditText edtLogin;
    private EditText edtSenha;
    private Button btnLogar;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializaPresenter();
        inicializaViews();
    }

    private void inicializaPresenter () {
        loginPresenter = new LoginPresenter(this);
    }

    private void inicializaViews () {
        edtLogin = findViewById(R.id.edtLogin);
        edtSenha = findViewById(R.id.edtSenha);
        btnLogar = findViewById(R.id.btnLogar);
        btnLogar.setOnClickListener((view)-> loginPresenter.fazLogin(edtLogin.getText().toString().trim(),
                edtSenha.getText().toString().trim()));
    }

    @Override
    public void mostraMensagemDeErroParaLoginSenha() {
        Snackbar.make(edtSenha, "Por favor, verifique Login ou Senha!", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void mostraMensagemDeErroParaTentativaDeLoginMaxima() {
        Snackbar.make(btnLogar, "Você excedeu o limite de tentativas do login!", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void mostraMensagemDeLoginBemSucedido() {
        Snackbar.make(btnLogar, "Logado com sucesso!", Snackbar.LENGTH_LONG).show();
    }
}
