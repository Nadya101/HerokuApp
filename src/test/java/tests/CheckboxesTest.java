package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

/*проверить, что первый чекбокс unchecked, отметить первый чекбокс, проверить что он checked.
Проверить, что второй чекбокс checked, сделать uncheck, проверить, что он unchecked
 */
public class CheckboxesTest {
    @Test
    public void checkboxesTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        //check if checkbox 1 is selected
        WebElement checkboxUnselected = driver.findElement(By.xpath("//*[@type = 'checkbox'][1]"));
        Assert.assertEquals(checkboxUnselected.isSelected(), false, "Error");
        checkboxUnselected.click();
        if(checkboxUnselected.isSelected()){
            System.out.println("First checkbox is selected!");
        }
        else{
            System.out.println("First checkbox isn't still selected!");
        }
        //check if checkbox 2 is selected
        WebElement checkboxSelected = driver.findElement(By.xpath("//*[@type = 'checkbox'][2]"));
        Assert.assertEquals(checkboxSelected.isSelected(), true, "Error");
        checkboxSelected.click();
        if(checkboxSelected.isSelected()){
            System.out.println("Second checkbox is selected");
        }else{
            System.out.println("Second checkbox isn't selected!");
        }
        driver.quit();
    }
}
