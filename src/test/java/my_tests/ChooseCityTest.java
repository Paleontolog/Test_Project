package my_tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class ChooseCityTest extends TestsPreparation {

    @DataProvider(name="SearchProvider")
    public Object[][] getDataFromDataprovider(){
        return new Object[][]
                {
                        { "Хвалынск" },
                        { "Москва" },
                        { "Самара" }
                };
    }

    @Test(dataProvider="SearchProvider")
    public void chooseCityTest(String cityName) {
        FirstPage page = new FirstPage();
        page.clickCityInner();
        page.changeCityName(cityName);
        page.checkCityName();
        LoginForm loginForm = page.clickButtonAccount();
        String email = "Naglui.eretick@yandex.ru";
        loginForm.enterLogin(email);
        String password = "28301230aaMP";
        loginForm.enterPassword(password);
        MyProfile address = page.goToMyProfile();
        address.findCityInner();
        address.findDeliveryAddress();
        address.checkAddresses();
    }
}
