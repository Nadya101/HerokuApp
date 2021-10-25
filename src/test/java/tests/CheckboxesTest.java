package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

/*проверить, что первый чекбокс unchecked, отметить первый чекбокс, проверить что он checked.
Проверить, что второй чекбокс checked, сделать uncheck, проверить, что он unchecked
 */
public class CheckboxesTest {
    @Test
    public void isSelectedFistCheckboxTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        WebElement firstCheckbox = driver.findElement(By.xpath("//*[@type = 'checkbox'][1]"));
        Assert.assertFalse(firstCheckbox.isSelected());
        driver.quit();
    }

    @Test
    public void isSelectedSecondCheckboxTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        WebElement secondCheckbox = driver.findElement(By.xpath("//*[@type = 'checkbox'][2]"));
        Assert.assertTrue(secondCheckbox.isSelected());
        driver.quit();
    }

    @Test
    public void changeSelectedFirstCheckboxTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        WebElement firstCheckbox = driver.findElement(By.xpath("//*[@type = 'checkbox'][1]"));
        firstCheckbox.click();
        Assert.assertTrue(firstCheckbox.isSelected());
        driver.quit();
    }

    @Test
    public void changeSelectedSecondCheckboxTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        WebElement secondCheckbox = driver.findElement(By.xpath("//*[@type = 'checkbox'][2]"));
        secondCheckbox.click();
        Assert.assertFalse(secondCheckbox.isSelected());
        driver.quit();
    }
}