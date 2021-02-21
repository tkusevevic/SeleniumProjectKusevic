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

public class SignIn {
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
        WebElement emailSignIn =
                driver.findElement(By.xpath("//*[@id=\"email\"]"));
        emailSignIn.sendKeys("email.tonko9@gmail.com");
        Thread.sleep(1000);

        WebElement passSignIn =
                driver.findElement(By.xpath("//*[@id=\"passwd\"]"));
        passSignIn.sendKeys("123456789");
        Thread.sleep(1000);

        WebElement signUpButt = driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]"));
        signUpButt.click();
        Thread.sleep(2000);

        WebElement myAcc =
                driver.findElement(By.xpath("//*[@id=\"my-account\"]"));
        Assert.assertTrue(myAcc.isDisplayed());
    }

    @AfterMethod
    public void teardownTest() {
        //Close browser and end the session
        driver.quit();
    }
}