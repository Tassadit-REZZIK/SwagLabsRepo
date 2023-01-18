package org.qaway.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qaway.base.CommonAPI;

public class SolutionPage extends CommonAPI {
    Logger LOG = LogManager.getLogger(SLHomePage.class.getName());
    public SolutionPage(WebDriver driver){
        PageFactory.initElements(driver,this); // on crée un constarctor
    }

    @FindBy(xpath = "//h1[@class='title']")
    WebElement searchSolutions;


    public boolean searchResultsForSolutions(){
        return isDisplayed(searchSolutions);
    }
}
