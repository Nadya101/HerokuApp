package tests.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class GreatestBooks {
    @Test
    public void findElementsFromHtmlPageTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("file:///E:/HerokuApp/src/test/java/tests/Test/books.html");
        WebElement tableElement = driver.findElement(By.tagName("table"));
        WebElement inputElement = driver.findElement(By.tagName("input"));
        WebElement checkBoxElement = driver.findElement(By.cssSelector("#book1_1"));
        WebElement selectElement = driver.findElement(By.tagName("select"));
        WebElement buttonElement = driver.findElement(By.className("btn"));
        WebElement imageElement = driver.findElement(By.tagName("img"));
        WebElement paragraphElement = driver.findElement(By.tagName("p"));
        WebElement linkElement = driver.findElement(By.tagName("a"));
        driver.quit();
    }
}