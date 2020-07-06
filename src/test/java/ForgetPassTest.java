import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ForgetPassTest {


    private WebDriver driver;

    @Before
    public void method() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");

    }

    @Test

    public void forgettPassword() {

        driver.findElement(By.cssSelector("div.account-cart-wrapper > a > span.label")).click();
        driver.findElement(By.cssSelector("div.links li.last a[title='Log In']")).click();
        driver.findElement(By.cssSelector("ul.form-list a.f-left")).click();
        assertEquals("Can you re-enter the pass.", "RETRIEVE YOUR PASSWORD HERE",
                driver.findElement(By.cssSelector("#form-validate > div.fieldset > h2")).getText());
        driver.findElement(By.id("email_address")).sendKeys("rusulorena@gmail.com");
        driver.findElement(By.cssSelector("div.buttons-set >button > span> span")).click();
        assertTrue(driver.findElement(By.cssSelector("li.success-msg span"))
                .getText().contains("you will receive an email with a link to reset your password."));

    }

    @After

    public void exit() {
        driver.quit();
    }
}
