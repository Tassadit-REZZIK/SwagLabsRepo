package org.qaway;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qaway.base.CommonAPI;
import org.qaway.pages.HomePage;
import org.qaway.pages.LoginPage;
import org.qaway.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestFilter extends CommonAPI {
    Logger LOG = LogManager.getLogger(TestFilter.class.getName());


    String username = Utility.decode(prop.getProperty("username"));
    String password = Utility.decode(prop.getProperty("password"));

    @Test
    public void filterFromHighToLow(){
        LoginPage loginPage= new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login(username, password);
        Assert.assertTrue(homePage.productsHeaderIsDisplayed()); // Assert c'est une partie du test
        captureScreenshot("homepage");


        homePage.selectHigherToLowerFromFilter();   // spécifique
        System.out.println("list of prices:" +homePage.getItemsPrice());


        double[] finalPrices = Utility.listToArrayOfDouble(homePage.getItemsPrice());
        Assert.assertTrue(Utility.isSortedHighToLow(finalPrices)); // vérifier si la liste is sorted
        System.out.println("items sorted success");
    }

    @Test
    public void filterFromAtoZ(){
        LoginPage loginPage= new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login(username, password);
        Assert.assertTrue(homePage.productsHeaderIsDisplayed()); // Assert c'est une partie du test
        captureScreenshot("homepage");


        homePage.selectAtoZFilter();   // spécifique
        System.out.println("list of names:" +homePage.getItemsName());


        String[] finalNames = Utility.listToArrayOfString(homePage.getItemsName());
        Assert.assertTrue(Utility.isSortedAtoZ(finalNames)); // vérifier si la liste is sorted
        System.out.println("items sorted success");
    }

    @Test
    public void filterFromZtoA(){
        LoginPage loginPage= new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login(username, password);
        Assert.assertTrue(homePage.productsHeaderIsDisplayed()); // Assert c'est une partie du test
        captureScreenshot("homepage");


        homePage.selectZtoAFilter();   // spécifique
        System.out.println("list of names:" +homePage.getItemsName());


        String[] finalNames = Utility.listToArrayOfString(homePage.getItemsName());
        Assert.assertTrue(Utility.isSortedZtoA(finalNames)); // vérifier si la liste is sorted
        System.out.println("items sorted success");
    }


}
