package my_tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class Test3 extends TestsPreparation {

//    int parseInt(String str) {
//        Pattern pat = Pattern.compile("[^\\d]");
//        Matcher matcher = pat.matcher(str);
//        return Integer.parseInt(matcher.replaceAll(""));
//    }

    @Test
    public void test_3() {
        FirstPage page = new FirstPage();
        page.findItem("Электрические зубные щетки");
        ProductListPage prodPage = new ProductListPage();
        prodPage.inputMinmumPrice(999);
        prodPage.inputMaximumPrice(1999);
        prodPage.showAllProduct();
        prodPage.getListAllProducts();
        prodPage.checkListNotEmpty();
        prodPage.checkPriceInRange(999, 1999);
        prodPage.addToBasket();

        ShoppingCartPage basketPage = prodPage.toMyBascet();
        basketPage.checkDeliveryText("бесплатной доставки осталось");
        basketPage.checkCorrectionPrice();
        basketPage.addCountProduct(2999);
        basketPage.checkDeliveryIsFreeTitle("Поздравляем!");
        basketPage.checkDeliveryIsFree();
        basketPage.checkCorrectionPrice();
//        WebElement elem = findAndAllureSc(driver, By.id("header-search"));
//        elem.click();
//        elem.sendKeys("Электрические зубные щетки");
//        elem.sendKeys(Keys.ENTER);
//
//        WebElement first_wind = findAndAllureSc(driver, By.id("glpricefrom"));
//        first_wind.click();
//        first_wind.sendKeys("999");
//
//        WebElement wind = driver.findElement(By.cssSelector("[class*='_1PQIIOelRL']"));
//        (new WebDriverWait(driver, 20))
//                .until(ExpectedConditions.visibilityOf(wind));
//
//        WebElement second_wind = findAndAllureSc(driver, By.id("glpriceto"));
//        second_wind.click();
//        second_wind.sendKeys("1999");
//        second_wind.sendKeys(Keys.ENTER);
//
//        (new WebDriverWait(driver, 20))
//                .until(ExpectedConditions.visibilityOf(wind));
//
//        while(true) {
//            try {
//                WebElement show = driver.findElement(By.cssSelector(".n-pager-more__button"));
//                show.click();
//            } catch (Exception e) {
//                break;
//            }
//        }
//
//        final int count_element = Integer.parseInt(driver.findElement(By
//                .cssSelector(".n-search-preciser__results-count"))
//                .getAttribute("textContent").split(" ")[1]);
//
//        (new WebDriverWait(driver,10)).until(new ExpectedCondition<Boolean>(){
//            public Boolean apply(WebDriver d) {
//                return d.findElements(By
//                        .cssSelector("[class*='grid-snippet_react']")).size() == count_element;
//            }
//        });
//
//        List<WebElement> a = driver.findElements(By.cssSelector("[class*='grid-snippet_react']"));
//        Assert.assertTrue(a.size() != 0);
//        boolean fl = true;
//        JSONParser parser = new JSONParser();
//        for (WebElement element : a) {
//            try {
//                JSONObject jsonObject = (JSONObject) parser.parse(element.getAttribute("data-bem"));
//                int price = Integer.parseInt((((JSONObject)
//                        ((JSONObject) jsonObject.get("b-zone")).get("data")).get("price")).toString());
//                if (price  < 999 || price > 1999) {
//                    fl = false;
//                    break;
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        Assert.assertTrue(fl);
//
//        findAndAllureSc(a.get(a.size() - 2), By.cssSelector("[class*='_2w0qPDYwej']")).click();
//
//        (new WebDriverWait(driver, 20))
//                .until(ExpectedConditions.presenceOfElementLocated(
//                        By.cssSelector("[class*='_1sjxYfIabK _26mXJDBxtH']")));
//
//        findAndAllureSc(a.get(a.size() - 2), By.cssSelector("[class*='_2w0qPDYwej']")).click();
//
//        (new WebDriverWait(driver, 20))
//                .until(ExpectedConditions.presenceOfElementLocated(
//                        By.cssSelector("[class*='_3AlSA6AOKL']")));
//
//        WebElement tempWeb = driver.findElement(By.cssSelector("[class *= '_3EX9adn_xp']"));
//        Assert.assertTrue(tempWeb.getAttribute("textContent").contains("бесплатной доставки осталось"));
//
//        List<WebElement> price_check = driver.findElements(By.cssSelector("[class *= '_1Q9ASvPbPN']"));
//        String tempText = price_check.get(0).findElement(By.cssSelector("[data-auto*='value']"))
//                .getAttribute("textContent");
//        int salePrice = parseInt(tempText);
//
//        tempText = price_check.get(1).findElement(By.cssSelector("[data-auto*='value']"))
//                .getAttribute("textContent");
//        int priceTrans = parseInt(tempText);
//        int discount = 0;
//        int indDisc = 2;
//        if (price_check.size() == 4) {
//            tempText = price_check.get(2).findElement(By
//                    .xpath("//span[text()[contains(., 'Скидка')]]/following-sibling::span"))
//                    .getAttribute("textContent");
//            discount = parseInt(tempText);
//            indDisc = 3;
//        }
//
//        tempText = price_check.get(indDisc).findElement(By.cssSelector("[class*='_1oBlNqVHPq']"))
//                .getAttribute("textContent");
//        int priceAll = parseInt(tempText);
//        Assert.assertEquals(salePrice + priceTrans - discount, priceAll);
//        tempText = driver.findElement(By.xpath("//div[@data-auto='CartOfferPrice']/span/span/span"))
//                .getAttribute("textContent");
//        int priceProduct = parseInt(tempText);
//
//        while(priceProduct < 2999){
//            findAndAllureSc(driver, By.xpath("//button//span[text()='+']")).click();
//            tempText = driver.findElement
//                    (By.xpath("//div[@data-auto='CartOfferPrice']/span/span/span"))
//                    .getAttribute("textContent");
//            priceProduct = parseInt(tempText);
//        }
//
//        (new WebDriverWait(driver, 20))
//                .until(ExpectedConditions.attributeContains(
//                        By.cssSelector("[class*='_3EX9adn_xp']"), "textContent", "Поздравляем!"));
//
//        tempWeb = driver.findElement(By.cssSelector("[class*='_3EX9adn_xp']"));
//        Assert.assertTrue(tempWeb.getAttribute("textContent").contains("Поздравляем!"));
//        price_check = driver.findElements(By.cssSelector("[class *= '_1Q9ASvPbPN']"));
//
//        tempText = price_check.get(0).findElement(By.cssSelector("[data-auto*='value']"))
//                .getAttribute("textContent");
//        salePrice = parseInt(tempText);
//        tempText = price_check.get(1).findElement(By.cssSelector("[data-auto*='value']"))
//                .getAttribute("textContent");
//        Assert.assertTrue(tempText.contains("бесплатно"));
//
//        discount = 0;
//        indDisc = 2;
//        if (price_check.size() == 4) {
//            tempText = price_check.get(2).findElement(By
//                    .xpath("//span[text()[contains(., 'Скидка')]]/following-sibling::span"))
//                    .getAttribute("textContent");
//            discount = parseInt(tempText);
//            indDisc = 3;
//        }
//
//        tempText = price_check.get(indDisc).findElement(By.cssSelector("[class*='_1oBlNqVHPq']"))
//                .getAttribute("textContent");
//        priceAll = parseInt(tempText);
//        Assert.assertEquals(salePrice - discount, priceAll);
    }
}
