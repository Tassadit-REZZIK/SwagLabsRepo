package org.qaway.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qaway.base.CommonAPI;

public class SLHomePage extends CommonAPI {

    Logger LOG = LogManager.getLogger(SLHomePage.class.getName());
    public SLHomePage(WebDriver driver){
        PageFactory.initElements(driver,this); // on crée un constarctor
    }

    @FindBy(xpath = "//div[@class='nav-menu']//a[@class='link'][normalize-space()='Contact']" )
    WebElement contact;

    @FindBy(xpath = "//div[@class='nav-menu-link-group-row-list-wrapper']//span[contains(text(),'Sauce Community')]")
    WebElement sauceCommunity;
    ////////



    @FindBy(className = "link-video")
    WebElement watchVideoLink;

    @FindBy(xpath =" //button[@id='onetrust-accept-btn-handler']")
    WebElement cookies;

    @FindBy(xpath ="//body/div[@id='modal-NMo7OPEriOk3Fw5bEvQeu']/div[2]/figure[1]/lite-youtube[1]")
    WebElement video;
    @FindBy(xpath = "//*[@id='template__page']/div[2]/section/div/div[2]/a[2]")
    WebElement arrow;
    @FindBy(xpath ="//div[@class='logo-strip-content carousel-container is-hidden-mobile carousel carousel-slider']//img[@title='Visa logo']")
    WebElement visa;
    @FindBy(xpath ="//div[@class='logo-strip-container carousel-panel carousel-item active']//img[@title='Stripe logo']")
    WebElement strip;
    @FindBy(xpath ="//div[@class='logo-strip-container carousel-panel carousel-item active']//img[@title='Buzzfeed logo']")
    WebElement buzzFeed;
    @FindBy(xpath ="//h4[normalize-space()='We love our customers (and vice versa)']")
    WebElement titleCustomers;
    public boolean titleCustomersMessage(){
        return isDisplayed(titleCustomers);
    }



    public void visaCustomer(){
        isDisplayed(visa);
    }
    public void clickOnCarousel(){
        jsClick(arrow, driver);
    }

    public void stripCustomer(){
        isDisplayed(strip);
    }
    public void buzzFeedCustomer (){
        isDisplayed(buzzFeed);
    }









    public String getSLHomePageUrl(WebDriver driver){
        return getPageUrl(driver);
    }


    ///////////
    public void hoverOverCompany(WebDriver driver){
        hoverOver(driver, contact);
        LOG.info("hover hover contact success");
    }


    public void clickOnLink(){
        watchVideoLink.click();
        LOG.info("click on video link success");

    }

    public void acceptCookies(){
        cookies.click();
        LOG.info("accept cookies success");
    }

    public boolean videoIsDisplayed(){
        return isDisplayed(video);
    }




}
