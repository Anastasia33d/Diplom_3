package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageObject.HeaderPage;
import pageObject.LoginPage;
import pageObject.ProfilePage;

import static constants.PageUrls.Auth.LOGIN;
import static constants.PageUrls.Main.MAIN;
import static constants.PageUrls.Profile.PROFILE;
import static org.junit.Assert.assertTrue;

public class LogoutTest extends BaseTest {
    @Test
    @DisplayName("выход по кнопке «Выход» в личном кабинете.")
    public void clickConstructorButtonSuccess() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.loginUser(user);
        loginPage.waitForUrl(MAIN);

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickPersonalAccountButton();
        headerPage.waitForUrl(PROFILE);

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickLogoutButton();
        profilePage.waitForUrl(LOGIN);

        assertTrue("Ожидался показ кнопки 'Войти'", loginPage.isEnterButtonVisible());
    }
}
