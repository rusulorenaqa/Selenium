import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class LoginTest {


    private WebDriver driver;

    @Before
    public void method(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");

    }


    @Test
        public void login(){

        driver.findElement(By.cssSelector("div.account-cart-wrapper > a > span.label")).click();
        driver.findElement(By.cssSelector("div.links li.last a[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("rusulorena@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("parola");
        driver.findElement(By.id("send2")).click();
        assertEquals("You can login with valid credentials!", "WELCOME, RUSU LORENA LORENA!",driver.findElement(By.cssSelector("p.welcome-msg")).getText());
    }
    @Test

    public void loginFailed(){

        driver.findElement(By.cssSelector("div.account-cart-wrapper > a > span.label")).click();
        driver.findElement(By.cssSelector("div.links li.last a[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("rusulorena@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("parola2020");
        driver.findElement(By.id("send2")).click();
        assertEquals("You can't login with invalid credential!", "Invalid login or password.",driver.findElement(By.cssSelector("li.error-msg ul li span")).getText());
    }
    @After

    public void exit(){
        driver.quit();

    }
}
