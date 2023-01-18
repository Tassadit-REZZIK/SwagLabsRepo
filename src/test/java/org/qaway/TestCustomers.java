package org.qaway;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qaway.base.CommonAPI;
import org.qaway.pages.HomePage;
import org.qaway.pages.LoginPage;
import org.qaway.pages.SLCommunityPage;
import org.qaway.pages.SLHomePage;
import org.qaway.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCustomers extends CommonAPI {

    Logger LOG = LogManager.getLogger(TestCustomers.class.getName());

    String username = Utility.decode(prop.getProperty("username"));
    String password = Utility.decode(prop.getProperty("password"));

    @Test
    public void Customers (){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        SLHomePage slHomePage = new SLHomePage(driver);
        // login
        loginPage.login(username,password);
        // click on hamburger menu
        homePage.clickOnHamburgerMenu();
        waitFor(2);
        Assert.assertTrue(homePage.productsHeaderIsDisplayed());

        // click on about
        homePage.clickAboutLink();
        slHomePage.titleCustomersMessage();
        slHomePage.visaCustomer();
        slHomePage.clickOnCarousel();
        slHomePage.stripCustomer();
        slHomePage.clickOnCarousel();
        slHomePage.buzzFeedCustomer();
        LOG.info("customer displayed successfully");
    }
}

