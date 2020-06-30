import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class LogoutTest {

    private WebDriver driver;

    @Before

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

    public void logout(){
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        assertEquals("Logout ok","WELCOME",
                driver.findElement(By.className("welcome-msg")).getText());

    }
    @After

    public void exit(){
        driver.quit();

    }


}
