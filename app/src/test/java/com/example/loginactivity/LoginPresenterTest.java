package com.example.loginactivity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class LoginPresenterTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    public void verificaSeTentativaDeLoginExcedeuEMetodoDeViewFoiChamado () {
        LoginView loginView = mock(LoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);
        loginPresenter.fazLogin("genius", "erro");
        loginPresenter.fazLogin("genius", "erro");
        loginPresenter.fazLogin("genius", "erro");
        loginPresenter.fazLogin("genius", "erro");
        verify(loginView).mostraMensagemDeErroParaTentativaDeLoginMaxima();
    }

    @Test
    public void verificaSeLoginSenhaEstaoCorretos () {
        LoginView loginView = mock(LoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);
        loginPresenter.fazLogin("genius", "batata");
        verify(loginView).mostraMensagemDeLoginBemSucedido();
    }

    @Test
    public void verificaSeLoginSenhaEstaoIncorretos () {
        LoginView loginView = mock(LoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);
        loginPresenter.fazLogin("dougras", "chupapinga");
        verify(loginView).mostraMensagemDeErroParaLoginSenha();
    }

    @AfterEach
    void tearDown() {
    }
}