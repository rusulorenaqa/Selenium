import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WishListTest {


    private WebDriver driver;

    @Before
    //In wishlist, se pot adauga produse doar daca suntem logati intr-un cont valid!
    //Asadar inainte de fiecare test facem login!

    public void method(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.id("email")).sendKeys("rusulorena@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("parola");
        driver.findElement(By.cssSelector("#send2 > span > span")).click();
        assertEquals("You can login with valid credentials!", "WELCOME, RUSU LORENA LORENA!",driver.findElement(By.cssSelector("body > div > div.page > div.header-language-background > div > p")).getText());

    }
    @Test

    public void wishListAdd(){
        driver.findElement(By.className("nav-5")).click();
        driver.findElement(By.className("link-wishlist")).click();
        assertEquals("You re at wishlist","MY WISHLIST",
                driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col2-left-layout > div > div.col-main > div.my-account > div.my-wishlist > div > h1")).getText());
        assertTrue(driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col2-left-layout > div > div.col-main > div.my-account > div.my-wishlist > ul > li > ul > li > span")).getText().contains("has been added to your wishlist"));
    }
    @After

    public void exit(){

        driver.quit();

    }


}
