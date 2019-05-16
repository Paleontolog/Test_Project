package my_tests;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class LoginTest extends TestsPreparation {

    @Test
    public void loginTest() {
        FirstPage topPanel = new FirstPage();
        LoginForm loginForm = topPanel.clickButtonAccount();
        String email = "Naglui.eretick@yandex.ru";
        loginForm.enterLogin(email);
        String password = "28301230aaMP";
        loginForm.enterPassword(password);
        topPanel.checkTextOnAccountInfoButton();
        topPanel.checkUserEmail();
    }
}