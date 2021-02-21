import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class SignUp {
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
        WebElement singUpButton = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));
        singUpButton.click();
        Thread.sleep(1000);

        Random rand = new Random();
        WebElement emailSignUp =
                driver.findElement(By.xpath("//*[@id=\"email_create\"]"));
        emailSignUp.sendKeys("email.tonko" + rand.nextInt(1000) + "@gmail.com");
        Thread.sleep(1000);

        WebElement createAcc = driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]"));
        createAcc.click();
        Thread.sleep(2000);

        WebElement genederB =
                driver.findElement(By.xpath("//*[@id=\"id_gender1\"]"));
        genederB.click();
        Thread.sleep(500);

        WebElement firstName =
                driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]"));
        firstName.sendKeys("Tonko");
        Thread.sleep(500);

        WebElement lastName =
                driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]"));
        lastName.sendKeys("Tonkic");
        Thread.sleep(500);

        WebElement pass =
                driver.findElement(By.xpath("//*[@id=\"passwd\"]"));
        pass.sendKeys("123456789");
        Thread.sleep(500);

        WebElement address2 =
                driver.findElement(By.xpath("//*[@id=\"address1\"]"));
        address2.sendKeys("Random Address");
        Thread.sleep(500);

        WebElement city =
                driver.findElement(By.xpath("//*[@id=\"city\"]"));
        city.sendKeys("Zagreb");
        Thread.sleep(500);

        Select drpState = new Select(driver.findElement(By.name("id_state")));
        drpState.selectByVisibleText(("Alaska"));
        Thread.sleep(500);

        WebElement ZIP =
                driver.findElement(By.xpath("//*[@id=\"postcode\"]"));
        ZIP.sendKeys("31000");
        Thread.sleep(500);

        Select drpCountry = new Select(driver.findElement(By.name("id_country")));
        drpCountry.selectByVisibleText(("United States"));
        Thread.sleep(500);

        WebElement num1 =
                driver.findElement(By.xpath("//*[@id=\"phone\"]"));
        num1.sendKeys("1239239399");
        Thread.sleep(500);

        WebElement num2 =
                driver.findElement(By.xpath("//*[@id=\"phone_mobile\"]"));
        num2.sendKeys("1239239398");
        Thread.sleep(500);

        WebElement addr3 =
                driver.findElement(By.xpath("//*[@id=\"alias\"]"));
        addr3.sendKeys("My Address" + rand.nextInt(100));
        Thread.sleep(500);

        WebElement submit =
                driver.findElement(By.xpath("//*[@id=\"submitAccount\"]"));
        submit.click();
        Thread.sleep(2000);

        WebElement myAcc =
                driver.findElement(By.xpath("//*[@id=\"my-account\"]"));
        Assert.assertTrue(myAcc.isDisplayed());
    }

    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }
}