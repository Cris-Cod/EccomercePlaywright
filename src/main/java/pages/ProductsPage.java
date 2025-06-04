package pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProductsPage {

    private Page page;

    public ProductsPage(Page page) {
        this.page = page;
    }

    String tile_page = "(//h2)[3]";
    String list_btn_viewProduct = "//div[@class='choose']";
    String input_search = "#search_product";
    String btn_search = "#submit_search";
    String name_product = "//div[@class='productinfo text-center']/p";
    String list_products = "//div[@class='single-products']";
    String list_overley_product = "//div[@class='overlay-content']";
    String list_overley_btn_addProduct = "//a[@class='btn btn-default add-to-cart']";
    String modal_addToCart = "//div[@class='modal-content']";
    String btn_continue_modal = "//button[@data-dismiss='modal']";
    String btn_viewCart_modal = "//div[@class='modal-body']/p[2]/a";

    public void validate_title(){
        assertThat(page.locator(tile_page)).isVisible();
    }

    public void select_btn_viewProduct(int numProduct){
        Locator l_product = page.locator(list_btn_viewProduct);
        if(numProduct < l_product.count()){
            l_product.nth(numProduct).click();
        }

    }

    public void search_product(String nameProduct){
        page.locator(input_search).click();
        page.locator(input_search).fill(nameProduct);
        page.locator(btn_search).click();
    }

    public void validateSearchProduct(String nameProduct){
        assertThat(page.locator(name_product)).containsText(nameProduct);
    }

    public void select_product(int product){
        Locator list_product = page.locator(list_products);
        list_product.nth(product).hover();
        Locator list_btn_addProduct = page.locator(list_overley_btn_addProduct);
        list_btn_addProduct.nth(product).click();
    }

    public void select_product1(int product){
        Locator list_product = page.locator(list_products);
        list_product.nth(product).hover();
        Locator list_btn_addProduct = page.locator(list_overley_btn_addProduct);
        list_btn_addProduct.nth(product + 1).click();
    }

    public void clickBtnContinueModal(){
        page.waitForSelector(modal_addToCart);
        if(page.isVisible(modal_addToCart)){
            page.locator(btn_continue_modal).click();
        }else{
            System.out.println("no se encuentra el modal");
        }

    }

    public void clickBtnviewCart(){
        page.locator(btn_viewCart_modal).click();
    }

}
