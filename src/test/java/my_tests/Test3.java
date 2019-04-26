package my_tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class Test3 extends TestsPreparation {
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
    }
}
