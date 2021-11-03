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

public class ContextMenu {

    @Test
    public void getTextFromAlertTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/context_menu");
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.id("hot-spot"));
        actions.contextClick(element).perform();
        WebDriverWait wait = new WebDriverWait(driver,10);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String getText = alert.getText();
        alert.accept();
        Assert.assertEquals(getText, "You selected a context menu");
       driver.quit();
    }
}
