import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CartTest {

    private WebDriver driver;

    @Before
    public void method(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");

    }

    @Test
    public void cartAdd(){
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.className("nav-4"))).perform();
        driver.findElement(By.className("nav-4-2")).click();
        assertEquals("Bed and Bath screen reached","BED & BATH",
                driver.findElement(By.cssSelector("div.page-title > h1")).getText());
        driver.findElement(By.cssSelector("ul.products-grid li:first-child div.actions button[title='Add to Cart']")).click();
        assertEquals("Cart page reached", "SHOPPING CART",
                driver.findElement(By.cssSelector("div.page-title > h1")).getText());
        assertTrue(driver.findElement(By.cssSelector("li.success-msg span"))
                .getText().contains("was added to your shopping cart."));
    }

    @After

    public void exit(){
        driver.quit();

    }


}
