package com.personal.demoblaze.pages;

import com.personal.demoblaze.utils.WaitHelper;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    WebDriver driver;
    WaitHelper wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WaitHelper(driver);
    }

    @FindBy(xpath = "//a[@class='login']")
    private WebElement button_SignIn;

    @FindBy(xpath = "//a[@class='account']")
    private WebElement button_UserAccount;

    @FindBy(xpath = "//a[@class='logout']")
    private WebElement button_SignOut;

    @FindBy(id = "contact-link")
    private WebElement button_ContactUs;

    @FindBy(xpath = "//a[@title='View my shopping cart']")
    private WebElement button_ShoppingCart;

    @FindBy(id="search_query_top")
    private WebElement textBar_Search;

    @FindBy(xpath = "//button[@name='submit_search']")
    private WebElement button_Search;

    @FindBy(xpath = "//div[@id='center_column']//a[@class='product-name']")
    private List<WebElement> productNames;

    @FindBy(xpath = "//a[@title='My orders']")
    private WebElement footerTab_MyOrders;

    public void click_SignIn() {
        button_SignIn.click();
    }

    public boolean isUserIsLoggedIn() {
        try {
            return button_UserAccount.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String get_LoginAccountString() {
        return button_UserAccount.getText();
    }

    public void click_SignOut() {
        button_SignOut.click();
        wait.waitForTimeOut(2);
    }

    public void click_ContactUs() {
        button_ContactUs.click();
        wait.waitForTimeOut(2);
    }

    public void click_ShoppingCart() {
        button_ShoppingCart.click();
        wait.waitForTimeOut(2);
    }

    public void fillProductName_And_ClickSearchButton(String productName) {
        textBar_Search.sendKeys(productName);
        button_Search.click();
    }

    public List<String> getProductNamesFromList(){
        List<String> texts = new ArrayList<>();
        for (WebElement product : productNames) {
            texts.add(product.getText());
        }
        return texts;
    }

    public void click_FooterTab_MyOrders() {
        footerTab_MyOrders.click();
    }

}
