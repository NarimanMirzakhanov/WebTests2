import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;


public class WebTest {

    @Test
    public void testFirst() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Users/Nariman/Downloads/chromedriver";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "http://www.99-bottles-of-beer.net/";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void testSecond() throws InterruptedException {

            String chromeDriver = "webdriver.chrome.driver";
            String driverPath = "/Users/Nariman/Downloads/chromedriver";
            String url = "http://www.99-bottles-of-beer.net/";
            String expectedResult = "Welcome to 99 Bottles of Beer";

            System.setProperty(chromeDriver, driverPath);
            WebDriver driver = new ChromeDriver();

        try {

            driver.get(url);
            Thread.sleep(2000);

            String actualResult = driver.findElement(By.cssSelector("#main > h2")).getText();

            Assert.assertEquals(expectedResult, actualResult);
        } finally {
            driver.quit();
        }
    }
}
