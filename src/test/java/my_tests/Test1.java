package my_tests;

import org.testng.ITestContext;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class Test1 extends TestsPreparation{

    @Test
    public void test_1() {

        FirstPage topPanel = new FirstPage();
        LoginForm loginForm = topPanel.clickButtonAccount();
        String email = "Naglui.eretick@yandex.ru";
        loginForm.enterLogin(email);
        String password = "28301230aaMP";
        loginForm.enterPassword(password);
        topPanel.checkTextOnAccountInfoButton();
        topPanel.checkUserEmail();

//        WebElement element = findAndAllureSc(driver, By.cssSelector(".header2-nav__user"));
//        element.click();
//
//        WebElement logInFotm = (new WebDriverWait(driver, 20)
//                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".passp-login-form"))));
//        element = findAndAllureSc(logInFotm, By.name("login"));
//        element.click();
//        element.sendKeys("Naglui.eretick@yandex.ru");
//        element.sendKeys(Keys.ENTER);
//        WebElement PassForm = (new WebDriverWait(driver, 20)
//                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".passp-password-form"))));
//        element = findAndAllureSc(PassForm, By.name("passwd"));
//        element.sendKeys("28301230aaMP" + "\n");
//
//        WebElement note = driver.findElement(By.cssSelector("[class*='header2-nav__user']"));
//        element = findAndAllureSc(note, By.cssSelector("[class*='__text']"));
//        Assert.assertEquals(element.getAttribute("textContent"), "Мой профиль");
//
//        (new Actions(driver)).moveToElement(note).build().perform();
//
//        element = findAndAllureSc(driver, By.cssSelector("[class*='user-menu__email']"));
//        Assert.assertEquals(element.getAttribute("textContent"), "Naglui.eretick@yandex.ru");
    }
}