import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

import static java.lang.Double.doubleToRawLongBits;
import static java.lang.Double.parseDouble;
//import java.util.


public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "cart_item")
    private List<WebElement> items;

    @FindBy(className = "inventory_item_price")
    private WebElement itemPrice;

    @FindBy(xpath = "(//div [@class = 'inventory_item_price'])")
    private List<WebElement> itemPrices;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;


    public boolean firstItemDisplayed(){
        return items.get(0).isDisplayed();
    }

    public int getItemsQuantity(){
        return items.size();
    }

    public boolean cartIsEmpty(){
        boolean empty = false;
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.visibilityOf(items.get(0)));
        } catch(Exception e){
            empty = true;
        }
        return empty;
    }

    public boolean allItemsAreDisplayed(){
        return allElementsCollectionsAreDisplayed(items);
    }

    public String checkItemPrice(){
        return (itemPrice.getText());
    }

    public String getPricesOfItem(){
        return itemPrices.get(0).getText();
    }

    public String getTotalCartPrice(){

        String str1 = itemPrices.get(0).getText();
        String str2 = itemPrices.get(1).getText();

        String charsToRemove = "$";

        for (char c : charsToRemove.toCharArray()) {
            str1 = str1.replace(String.valueOf(c), "");
            str2 = str2.replace(String.valueOf(c), "");
        }

        float total = Float.parseFloat(str1) + Float.parseFloat(str1);
        return "$" + total;
    }

    public double getTotalPriceOfItems(){
        double total = 0;
        for (WebElement item: itemPrices)
         {
             total += parseDouble(item.getText().substring(1));
        }
        return total;
    }

    public void clickCheckoutButton(){
        clickOnTheElement(checkoutButton);
    }

}
