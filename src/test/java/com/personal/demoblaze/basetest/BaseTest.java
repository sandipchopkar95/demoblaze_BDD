package com.personal.demoblaze.basetest;

import com.personal.demoblaze.config.ConfigReader;
import com.personal.demoblaze.config.DriverManager;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected ConfigReader configReader;

    public WebDriver setUpBrowser_NavigateToUrl(String url) throws IOException {
        if (driver == null) {
            configReader = new ConfigReader();
            driver = DriverManager.getDriver(configReader.getProperty("browser"));
            driver.get(url);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        }
        return driver;
    }

    public void tearDown() {
        if (driver != null) {
            DriverManager.quitDriver();
            driver = null;
        }
    }
}
