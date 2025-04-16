package tests;

import io.restassured.response.Response;
import models.User;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import driver.WebDriverFactory;
import utils.UserGenerator;

import static utils.UserTestUtils.*;

public class BaseTest {
    protected WebDriver driver;
    protected Response userCreateResponse;
    protected User user;

    @Before
    public void startUp() {
        driver = WebDriverFactory.createWebDriver();
        user = UserGenerator.getRandomUniqUser();
        userCreateResponse = createUserStep(user);
    }

    @After
    public void teardown() {
        clearUserCreateResponse(userCreateResponse);
        driver.quit();
    }
}