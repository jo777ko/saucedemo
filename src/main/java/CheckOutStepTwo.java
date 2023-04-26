import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static java.lang.Double.parseDouble;

public class CheckOutStepTwo extends BasePage{

    public CheckOutStepTwo(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "summary_subtotal_label")
    private WebElement itemTotal;

    public double getTotal(){
        return parseDouble(itemTotal.getText().substring(13));
//       return parseDouble(itemTotal.getText().substring(itemTotal.getText().indexOf("$")+1));
//        return parseDouble(itemTotal.getText().replace("Item total: $", ""));
    }
}
