package org.qaway;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qaway.base.CommonAPI;
import org.qaway.pages.*;
import org.qaway.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestValidatePrice extends CommonAPI {

    Logger LOG = LogManager.getLogger(TestValidatePrice.class.getName());
    String username = Utility.decode(prop.getProperty("username"));
    String password = Utility.decode(prop.getProperty("password"));

    @Test
    public void validatePrice(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        // login
        loginPage.login(username,password);
        Assert.assertTrue(homePage.productsHeaderIsDisplayed());
        waitFor(1);
        homePage.addItem1ToCart();
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
        Double expectedResult = checkoutStep2Page.getUnitPrice()+2.40;
        System.out.println(expectedResult);
        Double actualResult = checkoutStep2Page.getTotalPrice();
        Assert.assertEquals(expectedResult,actualResult);
    }



}
