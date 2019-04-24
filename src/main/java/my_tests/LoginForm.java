package my_tests;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.reporters.jq.TestPanel;

public class LoginForm extends TestsPreparation {
//    private static WebDriver driver;
//
//    public LoginForm(WebDriver driver) {
//        this.driver = driver;
//    }

    //"Naglui.eretick@yandex.ru"
    @Step("Enter login")
    public void enterLogin(String login) {
        WebElement logInFotm = (new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".passp-login-form"))));
        WebElement element = findAndAllureSc(logInFotm, By.name("login"));
        element.click();
        element.sendKeys("Naglui.eretick@yandex.ru");
        element.sendKeys(Keys.ENTER);
    }

    //"28301230aaMP"
    @Step("Enter password")
    public void enterPassword(String password) {
        WebElement PassForm = (new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".passp-password-form"))));
        WebElement element = findAndAllureSc(PassForm, By.name("passwd"));
        element.sendKeys("28301230aaMP");
        element.sendKeys(Keys.ENTER);
    }
}
