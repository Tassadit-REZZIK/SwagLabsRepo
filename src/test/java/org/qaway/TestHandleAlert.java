package org.qaway;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qaway.base.CommonAPI;
import org.qaway.pages.HomePage;
import org.qaway.pages.LoginPage;
import org.qaway.utility.Utility;
import org.testng.annotations.Test;

public class TestHandleAlert extends CommonAPI {

    Logger LOG = LogManager.getLogger(TestHandleAlert.class.getName());
    String username = Utility.decode(prop.getProperty("username"));
    String password = Utility.decode(prop.getProperty("password"));


    // ce test marche en cas de synchronisation de l'email
    @Test
    public void acceptHandleAlert(){
        LoginPage loginPage = new LoginPage(driver);
        // login
        LOG.info("user is going to login");
        loginPage.login(username,password);
        LOG.info("user logged in successfully");
        acceptAlert(driver);
    }
}
