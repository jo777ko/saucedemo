import org.junit.Test;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginTests extends BaseTest{

    @Test
    public void validLoginData() {
        LoginPage loginPage = new LoginPage(driver);
        User validUser = new User(validUserName, validPassword);
        loginPage.enterValueToUserName(validUser);
        loginPage.enterValueToPassword(validUser);
        loginPage.pushLoginButton();
        assertTrue(driver.getCurrentUrl().contains("inventory"));
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryContainerIsDisplayed());

    }

    @Test
    public void loginWithLockedOutUser() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        User lockOutUser = new User(lockedOutUserName, validPassword);
        loginPage.enterValueToUserName(lockOutUser);
        loginPage.enterValueToPassword(lockOutUser);
        loginPage.pushLoginButton();
        assertTrue(loginPage.errorMessage().contains("Sorry, this user has been locked out."));

    }

    @Test
    public void invalidUser() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        User invalidUser = new User(invalidUserName, invalidUserPassword);
        loginPage.enterValueToUserName(invalidUser);
        loginPage.enterValueToPassword(invalidUser);
        loginPage.pushLoginButton();
        assertTrue(loginPage.errorMessage().contains(
                "Username and password do not match any user in this service"));
//      assertEquals("Epic sadface: Username and password do not match any user in this service",
//                loginPage.errorMessage());

    }

    @Test
    public void titleIsVisible(){
        LoginPage loginPage = new LoginPage(driver);
        assertTrue(loginPage.titleIsVisible());
    }

    @Test
    public void listOfUserIsVisible(){
        LoginPage loginPage = new LoginPage(driver);
        assertTrue(loginPage.listOfUserNameIsVisible());
    }

    @Test
    public void passwordAllUsersIsVisible(){
        LoginPage loginPage = new LoginPage(driver);
        assertTrue(loginPage.passwordAllUserIsVisible());
    }
    @Test
    public void successLogout() {
        LoginPage loginPage = new LoginPage(driver);
        User validUser = new User(validUserName, validPassword);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryContainerIsDisplayed());
        SideBar sideBar = new SideBar(driver);
        sideBar.openSideBar();
        sideBar.logoutLink.click();
        assertTrue(loginPage.listOfUserNameIsVisible());
    }
}
