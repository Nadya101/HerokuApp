package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUpload {

    @Test
    public void uploadFiledTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/upload");
        driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\Admin\\Desktop\\testTA.txt");
        driver.findElement(By.id("file-submit")).click();
        String getText = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(getText, "testTA.txt");
        driver.quit();
    }
}