package pages;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SignUpPage {

    private Page page;

    public SignUpPage(Page page) {
        this.page = page;
    }

    private String text_signUp = "(//h2)[3]";
    private String input_name = "Name"; //placeholder
    private String input_email = "//input[@data-qa='signup-email']";
    private String btn_signUp = "//button[@data-qa='signup-button']";

    public void validateTitleSingUp(){
        assertThat(page.locator(text_signUp)).isVisible();
    }

    public void createUser(String nameUser, String email){
        page.getByPlaceholder(input_name).fill(nameUser);
        page.locator(input_email).fill(email);
        page.locator(btn_signUp).click();
    }
}
