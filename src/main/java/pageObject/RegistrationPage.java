package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import models.User;
import static constants.PageUrls.Auth.REGISTER;

public class RegistrationPage extends BasePage {
    private final By emailInput = By.xpath("//label[text()='Email']/../input");
    private final By passwordInput = By.xpath("//label[text()='Пароль']/../input");
    private final By errorMsg = By.xpath("//p[text()='Некорректный пароль']");
    private final By nameInput = By.xpath("//label[text()='Имя']/../input");
    private final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By loginButton = By.xpath("//a[text()='Войти']");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы регистрации")
    public void openPage() {
        driver.get(REGISTER);
    }

    @Step("Заполнение формы регистрации")
    public void fillRegistrationForm(User user) {
        setUserName(user.getName());
        setUserEmail(user.getEmail());
        setUserPassword(user.getPassword());
    }

    @Step("Вводим Email")
    public void setUserEmail(String email) {
        inputText(emailInput, email);
    }

    @Step("Вводим Пароль")
    public void setUserPassword(String password) {
        inputText(passwordInput, password);
    }

    @Step("Вводим Имя")
    public void setUserName(String userName) {
        inputText(nameInput, userName);
    }

    @Step("Нажимаем на кнопку Зарегистрироваться")
    public void clickOnRegisterButton() {
        clickOnElement(registerButton);
    }

    @Step("Нажимаем на кнопку Войти")
    public void clickOnLoginButton() {
        clickOnElement(loginButton);
    }

    @Step("Получение сообщения об ошибке короткого пароля")
    public String getIncorrectPasswordMessage() {
        return driver.findElement(errorMsg).getText();
    }
}