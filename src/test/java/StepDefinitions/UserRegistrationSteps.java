package StepDefinitions;

import Runner.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.PageObjectManager;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class UserRegistrationSteps extends TestBase {
    public UserRegistrationSteps() {
        pageObjectManager=new PageObjectManager(driver);
    }

 /*   @AfterStep
    public void setWait() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Exception" + e);
        }
    }*/

    @Then("User not registered and is on user registration page")
    @Given("User is on user registration page")
    @Then("User registration page will open")
    public void userRegistrationPageWillOpen() {
        Assert.assertTrue(pageObjectManager.getUserRegistration().isDisplayedRegistrationPage());
    }

    @When("User enter details to register")
    public void userEnterDetailsToRegister(List<List<String>> table) throws Throwable {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        pageObjectManager.getUserRegistration().fillUserRegisterationForm(table);
       //Thread.sleep(3000);
    }

    @And("User Click on Register Button")
    public void userClickOnRegisterButton() throws InterruptedException {
        String msg="";
        pageObjectManager.getUserRegistration().clickBtnRegister();
       // Assert.assertTrue(pageObjectManager.getUserRegistration().isDisplayedEmailToaster(msg));
       // Thread.sleep(1000);
    }



    @Then("Alert popped up with message {string}")
    public void alertPoppedUpWithMessage(String message) {
Assert.assertTrue(pageObjectManager.getUserRegistration().isAlertPresent(message));
    }


    @Then("Display error message")
    public void displayErrorMessage() {
        Assert.assertTrue(pageObjectManager.getUserRegistration().isPresentErrorBlock());
    }


    @And("Get error for field {string}")
    public void getErrorForField(String fieldName) throws InterruptedException {
        Assert.assertTrue(pageObjectManager.getUserRegistration().isErrorPresent(fieldName));
        Thread.sleep(2000);
    }

    @Then("Get toaster message {string}")
    public void getToasterMessage(String msg) {
       Assert.assertTrue(pageObjectManager.getUserRegistration().isDisplayedEmailToaster(msg));
        //System.out.println("pass");
    }

    @Then("Get error for {string} = {string}")
    public void getErrorFor(String fieldName, String errorStatus) {
        if(errorStatus.equalsIgnoreCase("Yes"))
            Assert.assertTrue(pageObjectManager.getUserRegistration().isErrorPresent(fieldName));

    }

    @When("User enter details")
    public void userEnterDetails() {
        System.out.println("User is on Registration form page");
    }

    @When("enter {string} = {string}")
    public void enter(String fieldname, String value) {
pageObjectManager.getUserRegistration().setRegistrationFieldVal(fieldname,value);
    }

    @When("enter userType = {string}")
    public void enterUserType(String value) {
pageObjectManager.getUserRegistration().selectUserType(value);
    }

    @And("enter firstname = {string}")
    public void enterFirstname(String value) {
    pageObjectManager.getUserRegistration().setFirstname(value);
    }

    @And("enter surname = {string}")
    public void enterSurname(String value) {
        pageObjectManager.getUserRegistration().setSurname(value);
    }

    @And("enter billingAddress = {string}")
    public void enterBillingAddress(String value) {
        pageObjectManager.getUserRegistration().setBillingAddress(value);
    }

    @And("enter mobile = {string}")
    public void enterMobile(String value) {
        pageObjectManager.getUserRegistration().setMobile(value);
    }

    @And("enter email = {string}")
    public void enterEmail(String value) {
        pageObjectManager.getUserRegistration().setEmail(value);
    }

    @And("enter password = {string}")
    public void enterPassword(String value) {
        pageObjectManager.getUserRegistration().setPassword(value);
    }

    @And("enter confirmPassword = {string}")
    public void enterConfirmPassword(String value) {
        pageObjectManager.getUserRegistration().setCpassword(value);
    }





  /*  @Then("Get error for fields")
    public void getErrorForFields(List<List<String>> table) {
        Map<String, String> user = TabletoDict.TableDictionaryConverter(table);
        if(user.get("firstname").equalsIgnoreCase("Yes"))
            Assert.assertTrue(pageObjectManager.getUserRegistration().isPresentFNErrorClass());
        if(user.get("surname").equalsIgnoreCase("Yes"))
            Assert.assertTrue(pageObjectManager.getUserRegistration().isPresentSNErrorClass());
        if(user.get("billingaddress").equalsIgnoreCase("Yes"))
            Assert.assertTrue(pageObjectManager.getUserRegistration().isPresentBAErrorClass());
        if(user.get("mobile").equalsIgnoreCase("Yes"))
            Assert.assertTrue(pageObjectManager.getUserRegistration().isPresentMobErrorClass());
        if(user.get("email").equalsIgnoreCase("Yes"))
            Assert.assertTrue(pageObjectManager.getUserRegistration().isPresentEmailErrorClass());
        if(user.get("password").equalsIgnoreCase("Yes"))
            Assert.assertTrue(pageObjectManager.getUserRegistration().isPresentPassErrorClass());
        if(user.get("cpassword").equalsIgnoreCase("Yes"))
            Assert.assertTrue(pageObjectManager.getUserRegistration().isPresentCpassErrorClass());
    }*/


}
