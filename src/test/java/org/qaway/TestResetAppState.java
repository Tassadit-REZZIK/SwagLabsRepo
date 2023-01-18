package org.qaway;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qaway.base.CommonAPI;
import org.qaway.pages.HomePage;
import org.qaway.pages.LoginPage;
import org.qaway.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestResetAppState extends CommonAPI {

    Logger LOG = LogManager.getLogger(TestResetAppState.class.getName());
    String username = Utility.decode(prop.getProperty("username"));
    String password = Utility.decode(prop.getProperty("password"));

    @Test
    public void resetAppState() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUsername(username);
        loginPage.typePassword(password);
        loginPage.clickOnLoginButton();
        LOG.info("login button click success");
        HomePage homePage = new HomePage(driver);
        homePage.addItem1ToCart();
        homePage.addItem1ToCartt();
        waitFor(1);
        Assert.assertTrue(homePage.Baskett().contains("2"));
        // click on hamburger menu
        homePage.clickOnHamburgerMenu();
        waitFor(2);
        // click on AppState
        homePage.clickResetAppState();
        waitFor(2);
        System.out.println(homePage.BasketText());
        boolean val = false;
        if (homePage.BasketText().equals("")){
           val = true;}
        else{
           val = false;
        }
        Assert.assertTrue(val);
    }
}
