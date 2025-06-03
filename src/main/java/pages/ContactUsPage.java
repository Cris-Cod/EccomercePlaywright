package pages;

import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ContactUsPage {

    private Page page;

    public ContactUsPage(Page page) {
        this.page = page;
    }

    String title_page = "(//h2)[1]";
    String input_name = "Name";  //placeholder
    String input_email = "//input[@data-qa='email']";
    String input_subject = "Subject";  //placeholder
    String textArea_yourMessage = "Your Message Here"; //placeholder
    String btn_select_archivo = "//input[@name='upload_file']";
    String btn_submit = "//input[@data-qa='submit-button']";
    String text_successfully = "//div[@class='status alert alert-success']";
    //Success! Your details have been submitted successfully.
    String btn_gohome = "//a[@class='btn btn-success']";

    public void validate_title(){
        assertThat(page.locator(title_page)).isVisible();
    }

    public void enter_data_form(String name, String email, String subject, String message) {
        page.getByPlaceholder(input_name).fill(name);
        page.locator(input_email).fill(email);
        page.getByPlaceholder(input_subject).fill(subject);
        page.getByPlaceholder(textArea_yourMessage).fill(message);
        page.locator(btn_select_archivo).setInputFiles(Paths.get("src/test/java/images/003.modelo.relacional.negro.png"));
        page.locator(btn_submit).dblclick();
        Page popup = page.waitForPopup(() -> {
            page.onceDialog(Dialog::accept);
        });
    }

    public void valiteTxtsuccessfully(String text){
        assertThat(page.locator(text_successfully)).containsText(text);
    }

    public void clickBtnGohome(){
        page.locator(btn_gohome).click();
    }
}
