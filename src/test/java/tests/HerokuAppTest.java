package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HerokuAppTest {
    @Test
    public void herokuAppTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/inputs");
        driver.manage().window().maximize();
        WebElement inputField = driver.findElement(By.tagName("input"));
        inputField.sendKeys("1111");
        String textFromInputField = inputField.getAttribute("value");
        Assert.assertEquals(textFromInputField, "1111", "Text from input field doesn't " +
                "contain entered symbols!");
        driver.quit();
    }

    public static class DynamicControls {
    }
}