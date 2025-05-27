package utils;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.ScreenshotType;
import io.qameta.allure.Allure;

import java.io.ByteArrayInputStream;
import java.nio.file.Paths;

public class ScreenShotUtils {

    private Page page;

    public ScreenShotUtils(Page page) {
    }

    public void attachScreenshot(String name){

            byte[] img =  page.screenshot(new Page.ScreenshotOptions().setType(ScreenshotType.PNG));
            Allure.addAttachment(name, new ByteArrayInputStream(img));

    }
}
