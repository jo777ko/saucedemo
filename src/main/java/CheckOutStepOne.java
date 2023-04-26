import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutStepOne extends BasePage{
    public CheckOutStepOne(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "postal-code")
    private WebElement zipCode;

    @FindBy(id = "continue")
    private WebElement continueButton;

    public void inputAllFields(){
        firstName.sendKeys("John");
        lastName.sendKeys("Cage");
        zipCode.sendKeys("123");
    }

    public void clickContinue(){
        continueButton.click();
    }


}
