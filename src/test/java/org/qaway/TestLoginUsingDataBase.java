package org.qaway;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qaway.base.CommonAPI;
import org.qaway.pages.HomePage;
import org.qaway.pages.LoginPage;
import org.qaway.utility.ConnectDB;
import org.qaway.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLoginUsingDataBase extends CommonAPI {
    Logger LOG = LogManager.getLogger(TestLoginUsingDataBase.class.getName());

    @Test
    public void TestLoginUsingDB () throws ClassNotFoundException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUsername(ConnectDB.getUsernameFromDB());
        loginPage.typePassword(ConnectDB.getPasswordFromDB());
        loginPage.clickOnLoginButton();
        LOG.info("login button click succes");
        HomePage homePage = new HomePage(driver);
        String expected1 = "PRODUCTS";
        String actual1 = homePage.productsHeader1();
        Assert.assertEquals(expected1,actual1);
        LOG.info("home page title validation success");
    }



}
