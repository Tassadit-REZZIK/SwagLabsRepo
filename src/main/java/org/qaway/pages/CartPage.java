package org.qaway.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qaway.base.CommonAPI;

public class CartPage extends CommonAPI {
    Logger LOG = LogManager.getLogger(CartPage.class.getName());


    public CartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@id='checkout']")
    WebElement checkout;

    @FindBy(xpath = "//button[@id='continue-shopping']")
    WebElement continueButton;

    @FindBy(xpath = " //button[@id='remove-sauce-labs-backpack']")
    WebElement removeButton;

    @FindBy(xpath = "//*[@id='shopping_cart_container']/a/span")
    WebElement basketbadge;


    public void clickOnCheckout(){
        clickOn(checkout);
    }

    public void continueShopping(){
        clickOn(continueButton);
    }

    public void clickOnRemove(){
        clickOn(removeButton);
    }
    public String Baskett(){
        return (basketbadge.getText());
    }

}
