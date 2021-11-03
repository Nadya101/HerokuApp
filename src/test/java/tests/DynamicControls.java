package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DynamicControls {
    @Test
    public void removeOrAddCheckboxTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement removeAddButton = driver.findElement(By.xpath("//*[@onclick ='swapCheckbox()']"));
        removeAddButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        List<WebElement> checkboxElements = driver.findElements(By.id("checkbox"));
        Assert.assertEquals(checkboxElements.size(), 0);
        driver.quit();
    }

    @Test
    public void isDisabledInputTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement input = driver.findElement(By.xpath("//*[@type = 'text']"));
        Assert.assertFalse(input.isEnabled());
        driver.quit();
    }

    @Test
    public void isEnabledInputTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement input = driver.findElement(By.xpath("//*[@type = 'text']"));
        driver.findElement(By.xpath("//*[@onclick ='swapInput()']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertTrue(input.isEnabled());
        driver.quit();
    }
}