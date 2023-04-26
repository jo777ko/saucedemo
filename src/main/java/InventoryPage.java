import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

import static org.junit.Assert.assertTrue;

public class InventoryPage extends BasePage{

    @FindBy(xpath = "(//div[@id='inventory_container'])[1]")
    private WebElement inventoryContainer;

    @FindBy(xpath = "//div[@class='inventory_item']")
    private List<WebElement>productCards;

    @FindBy(id="add-to-cart-sauce-labs-backpack")
    private WebElement backpackAddToCrtButton;

    @FindBy(id="add-to-cart-sauce-labs-fleece-jacket")
    private WebElement jacketAddToCrtButton;

    @FindBy(id="add-to-cart-sauce-labs-bike-light")
    private WebElement lightAddToCrtButton;

    @FindBy(id = "shopping_cart_container")
    private WebElement cartIcon;

    @FindBy(xpath = "(//div [@class='inventory_item_price']) [1]")
    private WebElement backpackPriceOnInventoryPage;

    @FindBy(className = "shopping_cart_badge")
    public WebElement itemsInCart;

    @FindBy(xpath = "(//button [@class='btn btn_secondary btn_small btn_inventory'])")
    public List<WebElement> removeButton;

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean inventoryContainerIsDisplayed(){
        return inventoryContainer.isDisplayed();
    }

    public void allProductCardsAreVisible(){
        for (WebElement card:
             productCards) {
            assertTrue(card.isDisplayed());
        }
    }

    public void clickOnBackPackAddToCart(){
        backpackAddToCrtButton.click();
    }

    public void clickOnJacketAddToCart(){
        jacketAddToCrtButton.click();
    }

    public void clickOnLightAddToCart(){
        lightAddToCrtButton.click();
    }



    public void clickOnCartIcon(){
        cartIcon.click();
    }

    public String backpackCost(){
        return backpackPriceOnInventoryPage.getText();
    }

}
