package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

//Проверить соответствие параграфа орфографии
public class TyposTest {
    @Test
    public void spellingTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/typos");
        String actualResult = driver.findElement(By.xpath("//*/p[2]")).getText();
        String expectedResult = "Sometimes you'll see a typo, other times you won't.";
        Assert.assertEquals(actualResult, expectedResult, "The text has a mistake.");
        driver.quit();
    }
}