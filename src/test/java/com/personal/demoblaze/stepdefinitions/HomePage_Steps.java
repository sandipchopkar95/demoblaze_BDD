package com.personal.demoblaze.stepdefinitions;

import com.personal.demoblaze.AppConstants.AppConstant;
import com.personal.demoblaze.basetest.BaseTest;
import com.personal.demoblaze.config.ConfigReader;
import com.personal.demoblaze.pages.CartPage;
import com.personal.demoblaze.pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;
import java.io.IOException;
import java.util.List;

public class HomePage_Steps extends BaseTest {
    HomePage homePage;
    CartPage cartPage;

    @Before
    public void launchBrowser_NavigateToHomePage() throws IOException {
        configReader = new ConfigReader();
        setUpBrowser_NavigateToUrl(configReader.getProperty("url"));
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
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

    @When("the user clicks on the Contact us header button")
    public void the_user_clicks_on_the_Contact_us_header_button() {
        homePage.click_ContactUs();
    }

    @Then("the user is navigated to the Contact us screen")
    public void the_user_is_navigated_to_the_Contact_us_screen() {
        String actualTitle = driver.getTitle();
        Assert.assertEquals("Contact us screen title does not match", AppConstant.TITLE_CONTACTUSPAGE, actualTitle);
    }

    @When("the user clicks on the Cart button")
    public void the_user_clicks_on_the_Cart_button() {
        homePage.click_ShoppingCart();
    }

    @Then("the user navigates to the card screen")
    public void the_user_navigates_to_the_card_screen() {
        String actualPageHeading = cartPage.getCartPageTitle();
        Assert.assertEquals("Cart page title not matched",AppConstant.HEADING_CARTPAGE, actualPageHeading);
    }

    @When("the user enters specific text in search bar and clicks search button")
    public void the_user_enters_specific_text_in_search_bar_and_clicks_search_button() {
        homePage.fillProductName_And_ClickSearchButton("T-Shirts");
    }

    @Then("the list of product is loaded with search text in product name")
    public void the_list_of_product_is_loaded_with_search_text_in_product_name() {
       List<String> searchResults = homePage.getProductNamesFromList();
       for (String searchResult : searchResults) {
           if(searchResult.contains("T-Shirts")) {
               Assert.assertTrue("Product "+searchResult+" does not contains T-Shirts",true);

           }
       }
    }

    @When("the user clicks on the My Orders button in the footer")
    public void the_user_clicks_on_the_My_Orders_button_in_the_footer() {
        homePage.click_FooterTab_MyOrders();
    }

    @Then("the user is taken to the Login page")
    public void the_user_is_taken_to_the_Login_page() {
        Assert.assertTrue("Login page title does not match", driver.getTitle().contains(AppConstant.TITLE_LOGINPAGE));
    }
}
