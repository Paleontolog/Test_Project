package my_tests;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;



public class Test1 {

    public WebDriver driver;

    @BeforeClass
    public void preparation() {
        //Указываем путь к драйверу
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("start-maximized");
        //options.addArguments("start-fullscreen");
        driver = new ChromeDriver(options);
    }


    @AfterClass
    public void clear() {
        driver.get("https://beru.ru/logout?retpath=https%3A%2F%2Fberu.ru%2F%3Fncrnd%3D4720%26loggedin%3D1");
        driver.quit();
    }


    @Test
    public void test1() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://beru.ru");
        ScreenCreator screen = new ScreenCreator(driver);
        screen.pageScreen(driver.findElement(By.className("_1ZYDKa22GJ")),
                "C:\\Users\\Heretic\\IdeaProjects\\huita");

        // driver.findElement(By.cssSelector("*")).sendKeys(Keys.ESCAPE);
        driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);

        screen.pageScreen(driver.findElement(By.className("header2-nav__user")),
                "C:\\Users\\Heretic\\IdeaProjects\\huita1");
        driver.findElement(By.className("header2-nav__user")).click();
        WebElement logInFotm = (new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.className("passp-login-form"))));

        screen.pageScreen(logInFotm.findElement(By.name("login")),
                "C:\\Users\\Heretic\\IdeaProjects\\huita2");

        logInFotm.findElement(By.name("login")).click();
        logInFotm.findElement(By.name("login")).sendKeys("Naglui.eretick@yandex.ru");
        logInFotm.findElement(By.name("login")).sendKeys(Keys.ENTER);

        WebElement PassForm = (new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.className("passp-password-form"))));

        screen.pageScreen(PassForm.findElement(By.name("passwd")),
                "C:\\Users\\Heretic\\IdeaProjects\\huita3");

        PassForm.findElement(By.name("passwd")).sendKeys("28301230aaMP" + "\n");
        WebElement all = driver.findElement(By.cssSelector("[class*='header2-nav__user']"));
        List<WebElement> a = all.findElements(By.cssSelector("*"));
        for (WebElement elem : a) {
            try {
                System.out.println(elem.getAttribute("textContent"));
            }
            catch (Exception e) {
                System.out.print("Error");
            }
        }

         System.out.println(driver.findElement(By.cssSelector("[class*='user-menu__email']"))
             .getAttribute("textContent"));

    }

}
