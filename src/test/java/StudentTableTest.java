import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StudentTableTest {
    private WebDriver driver;

    @Test
    public void testStudentCountAndActions() {
        // Открытие страницы группы
        driver.get("url_группы");

        WebElement studentCount = driver.findElement(By.id("studentCount"));
        int initialCount = Integer.parseInt(studentCount.getText());

        WebElement addButton = driver.findElement(By.id("addStudentButton"));
        addButton.click();

        WebElement confirmButton = driver.findElement(By.id("confirmButton"));
        confirmButton.click();

        Assert.assertEquals(Integer.parseInt(studentCount.getText()), initialCount + 1);

        WebElement viewStudentsButton = driver.findElement(By.id("viewStudentsButton"));
        viewStudentsButton.click();

        WebElement studentTable = driver.findElement(By.id("studentTable"));
        int actualTableStudentCount = studentTable.findElements(By.tagName("tr")).size();
        Assert.assertEquals(actualTableStudentCount, initialCount + 1);

        WebElement firstStudentDeleteButton = studentTable.findElement(By.cssSelector("tr:first-child .deleteButton"));
        firstStudentDeleteButton.click();

        WebElement firstStudentRestoreButton = studentTable.findElement(By.cssSelector("tr:first-child .restoreButton"));
        firstStudentRestoreButton.click();
    }
}