import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckOutTest extends BaseTest{

    @Test
    public void checkTotalItem(){
        LoginPage loginPage = new LoginPage(driver);
        User validUser = new User(validUserName, validPassword);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryContainerIsDisplayed());
        inventoryPage.clickOnBackPackAddToCart();
        inventoryPage.clickOnCartIcon();
        CartPage cartPage = new CartPage(driver);
        double totalFromCart = cartPage.getTotalPriceOfItems();
        cartPage.clickCheckoutButton();
        CheckOutStepOne checkOutStepOne = new CheckOutStepOne(driver);
        checkOutStepOne.inputAllFields();
        checkOutStepOne.clickContinue();
        CheckOutStepTwo checkOutStepTwo = new CheckOutStepTwo(driver);
        assertEquals(totalFromCart, checkOutStepTwo.getTotal(), 0);




    }
}
