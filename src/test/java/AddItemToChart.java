import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToChart {
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
        singUpButton.sendKeys("dress");
        Thread.sleep(1000);

        WebElement searchButton =
                driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button"));
        searchButton.click();
        Thread.sleep(2000);

        Actions actions = new Actions(driver);
        WebElement menuOption = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div/a[1]/img"));
        actions.moveToElement(menuOption).perform();
        Thread.sleep(2000);

        WebElement addButton =
                driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/div[2]/a[1]"));
        addButton.click();
        Thread.sleep(2000);

        WebElement priceText =
                driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2"));
        Assert.assertEquals(priceText.getText(), "Product successfully added to your shopping cart");
    }

    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }
}