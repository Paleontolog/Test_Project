package my_tests;
import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import javax.inject.Inject;
import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;



public class Test1 {
    public static WebDriver driver;

    @BeforeTest
    public void preparation() {
        //Указываем путь к драйверу
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("start-fullscreen");
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("disable-extensions"); // disabling extensions
        options.addArguments("disable-gpu"); // applicable to windows os only
        options.addArguments("disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("no-sandbox"); // Bypass OS security model
        options.setExperimentalOption("useAutomationExtension", false);
        driver = new ChromeDriver(options);

        // testContext.setAttribute("ScreenCreator", screen);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        driver.get("https://beru.ru");

        WebElement el = driver.findElement(By.cssSelector("[class*='_1ZYDKa22GJ']"));

        el.click();
    }

    @AfterTest
    public void clear() {
        driver.quit();
    }
    
    @Test
    public void test_1(ITestContext testContext) {

        WebElement el = driver.findElement(By.cssSelector(".header2-nav__user"));

        el.click();

        WebElement logInFotm = (new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".passp-login-form"))));

        el = logInFotm.findElement(By.name("login"));



        logInFotm.findElement(By.name("login")).click();
        logInFotm.findElement(By.name("login")).sendKeys("Naglui.eretick@yandex.ru");
        logInFotm.findElement(By.name("login")).sendKeys(Keys.ENTER);

        WebElement PassForm = (new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".passp-password-form"))));

        el = PassForm.findElement(By.name("passwd"));


        el.sendKeys("28301230aaMP" + "\n");


        WebElement note = driver.findElement(By.cssSelector("[class*='header2-nav__user']"));

        el = note.findElement(By.cssSelector("[class*='__text']"));

        Assert.assertEquals(el.getAttribute("textContent"), "Мой профиль");


        (new Actions(driver)).moveToElement(note).build().perform();

        el = driver.findElement(By.cssSelector("[class*='user-menu__email']"));

        Assert.assertEquals(el.getAttribute("textContent"), "Naglui.eretick@yandex.ru");
    }
}