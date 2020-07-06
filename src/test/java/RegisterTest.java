import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class RegisterTest {

    private WebDriver driver;

    @Before
    public void method(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");}

        @Test

    public void register() {
        driver.findElement(By.cssSelector("div.account-cart-wrapper > a > span.label")).click();
        driver.findElement(By.cssSelector("div.links li:nth-child(5) a[title='Register']")).click();
        driver.findElement(By.id("firstname")).sendKeys("Rusu");
        driver.findElement(By.id("middlename")).sendKeys("Lorena");
        driver.findElement(By.id("lastname")).sendKeys("Florina");
        Random number = new Random();
        driver.findElement(By.id("email_address")).sendKeys("test"+number.nextInt()+"@yahoo.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("confirmation")).sendKeys("123456");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.cssSelector("div.buttons-set > button")).click();
        assertEquals("Register valid","Thank you for registering with Madison Island.",
                driver.findElement(By.cssSelector(".success-msg span")).getText());

    }
    @Test

    public void registerWithoutEmail() {
        driver.findElement(By.cssSelector("div.account-cart-wrapper > a > span.label")).click();
        driver.findElement(By.cssSelector("div.links li:nth-child(5) a[title='Register']")).click();
        driver.findElement(By.id("firstname")).sendKeys("Rusu");
        driver.findElement(By.id("middlename")).sendKeys("Lorena");
        driver.findElement(By.id("lastname")).sendKeys("Florina");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("confirmation")).sendKeys("123456");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.cssSelector("div.buttons-set > button")).click();
        assertEquals("Can't connect without email","This is a required field.",
                driver.findElement(By.id("advice-required-entry-email_address")).getText());

    }
    @Test

    public void registerWithoutPass() {
        driver.findElement(By.cssSelector("div.account-cart-wrapper > a > span.label")).click();
        driver.findElement(By.cssSelector("div.links li:nth-child(5) a[title='Register']")).click();
        driver.findElement(By.id("firstname")).sendKeys("Rusu");
        driver.findElement(By.id("middlename")).sendKeys("Lorena");
        driver.findElement(By.id("lastname")).sendKeys("Florina");
        driver.findElement(By.id("email_address")).sendKeys("rusulorena@yahoo.com");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.cssSelector("div.buttons-set > button")).click();
        assertEquals("Can t connect without password","This is a required field.",
                driver.findElement(By.id("advice-required-entry-password")).getText());

    }
    @Test

    public void registerWithoutName() {
        driver.findElement(By.cssSelector("div.account-cart-wrapper > a > span.label")).click();
        driver.findElement(By.cssSelector("div.links li:nth-child(5) a[title='Register']")).click();
        driver.findElement(By.id("email_address")).sendKeys("rusulorena@yahoo.com");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.id("confirmation")).sendKeys("123");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.cssSelector("div.buttons-set > button")).click();
        assertEquals("Can t connect without name.","This is a required field.",
                driver.findElement(By.id("advice-required-entry-firstname")).getText());
        assertEquals("Can t connect without name.","This is a required field.",
                driver.findElement(By.id("advice-required-entry-lastname")).getText());

    }


    @After

    public void exit(){
        driver.quit();

}}
