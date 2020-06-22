import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LanguageTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        language();

    }

    public static void language(){

        WebDriver driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
        WebElement testDropDown = driver.findElement(By.id("select-language"));
        Select dropdown = new Select(testDropDown);
        dropdown.selectByIndex(1);
        driver.quit();

    }


}
