package my_tests;

import io.qameta.allure.Step;
import org.aspectj.weaver.ast.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShoppingCartPage extends TestsPreparation {
    private static List<WebElement> priceList = null;

    private int parseInt(String str) {
        Pattern pat = Pattern.compile("[^\\d]");
        Matcher matcher = pat.matcher(str);
        return Integer.parseInt(matcher.replaceAll(""));
    }

//    public ShoppingCartPage(WebDriver driver) {
//        this.driver = driver;
//    }

    @Step("Price product")
    private int regylarPrice() {
        String tempText = priceList.get(0).findElement(By.cssSelector("[data-auto*='value']"))
                .getAttribute("textContent");
        return parseInt(tempText);
    }

    @Step("Delivery price")
    private int delivryPrice() {
        String tempText = priceList.get(1).findElement(By.cssSelector("[data-auto*='value']"))
                .getAttribute("textContent");
        return tempText.contains("бесплатно") ? 0 : parseInt(tempText);
    }

    @Step("Sale price")
    private int salePrice() {
        int salary = 0;
        if (priceList.size() == 4) {
            String tempText = priceList.get(2).findElement(By
                    .xpath("//span[text()[contains(., 'Скидка')]]/following-sibling::span"))
                    .getAttribute("textContent");
            salary = parseInt(tempText);
        }
        return salary;
    }

    @Step("All price")
    private int summaryPrice(int index) {
        String tempText = priceList.get(index)
                .findElement(By.cssSelector("[class*='_1oBlNqVHPq']"))
                .getAttribute("textContent");
        return parseInt(tempText);
    }

    @Step("Check price is correct")
    public void checkCorrectionPrice() {
        priceList = driver.findElements(By.cssSelector("[class *= '_1Q9ASvPbPN']"));
        int sale = salePrice();
        int index = sale == 0 ? 2 : 3;
        Assert.assertEquals(regylarPrice() + delivryPrice() - sale,
                summaryPrice(index));
    }

    @Step("Check free delivery")
    public void checkDeliveryIsFree() {
        String priceStr = priceList.get(1).findElement(By.cssSelector("[data-auto*='value']"))
                .getAttribute("textContent").replace(" ", "");
        Assert.assertTrue(priceStr.contains("бесплатно"));
    }

    @Step("Add product")
    public void addCountProduct(int priceLimit) {
        String priceStr = driver.findElement(By.xpath("//div[@data-auto='CartOfferPrice']/span/span/span"))
                .getAttribute("textContent");
        int regylarPrice = parseInt(priceStr);
        while(regylarPrice < priceLimit) {
            System.out.println(regylarPrice);
            driver.findElement(By.xpath("//button//span[text()='+']")).click();
            priceStr = driver.findElement(By.xpath("//div[@data-auto='CartOfferPrice']/span/span/span"))
                    .getAttribute("textContent");
            regylarPrice = parseInt(priceStr);
        }
    }

    @Step("Check free delivery title")
    public void checkDeliveryIsFreeTitle(String title) {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.attributeContains(
                        By.cssSelector("[class*='_3EX9adn_xp']"), "textContent", title));
        checkDeliveryText(title);
    }

    @Step("Check delivery text")
    public void checkDeliveryText(String textDelivery) {
        WebElement freeCome = driver.findElement(By.cssSelector("[class *= '_3EX9adn_xp']"));
        Assert.assertTrue(freeCome.getAttribute("textContent").contains(textDelivery));
    }
}
