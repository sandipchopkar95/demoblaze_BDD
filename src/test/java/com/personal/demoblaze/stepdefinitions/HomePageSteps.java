package com.personal.demoblaze.stepdefinitions;

import com.personal.demoblaze.basetest.BaseTest;
import com.personal.demoblaze.config.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;
import java.io.IOException;

public class HomePageSteps extends BaseTest {

    @Before
    public void launchBrowser_NavigateToHomePage() throws IOException {
        configReader = new ConfigReader();
        setUpBrowser_NavigateToUrl(configReader.getProperty("url"));
    }

    @After
    public void closeBrowser() {
        tearDown();
    }

    @Given("the user enters the application URL in the browser")
    public void the_user_enters_the_application_url_in_the_browser() throws IOException {
        System.out.println("Navigating to application URL: " + configReader.getProperty("url"));
    }

    @When("the page loads")
    public void the_page_loads() {
        Assert.assertTrue("Page did not load successfully", driver.getCurrentUrl().contains(configReader.getProperty("url")));
    }

    @Then("the user should be redirected to the home page")
    public void the_user_should_be_redirected_to_the_home_page() {
        Assert.assertTrue("Home page URL is incorrect", driver.getCurrentUrl().contains("/index.php"));
    }

    @Then("the home page title should be {string}")
    public void the_home_page_title_should_be(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals("Home page title does not match", expectedTitle, actualTitle);
    }
}
