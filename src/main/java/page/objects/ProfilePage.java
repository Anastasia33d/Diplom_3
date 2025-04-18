package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    private final By nameInput = By.xpath("//input[contains(@name, 'Name') and contains(@type, 'text')]");
    private final By exitButton = By.xpath("//button[text()='Выход']");

    @Step("Проверка видимости инпута «Имя»")
    public boolean isNameInputVisible() {
        return isElementVisible(nameInput);
    }

    @Step("Клик по кнопке «Выход»")
    public void clickLogoutButton() {
        clickOnElement(exitButton);
    }
}