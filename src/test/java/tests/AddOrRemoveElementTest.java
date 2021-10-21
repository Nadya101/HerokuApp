package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

//добавить 2 элемента, удалить элемент, проверить количество элементов
public class AddOrRemoveElementTest {
    @Test
    public void addOrRemoveElementTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(By.xpath("//*[@onclick='addElement()']")).click();
        driver.findElement(By.xpath("//*[@onclick='addElement()']")).click();
        driver.findElement(By.xpath("//*[@onclick='deleteElement()']")).click();
        List<WebElement> allDeleteBtn = driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        Assert.assertEquals(allDeleteBtn.size(), 1);
        driver.quit();
    }
}