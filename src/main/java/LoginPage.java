import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{
    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(tagName = "h3")
    private WebElement errorMessage;

    @FindBy(className = "login_logo")
    private WebElement title;

    @FindBy(id = "login_credentials")
    private WebElement listOfUserNamed;

    @FindBy(className = "login_password")
    private WebElement passwordAllUsers;

    public LoginPage(WebDriver driver){
            super(driver);
        }

    public void enterValueToUserName(User user){
        enterTextToElement(user.getUserName(), userName);
    }

    public void enterValueToPassword(User user){
        enterTextToElement(user.getPassword(), password);
    }

    public void pushLoginButton(){
        clickOnTheElement(loginButton);
    }

    public String errorMessage(){
        return getTextOfElement(errorMessage);
    }

    public void successLogin(User user){
        enterTextToElement(user.getUserName(), userName);
        enterTextToElement(user.getPassword(), password);
        clickOnTheElement(loginButton);
    }

    public boolean titleIsVisible(){
        return title.isDisplayed();
    }

    public boolean listOfUserNameIsVisible(){
        return listOfUserNamed.isDisplayed();
    }

    public boolean passwordAllUserIsVisible(){
        return passwordAllUsers.isDisplayed();
    }

}
