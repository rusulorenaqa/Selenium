import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class SubscribeTest {
    private WebDriver driver;

    @Before
    public void method(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");

    }

    @Test
    public void subscribeNewEmail(){
        Random number = new Random();
        driver.findElement(By.cssSelector("#newsletter")).sendKeys("test"+number.nextInt() + "@yahoo.com");
        driver.findElement(By.cssSelector("div.actions button[title='Subscribe'] >span >span")).click();
        assertEquals("Subscribe successful","Thank you for your subscription.",
                driver.findElement(By.cssSelector("li.success-msg ul li span")).getText());
    }

    @After

    public void exit(){
        driver.quit();

    }
}
