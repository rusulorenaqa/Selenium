import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckoutTest {

    private WebDriver driver;

    @Before
    public void method() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");

        //Inainte sa adaugi in cart, trebuei sa fii logat.
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.id("email")).sendKeys("rusulorena@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("parola");
        driver.findElement(By.cssSelector("#send2 > span > span")).click();
        assertEquals("You can login with valid credentials!", "WELCOME, RUSU LORENA LORENA!", driver.findElement(By.cssSelector("body > div > div.page > div.header-language-background > div > p")).getText());


        //Dupa login, trebuie sa adaugi in cart, ca sa putem utiliza motoda de checkout.
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.className("nav-4"))).perform();
        driver.findElement(By.className("nav-4-2")).click();
        assertEquals("Bed and Bath screen reached", "BED & BATH",
                driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.page-title.category-title > h1")).getText());
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > div.actions > button")).click();
        assertEquals("Cart page reached", "SHOPPING CART",
                driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.cart.display-single-price > div.page-title.title-buttons > h1")).getText());
        assertTrue(driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.cart.display-single-price > ul > li > ul > li > span"))
                .getText().contains("was added to your shopping cart."));
    }

    @Test

    public void checkout() {
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.cart.display-single-price > div.cart-totals-wrapper > div > ul > li > button"))
                .click();
        assertTrue(driver.findElement(By.cssSelector("#opc-billing > div.step-title > h2")).getText().contains("BILLING INFORMATION"));
    }

    @After

    public void exitAndEmptyCart() {
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(3) > a")).click();
        driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr > td.a-center.product-cart-remove.last > a")).click();
        driver.quit();

    }


}


