package my_tests;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


// Скриншоты снимаются на каждом шаге при помощи функции findAndAllureSc
public class FirstPage extends TestsPreparation {
    private String cityName;

    private WebElement giveAccountInfoButton() {
        return driver.findElement(By.cssSelector(".header2-nav__user"));
    }

    @Step("Click on Account")
    public LoginForm clickButtonAccount() {
        giveAccountInfoButton().click();
        return new LoginForm();
    }

    @Step("Check User Email")
    public void checkUserEmail() {
        (new Actions(driver)).moveToElement(giveAccountInfoButton()).build().perform();
        WebElement userMenuEmail = driver.findElement(By.cssSelector("[class*='user-menu__email']"));
        Assert.assertEquals(userMenuEmail.getAttribute("textContent"), "Naglui.eretick@yandex.ru");
    }

    @Step("Check Text in Button Account")
    public void checkTextOnAccountInfoButton() {
        WebElement textButtonUser = giveAccountInfoButton().findElement(By.cssSelector("[class*='__text']"));
        Assert.assertEquals(textButtonUser.getAttribute("textContent"), "Мой профиль");
    }

    public WebElement findCurrentCity() {
        return driver.findElement(By.cssSelector("[class*='__region'] [class*='__inner']"));
    }

    @Step("Click On Current City")
    public void clickCityInner() {
        findCurrentCity().click();
    }

    @Step("Set new city")
    public void changeCityName(String cityName) {
        this.cityName = cityName;
        WebElement CityForm = (new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .cssSelector("[class*='region-select-form']"))));

        WebElement city = CityForm.findElement(By.cssSelector("[class*='region-suggest'] [class*='input__control']"));

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
    }

    @Step("Check city name")
    public void checkCityName() {
        Assert.assertEquals(findCurrentCity().getAttribute("textContent"), cityName);
    }

    @Step("Check address")
    public MyProfile goToMyProfile() {
        (new Actions(driver)).moveToElement(giveAccountInfoButton()).build().perform();
        WebElement addresses = driver.findElement(By.cssSelector("[class*='item_type_addresses']"));
        addresses.click();
        return new MyProfile();
    }

    @Step("Find item")
    public void findItem(String item) {
        WebElement fieldForSearch = driver.findElement(By.id("header-search"));
        fieldForSearch.click();
        fieldForSearch.sendKeys(item);
        fieldForSearch.sendKeys(Keys.ENTER);
    }
}
