package my_tests;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class Test1 extends TestsPreparation {

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
    }
}