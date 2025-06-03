package stepDefinitions;

import io.cucumber.java.en.*;
import pages.DetailProductPage;
import pages.HomePage;
import pages.ProductsPage;
import utils.BaseTest;

public class StepsDefinitionProducts extends BaseTest {

    HomePage homePage;
    ProductsPage productsPage;
    DetailProductPage detailProductPage;
    @Given("user enter the e-commerce page")
    public void user_enter_the_e_commerce_page() {
        setUp("chrome", "false", "https://www.automationexercise.com/");
    }
    @When("user selects new option to create a {string}")
    public void user_selects_new_option_to_create_a(String item) {
        item = " Products";
        homePage = new HomePage(page);
        homePage.title_page_home();
        homePage.select_items_menu(item);
    }
    @When("user selects the {string} product")
    public void user_selects_the_product(String number) {
        number = "0";
        int num = Integer.parseInt(number);
        productsPage = new ProductsPage(page);
        productsPage.validate_title();
        productsPage.select_btn_viewProduct(num);
    }
    @Then("Verify that detail detail is visible: product name, category, price, availability, condition, brand")
    public void verify_that_detail_detail_is_visible_product_name_category_price_availability_condition_brand() {
        detailProductPage = new DetailProductPage(page);
        detailProductPage.validateDetailProducts();
        close();
    }

    @When("user enters {string} in search input and click search button")
    public void user_enters_in_search_input_and_click_search_button(String name_product) {
        name_product = "Fancy Green Top";
        productsPage = new ProductsPage(page);
        productsPage.search_product(name_product);
    }
    @Then("verify {string} is visible")
    public void verify_is_visible(String name_product) {
        name_product = "Fancy Green Top";
        productsPage = new ProductsPage(page);
        productsPage.validateSearchProduct(name_product);
    }

    @When("user Hover over {string} product and click Add to cart")
    public void user_hover_over_product_and_click_add_to_cart(String product) {

    }
    @When("user clicks Continue Shopping button")
    public void user_clicks_continue_shopping_button() {

    }

    @When("user Hover over second {string} product and click Add to cart")
    public void user_hover_over_second_product_and_click_add_to_cart(String product) {

    }

    @When("user clicks View Cart button")
    public void user_clicks_view_cart_button() {

    }

    @Then("user verifies both products are added to Cart and verify their {string}, {string} and {string}")
    public void user_verifies_both_products_are_added_to_cart_and_verify_their_and(String prices, String quantity, String total_price) {

    }


}
