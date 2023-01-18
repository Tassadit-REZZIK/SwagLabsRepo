package org.qaway;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qaway.base.CommonAPI;
import org.qaway.pages.HomePage;
import org.qaway.pages.LoginPage;
import org.qaway.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHandleChatBot extends CommonAPI {

    Logger LOG = LogManager.getLogger( TestHandleChatBot.class.getName());
    String username = Utility.decode(prop.getProperty("username"));
    String password = Utility.decode(prop.getProperty("password"));

    // ce test a un probleme d'expath, j'ai essayé 3 ou 4 et ça ne marche toujours pas
    @Test
    public void verifyChatBot(){
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
        waitFor(3);
        homePage.clickOnHandleChatBot();

    }

}


