package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AccountInformationPage {

    private Page page;

    public AccountInformationPage(Page page) {
        this.page = page;
    }

    private String txtAccount = "(//h2)[1]";
    private String checkBoxMr = "//label[@for='id_gender1']";
    private String checkBoxMrs = "//label[@for='id_gender2']";
    private String inputName = "#name";
    private String inputEmail = "#email";
    private String inputPassword = "#password";
    private String selectDays = "#days";
    private String selectMonths = "#months";
    private String selectYear = "#years";

    /* Personal information */
    private String inputFirstName = "#first_name";
    private String inputLastName = "#last_name";
    private String inputAddress = "#address1";
    private String selectCountry = "#country";
    private String inputState = "#state";
    private String inputCity = "#city";
    private String inputZipCode = "#zipcode";
    private String inputMobileNumber = "#mobile_number";
    private String btn_createAccount = "//button[@data-qa='create-account']";


    public void validatetitleAinformation(){
        assertThat(page.locator(txtAccount)).isVisible();
    }
    public void registerUser(String status, String pass, String day, String month, String year){

        try {
            if(status.equalsIgnoreCase("Mr")){
                page.locator(checkBoxMr).check();
            }else{
                page.locator(checkBoxMrs).check();
            }
        }catch (Exception e){
            System.out.println("you should enter Mr or Mrs");
        }

        page.locator(inputPassword).fill(pass);
        Locator sDay = page.locator(selectDays);
        sDay.selectOption(day);
        Locator sMonth = page.locator(selectMonths);
        sMonth.selectOption(month);
        Locator sYear = page.locator(selectYear);
        sYear.selectOption(year);
    }

    public void personalInformationUser(String firstName, String lastName, String address, String country, String state, String city, String zidCode, String mobileNumber){
        page.locator(inputFirstName).fill(firstName);
        page.locator(inputLastName).fill(lastName);
        page.locator(inputAddress).fill(address);
        Locator sCountry = page.locator(selectCountry);
        sCountry.selectOption(country);
        page.locator(inputState).fill(state);
        page.locator(inputCity).fill(city);
        page.locator(inputZipCode).fill(zidCode);
        page.locator(inputMobileNumber).fill(mobileNumber);
        page.locator(btn_createAccount).click();
    }




}
