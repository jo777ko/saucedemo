import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    int waitTimeToClick = 5;
    int waitLongTimeToClick = 15;
    int waitTimeForVisibility = 10;

    public void enterTextToElement(String text, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeToClick));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public void enterTextToElementLongWait(String text, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitLongTimeToClick));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public void clickOnTheElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeToClick));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public String getTextOfElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeForVisibility));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    public boolean allElementsCollectionsAreDisplayed(List<WebElement> collections){
        for(WebElement item : collections){
            if(!item.isDisplayed()){ // = (item.isDisplayed() == false)
                return false;
            }
        }
        return true;
    }

}
