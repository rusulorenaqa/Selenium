import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class ContactUsTest {


    private WebDriver driver;

    @Before
    public void method(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");}


    @Test

    public void contactUsValid(){
        driver.findElement(By.cssSelector("body > div > div.page > div.footer-container > div > div:nth-child(2) > ul > li:nth-child(2) > a")).click();
        driver.findElement(By.id("name")).sendKeys("Rusu Lorena");
        driver.findElement(By.id("email")).sendKeys("rusulorena@yahoo.com");
        driver.findElement(By.id("telephone")).sendKeys("0766 666 666");
        driver.findElement(By.id("comment")).sendKeys("Buna ziua, La revedere!");
        driver.findElement(By.cssSelector("#contactForm > div.buttons-set > button > span > span")).click();
        assertEquals("Contact the store!","Your inquiry was submitted and will be responded to as soon as possible. Thank you for contacting us.",
                driver.findElement(By.cssSelector("#messages_product_view > ul > li > ul > li > span")).getText());
    }

    @Test

    public void contactUsInvalidEmail(){
        driver.findElement(By.cssSelector("body > div > div.page > div.footer-container > div > div:nth-child(2) > ul > li:nth-child(2) > a")).click();
        driver.findElement(By.id("name")).sendKeys("Rusu Lorena");
        driver.findElement(By.id("email")).sendKeys("rusulorenayahoo.com");
        driver.findElement(By.id("telephone")).sendKeys("0766 666 666");
        driver.findElement(By.id("comment")).sendKeys("Buna ziua, La revedere!");
        driver.findElement(By.cssSelector("#contactForm > div.buttons-set > button > span > span")).click();
        assertEquals("Can t contact the store!",0,
                driver.findElements(By.cssSelector("#messages_product_view > ul > li > ul > li > span")).size());
    }

    @After

    public void exit(){
        driver.quit();

    }


}
