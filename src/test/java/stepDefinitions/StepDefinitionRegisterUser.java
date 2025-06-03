package stepDefinitions;

import io.cucumber.java.en.*;
import pages.*;
import utils.BaseTest;
import utils.ExcelUtils;

import java.io.IOException;


public class StepDefinitionRegisterUser extends BaseTest {

    HomePage homePage;
    SignUpPage signUpPage;
    AccountCreatedPage accountCreatedPage;
    AccountInformationPage accountInformationPage;
    DeleteAccountPage deleteAccountPage;

    ExcelUtils excelUtils;

    @Given("the user enters the e-commerce page")
    public void the_user_enters_the_e_commerce_page() {
        setUp("chrome", "false", "https://www.automationexercise.com/");
    }

    @When("the user selects the option to create a {string}")
    public void the_user_selects_the_option_to_create_a(String item) {
        item = " Signup / Login";
        homePage = new HomePage(page);
        homePage.title_page_home();
        homePage.select_items_menu(item);
    }

    @When("enters {string} and {string}")
    public void enters_and(String userName, String email) throws IOException {

        userName = "prueba1";
        email = "prba@gmail.com";

        signUpPage = new SignUpPage(page);
        signUpPage.validateTitleSingUp();
        signUpPage.createUser(userName, email);

    }

    @When("provides information: {string}, {string}, and date of birth \\({string}, {string}, {string})")
    public void provides_information_and_date_of_birth(String status, String password, String day, String month, String year) throws IOException {
        status = "Mr";
        password = "123456";
        day = "5";
        month = "June";
        year = "2001";
        accountInformationPage = new AccountInformationPage(page);
        accountInformationPage.validatetitleAinformation();
        accountInformationPage.registerUser(status, password, day, month, year);

    }
    @When("enters personal information: {string}, {string}, {string}, {string}, {string}, {string}, {string}, and {string}")
    public void enters_personal_information_and(String firstName, String lastName, String address, String country, String state, String city, String zipCode, String number) throws IOException {
        firstName = "Kim";
        lastName = "Lu";
        address = "calle 12 # 16";
        country = "Canada";
        state = "Quebec";
        city = "Montreal";
        zipCode = "897879";
        number = "3002547691";
        accountInformationPage = new AccountInformationPage(page);
        accountInformationPage.personalInformationUser(firstName, lastName, address, country, state, city, zipCode, number);
    }

    @Then("the account is created successfully")
    public void the_account_is_created_successfully() {
       accountCreatedPage = new AccountCreatedPage(page);
       accountCreatedPage.validateTitleACreated();
       accountCreatedPage.clickBtnContinue();
    }
    @When("the user logs into the newly created account")
    public void the_user_logs_into_the_newly_created_account() {
        homePage = new HomePage(page);

        homePage.title_page_home();

    }
    @When("selects the option to delete the account")
    public void selects_the_option_to_delete_the_account() {
        homePage = new HomePage(page);
        homePage.select_items_menu(" Delete Account");
    }
    @Then("the account is deleted")
    public void the_account_is_deleted() {
        deleteAccountPage = new DeleteAccountPage(page);
        homePage = new HomePage(page);

        deleteAccountPage.validateTitleDeleteA();
        deleteAccountPage.validateAccountDeleted();
        deleteAccountPage.clickBtnContinue();
        homePage.title_page_home();
        close();
    }

    @When("enters {string} and existing {string}")
    public void enters_and_existing(String userName, String email) {
        userName = "pr2";
        email = "pr2@gmail.com";

        signUpPage = new SignUpPage(page);
        signUpPage.validateTitleSingUp();
        signUpPage.createUser(userName, email);
    }

    @Then("Verify message error {string} is visible")
    public void verify_message_error_is_visible(String message) {
        message = "Email Address already exist!";
        signUpPage = new SignUpPage(page);
        signUpPage.validateTextEmailExist(message);
    }



}
