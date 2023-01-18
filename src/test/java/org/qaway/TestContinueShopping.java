package org.qaway;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qaway.base.CommonAPI;
import org.qaway.pages.CartPage;
import org.qaway.pages.HomePage;
import org.qaway.pages.LoginPage;
import org.qaway.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestContinueShopping extends CommonAPI {
    Logger LOG = LogManager.getLogger(TestContinueShopping.class.getName());
    String username = Utility.decode(prop.getProperty("username"));
    String password = Utility.decode(prop.getProperty("password"));

    @Test
    public void ContinueShopping(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        // login
        LOG.info("user is going to login");
        loginPage.login(username,password);
        LOG.info("user logged in successfully");
        Assert.assertTrue(homePage.productsHeaderIsDisplayed());
        LOG.info("user is going to add item");
        waitFor(1);
        homePage.addItem1ToCart();
        LOG.info("user has added item1 successfully ");
        homePage.addItem1ToCartt();
        LOG.info("user has added item2 successfully ");
        waitFor(1);
        homePage.clicOnBasket();
        waitFor(1);
        CartPage cartPage = new CartPage(driver);
        cartPage.continueShopping();
        Assert.assertTrue(homePage.filterDropDownIsDisplayed());
    }
}
