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
        driver.findElement(By.cssSelector("div.product-collateral li.last")).click();
        driver.findElement(By.cssSelector("a[href='http://testfasttrackit.info/selenium-test/review/product/list/id/549/category/19/#review-form']")).click();
        assertEquals("Write your own review", "WRITE YOUR OWN REVIEW",
                driver.findElement(By.cssSelector("div.form-add h2")).getText());

    }



    @After

    public void exit(){
        driver.quit();
}}
