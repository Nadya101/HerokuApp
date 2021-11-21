package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

//кликнуть на кнопку, дождаться появления нотификации, проверить соответствие текста ожиданиям
public class NotificationMessagesTest {
    @Test
    public void checkNotificationTextTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");
        driver.findElement(By.linkText("Click here")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement notationField = driver.findElement(By.xpath("//div[@class = 'flash notice']"));
        String noteText = notationField.getAttribute("innerText");
        System.out.println(noteText);
       // Assert.assertEquals(noteText, "Action successful", "Action unsuccessful, please try again");



    }
}