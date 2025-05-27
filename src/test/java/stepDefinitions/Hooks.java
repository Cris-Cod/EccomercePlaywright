package stepDefinitions;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.ScreenshotType;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import utils.BaseTest;
import utils.ScreenShotUtils;

import java.io.ByteArrayInputStream;

public class Hooks extends BaseTest {

    private ScreenShotUtils screenShotUtils;

    @Before
    public void beforeScenario(){
        screenShotUtils = new ScreenShotUtils(page);
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
            if(page != null){
                try {
                    screenShotUtils = new ScreenShotUtils(page);
                    screenShotUtils.attachScreenshot("Step: " + scenario.getName());
                } catch (Exception e) {
                    System.out.println("No se pudo tomar captura: " + e.getMessage());
                }
            }
    }

    @After
    public void afterScenario(Scenario scenario){
       /* if(scenario.isFailed()){
            screenShotUtils.attachScreenshot("Fallo en: " + scenario.getName());
        }*/




        if(page != null){
            close();
        }
    }
}
