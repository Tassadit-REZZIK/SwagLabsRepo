package org.qaway.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qaway.base.CommonAPI;

public class CheckoutCompletePage extends CommonAPI {
    Logger LOG = LogManager.getLogger(CheckoutCompletePage.class.getName());


    public CheckoutCompletePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[normalize-space()='THANK YOU FOR YOUR ORDER']")
    WebElement orderTitle;

    public boolean getOrderTitle() {
        return orderTitle.isDisplayed();
    }
    @FindBy(xpath = "//button[@id='back-to-products']")
    WebElement homeButton;

    public boolean getHomeButton(){
        return homeButton.isDisplayed();
    }
}