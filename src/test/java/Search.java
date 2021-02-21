import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class Search {
    public WebDriver driver;
    public String testURL = "http://automationpractice.com/index.php";
    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");

        driver = new ChromeDriver();
        driver.navigate().to(testURL);
    }

    @Test
    public void searchTShirt() throws InterruptedException {
        WebElement singUpButton = driver.findElement(By.xpath("//*[@id=\"search_query_top\"]"));
        singUpButton.sendKeys("t-shirt");
        Thread.sleep(1000);

        WebElement searchButton =
                driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button"));
        searchButton.click();
        Thread.sleep(2000);

        WebElement resultName = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a"));
        Assert.assertEquals(resultName.getText(), "Faded Short Sleeve T-shirts");
    }

    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }
}