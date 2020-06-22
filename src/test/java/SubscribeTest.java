import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SubscribeTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        subscribe();

    }
    public static void subscribe(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#newsletter")).sendKeys("rusulorena@yahoo.com");
        driver.findElement(By.cssSelector("#newsletter-validate-detail > div > div.actions > button > span > span")).click();
        driver.quit();
    }
}
