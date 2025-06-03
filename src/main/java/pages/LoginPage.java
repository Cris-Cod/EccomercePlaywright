package pages;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPage {

    private Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    private String txt_title = "(//h2)[1]";
    private String input_email = "//input[@data-qa='login-email']";
    private String input_password = "Password";  //placeholder
    private String btn_submit = "//button[@data-qa='login-button']";
    private String text_login_invalid = "(//p)[1]";

    public void validateTitleLogin(){
        assertThat(page.locator(txt_title)).isVisible();
    }

    public void enterLogin(String email, String pass){
        page.locator(input_email).fill(email);
        page.getByPlaceholder(input_password).fill(pass);
        page.locator(btn_submit).click();
    }

    public void valiateTextLoginIvalid(String message){
        assertThat(page.locator(text_login_invalid)).containsText(message);
    }
}
