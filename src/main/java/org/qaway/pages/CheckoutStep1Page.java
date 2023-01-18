package org.qaway.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qaway.base.CommonAPI;

public class CheckoutStep1Page extends CommonAPI {
    Logger LOG = LogManager.getLogger(CheckoutStep1Page.class.getName());


    public CheckoutStep1Page(WebDriver driver){
        PageFactory.initElements(driver, this);
    }




    //    @FindBy(id= "first-name")
    @FindBy(xpath = "//input[@id='first-name']")
    WebElement firstNameInput;

    //    @FindBy(id = "last-name")
    @FindBy(xpath = "//input[@id='last-name']")
    WebElement lastNameInput;

    //    @FindBy(id = "postal-code")
    @FindBy(xpath = "//input[@id='postal-code']")
    WebElement postalCodeInput;

    //    @FindBy(id = "continue")
    @FindBy(xpath = "//input[@id='continue']")
    WebElement continueButton;






    public void insertInf(String fName, String lName, String cp){
        type(firstNameInput,fName);
        waitFor(1);
        type(lastNameInput,lName);
        waitFor(1);
        type(postalCodeInput,cp);
        waitFor(1);
    }

    public void ClickOnContinue(){
        continueButton.click();
        waitFor(1);
    }



}
