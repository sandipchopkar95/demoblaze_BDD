package com.personal.demoblaze.pages;

import com.personal.demoblaze.utils.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    WebDriver driver;
    WaitHelper wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WaitHelper(driver);
    }

    @FindBy(xpath = "//h1[@class='page-heading']")
    private WebElement pageTitle;

    public String getCartPageTitle() {
        wait.waitForElementToBeVisible(pageTitle,5);
        return pageTitle.getText();
    }
}
