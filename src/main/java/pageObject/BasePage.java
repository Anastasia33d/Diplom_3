package pageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected final int DEFAULT_TIMEOUT = 7;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ввод текста '{text}' в элемент с локатором: {locator}")
    public void inputText(By locator, String text) {
        waitForVisibility(locator);
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    @Step("Нажатие на элемент с локатором: {locator}")
    public void clickOnElement(By locator) {
        WebElement clickableElement = waitForElementToBeClickable(locator);
        clickableElement.click();
    }

    @Step("Ожидание, что элемент станет кликабельным: {locator}")
    public WebElement waitForElementToBeClickable(By locator) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                    .until(ExpectedConditions.elementToBeClickable(locator));
        } catch (TimeoutException e) {
            throw new AssertionError("Element is not clickable: " + locator, e);
        }
    }

    @Step("Ожидание перехода на URL: {expectedUrl}")
    public void waitForUrl(String expectedUrl) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                    .until(ExpectedConditions.urlToBe(expectedUrl));
        } catch (TimeoutException e) {
            throw new AssertionError("URL does not match expected: " + expectedUrl, e);
        }
    }

    @Step("Ожидание появления элемента с локатором: {locator}")
    public void waitForVisibility(By locator) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            throw new AssertionError("Element not found: " + locator, e);
        }
    }

    @Step("Проверка видимости элемента с локатором: {locator}")
    public boolean isElementVisible(By locator) {
        try {
            waitForVisibility(locator);
            return true;
        } catch (AssertionError e) {
            return false;
        }
    }

    @Step("Искусственная задержка на {millis} мс")
    public void waitFixedMillis(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Delay interrupted", e);
        }
    }
}