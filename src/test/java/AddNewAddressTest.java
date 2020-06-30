import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class AddNewAddressTest {

    private WebDriver driver;

    @Before
    public void method() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.id("email")).sendKeys("rusulorena@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("parola");
        driver.findElement(By.cssSelector("#send2 > span > span")).click();
        assertEquals("You can login with valid credentials!", "WELCOME, RUSU LORENA LORENA!", driver.findElement(By.cssSelector("body > div > div.page > div.header-language-background > div > p")).getText());
    }

    @Test

    public void addAddress() {
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.first > a")).click();
        assertEquals("You re in Dashboard.", "MY DASHBOARD",
                driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col2-left-layout > div > div.col-main > div.my-account > div > div.page-title > h1")).getText());
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col2-left-layout > div > div.col-left.sidebar.col-left-first > div > div.block-content > ul > li:nth-child(3) > a")).click();
        driver.findElement(By.id("street_1")).sendKeys("Primaverii Street, no3");
        driver.findElement(By.id("city")).sendKeys("Cluj-Napoca");

        WebElement dropDownCountry = driver.findElement(By.id("country"));
        Select drop = new Select(dropDownCountry);
        drop.selectByIndex(16);
        WebElement optionCountry = drop.getFirstSelectedOption();
        assertEquals("Select region ok", "Austria",
                optionCountry.getText());

        WebElement testDropDown = driver.findElement(By.id("region_id"));
        Select dropdown = new Select(testDropDown);
        dropdown.selectByIndex(1);
        WebElement option = dropdown.getFirstSelectedOption();
        assertEquals("Select region ok", "Burgenland",
                option.getText());
        driver.findElement(By.id("zip")).sendKeys("41234567");


    }

    @After
    public void exit() {
        driver.quit();

    }


}
