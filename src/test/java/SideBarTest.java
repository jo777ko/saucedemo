import org.junit.Test;

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;

public class SideBarTest extends BaseTest{

    @Test
    public void linksAreaIsVisible() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        User validUser = new User(validUserName, validPassword);
        loginPage.successLogin(validUser);
        SideBar sideBar = new SideBar(driver);
//        sleep(1000);
        sideBar.openSideBar();
//        sleep(5000);
        assertTrue(sideBar.sideBarIsVisible());
        assertTrue(sideBar.allItemsLinkIsVisible());
        assertTrue(sideBar.aboutLinkIsVisible());
        assertTrue(sideBar.logoutLinkIsVisible());
        assertTrue(sideBar.resetAppStoreLinkIsVisible());
        assertTrue(sideBar.sideBarCloseButtonIsVisible());
    }
    @Test
    public void closeSideBar() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        User validUser = new User(validUserName, validPassword);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryContainerIsDisplayed());
        SideBar sideBar = new SideBar(driver);
        sideBar.openSideBar();
        sideBar.closeSideBar();
//        sideBar.sideBarIsHidden();
        sleep(2000);
        assertFalse(sideBar.allItemsLinkIsVisible());
        assertFalse(sideBar.aboutLinkIsVisible());
        assertFalse(sideBar.logoutLinkIsVisible());
        assertFalse(sideBar.resetAppStoreLinkIsVisible());
    }

    @Test
    public void resetAppStateCorrectly(){
        LoginPage loginPage = new LoginPage(driver);
        User validUser = new User(validUserName, validPassword);
        loginPage.successLogin(validUser);

        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryContainerIsDisplayed());

        inventoryPage.clickOnBackPackAddToCart();
        inventoryPage.clickOnJacketAddToCart();

        assertEquals(Integer.parseInt(inventoryPage.itemsInCart.getText()), inventoryPage.removeButton.size());
    }

}
