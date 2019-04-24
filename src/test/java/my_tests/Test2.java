package my_tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class Test2 extends TestsPreparation {

    @Parameters("cityName")
    @Test
    public void test_2(String cityName) {

        FirstPage page = new FirstPage();
        page.clickCityInner();
        page.changeCityName(cityName);
        page.checkCityName();
        LoginForm loginForm = page.clickButtonAccount();
        String email = "Naglui.eretick@yandex.ru";
        loginForm.enterLogin(email);
        String password = "28301230aaMP";
        loginForm.enterPassword(password);
        MyProfile address = page.goToMyProfile();;
        address.findCityInner();
        address.findDeliveryAddress();
        address.checkAdвresses();

//        WebElement element = findAndAllureSc(driver, By.cssSelector("[class*='__region'] [class*='__inner']"));
//        element.click();
//        WebElement CityForm = (new WebDriverWait(driver, 20)
//                .until(ExpectedConditions.presenceOfElementLocated(By
//                        .cssSelector("[class*='region-select-form']"))));
//
//        WebElement city = findAndAllureSc(CityForm, By
//                .cssSelector("[class*='region-suggest'] [class*='input__control']"));
//        city.click();
//        city.sendKeys(cityName);
//
//        (new WebDriverWait(driver, 10))
//                .until(ExpectedConditions.visibilityOf(city.
//                        findElement(By.xpath("//strong[text()[contains(.,\'" + cityName + "\')]]"))));
//
//        city.sendKeys(Keys.ENTER);
//
//        (new WebDriverWait(driver, 20))
//                .until(ExpectedConditions.invisibilityOf(
//                        driver.findElement(By.cssSelector("[class*='suggestick-list']"))));
//
//        city.sendKeys(Keys.ENTER);
//        driver.navigate().refresh();
//        element = findAndAllureSc(driver, By.cssSelector("[class*='__region'] [class*='__inner']"));
//        Assert.assertEquals(element.getAttribute("textContent"), cityName);
//
//
//        element = findAndAllureSc(driver, By.className("header2-nav__user"));
//        element.click();
//        WebElement logInFotm = (new WebDriverWait(driver, 20)
//                .until(ExpectedConditions.presenceOfElementLocated(By.className("passp-login-form"))));
//        element = findAndAllureSc(logInFotm, By.name("login"));
//        element.click();
//        element.sendKeys("Naglui.eretick@yandex.ru");
//        element.sendKeys(Keys.ENTER);
//
//        WebElement PassForm = (new WebDriverWait(driver, 20)
//                .until(ExpectedConditions.presenceOfElementLocated(By.className("passp-password-form"))));
//
//        element = findAndAllureSc(PassForm, By.name("passwd"));
//        element.sendKeys("28301230aaMP" + "\n");
//
//
//        WebElement web = findAndAllureSc(driver, By.className("header2-nav__user"));
//        (new Actions(driver)).moveToElement(web).build().perform();
//        element = findAndAllureSc(driver, By.cssSelector("[class*='item_type_addresses']"));
//        element.click();
//        WebElement elem1 = findAndAllureSc(driver, By
//                .cssSelector("[class*='settings-list_type_region'] [class*='__inner']"));
//        WebElement elem2 = findAndAllureSc(driver, By.cssSelector("[class*='__region'] [class*='__inner']"));
//        Assert.assertEquals(elem1.getAttribute("textContent"), elem2.getAttribute("textContent"));
    }
}
