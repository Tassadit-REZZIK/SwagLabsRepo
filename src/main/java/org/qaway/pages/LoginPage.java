package org.qaway.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qaway.base.CommonAPI;

public class LoginPage extends CommonAPI {


    Logger LOG = LogManager.getLogger(LoginPage.class.getName());

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css="#user-name")
    WebElement userNameField;

    @FindBy(css="#password")
    WebElement passwordField;
    @FindBy(css="#login-button")

    WebElement loginBtn;
    @FindBy(css=".error-message-container.error")

    WebElement errorMessage;





    @FindBy(xpath = "//input[@id='name']")
    WebElement alertField;
    @FindBy(xpath = "//input[@id='alertbtn']")
    WebElement alertBtb;

    @FindBy(xpath = "//input[@id='confirmbtn']")
    WebElement confirmBtn;



    public boolean usernameFieldIsDisplayed(){

        LOG.info("cheking username field is displayed ...");
        return isDisplayed(userNameField);
    }
    public void typeUsername(String username){
        type(userNameField, username);

    }

    public void typeUsernameUsingDB(String username){
        type(userNameField, username);

    }
    public boolean passwordFieldIsDisplayed(){

        LOG.info("cheking password field is displayed ...");
        return isDisplayed(passwordField);
    }
    public void typePassword(String password){
        type(passwordField, password);
    }
    public boolean loginBtnIsDisplayed(){
        LOG.info("cheking login button is displayed ...");
        return isDisplayed(loginBtn);
    }
    public void clickOnLoginButton(){

        clickOn(loginBtn);
    }

    public String getErrorMessage(){
        return getWebElementText(errorMessage);
    }

    public void login(String username, String password){
        typeUsername(username);

        typePassword(password);

        clickOnLoginButton();

        LOG.info("login process success");
    }


    @FindBy(css=".bot_column")
    WebElement imageField;

    @FindBy(css=".login_credentials")
    WebElement credentials;
    @FindBy(css=".login_password")

    WebElement loginPassword;
    @FindBy(css=".login_wrapper-inner")

    WebElement loginWrapper;





    public boolean imageFieldIsDisplayed(){

        LOG.info("cheking image field is displayed ...");
        return isDisplayed(imageField);
    }

    public boolean credentialsIsDisplayed(){
        LOG.info("cheking credentials is displayed ...");
        return isDisplayed(credentials);
    }
    public boolean loginPasswordIsDisplayed(){

        LOG.info("cheking login password field is displayed ...");
        return isDisplayed(loginPassword);
    }


    public boolean loginWrapperIsDisplayed(){

        LOG.info("cheking wrapper field is displayed ...");
        return isDisplayed(loginWrapper);
    }


    public void clickOnLink() {
    }

    public String getHomePageUrl(WebDriver driver){
        return getPageUrl(driver);
    }
}
