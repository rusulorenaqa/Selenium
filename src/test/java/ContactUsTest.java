import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContactUsTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        contactUs();

    }
    public static void contactUs(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("body > div > div.page > div.footer-container > div > div:nth-child(2) > ul > li:nth-child(2) > a")).click();
        driver.findElement(By.id("name")).sendKeys("Rusu Lorena");
        driver.findElement(By.id("email")).sendKeys("rusulorena@yahoo.com");
        driver.findElement(By.id("telephone")).sendKeys("0766 666 666");
        driver.findElement(By.id("comment")).sendKeys("Buna ziua, La revedere!");
        driver.findElement(By.cssSelector("#contactForm > div.buttons-set > button > span > span")).click();
        driver.quit();
    }
}
