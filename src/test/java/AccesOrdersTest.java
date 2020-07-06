import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class AccesOrdersTest {

    private WebDriver driver;

    @Before
    public void method() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("div.account-cart-wrapper > a > span.label")).click();
        driver.findElement(By.cssSelector("div.links li.last a[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("rusulorena@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("parola");
        driver.findElement(By.id("send2")).click();
        WebElement welcomeMessage = driver.findElement(By.cssSelector("p.welcome-msg"));
        assertEquals("You can login with valid credentials!", "WELCOME, RUSU LORENA LORENA!",
               welcomeMessage.getText());


    }

    @Test

    public void goToOrders() {
        driver.findElement(By.cssSelector("div.account-cart-wrapper > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account a[title='My Account'] ")).click();
        assertEquals("You re in Dashboard.", "MY DASHBOARD",
                driver.findElement(By.cssSelector("div.page-title h1")).getText());
        driver.findElement(By.cssSelector("a[href='http://testfasttrackit.info/selenium-test/sales/order/history/']")).click();
        assertEquals("Are you in your orders", "MY ORDERS",
                driver.findElement(By.cssSelector("div.my-account div.page-title")).getText());

    }


    @After
    public void exit() {
        driver.quit();

    }
}
