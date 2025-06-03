package stepDefinitions;


import com.microsoft.playwright.Page;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import pages.ContactUsPage;
import pages.HomePage;
import pages.LoginPage;
import utils.BaseTest;
import utils.ScreenShotUtils;


public class StepDefinitionLogin extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;
    ScreenShotUtils screenShotUtils;
    ContactUsPage contactUsPage;


    @Given("user enters the e-commerce page")
    public void user_enters_the_e_commerce_page() {
       setUp("chrome", "false", "https://www.automationexercise.com/");
    }

    @When("user selects the option to create a {string}")
    public void user_selects_the_option_to_create_a(String item) {
        item = " Signup / Login";
        homePage = new HomePage(page);
        homePage.title_page_home();
        homePage.select_items_menu(item);

    }
    @When("enters {string} and {string} in the login module")
    public void enters_and_in_the_login_module(String email, String pasword) {
        email = "pr2@gmail.com";
        pasword = "123456";

        loginPage = new LoginPage(page);
        loginPage.validateTitleLogin();
        loginPage.enterLogin(email, pasword);
    }


    @Then("verify the {string} is visible")
    public void verify_the_is_visible(String userName) {
        userName = "pr2";
        homePage = new HomePage(page);
        homePage.validateUserLogged(userName);
        close();

    }

    @When("enters incorrect {string} and {string} in the login module")
    public void enters_incorrect_and_in_the_login_module(String email, String password) {
        email = "lus@gmail.com";
        password = "#2587q";

        loginPage = new LoginPage(page);
        loginPage.validateTitleLogin();
        loginPage.enterLogin(email, password);
    }
    @Then("Verify error {string} is visible")
    public void verify_error_is_visible(String message) {
        message = "Your email or password is incorrect!";
        loginPage = new LoginPage(page);
        loginPage.valiateTextLoginIvalid(message);
        close();
    }

    @When("user selects the new option to create a {string}")
    public void user_selects_the_new_option_to_create_a(String item) {
        item = " Contact us";
        homePage = new HomePage(page);
        homePage.title_page_home();
        homePage.select_items_menu(item);
    }
    @When("enters {string}, {string}, {string} and {string}")
    public void enters_and(String name, String email, String subject, String message) {
        name = "test1";
        email = "pr2@gmail.com";
        subject = "test";
        message = "test test";
        contactUsPage = new ContactUsPage(page);
        contactUsPage.validate_title();
        contactUsPage.enter_data_form(name, email, subject, message);
    }
    @Then("Verify success message {string} is visible")
    public void verify_success_message_is_visible(String message) {
        message = "Success! Your details have been submitted successfully.";
        contactUsPage = new ContactUsPage(page);
        contactUsPage.valiteTxtsuccessfully(message);
        contactUsPage.clickBtnGohome();
        homePage = new HomePage(page);
        homePage.title_page_home();
    }


}
