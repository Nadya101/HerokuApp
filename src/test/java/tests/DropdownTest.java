package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/* Взять все элементы дроп-дауна и проверить их наличие.
Выбрать первый, проверить, что он выбран, выбрать второй, проверить, что он выбран
*/
public class DropdownTest {
    @Test
    public void checkDropdownTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dropdown");
        WebElement dropDownList = driver.findElement(By.id("dropdown"));
        System.out.println("Dropdown list consist of " + driver.findElements(By.tagName("option")).size()
                + " options.");
        WebElement option1 = driver.findElement(By.xpath("//*[@value='1']"));
        WebElement option2 = driver.findElement(By.xpath("//*[@value='2']"));
        dropDownList.click();
        option1.click();
        if(option1.isSelected()){
            System.out.println("Option 1 is selected!");
        }else{
            System.out.println("Option 1 can't be selected!");
        }
        option2.click();
        if(option2.isSelected()){
            System.out.println("Option 2 is selected!");
        }else
        {
            System.out.println("Option 2 can't be selected!");
        }
        Assert.assertEquals(driver.findElements(By.tagName("option")).size(), 3);
        driver.quit();
    }
}
