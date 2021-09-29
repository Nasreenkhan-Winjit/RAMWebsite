package Runner;

import browsers.BrowserFactory;
import browsers.DriverManagerWeb;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import java.util.concurrent.TimeUnit;

@CucumberOptions(
        features = "classpath:features1",
        glue = {"StepDefinitions"},
        monochrome = true,
        plugin = {"pretty",
                "summary",
                "rerun:target/rerun.txt",
                "html:target/cucumber-reports/Cucumber-html-report.html",
                "json:target/cucumber-reports/CucumberTestReport.json",
                // "junit:target/cucumber-reports/Cucumber-xml-report.xml",
                //"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }

)

public class TestRunner extends AbstractTestNGCucumberTests {
    public static WebDriver driver;

    // public static EventFiringWebDriver eventFiringWebDriver;
    @BeforeTest
    public void launchBrowser() {
        driver = BrowserFactory.getManager("CHROME").getWebDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println("Browser Launched");
        driver.manage().deleteAllCookies(); //delete all cookies
        try {
            Thread.sleep(10000); //wait 10 seconds to clear cookies.
        } catch (Exception e) {
            System.out.println("Exception occured " + e);
        }

        System.out.println("Cleared Cookies");
        driver.get("https://www.ram.co.za");
    }

    @AfterTest
    public void tearDown() {
        System.out.println("Browser Quit");
        driver.manage().deleteAllCookies();
        driver.quit();
        //  Reporter.loadXMLConfig(new File(FileReaderManager.getReportConfigPath()));
    }


}
