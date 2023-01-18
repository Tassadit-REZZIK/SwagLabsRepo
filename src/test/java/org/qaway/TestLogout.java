package org.qaway;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qaway.base.CommonAPI;
import org.qaway.pages.HomePage;
import org.qaway.pages.LoginPage;
import org.qaway.utility.ExcelReader;
import org.qaway.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class TestLogout extends CommonAPI {

    Logger LOG = LogManager.getLogger(TestLogout.class.getName());
    String username = Utility.decode(prop.getProperty("username"));
    String password = Utility.decode(prop.getProperty("password"));

    @Test
    public void Logout() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUsername(username);
        loginPage.typePassword(password);
        loginPage.clickOnLoginButton();
        LOG.info("login button click success");
        HomePage homePage = new HomePage(driver);
        // click on hamburger menu
        homePage.clickOnHamburgerMenu();
        waitFor(2);
        // click on logout
        homePage.clickLogout();
        waitFor(2);
        LOG.info("current url: " + loginPage.getHomePageUrl(driver));
        Assert.assertEquals("https://www.saucedemo.com/", loginPage.getHomePageUrl(driver));waitFor(3);

    }
}
