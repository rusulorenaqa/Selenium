import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class LanguageTest {

    private WebDriver driver;

    @Before
    public void method(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");

    }
    @Test

    public void language(){

        WebElement testDropDown = driver.findElement(By.id("select-language"));
        Select dropdown = new Select(testDropDown);
        dropdown.selectByIndex(1);
        WebElement testDropDownAfterRefresh = driver.findElement(By.id("select-language"));
        Select dropdownAfterRefresh = new Select(testDropDownAfterRefresh);
        WebElement option = dropdownAfterRefresh.getFirstSelectedOption();
        assertEquals("Select language ok","French",
                option.getText());

    }
    @After
    public void exit(){
        driver.quit();
    }



}
