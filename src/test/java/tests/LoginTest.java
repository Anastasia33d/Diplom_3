package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pageObject.*;

import static constants.PageUrls.Auth.LOGIN;
import static constants.PageUrls.Main.MAIN;
import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {
    protected LoginPage loginPage;
    private final String expectedOrderButtonMessage = "Ожидался показ кнопки 'Оформить заказ'";
    @Before
    public void init() {
        loginPage = new LoginPage(driver);
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void loginThroughLoginButtonSuccess() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.clickLoginButton();

        loginPage.waitForUrl(LOGIN);
        loginPage.loginUser(user);
        loginPage.waitForUrl(MAIN);

        assertTrue(expectedOrderButtonMessage, mainPage.isOrderButtonVisible());
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void loginThroughPersonalAccountButtonSuccess() {
        MainPage mainPage = new MainPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);
        mainPage.openPage();
        headerPage.clickPersonalAccountButton();

        loginPage.waitForUrl(LOGIN);
        loginPage.loginUser(user);
        loginPage.waitForUrl(MAIN);

        assertTrue(expectedOrderButtonMessage, mainPage.isOrderButtonVisible());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginThroughRegistrationLoginButtonSuccess() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        MainPage mainPage = new MainPage(driver);
        registrationPage.openPage();
        registrationPage.clickOnLoginButton();

        loginPage.waitForUrl(LOGIN);
        loginPage.loginUser(user);
        loginPage.waitForUrl(MAIN);

        assertTrue(expectedOrderButtonMessage, mainPage.isOrderButtonVisible());
    }

    @Test
    @DisplayName("вход через кнопку в форме восстановления пароля.")
    public void loginThroughResetPasswordFormLoginButtonSuccess() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        MainPage mainPage = new MainPage(driver);
        forgotPasswordPage.openPage();
        forgotPasswordPage.clickOnLoginButton();

        loginPage.waitForUrl(LOGIN);
        loginPage.loginUser(user);
        loginPage.waitForUrl(MAIN);

        assertTrue(expectedOrderButtonMessage, mainPage.isOrderButtonVisible());
    }
}