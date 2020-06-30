import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;

public class GoToReview {

    private WebDriver driver;

    @Before
    public void method() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");

    }

    @Test

    public void goToProduct() {
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.className("nav-3"))).perform();
        driver.findElement(By.className("nav-3-2")).click();
        driver.findElement(By.id("product-collection-image-549")).click();
        driver.findElement(By.cssSelector("body > div.wrapper > div.page > div.main-container.col1-layout > div > div.col-main > div.product-view > div.product-collateral.toggle-content.tabs > ul > li.last")).click();
        driver.findElement(By.cssSelector("#customer-reviews > p > a")).click();
        assertEquals("Write yout own review", "WRITE YOUR OWN REVIEW",
                driver.findElement(By.cssSelector("#customer-reviews > div > h2")).getText());

    }



    @After

    public void exit(){
        driver.quit();
}}
