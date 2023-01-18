package org.qaway;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qaway.base.CommonAPI;
import org.qaway.pages.*;
import org.qaway.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestEndToEnd extends CommonAPI {

    Logger LOG = LogManager.getLogger(TestEndToEnd.class.getName());
    String username = Utility.decode(prop.getProperty("username"));
    String password = Utility.decode(prop.getProperty("password"));

    @Test
    public void order(){
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
        LOG.info("user has added item successfully ");
        waitFor(1);
        homePage.clicOnBasket();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickOnCheckout();
        waitFor(1);
        CheckoutStep1Page checkoutStep1Page = new CheckoutStep1Page(driver);
        waitFor(1);
        checkoutStep1Page.insertInf("Tassadit","REZZIK", "54300");
        waitFor(1);
        checkoutStep1Page.ClickOnContinue();
        CheckoutStep2Page checkoutStep2Page = new CheckoutStep2Page(driver);
        waitFor(1);
        checkoutStep2Page.ClickOnFinishButton();
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        Assert.assertTrue(checkoutCompletePage.getOrderTitle());
        Assert.assertTrue(checkoutCompletePage.getHomeButton());

    }

}
