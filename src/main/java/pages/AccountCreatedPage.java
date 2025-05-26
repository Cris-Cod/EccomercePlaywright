package pages;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AccountCreatedPage {

    private Page page;

    public AccountCreatedPage(Page page) {
        this.page = page;
    }

    private String txt_title = "(//h2)[1]";
    private String btn_continue = "//a[@data-qa='continue-button']";

    public void validateTitleACreated(){
        assertThat(page.locator(txt_title)).isVisible();
    }

    public void clickBtnContinue(){
        page.locator(btn_continue).click();
    }
}
