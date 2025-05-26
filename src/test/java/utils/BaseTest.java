package utils;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitUntilState;

public class BaseTest {

    Playwright playwright;
    Browser browser;
    BrowserContext context;
    BrowserType browserType;
    protected Page page;

    public void setUp(String browserName, String headless, String url){
        playwright = Playwright.create();

        if(browserName.equalsIgnoreCase("chrome")){
            browserType = playwright.chromium();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            browserType = playwright.firefox();
        } else if (browserName.equalsIgnoreCase("edge")) {
            browserType = playwright.webkit();
        }

        if(headless.equalsIgnoreCase("true")){
            browser = browserType.launch(new BrowserType.LaunchOptions().setChannel(browserName).setHeadless(true));
        }else{
            browser = browserType.launch(new BrowserType.LaunchOptions().setChannel(browserName).setHeadless(false));
        }
        browser.newContext(new Browser.NewContextOptions().setViewportSize(1200,900));
        page = browser.newPage();
        page.navigate(url, new Page.NavigateOptions().setWaitUntil(WaitUntilState.DOMCONTENTLOADED));
    }

    public void close(){
        page.close();
        browser.close();
        playwright.close();
    }
}
