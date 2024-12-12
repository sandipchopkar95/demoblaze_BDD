package com.personal.demoblaze.stepdefinitions;

import com.personal.demoblaze.AppConstants.AppConstant;
import com.personal.demoblaze.basetest.BaseTest;
import com.personal.demoblaze.config.ConfigReader;
import com.personal.demoblaze.pages.HomePage;
import com.personal.demoblaze.pages.LoginPage;
import com.personal.demoblaze.utils.WaitHelper;
import io.cucumber.java.*;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.io.IOException;

public class Login_Logout_Steps extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;

    @Before
    public void launchBrowser_NavigateToHomePage() throws IOException {
        configReader = new ConfigReader();
        setUpBrowser_NavigateToUrl(configReader.getProperty("url"));
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
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
        homePage.click_SignIn();
    }

    @Then("the user enters the email id and password and click on Submit login button")
    public void the_user_enters_the_email_id_and_password_and_click_on_Submit_login_button() {
        loginPage.enterEmail("sandipchopkar789@gmail.com");
        loginPage.enterPassword("tester");
        loginPage.click_SignIn();
    }

    @Then("the user's username should be displayed as the logged-in user")
    public void the_user_s_username_should_be_displayed_as_the_logged_in_user() {
        Assert.assertEquals("Username is not correct on user account info", AppConstant.TESTING_USERNAME, homePage.get_LoginAccountString());
    }

    @And("the user clicks on the Sign out header button")
    public void the_user_clicks_on_the_Sign_out_header_button() {
        homePage.click_SignOut();
    }

    @Then("the user is sign out successfully")
    public void the_user_is_sign_out_successfully() {
        Assert.assertFalse("No user is logged In", homePage.isUserIsLoggedIn());
    }

}
