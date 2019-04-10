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

@Listeners(TestListener.class)
public class Test2 extends TestsPreparation {

    @Parameters("cityName")
    @Test
    public void test_2(String cityName) {

        WebElement element = findAndAllureSc(driver, By.cssSelector("[class*='__region'] [class*='__inner']"));
        element.click();
        WebElement CityForm = (new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .cssSelector("[class*='region-select-form']"))));

        WebElement city = findAndAllureSc(CityForm, By
                .cssSelector("[class*='region-suggest'] [class*='input__control']"));
        city.click();
        city.sendKeys(cityName);

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(city.
                        findElement(By.xpath("//strong[text()[contains(.,\'" + cityName + "\')]]"))));

        city.sendKeys(Keys.ENTER);

        (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.invisibilityOf(
                        driver.findElement(By.cssSelector("[class*='suggestick-list']"))));

        city.sendKeys(Keys.ENTER);
        driver.navigate().refresh();
        element = findAndAllureSc(driver, By.cssSelector("[class*='__region'] [class*='__inner']"));
        Assert.assertEquals(element.getAttribute("textContent"), cityName);


        element = findAndAllureSc(driver, By.className("header2-nav__user"));
        element.click();
        WebElement logInFotm = (new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.className("passp-login-form"))));
        element = findAndAllureSc(logInFotm, By.name("login"));
        element.click();
        element.sendKeys("Naglui.eretick@yandex.ru");
        element.sendKeys(Keys.ENTER);

        WebElement PassForm = (new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.className("passp-password-form"))));

        element = findAndAllureSc(PassForm, By.name("passwd"));
        element.sendKeys("28301230aaMP" + "\n");


        WebElement web = findAndAllureSc(driver, By.className("header2-nav__user"));
        (new Actions(driver)).moveToElement(web).build().perform();
        element = findAndAllureSc(driver, By.cssSelector("[class*='item_type_addresses']"));
        element.click();
        WebElement elem1 = findAndAllureSc(driver, By
                .cssSelector("[class*='settings-list_type_region'] [class*='__inner']"));
        WebElement elem2 = findAndAllureSc(driver, By.cssSelector("[class*='__region'] [class*='__inner']"));
        Assert.assertEquals(elem1.getAttribute("textContent"), elem2.getAttribute("textContent"));
    }
}
