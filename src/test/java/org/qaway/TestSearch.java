package org.qaway;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qaway.base.CommonAPI;
import org.qaway.pages.*;
import org.qaway.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSearch extends CommonAPI {
    Logger LOG = LogManager.getLogger( TestSearch.class.getName());
    String username = Utility.decode(prop.getProperty("username"));
    String password = Utility.decode(prop.getProperty("password"));

    @Test
    public void searchFunctionality(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        // login
        loginPage.login(username,password);
        // click on hamburger menu
        homePage.clickOnHamburgerMenu();
        waitFor(2);
        Assert.assertTrue(homePage.productsHeaderIsDisplayed());
        // click on about
        homePage.clickAboutLink();
        waitFor(1);
        // click on search button
        homePage.clickSearchButton();
        waitFor(1);
        homePage.setTextSearch();
        SolutionPage solutionPage = new SolutionPage(driver);
        Assert.assertTrue(solutionPage.searchResultsForSolutions());
    }
}
