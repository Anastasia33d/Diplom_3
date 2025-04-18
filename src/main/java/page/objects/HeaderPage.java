package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage {
    private final By personalAccountButton = By.xpath("//a[.//p[normalize-space(text())='Личный Кабинет']]");
    private final By constructorButton = By.xpath("//a[.//p[normalize-space(text())='Конструктор']]");
    private final By logo = By.xpath("//div[contains(@class, 'AppHeader_header__logo')]//a[@href='/']");

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    @Step("Клик по кнопке «Личный кабинет»")
    public void clickPersonalAccountButton() {
        clickOnElement(personalAccountButton);
    }

    @Step("Клик по кнопке «Конструктор»")
    public void clickConstructorButton() {
        clickOnElement(constructorButton);
    }

    @Step("Клик по логотипу 'stellar burgers'")
    public void clickLogo() {
        clickOnElement(logo);
    }
}

