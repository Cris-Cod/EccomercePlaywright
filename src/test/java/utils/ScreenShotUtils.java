package utils;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.ScreenshotType;
import io.qameta.allure.Allure;

import java.io.ByteArrayInputStream;
import java.nio.file.Paths;

public class ScreenShotUtils {

    protected Page page = null;

    public ScreenShotUtils(Page page) {
        this.page = page;
    }

    public void attachScreenshot(Page page, String name){

            /*byte[] img =  page.screenshot(new Page.ScreenshotOptions().setType(ScreenshotType.PNG));
            Allure.addAttachment(name, new ByteArrayInputStream(img));*/
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("/screnshots/" + name)));
    }
}
