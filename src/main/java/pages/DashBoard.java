package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashBoard extends  BaseClass {
    public DashBoard(WebDriver driver) {
        super(driver);
        new WebDriverWait(getDriver(), 30).until(ExpectedConditions.titleContains("RAM - Hello,"));
    }

    @FindBy(xpath = "//div[@class='content-container']//h1[@class='content-title']")
    WebElement loggeduser;
    @FindBy(xpath = "//a[normalize-space()='Logout']") WebElement linkLoggedOut;



    public boolean isUserLogged(String username) {
        System.out.println(getPageTitle());
        return getPageTitle().contains(username);
        //System.out.println(loggeduser.getText());
        //return (loggeduser.getText().contains(username));
    }
public void clickLogOut(){
        getWaitElementClickable(linkLoggedOut).click();
}
}