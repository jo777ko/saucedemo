import org.junit.Test;


import static org.junit.Assert.*;

public class CartPageTest extends BaseTest{

    @Test
    public void successAddedItem(){
        LoginPage loginPage = new LoginPage(driver);
        User validUser = new User(validUserName, validPassword);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryContainerIsDisplayed());
        String costFromInventory = inventoryPage.backpackCost();
        inventoryPage.clickOnBackPackAddToCart();
        inventoryPage.clickOnJacketAddToCart();
        inventoryPage.clickOnCartIcon();
        CartPage cartPage = new CartPage(driver);
        assertTrue(cartPage.firstItemDisplayed());
        assertEquals(2, cartPage.getItemsQuantity());
        assertEquals(cartPage.checkItemPrice(), costFromInventory);



    }


    public void successAdding3Items(){
        LoginPage loginPage = new LoginPage(driver);
        User validUser = new User(validUserName, validPassword);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryContainerIsDisplayed());
        inventoryPage.clickOnBackPackAddToCart();
        inventoryPage.clickOnJacketAddToCart();
        inventoryPage.clickOnLightAddToCart();
        inventoryPage.clickOnCartIcon();
        CartPage cartPage = new CartPage(driver);
        assertTrue(cartPage.firstItemDisplayed());
        assertEquals(3, cartPage.getItemsQuantity());
        cartPage.allItemsAreDisplayed();

    }


    public void checkEmptyCart() {
        LoginPage loginPage = new LoginPage(driver);
        User validUser = new User(validUserName, validPassword);
        loginPage.successLogin(validUser);

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickOnCartIcon();

        CartPage cartPage = new CartPage(driver);

        assertTrue(cartPage.cartIsEmpty());

    }
}
