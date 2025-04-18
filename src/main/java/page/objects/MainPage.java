package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static constants.PageUrls.Main.MAIN;

public class MainPage extends BasePage {
    private final By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By orderButton = By.xpath("//button[normalize-space(text())='Оформить заказ']");
    private final By bunsTab = By.xpath("//div[span[text()='Булки']]");
    private final By bunsHeader = By.xpath("//h2[text()='Булки']");
    private final By saucesTab = By.xpath("//div[span[text()='Соусы']]");
    private final By saucesHeader = By.xpath("//h2[text()='Соусы']");
    private final By toppingsTab = By.xpath("//div[span[text()='Начинки']]");
    private final By toppingsHeader = By.xpath("//h2[text()='Начинки']");
    private final String CURRENT_TAB_CLASS = "tab_tab_type_current";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие главной страницы")
    public void openPage() {
        driver.get(MAIN);
    }

    @Step("Клик по табу «Булки»")
    public void clickBunsTab() {
        clickOnElement(bunsTab);
    }

    @Step("Клик по табу «Соусы»")
    public void clickSaucesTab() {
        clickOnElement(saucesTab);
    }

    @Step("Клик по табу «Начинки»")
    public void clickToppingsTab() {
        clickOnElement(toppingsTab);
    }

    @Step("Клик по кнопке «Войти в аккаунт»")
    public void clickLoginButton() {
        clickOnElement(loginButton);
    }

    @Step("Проверка видимости кнопки «Оформить заказ»")
    public boolean isOrderButtonVisible() {
        return isElementVisible(orderButton);
    }

    @Step("Проверка видимости заголовка «Булки»")
    public boolean isBunsHeaderVisible() {
        return isElementVisible(bunsHeader);
    }

    @Step("Проверка видимости заголовка «Соусы»")
    public boolean isSaucesHeaderVisible() {
        return isElementVisible(saucesHeader);
    }

    @Step("Проверка видимости заголовка «Начинки»")
    public boolean isToppingsHeaderVisible() {
        return isElementVisible(toppingsHeader);
    }

    @Step("Проверка, что таб «Булки» активен")
    public boolean isBunsTabActive() {
        WebElement bunsTabElement = driver.findElement(bunsTab);
        waitForCssClass(bunsTabElement, CURRENT_TAB_CLASS);

        return bunsTabElement.getAttribute("class").contains(CURRENT_TAB_CLASS);
    }

    @Step("Проверка, что таб «Соусы» активен")
    public boolean isSaucesTabActive() {
        String classes = driver.findElement(saucesTab).getAttribute("class");
        return classes.contains(CURRENT_TAB_CLASS);
    }
    @Step("Проверка, что таб «Начинки» активен")
    public boolean isToppingsTabActive() {
        String classes = driver.findElement(toppingsTab).getAttribute("class");
        return classes.contains(CURRENT_TAB_CLASS);
    }
}