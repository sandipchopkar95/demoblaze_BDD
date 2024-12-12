package com.personal.demoblaze.stepdefinitions;

import com.personal.demoblaze.AppConstants.AppConstant;
import com.personal.demoblaze.basetest.BaseTest;
import com.personal.demoblaze.config.ConfigReader;
import com.personal.demoblaze.pages.MyAccountPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;

public class MyAccountPage_Steps extends BaseTest {
    MyAccountPage myAccountPage;

    @Before
    public void launchBrowser_NavigateToHomePage() throws IOException {
        configReader = new ConfigReader();
        setUpBrowser_NavigateToUrl(configReader.getProperty("url"));
        myAccountPage = new MyAccountPage(driver);
    }

    @After
    public void closeBrowser() {
        tearDown();
    }

    @Then("the user navigates to the My Account screen")
    public void the_user_navigates_to_the_my_account_screen() {
        Assert.assertEquals("User not navigated to My Account", AppConstant.TITLE_MYACCOUNT, driver.getTitle());
    }

    @When("the user clicks on the {string} button")
    public void the_user_clicks_on_the_respective_tab_button(String button) {
        switch (button) {
            case "Add my first address":
                myAccountPage.clickTab_AddMyFirstAddress();
                break;
            case "Order history and details":
                myAccountPage.clickTab_OrderHistory();
                break;
            case "My credit slips":
                myAccountPage.clickTab_MyCreditSlips();
                break;
            case "My Addresses":
                myAccountPage.clickTab_MyAddresses();
                break;
            case "My personal Info":
                myAccountPage.clickTab_MyPersonalInformation();
                break;
            default:
                System.out.println("error");
        }

    }

    @Then("the user navigates to the {string} screen")
    public void the_user_navigates_to_the_respective_screen(String pageName) {
        switch (pageName) {
            case "Add my first address":
                Assert.assertEquals("My Address title not matching", AppConstant.TITLE_MY_ADDRESS, driver.getTitle());
                break;
            case "Order history and details":
                Assert.assertEquals("Order History title not matching", AppConstant.TITLE_ORDER_HISTORY, driver.getTitle());
                break;
            case "My credit slips":
                Assert.assertEquals("My credit slips title not matching", AppConstant.TITLE_ORDER_SLIPS, driver.getTitle());
                break;
            case "My Addresses":
                Assert.assertEquals("My addresses title not matching", AppConstant.TITLE_MY_ADDRESSES, driver.getTitle());
                break;
            case "My personal Info":
                Assert.assertEquals("My personal info title not matching", AppConstant.TITLE_PERSONAL_INFO, driver.getTitle());
                break;
            default:
                System.out.println("error");
        }
    }
}
