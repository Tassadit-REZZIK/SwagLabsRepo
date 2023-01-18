package org.qaway.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStep2Page {
    Logger LOG = LogManager.getLogger(CheckoutStep2Page.class.getName());
    public CheckoutStep2Page(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    WebElement itemTotal;
    @FindBy(xpath = "//div[@class='summary_total_label']")
    WebElement total;

    @FindBy(xpath = "//button[@id='finish']")
    WebElement finishButton;



    public double getUnitPrice() {
        String unitPrice1 = itemTotal.getText();
        String unit = unitPrice1.replaceAll("[^0-9]+", "");;
        double finalUnitPrice = Double.parseDouble(unit);
        return finalUnitPrice / 100;
    }

    public double getTotalPrice() {
        String unitPrice1 = total.getText();
        String unit = unitPrice1.replaceAll("[^0-9]", "");
        double finalUnitPrice = Double.parseDouble(unit);
        return finalUnitPrice / 100;
    }
    public void ClickOnFinishButton(){
        finishButton.click();

    }


}
