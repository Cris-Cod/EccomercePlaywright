package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.testng.Assert;
import java.util.List;



public class CartPage {

    private Page page;

    public CartPage(Page page) {
        this.page = page;
    }

    String description_product = "//td[@class='cart_description']/h4";
    String price = "//td[@class='cart_price']/p";
    String quantity = "//td[@class='cart_quantity']/button";
    String total = "//td[@class='cart_total']/p";

    public void validateDescriptionProduct(List<String> description){
        Locator descri = page.locator(description_product);
        List<String> namesDescription = descri.allInnerTexts();

        Assert.assertEqualsNoOrder(namesDescription, description);

        /*for(String name : namesDescription){
            Assert.assertTrue(
                    "Description "
                    description.contains(name)
            );
        }*/
    }

    public void validatePrice(List<String> priceProduct){
        Locator price_locator = page.locator(price);
        List<String> textPrice = price_locator.allInnerTexts();

        Assert.assertEqualsNoOrder(textPrice, priceProduct);
    }

    public void validateQuantity(List<String> quantityProduct){
        Locator quantity_locator = page.locator(quantity);
        List<String> undQuantity = quantity_locator.allInnerTexts();

        Assert.assertEqualsNoOrder(undQuantity, quantityProduct);
    }

    public void validateTotal(List<String> totalProduct){
        Locator total_locator = page.locator(total);
        List<String> undTotal = total_locator.allInnerTexts();

        Assert.assertEqualsNoOrder(undTotal, totalProduct);
    }
}
