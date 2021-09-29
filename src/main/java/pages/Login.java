package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login extends BaseClass {
    public Login(WebDriver driver) {
        super(driver);
    }

    //locating elements on login form
    @FindBy(name = "emailaddress")
    WebElement txtEmailId;
    @FindBy(name = "password")
    WebElement txtPass;
    @FindBy(className = "forgot-link")
    WebElement linkForgotPass;
    @FindBy(className = "ram-btn yellow")
    WebElement linkRegister;
    @FindBy(id = "close-login")
    WebElement btnClose;
    @FindBy(id = "quick-login-form")
    WebElement formLogin;
    @FindBy(xpath = "//form[@id='quick-login-form']/button")
    WebElement btnSubmitForm;

    @FindBy(css="div[class='user-nav'] li:nth-child(3) a")
    WebElement linkUserName;




    public void setEmailID(String email) {
        txtEmailId.clear();
        txtEmailId.sendKeys(email);
    }

    public void setPassword(String pass) {
        txtPass.clear();
        txtPass.sendKeys(pass);
    }

    public void clickbtnSubmitForm() {
        btnSubmitForm.click();
    }
    public void wait_LoginFormDisappeared(){
        getWait(20).until(ExpectedConditions.invisibilityOf(formLogin));
    }

    public void clickBtnClose() {
        btnClose.click();
    }

    public void clickLinkForgotPass() {
        linkForgotPass.click();
    }

    public boolean isPasswordMasked() {
        return (getAttributeVal(txtPass, "type").equalsIgnoreCase("password"));
    }

    public boolean isLoginFormDisplayed() {
       new WebDriverWait(getDriver(), 30).until(ExpectedConditions.visibilityOf(formLogin));
        return formLogin.isDisplayed();
    }

    public boolean isEmailFocused() {
        return txtEmailId.equals(getDriver().switchTo().activeElement());
    }

    public String getLoggedUserName() {
        return linkUserName.getText();
    }

    public void clickUserName() {
        linkUserName.click();
    }

    public boolean isEmailRequired() {
        boolean required = Boolean.parseBoolean(txtEmailId.getAttribute("required"));
        //System.out.println("value " + required);
        return required;
    }
}