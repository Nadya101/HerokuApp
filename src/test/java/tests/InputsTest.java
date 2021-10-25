package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InputsTest {
    @Test
    public void fillInWithNumberInputFieldTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement inputField = driver.findElement(By.tagName("input"));
        inputField.sendKeys("44444");
        inputField.sendKeys(Keys.ARROW_UP); //44445
        inputField.sendKeys(Keys.ARROW_UP);  //44446
        inputField.sendKeys(Keys.ARROW_DOWN); //44445
        String getInsertedText = inputField.getAttribute("value");
        Assert.assertEquals(getInsertedText, "44445");
        driver.quit();
    }

    @Test
    public void fillInWithCharsInputFieldTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement inputField = driver.findElement(By.tagName("input"));
        inputField.sendKeys("Hello");
        String getInsertedText = inputField.getAttribute("value");
        System.out.println(inputField.getAttribute("value"));
        Assert.assertEquals(getInsertedText, "");
        driver.quit();
    }

    @Test
    public void fillInWithSymobolsInputFieldTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement inputField = driver.findElement(By.tagName("input"));
        inputField.sendKeys("+-=");
        String getInsertedPlus = inputField.getAttribute("value");
        System.out.println(inputField.getAttribute("value"));
        Assert.assertEquals(getInsertedPlus, "");
        inputField.clear();
        inputField.sendKeys("*![]&?");
        String getInsertedSymbols = inputField.getAttribute("value");
        System.out.println(inputField.getAttribute("value"));
        Assert.assertEquals(getInsertedSymbols, "");
        driver.quit();
    }
}
