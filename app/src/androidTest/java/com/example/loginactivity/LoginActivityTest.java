package com.example.loginactivity;

import android.content.Intent;

import androidx.test.rule.ActivityTestRule;

import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class LoginActivityTest {

    private ActivityTestRule<LoginActivity> activityTestRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void verificaSeEditTextLoginEhMostrado () {
        activityTestRule.launchActivity(new Intent());
        onView(withId(R.id.edtLogin)).check(matches(isDisplayed()));
    }

    @Test
    public void verificaSeMensagemDeErroEhMostradaParaCampoVazio () {
        activityTestRule.launchActivity(new Intent());
        onView(withId(R.id.btnLogar)).check(matches(isDisplayed())).perform(click());
        onView(withText("Por favor, verifique Login ou Senha!")).check(matches(isDisplayed()));
    }

    @Test
    public void verificaLoginBemSucedido () {
        activityTestRule.launchActivity(new Intent());
        onView(withId(R.id.edtLogin)).perform(typeText("genius"),closeSoftKeyboard());
        onView(withId(R.id.edtSenha)).perform(typeText("batata"),closeSoftKeyboard());
        onView(withId(R.id.btnLogar)).check(matches(isDisplayed())).perform(click());
        onView(withText("Logado com sucesso!")).check(matches(isDisplayed()));
    }

}