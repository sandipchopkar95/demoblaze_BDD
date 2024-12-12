package com.personal.demoblaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUs {
    WebDriver driver;
    public ContactUs(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
