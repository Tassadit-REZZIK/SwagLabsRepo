package org.qaway;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qaway.base.CommonAPI;
import org.qaway.pages.HomePage;
import org.qaway.pages.LoginPage;
import org.qaway.pages.ScrollDownSwagLabsPage;
import org.qaway.utility.Utility;
import org.testng.annotations.Test;

public class TestScrollDownSwagLabs extends CommonAPI {
    Logger LOG = LogManager.getLogger(TestScrollDownSwagLabs.class.getName());
    String username = Utility.decode(prop.getProperty("username"));
    String password = Utility.decode(prop.getProperty("password"));

    @Test
    public void TestSDSL(){
        LoginPage loginPage = new LoginPage(driver);
        // login
        loginPage.login(username,password);
        HomePage homePage = new HomePage(driver);
        scrollIntoView(driver, homePage.Robot());
    }
}
