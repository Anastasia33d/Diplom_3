package page.objects;

import static constants.PageUrls.Auth.LOGIN;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import models.User;

public class LoginPage extends BasePage {
    private final By emailField = By.xpath(".//div[label[text()='Email']]//input");
    private final By enterButton = By.xpath(".//button[text()='Войти']");
    private final By passwordField = By.xpath(".//div[label[text()='Пароль']]//input");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы Логина")
    public void openPage() {
        driver.get(LOGIN);
    }

    @Step("Клик по кнопке Войти")
    public void clickEnterButton() {
        clickOnElement(enterButton);
    }

    @Step("Проверка видимости кнопки Войти")
    public boolean isEnterButtonVisible() {
        return isElementVisible(enterButton);
    }

    @Step("Вводим Пароль")
    public void setUserPassword(String password) {
        inputText(passwordField, password);
    }

    @Step("Вводим Email")
    public void setUserEmail(String email) {
        inputText(emailField, email);
    }

    @Step("Логин пользователя через форму")
    public void loginUser(User user) {
        setUserEmail(user.getEmail());
        setUserPassword(user.getPassword());
        clickEnterButton();
    }
}