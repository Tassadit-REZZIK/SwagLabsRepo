package org.qaway.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qaway.base.CommonAPI;

public class ScrollDownSwagLabsPage extends CommonAPI {
    public ScrollDownSwagLabsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[@id='page_wrapper']/footer/img")

    WebElement robot;

    public WebElement Robot(){
        return robot;
    }

    public void scrolldown(){
        scrollIntoView(driver, robot);
    }
}


