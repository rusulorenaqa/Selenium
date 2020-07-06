import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EmptyCartTest {

    private WebDriver driver;

    @Before
    public void method() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");

        //Inainte sa adaugi in cart, trebuei sa fii logat.
        driver.findElement(By.cssSelector("div.account-cart-wrapper > a > span.label")).click();
        driver.findElement(By.cssSelector("div.links li.last a[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("rusulorena@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("parola");
        driver.findElement(By.id("send2")).click();
        assertEquals("You can login with valid credentials!", "WELCOME, RUSU LORENA LORENA!", driver.findElement(By.cssSelector("p.welcome-msg")).getText());


        //Dupa login, trebuie sa adaugi in cart, ca sa putem utiliza motoda de checkout.
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.className("nav-4"))).perform();
        driver.findElement(By.className("nav-4-2")).click();
        assertEquals("Bed and Bath screen reached", "BED & BATH",
                driver.findElement(By.cssSelector("div.page-title > h1")).getText());
        driver.findElement(By.cssSelector("ul.products-grid li:first-child div.actions button[title='Add to Cart']")).click();
        assertEquals("Cart page reached", "SHOPPING CART",
                driver.findElement(By.cssSelector("div.page-title > h1")).getText());
        assertTrue(driver.findElement(By.cssSelector("li.success-msg span"))
                .getText().contains("was added to your shopping cart."));
    }

    @Test

    public void emptyCart(){
        driver.findElement(By.id("empty_cart_button")).click();
        assertEquals("Empty cart", "SHOPPING CART IS EMPTY",
                driver.findElement(By.cssSelector("div.page-title > h1")).getText());
    }

    @After

    public void exit(){
        driver.quit();
    }
}
