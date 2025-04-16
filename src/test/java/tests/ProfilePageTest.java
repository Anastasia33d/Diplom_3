package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageObject.HeaderPage;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.ProfilePage;

import static constants.PageUrls.Auth.LOGIN;
import static constants.PageUrls.Main.MAIN;
import static constants.PageUrls.Profile.PROFILE;
import static org.junit.Assert.assertTrue;

public class ProfilePageTest extends BaseTest {
    private final String expectedOrderButtonMessage = "Ожидался показ кнопки 'Оформить заказ'";
    @Test
    @DisplayName("Переход в личный кабинет")
    public void clickPersonalAccountSuccess() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickPersonalAccountButton();
        mainPage.waitForUrl(LOGIN);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser(user);
        loginPage.waitForUrl(MAIN);

        headerPage.clickPersonalAccountButton();
        mainPage.waitForUrl(PROFILE);

        ProfilePage profilePage = new ProfilePage(driver);

        assertTrue("Ожидался показ инпута имени", profilePage.isNameInputVisible());
    }

    @Test
    @DisplayName("Переход из личного кабинета по клику на конструктор")
    public void clickConstructorButtonSuccess() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.loginUser(user);
        loginPage.waitForUrl(MAIN);

        MainPage mainPage = new MainPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickPersonalAccountButton();
        mainPage.waitForUrl(PROFILE);

        headerPage.clickConstructorButton();
        mainPage.waitForUrl(MAIN);

        assertTrue(expectedOrderButtonMessage, mainPage.isOrderButtonVisible());
    }

    @Test
    @DisplayName("Переход из личного кабинета по клику на логотип 'stellar burgers'")
    public void clickLogoSuccess() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.loginUser(user);
        loginPage.waitForUrl(MAIN);

        MainPage mainPage = new MainPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickPersonalAccountButton();
        mainPage.waitForUrl(PROFILE);

        headerPage.clickLogo();
        mainPage.waitForUrl(MAIN);

        assertTrue(expectedOrderButtonMessage, mainPage.isOrderButtonVisible());
    }
}
