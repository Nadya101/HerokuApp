package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/* Проверить содержимое нескольких (3-5) ячеек таблицы.
Использовать xpath типа //table//tr[1]//td[1]
 - получение первой ячейки из первого ряда первой таблицы и так далее
*/
public class SortableDataTablesTest {
    @Test
    public void sortableDataTablesTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/tables");
        String table1cell1 = driver.findElement(By.xpath("//*/tr[1]/td[1]")).getText();
        Assert.assertEquals(table1cell1, "Smith");
        String table1cell2 = driver.findElement(By.xpath("//*/tr[1]/td[2]")).getText();
        Assert.assertEquals(table1cell2, "John");
        String table1cell3 = driver.findElement(By.xpath("//*/tr[1]/td[3]")).getText();
        Assert.assertEquals(table1cell3, "jsmith@gmail.com");
        driver.quit();
    }
}
