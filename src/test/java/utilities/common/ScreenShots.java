package utilities.common;

import Runner.TestBase;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;


public class ScreenShots extends TestBase {

    public String takeScreenshot(String fileName) throws IOException {
        String destDir = System.getProperty("user.dir") + "\\src\\test\\resources\\screenshots\\";
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        new File(destDir).mkdirs();
        String destFile = destDir + "\\" + fileName + ".png";
        FileUtils.copyFile(scrFile, new File(destFile));
        return destFile;
    }

    public String embedScreenshotBYTES(String fileName) {
        try {
           Allure.addAttachment(fileName, new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileName;
    }
}
