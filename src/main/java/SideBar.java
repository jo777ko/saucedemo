import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class SideBar extends BasePage{

    WebDriver driver;
    @FindBy(className = "bm-menu-wrap")
    WebElement sideBarMenu;

    @FindBy(id = "react-burger-menu-btn")
    public WebElement sideBarButton;

    @FindBy(id = "inventory_sidebar_link")
    public WebElement allItemsLink;

    @FindBy(id = "about_sidebar_link")
    public WebElement aboutLink;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logoutLink;

    @FindBy(id = "reset_sidebar_link")
    public WebElement resetAppStoreLink;

    @FindBy(id = "react-burger-cross-btn")
    public WebElement sideBarCloseButton;



    public SideBar(WebDriver driver){
        super(driver);
    }

    public boolean sideBarIsVisible(){
        return sideBarButton.isDisplayed();
    }

    public boolean allItemsLinkIsVisible() throws InterruptedException {
        sleep(2000);
        return allItemsLink.isDisplayed();
    }

    public boolean aboutLinkIsVisible(){
        return aboutLink.isDisplayed();
    }

    public boolean logoutLinkIsVisible(){
        return logoutLink.isDisplayed();
    }

    public boolean resetAppStoreLinkIsVisible(){
        return resetAppStoreLink.isDisplayed();
    }
    public boolean sideBarCloseButtonIsVisible(){
        return sideBarCloseButton.isDisplayed();
    }

    public void openSideBar(){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.visibilityOf(sideBarButton));
        sideBarButton.click();

    }

    public void closeSideBar(){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.visibilityOf(sideBarCloseButton));
        sideBarCloseButton.click();
    }

    public boolean sideBarCloseButtonIsEnable(){
        return sideBarCloseButton.isEnabled();
    }

    public void sideBarIsHidden(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOf(sideBarMenu));
    }

    public void clickOnResetAppState(){
        resetAppStoreLink.click();
    }


}
