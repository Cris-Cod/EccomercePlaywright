package pages;

import com.microsoft.playwright.Page;

public class CartPage {

    private Page page;

    public CartPage(Page page) {
        this.page = page;
    }

    String description_product = "//td[@class='cart_description']/h4";
    String price = "//td[@class='cart_price']/p";
    String quantity = "//td[@class='cart_quantity']/button";
    String total = "//td[@class='cart_total']/p";
}
