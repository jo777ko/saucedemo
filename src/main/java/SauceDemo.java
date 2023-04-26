import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SauceDemo {

    ChromeDriver driver;
    String BASE_URL = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gambi\\Downloads\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(BASE_URL);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void validLoginData() throws InterruptedException {
        WebElement login = driver.findElement(By.id("user-name"));
        login.sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement logInButton = driver.findElement(By.id("login-button"));
        logInButton.click();
        sleep(10000);
        driver.getCurrentUrl();
//        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
        assertTrue(driver.getCurrentUrl().contains("inventory"));
        WebElement inventoryContainer = driver.findElements(By.id("inventory_container")).get(0);
        assertTrue(inventoryContainer.isDisplayed());
    }

    @Test
    public void invalidLoginData() throws InterruptedException {
        WebElement login = driver.findElement(By.id("user-name"));
        login.sendKeys("locked_out_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement logInButton = driver.findElement(By.id("login-button"));
        logInButton.click();
        sleep(5000);
        WebElement errorMessage = driver.findElement(By.xpath(
                "//div [@class='error-message-container error'] /h3"));
        assertTrue(errorMessage.getText().contains("Sorry, this user has been locked out."));
//        assertEquals("Epic sadface: Sorry, this user has been locked out.",
//                errorMessage.getText());
//        System.out.println(errorMessage.getText());

    }

    @Test
    public void invalidLogin() throws InterruptedException {
        WebElement login = driver.findElement(By.id("user-name"));
        login.sendKeys("abcd");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement logInButton = driver.findElement(By.id("login-button"));
        logInButton.click();
        sleep(5000);
        WebElement errorMessage = driver.findElement(By.xpath(
                "//div [@class='error-message-container error'] /h3"));
        assertTrue(errorMessage.getText().contains(
                "Username and password do not match any user in this service"));
//        assertEquals("Epic sadface: Username and password do not match any user in this service",
//                errorMessage.getText());
//        System.out.println(errorMessage.getText());

    }


}
