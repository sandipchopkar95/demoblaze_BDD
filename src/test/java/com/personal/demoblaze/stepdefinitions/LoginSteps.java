package com.personal.demoblaze.stepdefinitions;

import com.personal.demoblaze.AppConstants.AppConstant;
import com.personal.demoblaze.basetest.BaseTest;
import com.personal.demoblaze.config.ConfigReader;
import com.personal.demoblaze.pages.HomePage;
import com.personal.demoblaze.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;
import java.io.IOException;

public class LoginSteps extends BaseTest {

    @Before
    public void launchBrowser_NavigateToHomePage() throws IOException {
        configReader = new ConfigReader();
        setUpBrowser_NavigateToUrl(configReader.getProperty("url"));
    }

    @After
    public void closeBrowser() {
        tearDown();
    }

    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page() {
        Assert.assertEquals("User is not on home page", AppConstant.TITLE_HOMEPAGE, driver.getTitle());
    }

    @When("the user clicks on the Sign In header button")
    public void the_user_clicks_on_the_sign_in_header_button() {
        HomePage homePage = new HomePage(driver);
        homePage.click_SignIn();
    }

    @And("the user enters the email id and password and click on Submit login button")
    public void the_user_enters_the_email_id_and_password_and_click_on_Submit_login_button() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("sandipchopkar789@gmail.com");
        loginPage.enterPassword("tester");
        loginPage.click_SignIn();
    }

    @Then("the user's username should be displayed as the logged-in user")
    public void the_user_s_username_should_be_displayed_as_the_logged_in_user() {
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals("Username is not correct on user account info", AppConstant.TESTING_USERNAME, homePage.get_LoginAccountString());
    }

}
