package pages;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DeleteAccountPage {

    private Page page;

    public DeleteAccountPage(Page page) {
        this.page = page;
    }

    private String txt_title = "(//h2)[1]";
    private String txt_yourAccountDeleted = "(//p)[1]";
    private String btn_continue = "//a[@data-qa='continue-button']";

    public void validateTitleDeleteA(){
        assertThat(page.locator(txt_title)).isVisible();
    }

    public void validateAccountDeleted(){
        assertThat(page.locator(txt_yourAccountDeleted)).containsText("Your account has been permanently deleted!");
    }

    public void clickBtnContinue(){
        page.locator(btn_continue).click();
    }
}
