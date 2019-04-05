package my_tests;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;


public class Test1 extends TestsPreparation{

    @Test
    public void test_1(ITestContext testContext) {

        /*WebElement element = driver.findElement(By.cssSelector(".header2-nav__user"));
        screen.saveAllureScreenshot(element, "1");
        element.click();
        */
        WebElement element = findWithScreen(driver, By.cssSelector(".header2-nav__user"));
        element.click();

        WebElement logInFotm = (new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".passp-login-form"))));


        /*element = logInFotm.findElement(By.name("login"));

        screen.saveAllureScreenshot(logInFotm.findElement(By.name("login")), "2");

        logInFotm.findElement(By.name("login")).click();
        logInFotm.findElement(By.name("login")).sendKeys("Naglui.eretick@yandex.ru");
        logInFotm.findElement(By.name("login")).sendKeys(Keys.ENTER);
        */
        element = findWithScreen(logInFotm, By.name("login"));
        element.click();
        element.sendKeys("Naglui.eretick@yandex.ru");
        element.sendKeys(Keys.ENTER);

        /*
        WebElement PassForm = (new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".passp-password-form"))));

        element = PassForm.findElement(By.name("passwd"));

        screen.saveAllureScreenshot(element, "3");
        */

        WebElement PassForm = (new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".passp-password-form"))));

        element = findWithScreen(PassForm, By.name("passwd"));

        element.sendKeys("28301230aaMP" + "\n");


        WebElement note = driver.findElement(By.cssSelector("[class*='header2-nav__user']"));

        /*element = note.findElement(By.cssSelector("[class*='__text']"));
        screen.saveAllureScreenshot(element, "4");
        Assert.assertEquals(element.getAttribute("textContent"), "Мой профиль");
        */

        element = findWithScreen(note, By.cssSelector("[class*='__text']"));

        Assert.assertEquals(element.getAttribute("textContent"), "Мой профиль");

        (new Actions(driver)).moveToElement(note).build().perform();

        /*element = driver.findElement(By.cssSelector("[class*='user-menu__email']"));
        screen.saveAllureScreenshot(element, "5");
        Assert.assertEquals(element.getAttribute("textContent"), "Naglui.eretick@yandex.ru");*/

        element = findWithScreen(driver, By.cssSelector("[class*='user-menu__email']"));

        Assert.assertEquals(element.getAttribute("textContent"), "Naglui.eretick@yandex.ru");
    }
}