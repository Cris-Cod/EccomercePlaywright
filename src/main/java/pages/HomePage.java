package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.testng.Assert;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomePage {

    private Page page;

    public HomePage(Page page) {
        this.page = page;
    }

    private String title_home = "(//h1)[1]";
    private String list_menu_items = "//ul[@class='nav navbar-nav']/li";
    private String user_logged = "//ul[@class='nav navbar-nav']/li[10]";

    //Delete Account

    public void title_page_home(){
        assertThat(page.locator(title_home)).isVisible();
    }

    public void select_items_menu(String item){
        Locator allItems = page.locator(list_menu_items);
        List<String> allItemsNames = allItems.allInnerTexts();

        for (int i = 0; i < allItemsNames.size(); i++) {
            if(allItemsNames.get(i).equalsIgnoreCase(item)){
                allItems.nth(i).click();
            }
        }
    }

    public void validateUserLogged(String user){
        String txt_user = page.locator(user_logged).textContent();
        String validate_text = txt_user.split(" ")[4];
        Assert.assertEquals(validate_text, user);

    }


}
