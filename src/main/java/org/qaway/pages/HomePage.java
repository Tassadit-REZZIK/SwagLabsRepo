package org.qaway.pages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qaway.base.CommonAPI;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends CommonAPI {

    Logger LOG = LogManager.getLogger(HomePage.class.getName());


    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".title")

    WebElement productsHeader;

    ///////////////////////

    @FindBy(css=".product_sort_container")
    WebElement filterDropdown; // menu des roulants


    @FindBy(xpath="//div[@class='inventory_item_price']")
    List<WebElement> itemsPrice; // on a utilisé List car ça correspond à 6WebElemets

    /////////////////////

    @FindBy(xpath="//div[@class='inventory_item_name']")
    List<WebElement> itemsName; // on a utilisé List car ça correspond à 6WebElemets

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    WebElement hamburgerMenu;

   @FindBy(xpath = "//a[@id='about_sidebar_link']")
    WebElement aboutLink;

    @FindBy(className = "drift-controller-icon--active")
    WebElement chatbot;








    @FindBy(xpath = "//a[@id='reset_sidebar_link']")
    WebElement resetappstatelink;

    @FindBy(xpath = "//a[@id='inventory_sidebar_link']")
    WebElement allItemsLink;

    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    WebElement logoutLink;

    @FindBy(xpath = "//a[@id='reset_sidebar_link']")
    WebElement resetAppStateLink;

    @FindBy(xpath = "(//div[@class='inventory_item_price']/following-sibling::button)[1]")
    WebElement item1;
    @FindBy(xpath = "(//div[@class='inventory_item_price']/following-sibling::button)[2]")
    WebElement item2;

    @FindBy(css =".shopping_cart_link")
    WebElement basket;

    @FindBy(xpath = "//span[contains(text(),'2')]")
    WebElement basketbadge;

    @FindBy(xpath = "//*[@id='page_wrapper']/footer/img")

    WebElement robot;

    @FindBy(xpath = "//i[@class='svg svg-search nav-action-list-items-search-form-icon has-fill-white']//*[name()='svg']")

    WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"headerMainNav\"]/div/nav/ul/li[3]/ul/li[4]/form/div/input")

    WebElement searchInput;
    public WebElement Robot(){
        return robot;
    }

    public String Baskett(){
        return basketbadge.getText();
    }


    public boolean Basket(){
        return isDisplayed(basket);
    }
    public String BasketText(){
        return basket.getText();
    }

    public void clicOnBasket(){
        basket.click();
    }

    public boolean productsHeaderIsDisplayed(){
        LOG.info("products header is displayed");
//        System.out.println("products header is displayed");
        return  isDisplayed(productsHeader);
    }
    //////////

    public String productsHeader1(){
        LOG.info("get products");
        return productsHeader.getText() ;
    }


    public void selectLowerToHigherFromFilter(){
        selectFromDropdown(filterDropdown, "Price (low to high)");
        LOG.info("price low to high select success");
    }



////////////////////////
    public void selectHigherToLowerFromFilter(){
        selectFromDropdown(filterDropdown, "Price (high to low)");
        LOG.info("price high to low select success");
    }



    public void selectAtoZFilter(){
        selectFromDropdown(filterDropdown, "Name (A to Z)");
        LOG.info("Name A to Z select success");
    }


    public void selectFromFilter(String option){
        selectFromDropdown(filterDropdown, option);
        LOG.info(option + " price low to high select success");
    }

    public void selectZtoAFilter(){
        selectFromDropdown(filterDropdown, "Name (Z to A)");
        LOG.info("Name Z to A select success");
    }

    public boolean filterDropDownIsDisplayed(){
        LOG.info("filter drop down success");
        return isDisplayed(filterDropdown);
    }

    public List<String> getItemsPrice(){
        List<String> prices = new ArrayList<String>();
        for (WebElement itemPrice: itemsPrice){
            prices.add(itemPrice.getText().replace("$",""));
        }
        return prices;
    }


    public List<String> getItemsName(){
        List<String> names = new ArrayList<String>();
        for (WebElement itemName: itemsName){
            names.add(itemName.getText());
        }
        return names;
    }

    public boolean validateAllItemsOptionIsDisplayed(){
        LOG.info("checking all items link is displayed ...");
        return isDisplayed (allItemsLink);
    }
    public boolean validateAboutOptionsIsDisplayed(){
        LOG.info("cheking about link is displayed ...");
        return isDisplayed (aboutLink);
    }
    public boolean validateLogoutOptionsIsDisplayed(){
        LOG.info("cheking logout link is displayed ...");
        return isDisplayed (logoutLink);
    }
    public boolean validateResetAppStateOptionsIsDisplayed(){
        LOG.info("cheking app state link is displayed ...");
        return isDisplayed (resetAppStateLink);
    }

    public void clickOnHamburgerMenu (){
        clickOn(hamburgerMenu);
        LOG.info("click on hamburger menu success");
    }
    public void clickAboutLink (){
        clickOn(aboutLink);
        LOG.info("click on about link success");
    }

    public void clickOnHandleChatBot(){
        clickOn(chatbot);
        LOG.info("click on handle chat bot success");
    }

    public void clickSearchButton (){
        clickOn(searchButton);
        LOG.info("click on search button success");
    }

    public void setTextSearch(){
        type(searchInput, "Solutions"+"\n");
        LOG.info("typing text into search field");
    }

    public void clickResetAppState(){
        clickOn(resetappstatelink);
        LOG.info("click on reset AppState success");
    }

    public void clickLogout(){
        clickOn( logoutLink);
        LOG.info("click on reset AppState success");
    }
    public void addItem1ToCart(){
        item1.click();
    }

    public void addItem1ToCartt(){
        clickOn(item2);
    }

    public String getItem1Color(){
        return getElementCssValue(item1);
    }
}



