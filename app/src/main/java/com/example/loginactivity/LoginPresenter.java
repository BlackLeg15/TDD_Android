package com.example.loginactivity;

public class LoginPresenter {
    private static final int TENTATIVA_DE_LOGIN_MAXIMA = 3;
    private int loginAttempt;
    LoginView loginView;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
    }

    public int incrementaTentativaDeLogin() {
        this.loginAttempt += 1;
        return this.loginAttempt;
    }

    public boolean tentativaDeLoginEstaExcedida() {
        return loginAttempt >= TENTATIVA_DE_LOGIN_MAXIMA;
    }

    public void fazLogin(String login, String senha) {
        if(tentativaDeLoginEstaExcedida()) {
            loginView.mostraMensagemDeErroParaTentativaDeLoginMaxima();
            return;
        }
        if(login.equals("genius") && senha.equals("batata")){
            loginView.mostraMensagemDeLoginBemSucedido();
            return;
        }

        incrementaTentativaDeLogin();
        loginView.mostraMensagemDeErroParaLoginSenha();
    }
}
