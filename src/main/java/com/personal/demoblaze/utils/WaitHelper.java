package com.personal.demoblaze.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitHelper {
    WebDriver driver;

    public WaitHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForTimeOut(int timeout) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
        wait.withTimeout(Duration.ofSeconds(timeout));
    }

    public void waitForElementToBeVisible(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
