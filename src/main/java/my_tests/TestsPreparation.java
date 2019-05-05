package my_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

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
        screen = new ScreenCreator(driver, SCREEN_PATH);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.get("https://beru.ru");
        //Закрытие рекламы (реклама исчезла с сайта, закрывать нечего)
        //WebElement el = findAndAllureSc(driver, By.cssSelector("[class*='_1ZYDKa22GJ']"));
        //el.click();
    }

    @AfterMethod
    public void clear() {
        driver.get("https://beru.ru/logout?retpath=https%3A%2F%2Fberu.ru%2F%3Fncrnd%3D5032%26loggedin%3D1");
        driver.quit();
    }
}
