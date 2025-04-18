package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static constants.PageUrls.Auth.FORGOT_PASSWORD;

public class ForgotPasswordPage extends BasePage {
    private final By loginButton = By.xpath("//a[text()='Войти']");

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы восстановления пароля")
    public void openPage() {
        driver.get(FORGOT_PASSWORD);
    }

    @Step("Нажимаем на кнопку Войти")
    public void clickOnLoginButton() {
        clickOnElement(loginButton);
    }
}
