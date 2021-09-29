package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PassRecovery extends BaseClass {
    public PassRecovery(WebDriver driver) {
        super(driver);
    }

    //locating elements on password recovery page
    @FindBy(name = "email")
    WebElement txtPassRecoveryEmail;
    @FindBy(css = "form[id='passwordRecoveryForm'] button")
    WebElement btnSumitEmail;
    @FindBy(css = "div.col-sm-12 p:nth-child(3)")
    WebElement recoveryEmailSentNotification;
    @FindBy(id = "pw1")
    WebElement newPass;
    @FindBy(id = "pw2")
    WebElement newConfirmPass;
    @FindBy(css = ".submit-btn.teal")
    WebElement btnSubmitPass;
    //page title
    String passwordRecoveryPage = "RAM - Password Recovery";
    String passwordResetURL="https://www.ram.co.za/MyRam/PasswordReset";

    public boolean isDisplayedPasswordRecoveryPage() {
               return verifyPageTitle(passwordRecoveryPage);
    }

    public boolean isPasswordResetPage(){
        return  getDriver().getCurrentUrl().equalsIgnoreCase(passwordResetURL);
    }
    public void setPassRecoveryEmail(String email) {
        txtPassRecoveryEmail.clear();
        txtPassRecoveryEmail.sendKeys(email);
    }

    public void clickBtnSubmitEmail() {
        btnSumitEmail.click();
    }

    public String getTxtRecoveryNotification() {
        //System.out.println(recoveryEmailSentNotification.getText());
        return recoveryEmailSentNotification.getText();

    }

    public boolean isNotificationReceived() {
        return getTxtRecoveryNotification().contains("An email has been sent to you");
    }

    public void setNewPass(String password) {
        newPass.clear();
        newPass.sendKeys(password);
    }

    public void setNewConfirmPass(String password) {
        newConfirmPass.clear();
        newConfirmPass.sendKeys(password);
    }

    public void clickBtnSubmitPass() {
        btnSubmitPass.click();
    }
}
