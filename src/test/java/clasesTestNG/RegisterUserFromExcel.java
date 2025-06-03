package clasesTestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import stepDefinitions.StepDefinitionRegisterUser;
import utils.ExcelUtils;

import java.io.IOException;
import java.util.Map;

public class RegisterUserFromExcel {

    private StepDefinitionRegisterUser registerUser = new StepDefinitionRegisterUser();


    @DataProvider(name = "RegisterData")
    public Object[][] getCreateUserData() throws IOException {
        return ExcelUtils.readExcel("src/test/java/datafiles/data.xlsx","RegisterUser");
    }


    @Test(dataProvider = "RegisterData")
    public void testRegisterUser(Map<String, String> data) throws IOException {
        registerUser.the_user_enters_the_e_commerce_page();
        registerUser.the_user_selects_the_option_to_create_a(" Signup / Login");
        registerUser.enters_and(data.get("userName"), data.get("email"));
        registerUser.provides_information_and_date_of_birth(data.get("status"), data.get("password"), data.get("day"), data.get("month"), data.get("year"));
        registerUser.enters_personal_information_and(data.get("firstname"), data.get("lastname"), data.get("address"), data.get("country"), data.get("state"), data.get("city"), data.get("zipcode"), data.get("number"));
        registerUser.the_account_is_created_successfully();
        registerUser.the_user_logs_into_the_newly_created_account();
        registerUser.selects_the_option_to_delete_the_account();
        registerUser.the_account_is_deleted();
    }
}
