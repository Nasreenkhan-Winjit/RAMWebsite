package StepDefinitions;

import Runner.TestBase;
import com.vimalselvam.cucumber.listener.Reporter;
import io.cucumber.core.gherkin.Step;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;



public class hooks  {
  //public static WebDriver driver;

    @Before
    public void initializeTest() {
        System.out.println("Start new scenario");
    }
    @AfterStep
    public void setWait() {

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Exception" + e);
        }
    }
    @After
    public void endTest(@NotNull Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println(scenario.getName()+" failed");
            String screenshotName1 = scenario.getName().replaceAll(" ", "_");
            String screenshotName=screenshotName1.replaceAll("\"","\'");
            //File destinationPath = new File(System.getProperty("user.dir") + "\\target\\cucumber-reports\\screenshots\\" + screenshotName + ".png");
            String destinationPath = System.getProperty("user.dir") + "\\target\\cucumber-reports\\screenshots\\" + screenshotName + ".png";
            TestBase.takeAScrenshot(destinationPath);
        }
    }




}
