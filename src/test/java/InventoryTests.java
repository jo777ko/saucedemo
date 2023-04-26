import org.junit.Test;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class InventoryTests extends BaseTest{

    @Test
    public void visibilityOfProductCards(){
        LoginPage loginPage = new LoginPage(driver);
        User validUser = new User(validUserName, validPassword);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.allProductCardsAreVisible();

    }

    @Test
    public void checkProductAdded() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        User validUser = new User(validUserName, validPassword);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryContainerIsDisplayed());
        SideBar sideBar = new SideBar(driver);
        sideBar.openSideBar();
        sleep(2000);
        sideBar.resetAppStoreLink.click();
//        sideBar.clickOnResetAppState();
        sleep(2000);
        sideBar.closeSideBar();
        sleep(2000);
        inventoryPage.clickOnBackPackAddToCart();
        sleep(10000);


    }

    @Test
    public void checkLogOut() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        User validUser = new User(validUserName, validPassword);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryContainerIsDisplayed());
        SideBar sideBar = new SideBar(driver);
        sideBar.openSideBar();
        sleep(2000);
        sideBar.logoutLink.click();
        sleep(2000);
        assertTrue(loginPage.listOfUserNameIsVisible());
        sleep(2000);

    }

}
