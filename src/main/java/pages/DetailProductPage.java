package pages;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DetailProductPage {

    private Page page;

    public DetailProductPage(Page page) {
        this.page = page;
    }

    String productName = "(//h2)[3]";
    String category = "(//p)[3]";
    String availability = "(//p)[4]";
    String condition = "(//p)[5]";
    String brand = "(//p)[6]";
    String price = "(//span)[13]";

    public void validateDetailProducts(){
        assertThat(page.locator(productName)).isVisible();
        assertThat(page.locator(category)).isVisible();
        assertThat(page.locator(availability)).isVisible();
        assertThat(page.locator(condition)).isVisible();
        assertThat(page.locator(brand)).isVisible();
        assertThat(page.locator(price)).isVisible();
    }



}