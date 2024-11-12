import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddGroupTest {
    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeClass
    public static void setUpBeforeClass() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Before
    public void setUp() {
        driver.get("https://test-stand.gb.ru/login");
    }

    @Test
    public void testAddGroup() {
        // Логинимся
        driver.findElement(By.id("username")).sendKeys("Student-22");
        driver.findElement(By.id("password")).sendKeys("1db9411502");
        driver.findElement(By.id("login-button")).click();

        // Ожидание загрузки страницы после логина
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-group-button")));

        // Нажимаем на ‘+’ для добавления группы
        driver.findElement(By.id("add-group-button")).click();

        // Ожидание открытия модального окна
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("group-name-input")));

        // Вводим имя новой группы
        String groupName = "group-1";
        driver.findElement(By.id("group-name-input")).sendKeys(groupName);

        // Нажимаем кнопку SAVE
        driver.findElement(By.id("save-button")).click();

        // Ожидание появления новой группы в таблице
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='" + groupName + "']")));

        // Проверка, что группа с именем появилась в таблице
        Assert.assertTrue(driver.findElement(By.xpath("//td[text()='" + groupName + "']")).isDisplayed());
    }

    @AfterClass
    public static void tearDownAfterClass() {
        driver.quit();
    }
}
