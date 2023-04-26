import io.qameta.allure.Attachment;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseTest {
    public static ChromeDriver driver;
    String BASE_URL = "https://www.saucedemo.com/";



    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gambi\\Downloads\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(BASE_URL);
    }

    @After
    public void tearDown() {

        driver.quit();
    }

    public String validUserName = "standard_user";
    public String lockedOutUserName = "locked_out_user";

    public String validPassword = "secret_sauce";
    public String lockedOutUserPassword = "secret_sauce";

    public String invalidUserName = "abcd";
    public String invalidUserPassword = "secret";

//    @Rule
//    public TestWatcher screenShotOnFailure = new TestWatcher() {
//        @Override
//        protected void failed(Throwable e, Description description) {
//            makeScreenshotOnFailure();
//            driver.close();
//            driver.quit();
//
//        }
//
//        protected void succeeded(Description description){
//            driver.close();
//            driver.quit();
//        }
//        @Attachment("Screenshot on failure")
//        public byte[] makeScreenshotOnFailure(){
//            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//        }
//    };
}
