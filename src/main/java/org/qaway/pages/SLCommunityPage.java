package org.qaway.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qaway.base.CommonAPI;

public class SLCommunityPage extends CommonAPI {
    Logger LOG = LogManager.getLogger(SLCommunityPage.class.getName());


    public SLCommunityPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='modal-NMo7OPEriOk3Fw5bEvQeu']/div[2]")
    WebElement lightVideo;

    public boolean getMainHeaderText(){
        LOG.info("light video displayed success");
        return isDisplayed(lightVideo);
    }
}
