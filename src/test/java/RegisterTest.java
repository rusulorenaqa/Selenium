import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        register();
        registerWithoutEmail();
        registerWithoutPass();
        registerWithoutName();
        registerWithoutNewsletter();


    }

    public static void register() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.id("firstname")).sendKeys("Rusu");
        driver.findElement(By.id("middlename")).sendKeys("Lorena");
        driver.findElement(By.id("lastname")).sendKeys("Florina");
        driver.findElement(By.id("email_address")).sendKeys("rusulorena@yahoo.com");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.id("confirmation")).sendKeys("123");
        driver.findElement(By.id("is_subscribed")).click();
        //driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button")).click();
        driver.quit();
    }

    public static void registerWithoutEmail() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.id("firstname")).sendKeys("Rusu");
        driver.findElement(By.id("middlename")).sendKeys("Lorena");
        driver.findElement(By.id("lastname")).sendKeys("Florina");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.id("confirmation")).sendKeys("123");
        driver.findElement(By.id("is_subscribed")).click();
        //driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button")).click();
        driver.quit();
    }

    public static void registerWithoutPass() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.id("firstname")).sendKeys("Rusu");
        driver.findElement(By.id("middlename")).sendKeys("Lorena");
        driver.findElement(By.id("lastname")).sendKeys("Florina");
        driver.findElement(By.id("email_address")).sendKeys("rusulorena@yahoo.com");
        driver.findElement(By.id("is_subscribed")).click();
        //driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button")).click();
        driver.quit();
    }

    public static void registerWithoutName() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.id("email_address")).sendKeys("rusulorena@yahoo.com");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.id("confirmation")).sendKeys("123");
        driver.findElement(By.id("is_subscribed")).click();
        //driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button")).click();
        driver.quit();
    }

    public static void registerWithoutNewsletter() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.id("firstname")).sendKeys("Rusu");
        driver.findElement(By.id("middlename")).sendKeys("Lorena");
        driver.findElement(By.id("lastname")).sendKeys("Florina");
        driver.findElement(By.id("email_address")).sendKeys("rusulorena@yahoo.com");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.id("confirmation")).sendKeys("123");
        //driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button")).click();
        driver.quit();

    }

}
