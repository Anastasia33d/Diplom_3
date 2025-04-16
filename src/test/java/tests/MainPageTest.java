package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageObject.MainPage;

import static org.junit.Assert.assertTrue;

public class MainPageTest extends BaseTest {
    @Test
    @DisplayName("Переход в раздел 'Булки'")
    public void testBunsSectionVisible() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();

        assertTrue("Таб 'Булки' не является активным", mainPage.isBunsTabActive());
        assertTrue("Заголовок 'Булки' не отображается", mainPage.isBunsHeaderVisible());
    }

    @Test
    @DisplayName("Переход в раздел 'Соусы'")
    public void testSaucesSectionVisible() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();

        mainPage.clickSaucesTab();

        assertTrue("Таб 'Соусы' не является активным", mainPage.isSaucesTabActive());
        assertTrue("Заголовок 'Соусы' не отображается", mainPage.isSaucesHeaderVisible());
    }

    @Test
    @DisplayName("Переход в раздел 'Начинки'")
    public void testToppingsSectionVisible() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();

        mainPage.clickToppingsTab();

        assertTrue("Таб 'Начинки' не является активным", mainPage.isToppingsTabActive());
        assertTrue("Заголовок 'Начинки' не отображается", mainPage.isToppingsHeaderVisible());
    }
}
