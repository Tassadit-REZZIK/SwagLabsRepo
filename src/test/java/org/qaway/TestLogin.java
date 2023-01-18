package org.qaway;

import com.mysql.cj.exceptions.AssertionFailedException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.qaway.base.CommonAPI;
import org.qaway.pages.HomePage;
import org.qaway.pages.LoginPage;
import org.qaway.pages.SLCommunityPage;
import org.qaway.pages.SLHomePage;
import org.qaway.utility.ExcelReader;
import org.qaway.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class TestLogin extends CommonAPI { // je rajoute extends CommonAPI
    Logger LOG = LogManager.getLogger(TestLogin.class.getName());

    // je fais appel à config.properties


    String username = Utility.decode(prop.getProperty("username"));

    String password = Utility.decode(prop.getProperty("password"));

    String username1 = prop.getProperty("username1");

    String username2 = prop.getProperty("username2");

    String username3 = prop.getProperty("username3");


    ExcelReader excelReader = new ExcelReader(Utility.currentDir+ File.separator+"data"+File.separator+"test-data.xlsx", "data");
    ExcelReader excelReader1 = new ExcelReader(Utility.currentDir+ File.separator+"data"+File.separator+"test-data.xlsx", "data1");



    //@Test
    public void  loginAttemptWithLockedUsername() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "login page title");
        String actual = getPageTitle();
        System.out.println(actual);
        System.out.println(expected);
        Assert.assertEquals(expected, actual);
        LOG.info("page title validation succes");
        loginPage.typeUsername(username1);
        loginPage.typePassword(password);
        loginPage.clickOnLoginButton();
        LOG.info("login button click succes");
        String textError = loginPage.getErrorMessage();
        LOG.info("error message: "+ textError);
        Assert.assertEquals(excelReader1.getDataForGivenHeaderAndKey("key", "invalid"), textError);
        LOG.info("error message validation succes");
    }

    @Test
    public void  loginAttemptWithProblemUser() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "login page title");
        String actual = getPageTitle();
        Assert.assertEquals(expected, actual);
        LOG.info("page title validation succes");
        loginPage.typeUsername(username2);
        loginPage.typePassword(password);
        loginPage.clickOnLoginButton();
        LOG.info("login button click succes");
        String expected1 = excelReader.getDataForGivenHeaderAndKey("key", "home page header");
        System.out.println(expected1);
        HomePage homePage = new HomePage(driver);
        String actual1 = homePage.productsHeader1();
        System.out.println(actual1);
        Assert.assertEquals(expected1, actual1);
        LOG.info("home page title validation success");
    }

    @Test
    public void  loginAttemptWithPerformanceGlitch() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "login page title");
        String actual = getPageTitle();
        Assert.assertEquals(expected, actual);
        LOG.info("page title validation succes");
        loginPage.typeUsername(username3);
        loginPage.typePassword(password);
        loginPage.clickOnLoginButton();
        LOG.info("login button click succes");
        HomePage homePage = new HomePage(driver);
        Thread.sleep(4000);
        Assert.assertTrue(homePage.Basket());
        System.out.println("items sorted success");

    }

    // this test is about scrollDown
    @Test
    public void scrollDownTests(){
        LoginPage loginPage = new LoginPage(driver);
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "login page title");
        String actual = getPageTitle();
        System.out.println(actual);
        System.out.println(expected);
        Assert.assertEquals(expected, actual);
        LOG.info("page title validation succes");
        loginPage.typeUsername(username);
        loginPage.typePassword(password);
        loginPage.clickOnLoginButton();
        LOG.info("login button click succes");
        HomePage homePage = new HomePage(driver);
        SLHomePage slHomePage = new SLHomePage(driver);
        // click on hamburger menu
        homePage.clickOnHamburgerMenu();
        waitFor(2);
        // click on about
        homePage.clickAboutLink();
        // click on sauce lab community
        LOG.info("current url: " + slHomePage.getSLHomePageUrl(driver));
        Assert.assertEquals("https://saucelabs.com/", slHomePage.getSLHomePageUrl(driver));
        waitFor(2);
        slHomePage.acceptCookies();
        slHomePage.clickOnLink();
        Assert.assertTrue(slHomePage.videoIsDisplayed());
    }
}
