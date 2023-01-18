package org.qaway;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qaway.base.CommonAPI;
import org.qaway.pages.LoginPage;
import org.qaway.utility.ExcelReader;
import org.qaway.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class TestUI extends CommonAPI {

    Logger LOG = LogManager.getLogger(TestUI.class.getName());

    ExcelReader excelReader = new ExcelReader(Utility.currentDir+ File.separator+"data"+File.separator+"test-data.xlsx", "data");

    @Test
    public void validateSwagLabsPageElements(){
        LoginPage loginPage = new LoginPage(driver);
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "login page title");
        String actual = getPageTitle();
        Assert.assertEquals(expected, actual);
        LOG.info("page title validation succes");
        captureScreenshot("initialpage");

        boolean imageDisplayed = loginPage.imageFieldIsDisplayed();
        Assert.assertTrue(imageDisplayed);
        LOG.info("image field is displayed");

        boolean credentialsIsDisplayed = loginPage.credentialsIsDisplayed();
        Assert.assertTrue(credentialsIsDisplayed);
        LOG.info("credentials is displayed");

        boolean passwordLoginIsDisplayed = loginPage.loginPasswordIsDisplayed();
        Assert.assertTrue(passwordLoginIsDisplayed);
        LOG.info("login password field is displayed");

        boolean loginWrapperIsDisplayed = loginPage.loginWrapperIsDisplayed();
        Assert.assertTrue(loginWrapperIsDisplayed);
        LOG.info("login wrapper field is displayed");


    }






}














