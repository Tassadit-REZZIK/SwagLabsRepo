package org.qaway.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qaway.base.CommonAPI;

public class ScrollDownAboutPage extends CommonAPI {

    public  ScrollDownAboutPage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//h4[contains(text(),'We love our customers (and vice versa)')]")
    WebElement Customers;

    public void scrolldownabout(){
        scrollIntoView(driver, Customers);
    }
}


