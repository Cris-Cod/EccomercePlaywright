package stepDefinitions;


import io.cucumber.java.en.*;
import pages.HomePage;
import pages.LoginPage;
import utils.BaseTest;


public class StepDefinitionLogin extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;


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

    }


}
