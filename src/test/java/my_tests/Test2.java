package my_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Test2 extends TestsPreparation {

    @Parameters("cityName")
    @Test
    public void test(String cityName) {

        WebElement element = driver.findElement(By.cssSelector("[class*='__region'] [class*='__inner']"));

        screen.saveAllureScreenshot(element, "2");
        element.click();

        WebElement CityForm = (new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .cssSelector("[class*='region-select-form']"))));

        screen.saveAllureScreenshot(CityForm, "3");

        WebElement city = CityForm.findElement(By
                .cssSelector("[class*='region-suggest'] [class*='input__control']"));

        screen.saveAllureScreenshot(city, "4");

        city.click();


        city.sendKeys(cityName);

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(city));

        city.sendKeys(Keys.ENTER);
        city.sendKeys(Keys.ENTER);

        driver.navigate().refresh();

        element = driver.findElement(By.cssSelector("[class*='__region'] [class*='__inner']"));

        screen.saveAllureScreenshot(element, "4");

        Assert.assertEquals(element.getAttribute("textContent"), cityName);

        //=================================================================================================
        element = driver.findElement(By.className("header2-nav__user"));
        screen.saveAllureScreenshot(element, "5");
        element.click();
        WebElement logInFotm = (new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.className("passp-login-form"))));

        element = logInFotm.findElement(By.name("login"));
        screen.saveAllureScreenshot(element, "6");

        element.click();
        element.sendKeys("Naglui.eretick@yandex.ru");
        element.sendKeys(Keys.ENTER);

        WebElement PassForm = (new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.className("passp-password-form"))));

        element = PassForm.findElement(By.name("passwd"));
        element.sendKeys("28301230aaMP" + "\n");
        //==================================================================================================


        WebElement web = driver.findElement(By.className("header2-nav__user"));
        screen.saveAllureScreenshot(web, "7");

        (new Actions(driver)).moveToElement(web).build().perform();

        element = driver.findElement(By.cssSelector("[class*='item_type_addresses']"));
        screen.saveAllureScreenshot(web, "8");
        element.click();


        WebElement elem1 = driver.findElement(By
                .cssSelector("[class*='settings-list_type_region'] [class*='__inner']"));

        screen.saveAllureScreenshot(elem1, "9");

        WebElement elem2 = driver.findElement(By.cssSelector("[class*='__region']")).
                findElement(By.cssSelector("[class*='__inner']"));

        screen.saveAllureScreenshot(elem2, "10");

        Assert.assertEquals(elem1.getAttribute("textContent"), elem2.getAttribute("textContent"));
    }
}
