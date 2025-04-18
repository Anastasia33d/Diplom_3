package tests;

import driver.WebDriverFactory;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import page.objects.RegistrationPage;
import utils.UserGenerator;
import utils.UserTestUtils;

import static constants.PageUrls.Auth.LOGIN;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static utils.UserTestUtils.clearUserCreateResponse;

public class RegistrationTest {
    private RegistrationPage registrationPage;
    protected WebDriver driver;
    protected Response userLoginResponse;
    protected User user = UserGenerator.getRandomUniqUser();

    @Before
    @Step("Открытие страницы регистрации")
    public void init() {
        driver = WebDriverFactory.createWebDriver();
        registrationPage = new RegistrationPage(driver);
        registrationPage.openPage();
    }

    @After
    public void teardown() {
        clearUserCreateResponse(userLoginResponse);
        driver.quit();
    }

    @Test
    @DisplayName("Тест успешной регистрации")
    public void registerNewUserSuccess() {
        registrationPage.fillRegistrationForm(user);
        registrationPage.clickOnRegisterButton();
        registrationPage.waitForUrl(LOGIN);

        userLoginResponse = UserTestUtils.loginUserStep(user);
        int WAIT_UNTIL_USER_CREATED = 2000;
        registrationPage.waitFixedMillis(WAIT_UNTIL_USER_CREATED);
        String accessToken = userLoginResponse.jsonPath().getString("accessToken");
        assertNotNull("Не удалось зарегестрировать пользователя, поле accessToken отсутствует или его значение равно null", accessToken);
    }

    @Test
    @DisplayName("Негативная регистрация с коротким паролем")
    public void registerNewUserWithShortPasswordFail() {
        String password = "abc";
        user.setPassword(password);

        registrationPage.fillRegistrationForm(user);
        registrationPage.clickOnRegisterButton();

        assertEquals("Некорректный пароль", registrationPage.getIncorrectPasswordMessage());
    }
}
