package my_tests;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class Test1  {

    public static WebDriver driver;

    public static ScreenCreator screen;

    @BeforeTest
    public void preparation() {
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
        screen = new ScreenCreator(driver, "C:\\Users\\Heretic\\IdeaProjects\\sample");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        driver.get("https://beru.ru");

        WebElement el = driver.findElement(By.cssSelector("[class*='_1ZYDKa22GJ']"));
        screen.saveAllureScreenshot(el, "2534534");
        el.click();
    }

    @AfterTest
    public void clear() {
        driver.quit();
    }


    @Test
    public void test_1(ITestContext testContext) {

        WebElement el = driver.findElement(By.cssSelector(".header2-nav__user"));
        screen.saveAllureScreenshot(el, "1");
        el.click();

        WebElement logInFotm = (new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".passp-login-form"))));

        el = logInFotm.findElement(By.name("login"));

        screen.saveAllureScreenshot(logInFotm.findElement(By.name("login")), "2");

        logInFotm.findElement(By.name("login")).click();
        logInFotm.findElement(By.name("login")).sendKeys("Naglui.eretick@yandex.ru");
        logInFotm.findElement(By.name("login")).sendKeys(Keys.ENTER);

        WebElement PassForm = (new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".passp-password-form"))));

        el = PassForm.findElement(By.name("passwd"));
        screen.saveAllureScreenshot(el, "3");

        el.sendKeys("28301230aaMP" + "\n");


        WebElement note = driver.findElement(By.cssSelector("[class*='header2-nav__user']"));

        el = note.findElement(By.cssSelector("[class*='__text']"));
        screen.saveAllureScreenshot(el, "4");
        Assert.assertEquals(el.getAttribute("textContent"), "Мой профиль");

        (new Actions(driver)).moveToElement(note).build().perform();

        el = driver.findElement(By.cssSelector("[class*='user-menu__email']"));
        screen.saveAllureScreenshot(el, "5");
        Assert.assertEquals(el.getAttribute("textContent"), "Naglui.eretick@yandex.ru");
    }
}