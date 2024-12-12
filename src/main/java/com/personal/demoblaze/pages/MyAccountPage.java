package com.personal.demoblaze.pages;

import com.personal.demoblaze.utils.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    WebDriver driver;
    WaitHelper wait;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WaitHelper(driver);
    }

    @FindBy(xpath = "//span[contains(text(), 'Add my first address')]")
    private WebElement tab_AddMyFirstAddress;

    @FindBy(xpath = "//span[contains(text(), 'Order history and details')]")
    private WebElement tab_OrderHistory;

    @FindBy(xpath = "//span[contains(text(), 'My credit slips')]")
    private WebElement tab_MyCreditSlips;

    @FindBy(xpath = "//span[contains(text(), 'My addresses')]")
    private WebElement tab_MyAddresses;

    @FindBy(xpath = "//span[contains(text(), 'My personal information')]")
    private WebElement tab_MyPersonalInformation;

    public void clickTab_AddMyFirstAddress() {
        tab_AddMyFirstAddress.click();
    }

    public void clickTab_OrderHistory() {
        tab_OrderHistory.click();
    }

    public void clickTab_MyCreditSlips() {
        tab_MyCreditSlips.click();
    }

    public void clickTab_MyAddresses() {
        tab_MyAddresses.click();
    }

    public void clickTab_MyPersonalInformation() {
        tab_MyPersonalInformation.click();
    }


}
