package Runner;

import com.vimalselvam.cucumber.listener.Reporter;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.apache.hc.core5.util.TimeValue;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PageObjectManager;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestBase extends TestRunner {
    //protected static WebDriver driver;


    protected static PageObjectManager pageObjectManager;
    protected static String parentWindow;
    protected static String childWindow;
    protected static String currentWindow;



    public int verifyBrokenLinks() {
        String url = "";
        HttpURLConnection huc = null;
        int respCode = 200;
        int brokenLinkCount = 0;
        List<WebElement> links = driver.findElements(By.tagName("a"));
        Iterator<WebElement> iterator = links.iterator();
        while (iterator.hasNext()) {
            WebElement anchor=iterator.next();
            url = anchor.getAttribute("href");
            if (url == null || url.isEmpty()) {
                System.out.println("URL is not configured  or it is empty for: "+anchor.getText());
                continue;
            }
            if (!url.startsWith("https://www.ram.co.za")) {
                System.out.println("URL belongs to another domain...Skipping it.."+anchor.getText());
                continue;
            }
            try {
                huc = (HttpURLConnection) (new URL(url).openConnection());
                huc.setRequestMethod("HEAD");
                huc.connect();
                respCode = huc.getResponseCode();
                if (respCode >= 400) {
                    System.out.println(url + " is broken link for link"+anchor.getText());
                    brokenLinkCount++;
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return brokenLinkCount;
    }


    protected void waitForLoad(WebDriver driver) {
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    protected void switchWindowTab(WebDriver driver) {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.PAGE_DOWN);
    }

    public void ClearBrowserCache() throws InterruptedException {
        driver.manage().deleteAllCookies(); //delete all cookies
        Thread.sleep(10000); //wait 10 seconds to clear cookies.
    }

public static void takeAScrenshot(String destinationPath){
                  try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File sourcePath = ts.getScreenshotAs(OutputType.FILE);
            File destinationFile=new File(destinationPath);
                        FileUtils.copyFile(sourcePath, destinationFile);
            //Reporter.addScreenCaptureFromPath(destinationPath.toString());
        } catch (WebDriverException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public void delay(int timeInSeconds){
        long duration=TimeUnit.SECONDS.toMillis(timeInSeconds);
        try {
            Thread.sleep(duration);
        } catch (Exception e) {
            System.out.println("Exception" + e);
        }
    }

    }

