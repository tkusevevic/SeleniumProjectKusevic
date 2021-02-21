import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ItemDetails {
    public WebDriver driver;
    public String testURL = "http://automationpractice.com/index.php";

    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");

        driver = new ChromeDriver();
        driver.navigate().to(testURL);
    }

    @Test
    public void itemDetauls() throws InterruptedException {
        WebElement singUpButton = driver.findElement(By.xpath("//*[@id=\"search_query_top\"]"));
        singUpButton.sendKeys("t-shirt");
        Thread.sleep(1000);


        WebElement searchButton =
                driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button"));
        searchButton.click();
        Thread.sleep(1000);


        WebElement item =
                driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img"));
        item.click();
        Thread.sleep(1000);
    }

    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }
}