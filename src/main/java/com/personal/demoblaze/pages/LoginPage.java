package com.personal.demoblaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    private WebElement textField_email;

    @FindBy(id = "passwd")
    private WebElement textField_password;

    @FindBy(id = "SubmitLogin")
    private WebElement button_SignIn;

    public void enterEmail(String email) {
        textField_email.sendKeys(email);
    }

    public void enterPassword(String password) {
        textField_password.sendKeys(password);
    }

    public void click_SignIn() {
        button_SignIn.click();
    }
}
