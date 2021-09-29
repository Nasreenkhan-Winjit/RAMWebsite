package StepDefinitions;

import Runner.TestBase;
import commonModule.EmailReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import pages.PageObjectManager;


import java.util.ArrayList;

public class LoginSteps extends TestBase {
    public LoginSteps() {
        pageObjectManager = new PageObjectManager(driver);
    }

   /* @AfterStep
    public void setWait() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Exception" + e);
        }
    }*/

    public static String resetPassLink;

    @And("Enter email address {string}")
    public void enterEmailAddress(String email) {
        pageObjectManager.getLoginPage().setEmailID(email);
    }

    @And("Enter Password {string}")
    public void enterPassword(String pass) {
        pageObjectManager.getLoginPage().setPassword(pass);
    }

    @And("Click on Submit Button to submit login form")
    public void clickOnLoginButton() throws InterruptedException {
        pageObjectManager.getLoginPage().clickbtnSubmitForm();
               // Thread.sleep(2000);

    }

    @Then("Shows password in masked format")
    public void showsPasswordInMaskedFormat() {
        pageObjectManager.getLoginPage().isPasswordMasked();
    }

    @And("User close login form")
    public void userCloseLoginPage() {
        pageObjectManager.getLoginPage().clickBtnClose();
    }

    @Given("Login Form is open")
    @Then("Login Form will open")
    public void loginFormIsOpen() {
        //pageObjectManager.getLoginPage().switchToChildWindow();
        Assert.assertTrue(pageObjectManager.getLoginPage().isLoginFormDisplayed(),"Login form is opened");
    }

    @And("Mouse cursor is on email address textbox.")
    public void mouseCursorIsOnEmailAddressTextbox() {
        Assert.assertTrue(pageObjectManager.getLoginPage().isEmailFocused());
    }


    @SneakyThrows
    @Then("User {string} logged in")
    public void userLoggedIn(String username) {
        Thread.sleep(1000);
        Assert.assertTrue(pageObjectManager.getHomepage().isUserLoggedIn());
            // System.out.println("user logged in= "+abc);
            // SoftAssertions.assertSoftly(softAssertions -> softAssertions.assertThat(abc).as("There is an error").isTrue());
            SoftAssertions.assertSoftly(softAssertions -> softAssertions.assertThat(pageObjectManager.getLoginPage().getLoggedUserName()).as("user name do not match").isEqualTo(username));
        }

    @And("Click on username")
    public void clickOnUsername() {
        pageObjectManager.getLoginPage().clickUserName();
    }

    @Then("User not logged in")
    public void userNotLoggedIn() {
        Assert.assertTrue(pageObjectManager.getLoginPage().isLoginFormDisplayed());
    }

    @Then("Display validation message")
    public void displayValidationMessage() {
        Assert.assertTrue(pageObjectManager.getLoginPage().isEmailRequired());
    }


    @And("User click on Forgot Password")
    public void userClickOnForgotPassword() {
        pageObjectManager.getLoginPage().clickLinkForgotPass();
    }

    @Given("User is on Password Recovery page")
    @Then("Password Recovery page should open")
    public void passwordRecoveryPageShouldOpen() {
  Assert.assertTrue(pageObjectManager.getPassRecovery().isDisplayedPasswordRecoveryPage());
    }

    @And("User enter password recovery email address {string}")
    public void userEnterPasswordRecoveryEmailAddress(String email) {
        pageObjectManager.getPassRecovery().setPassRecoveryEmail(email);
    }

    @And("Click on Submit Button on password recovery page")
    public void clickOnSubmitButtonOnPasswordRecoveryPage() {
        pageObjectManager.getPassRecovery().clickBtnSubmitEmail();
    }

    @Then("Notification msg should display")
    public void notificationMsgShouldDisplay() throws InterruptedException {
       // System.out.println(pageObjectManager.getPassRecovery().isNotificationReceived());
        waitForLoad(driver);
        Assert.assertTrue(pageObjectManager.getPassRecovery().isNotificationReceived());
        Thread.sleep(100000);
    }


    @When("user read mail")
    public void userReadMail() {
         String strForgotLink = EmailReader.getStrResetPass("imap.googlemail.com",993,"imaps","swati.winjit123@gmail.com","Swati123$","RAM Website Password Reset","dontreply@ram.co.za");

         driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL + "t");

         ArrayList<String> tablist = new ArrayList<>(driver.getWindowHandles());
         driver.switchTo().window(tablist.get(0));
         driver.get(strForgotLink);

       // EmailReader.readMails("pop.gmail.com", 995, "pop3s", "swati.winjit123@gmail.com", "Swati123$", "Test");
    }


    @And("Link to change password is sent to email id enter by user")
    public void linkToChangePasswordIsSentToUsersEmailId()  {
        //Thread.sleep(60000);
        resetPassLink = EmailReader.getStrResetPass("imap.googlemail.com",993,"imaps","swati.winjit123@gmail.com","Swati123$","RAM Website Password Reset","dontreply@ram.co.za");
        if(resetPassLink.isEmpty())
            resetPassLink = EmailReader.getStrResetPass("imap.googlemail.com",993,"imaps","swati.winjit123@gmail.com","Swati123$","RAM Website Password Reset","dontreply@ram.co.za");
        System.out.println("Reset pass Link: "+resetPassLink);
        Assert.assertFalse(resetPassLink.isEmpty());
    }

    @When("User click on Reset Password link")
    public void userClickOnResetPasswordLink() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(resetPassLink);
    }

    @And("User enter new password {string}")
    public void userEnterNewPassword(String password) {
        pageObjectManager.getPassRecovery().setNewPass(password);
    }

    @And("User reenter new password {string}")
    public void userReenterNewPassword(String password) {

    pageObjectManager.getPassRecovery().setNewConfirmPass(password);}

    @And("User click on submit button")
    public void userClickOnSubmitButton() {
    pageObjectManager.getPassRecovery().clickBtnSubmitPass();
    }


    @Then("Get error toaster message {string}")
    public void getErrorToasterMessage(String msg) {
    }

    @Then("Password is reset and user is on password reset page")
    public void passwordIsResetAndUserIsOnPasswordResetPage() {
    waitForLoad(driver);
    Assert.assertTrue(pageObjectManager.getPassRecovery().isPasswordResetPage());
    }

    @And("Wait for login form to be disappear")
    public void waitForLoginFormToBeDisappear() {
        pageObjectManager.getLoginPage().wait_LoginFormDisappeared();
    }


}
