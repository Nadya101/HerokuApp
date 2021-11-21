package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Frames {
    @Test
    public void getTextFromIFrameTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/frames");
        WebElement iframe = driver.findElement(By.linkText("iFrame"));
        iframe.click();
        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
        String messageText = driver.findElement(By.id("tinymce")).getText();
        driver.switchTo().defaultContent();
        Assert.assertEquals(messageText, "Your content goes here.");
        driver.quit();
    }
}