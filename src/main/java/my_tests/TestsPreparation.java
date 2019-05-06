package my_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestsPreparation {

    public static WebDriver driver;

    public static ScreenCreator screen;

    public static String SCREEN_PATH = new File("screenshots").getAbsolutePath();

    public String saveScreen() {
        Date dat = new Date();
        DateFormat formatForDateNow = new SimpleDateFormat("yyyy-mm-dd hh.mm.ss");
        screen.pageScreen(formatForDateNow.format(dat));
        return formatForDateNow.format(dat);
    }

    @BeforeMethod
    public void preparation() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("start-fullscreen");
        options.addArguments("disable-infobars");
        options.addArguments("disable-extensions");
        options.addArguments("disable-gpu");
        options.addArguments("disable-dev-shm-usage");
        options.addArguments("no-sandbox");
        options.setExperimentalOption("useAutomationExtension", false);
        driver = new ChromeDriver(options);
        screen = new ScreenCreator(driver, SCREEN_PATH);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.get("https://beru.ru");
    }

    @AfterMethod
    public void clear() {
        if (driver.findElement(By.cssSelector(".header2-nav__user"))
                .getAttribute("textContent").contains("Мой профиль")) {
            driver.findElement(By.cssSelector(".header2-nav__user")).click();
            driver.findElement(By.cssSelector("[class*='type_logout']")).click();
        }
        driver.quit();
    }
}
