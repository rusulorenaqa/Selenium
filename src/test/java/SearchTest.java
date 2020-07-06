import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class SearchTest {

    private WebDriver driver;

    @Before
    public void method(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");}

    @Test
    public void searchtest(){
        driver.findElement(By.id("search")).sendKeys("tops");
        driver.findElement(By.cssSelector("div.input-box button")).click();
        assertEquals("Searching ok", "SEARCH RESULTS FOR 'TOPS'",
                driver.findElement(By.cssSelector("div.page-title h1")).getText());


    }

    @After

    public void exit(){
        driver.quit();

    }

}
