import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest {
    private WebDriver driver;

    @Test
    public void testEmptyLoginFields() {
        driver.get("url_логина");

        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        String expectedError = "Логин и пароль не могут быть пустыми";
        Assert.assertEquals(errorMessage.getText(), expectedError);
    }
}
