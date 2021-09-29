package StepDefinitions;

import Runner.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.PageObjectManager;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SendAParcelSteps extends TestBase {
    public SendAParcelSteps() {
        pageObjectManager = new PageObjectManager(driver);
    }

    @When("Select parcel send type as {string}")
    public void selectParcelSendTypeAs(String parcelSendType) throws InterruptedException {
        pageObjectManager.getSendAParcel().setParcelSendType(parcelSendType);
        //Thread.sleep(2000);
    }

    @And("Select parcelType as a {string}")
    public void selectParcelTypeAsA(String parcelType) throws InterruptedException {
        pageObjectManager.getSendAParcel().setParcelType(parcelType);
        //Thread.sleep(2000);
    }

    @And("Select parcelContent as {string}")
    public void selectParcelContentAs(String parcelContent) throws InterruptedException {
        pageObjectManager.getSendAParcel().setParcelContent(parcelContent);
        //Thread.sleep(1000);
    }

    @And("Enter collection address as {string}")
    public void enterCollectionAddressAs(String address) throws InterruptedException {
        //  pageObjectManager.getSendAParcel().leftClick();
        pageObjectManager.getSendAParcel().setFromAddress(address);

        //  pageObjectManager.getSendAParcel().leftClick();
        //Thread.sleep(1000);
    }

    @And("Enter delivery address as {string}")
    public void enterDeliveryAddressAs(String address) throws InterruptedException {
        // pageObjectManager.getSendAParcel().leftClick();
        pageObjectManager.getSendAParcel().setToAddress(address);
        // pageObjectManager.getSendAParcel().leftClick();
        //Thread.sleep(2000);
    }

    @And("Click on Next button")
    public void clickOnNextButton() throws InterruptedException {
        pageObjectManager.getSendAParcel().clickBtnNext();

        //Thread.sleep(2000);
    }

    @Then("User is on {string} step")
    public void userIsOnStep(String stepTitle) throws InterruptedException {
        Assert.assertTrue(pageObjectManager.getSendAParcel().getCurrentStepTitle().equalsIgnoreCase(stepTitle));
        //Thread.sleep(2000);
    }


    @Given("Step {string} completed")
    public void stepCompleted(String stepTitle) {
       driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        waitForLoad(driver);
        Assert.assertTrue(pageObjectManager.getSendAParcel().isStepDone(stepTitle));
    }

    @When("Select parcel count as {string}")
    public void selectParcelCountAs(String parcelCount) {
        pageObjectManager.getSendAParcel().setParcelCount(parcelCount);
    }

    @SneakyThrows
    @And("Select {string} to enter details as")
    public void selectToEnterDetailsAs(String parcelName) {
        pageObjectManager.getSendAParcel().selectParcel(parcelName);
        //Thread.sleep(1500);
    }

    /*
        @And("Parcel {int} Weight= {string}")
        public void parcelWeight(int parcelNo, String weight) throws InterruptedException {
                   //if(weight<>Null)
            pageObjectManager.getSendAParcel().setParcelWeight(parcelNo, weight);
            Thread.sleep(1000);
        }

        @And("Parcel {int} Length= {int}")
        public void parcelLength(int parcelNo, int length) throws InterruptedException {
            pageObjectManager.getSendAParcel().setParcelLenght(parcelNo, length);
            Thread.sleep(1000);
        }

        @And("Parcel {int} Width= {int}")
        public void parcelWidth(int parcelNo, int width) throws InterruptedException {
            pageObjectManager.getSendAParcel().setParcelWidth(parcelNo, width);
            Thread.sleep(1000);
        }

        @And("Parcel {int} Height= {int}")
        public void parcelHeight(int parcelNo, int height) throws InterruptedException {
            pageObjectManager.getSendAParcel().setParcelHeight(parcelNo, height);
            Thread.sleep(2000);
        }
    */
    @When("User click on Show all options")
    public void userClickOnShoowAllOptions() {
        pageObjectManager.getSendAParcel().clickBtnShowAllOptions();
        //Thread.sleep(2000);
    }

    @And("Select service type {string}")
    public void selectServiceType(String type) {
        int i = pageObjectManager.getSendAParcel().selectServiceType(type);
        pageObjectManager.getSendAParcel().clickBtnSelect(i);
        //Thread.sleep(2000);
    }

    @And("Click on Confirm button")
    public void clickOnConfirmButton() {
        pageObjectManager.getSendAParcel().clickBtnConfirm();
        //Thread.sleep(2000);
    }

    @When("User enter email {string}")
    public void userEnterEmail(String email) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        pageObjectManager.getSendAParcel().setSendLoginEmail(email);
        //Thread.sleep(1000);
    }

    @And("Enter Password as {string}")
    public void enterPasswordAs(String pass) {
        pageObjectManager.getSendAParcel().setSendLoginPassword(pass);
        //Thread.sleep(1000);
    }

    @And("Click on Login button")
    public void clickOnLoginButton() throws InterruptedException {
        pageObjectManager.getSendAParcel().clickBtnLogin();
        //Thread.sleep(2000);
    }

    @Then("Send Address page get opened")
    public void sendAddressPageGetOpened() {
        waitForLoad(driver);
        Assert.assertTrue(("Url of current page is "+driver.getCurrentUrl()),pageObjectManager.getSendAParcel().isSendAddressPage());
    }

    @When("User enter collection details as  collection_Firstname={string}")
    public void userEnterCollectionDetailsAsCollection_Firstname(String name) {
        pageObjectManager.getSendAParcel().setCollectionFirstName(name);
    }

    @And("Collection_Surname={string}")
    public void collection_surname(String name) {
        pageObjectManager.getSendAParcel().setCollectionSurName(name);
    }

    @And("Collection_Mobile no={string}")
    public void collection_mobileNo(String mob) {
        pageObjectManager.getSendAParcel().setCollectionMobile(mob);
    }

    @And("Collection_email address={string}")
    public void collection_emailAddress(String email) {
        pageObjectManager.getSendAParcel().setCollectionEmail(email);
    }

    @And("Collection_Property type={string}")
    public void collection_propertyType(String type) {
        if (type != null){
            if (type.length() >= 1)
                pageObjectManager.getSendAParcel().setCollectionType(type);
        }
    }

    @And("User enter delivery details as  delivery_Firstname={string}")
    public void userEnterDeliveryDetailsAsDelivery_Firstname(String name) {
        pageObjectManager.getSendAParcel().setDeliveryFirstname(name);
    }

    @And("Delivery_Surname={string}")
    public void delivery_surname(String name) {
        pageObjectManager.getSendAParcel().setDeliverySurname(name);
    }

    @And("Delivery_Mobile no={string}")
    public void delivery_mobileNo(String mob) {
        pageObjectManager.getSendAParcel().setDeliveryMobile(mob);
    }

    @And("Delivery_email address={string}")
    public void delivery_emailAddress(String email) {
        pageObjectManager.getSendAParcel().setDeliveryEmail(email);
    }

    @And("Delivery_Property type={string}")
    public void delivery_propertyType(String type) {
        if (type != null) {
            if (type.length() >= 1)
                pageObjectManager.getSendAParcel().setDeliveryType(type);
        }
    }

    @And("Click on Submit button")
    public void clickOnSubmitButton() {
        pageObjectManager.getSendAParcel().clickBtnDomesSubmit();

    }

    @And("User not navigated to secure EFT payment page")
    @Given("Send Confirm page is opened")
    @Then("Send Confirm page get opened")
    public void sendConfirmPageGetOpened() {
        Assert.assertTrue(pageObjectManager.getSendAParcel().isSendConfirmPage());
    }

    @And("Select payment type={string}")
    public void selectPaymentType(String payType) throws InterruptedException {
        // driver.switchTo().frame(1)
        pageObjectManager.getSendAParcel().selectPayType(payType);
        //Thread.sleep(1000);
    }

    @And("Accept terms and condition")
    public void acceptTermsAndCondition() throws InterruptedException {
        pageObjectManager.getSendAParcel().clickAgreeBox();
        //Thread.sleep(2000);
    }

    @And("Click on Confirm and Proceed to Payment button")
    public void clickOnConfirmAndProceedToPaymentButton() throws InterruptedException {
        pageObjectManager.getSendAParcel().clickBtnConfirm_Pay();
        //Thread.sleep(3000);
    }

    @Then("User navigated to secure EFT payment page")
    public void userNavigatedToSecureEFTPaymentPage() {
        waitForLoad(driver);
        org.testng.Assert.assertTrue(pageObjectManager.getSendAParcel().isSecureEFTPaymentPage());
    }

    @And("Select delivery address country as {string}")
    public void selectDeliveryAddressAs(String countryName) {
        pageObjectManager.getSendAParcel().selectCountry(countryName);
    }

    @And("Upload Invoice {string}")
    public void uploadInvoice(String filePath) {
        pageObjectManager.getSendAParcel().chooseInvoiceFile(filePath);
    }

    @And("Delivery_Address={string}")
    public void delivery_address(String deliveryAddress) throws InterruptedException {
        pageObjectManager.getSendAParcel().setDeliveryAddress(deliveryAddress);
        //Thread.sleep(1000);
    }

    @And("Click on Submit button for International parcel")
    public void clickOnSubmitButtonForInternationalParcel() {
        pageObjectManager.getSendAParcel().clickBtnInterSubmit();
    }

    @And("Collection_address={string}")
    public void collection_address(String address) throws InterruptedException {
        pageObjectManager.getSendAParcel().setCollectionAddress(address);
        //Thread.sleep(2000);
    }

    @And("Close the application")
    public void closeTheApplication() {
      tearDown();
    }

    @And("Open Application")
    public void openApplication() {
        launchBrowser();
    }

    @And("Click on Button {string}")
    public void clickOnButton(String btnName) {
        pageObjectManager.getSendAParcel().clickBtnUseAddress(btnName);
    }

    @And("User enter Firearm details as Firearm_Id={string}")
    public void userEnterFirearmDetailsAsFirearm_Id(String id) {
        pageObjectManager.getSendAParcel().setFirearmOwnerId(id);
    }

    @And("Select Firearm_Type={string}")
    public void selectFirearm_Type(String type) {
        pageObjectManager.getSendAParcel().setFirearmType(type);
    }

    @And("Make of Firearm={string}")
    public void makeOfFirearm(String make) {
        pageObjectManager.getSendAParcel().setFirearmMake(make);
    }

    @And("Firearm serial number={string}")
    public void firearmSerialNumber(String number) {
        pageObjectManager.getSendAParcel().setFirearmSN(number);
    }

    @And("Firearm has telescope={string}")
    public void firearmHasTelescope(String telescope) {
        pageObjectManager.getSendAParcel().selectFirearmScope(telescope);
    }

    @And("Firearm Magazines={string}")
    public void firearmMagazines(String mags) {
        pageObjectManager.getSendAParcel().setFirearmMags(mags);
    }

    @And("Firearm other={string}")
    public void firearmOther(String other) throws InterruptedException {
        pageObjectManager.getSendAParcel().setFirearmOther(other);
        // Thread.sleep(3000);
    }

    @And("click on next slide_arrow")
    public void clickOnSlide_arrow_next() {
        pageObjectManager.getSendAParcel().clickBtnNextSlider();
    }

    @Then("Get error in ParcelType {string}")
    public void getErrorInParcelType(String errorStatus) {
        if (errorStatus.equalsIgnoreCase("Yes"))
            Assert.assertTrue(pageObjectManager.getSendAParcel().isPresentDParcelTypeErrorClass());
        else if (errorStatus.equalsIgnoreCase("Iyes"))
            Assert.assertTrue(pageObjectManager.getSendAParcel().isPresentIParcelTypeErrorClass());
    }

    @And("Get error in ParcelContent {string}")
    public void getErrorInParcelContent(String errorStatus) {
        if (errorStatus.equalsIgnoreCase("Yes"))
            Assert.assertTrue(pageObjectManager.getSendAParcel().isPresentSelectErrorClass());
    }


    @And("Get error in to address textbox {string}")
    public void getErrorInToAddressTextbox(String errorStatus) {
        if (errorStatus.equalsIgnoreCase("Yes"))
            Assert.assertTrue(pageObjectManager.getSendAParcel().isPresentToAddressErrorClass());
    }

    @And("Get error in from address textbox {string}")
    public void getErrorInFromAddressTextbox(String errorStatus) {
        if (errorStatus.equalsIgnoreCase("Yes"))
            Assert.assertTrue(pageObjectManager.getSendAParcel().isPrsentFrmAddressErrorClass());
    }

    @When("User fill details")
    public void userFillDetails(List<List<String>> table) {
        waitForLoad(driver);
        pageObjectManager.getSendAParcel().fillDetailsStep1(table);
    }


    @Then("Displays error Toaster message")
    public void displaysErrorToasterMessage() {
        Assert.assertTrue(pageObjectManager.getSendAParcel().isDisplayRestrictedParcelContentToaster());
    }


    @Then("Get error in Parcel {int} Weight {string}")
    public void getErrorInParcelWeight(int parcelNumber, String errorStatus) {
        if (errorStatus.equalsIgnoreCase("Yes"))
            pageObjectManager.getSendAParcel().isPresentPWeightErrorClass(parcelNumber);
    }

    @And("Get error in Parcel {int} Lenght {string}")
    public void getErrorInParcelLenght(int parcelNumber, String errorStatus) {
        if (errorStatus.equalsIgnoreCase("Yes"))
            pageObjectManager.getSendAParcel().isPresentPLenghtErrorClass(parcelNumber);
    }

    @And("Get error in Parcel {int} Width {string}")
    public void getErrorInParcelWidth(int parcelNumber, String errorStatus) {
        if (errorStatus.equalsIgnoreCase("Yes"))
            pageObjectManager.getSendAParcel().isPresentPWidthErrorClass(parcelNumber);
    }

    @And("Get error in Parcel {int} Height {string}")
    public void getErrorInParcelHeight(int parcelNumber, String errorStatus) {
        if (errorStatus.equalsIgnoreCase("Yes"))
            pageObjectManager.getSendAParcel().isPresentPHeightErrorClass(parcelNumber);
    }


    @And("Parcel {int} Weight= {string}")
    public void parcelWeight(int parcelNo, String weight) throws InterruptedException {
        if (weight != null) {
            pageObjectManager.getSendAParcel().setParcelWeight(parcelNo, (weight));
            //Thread.sleep(2000);
        }
    }

    @And("Parcel {int} Length= {string}")
    public void parcelLength(int parcelNo, String length) throws InterruptedException {
        if (length != null) {
            pageObjectManager.getSendAParcel().setParcelLenght(parcelNo, (length));
            //Thread.sleep(2000);
        }
    }

    @And("Parcel {int} Width= {string}")
    public void parcelWidth(int parcelNo, String width) throws InterruptedException {
        if (width != null) {
            pageObjectManager.getSendAParcel().setParcelWidth(parcelNo, (width));
            //Thread.sleep(2000);
        }
    }

    @And("Parcel {int} Height= {string}")
    public void parcelHeight(int parcelNo, String height) throws InterruptedException {
        if (height != null) {
            pageObjectManager.getSendAParcel().setParcelHeight(parcelNo, (height));
            Thread.sleep(2000);
        }
    }

    @When("User click on Show all link")
    public void userClickOnShowAllLink() {
                pageObjectManager.getSendAParcel().clickLinkShowAllOptions();
    }

    @And("Click on Change button")
    public void clickOnChangeButton() {
        pageObjectManager.getSendAParcel().clickBtnChange();
    }


    @And("Click on Close button")
    public void clickOnCloseButton() {
        pageObjectManager.getSendAParcel().clickBtnClose();
    }


    @Then("Get error for fields")
    public void getErrorForFields() {

    }


    @Then("Get error and send confirm page not opened")
    public void getErrorAndSendConfirmPageNotOpened() {
        Assert.assertTrue(pageObjectManager.getSendAParcel().isSendAddressPage());
    }

    @When("Click on Back button")
    public void clickOnBackButton() {
    pageObjectManager.getSendAParcel().clickBtnBack();
    }

    @Then("User is navigate to Start you order")
    public void userIsNavigateToStartYouOrder() {
        pageObjectManager.getSendAParcel().getCurrentStepTitle().equalsIgnoreCase("Start Your Order");
        }

    @When("User click on step {string}")
    public void userClickOnStep(String step) {
    pageObjectManager.getSendAParcel().clickStep(step);
    waitForLoad(driver);
    }

    @When("User click on Forgot Password link")
    public void userClickOnForgotPasswordLink() {
        pageObjectManager.getSendAParcel().clickLinkForgotPassword();
    }

    @Given("User is on Start your Order page")
    public void userIsOnStartYourOrderPage() {
        pageObjectManager.getSendAParcel().getCurrentStepTitle().equalsIgnoreCase("Start Your Order");
    }

    @Then("User logged in")
    public void userLoggedIn() throws InterruptedException {
       Thread.sleep(2000);
    Assert.assertTrue(pageObjectManager.getHomepage().isUserLoggedIn());

    }

    @Given("User is on Send a Parcel-Register page")
    public void userIsOnSendAParcelRegisterPage() {
        waitForLoad(driver);
        Assert.assertTrue(("User is on page: "+driver.getCurrentUrl()),pageObjectManager.getSendAParcel().isSendRegisterPage());
    }

    @And("Disable the field From Address")
    public void disableTheFieldFromAddress() {
        org.testng.Assert.assertTrue(pageObjectManager.getSendAParcel().isFromAddressDisabled(),"From Address textbox must be disabled");
    }

    @And("Disable the field To Address")
    public void disableTheFieldToAddress() {
        org.testng.Assert.assertTrue(pageObjectManager.getSendAParcel().isToAddressDisabled(),"To Address textbox must be disabled");
    }

}
