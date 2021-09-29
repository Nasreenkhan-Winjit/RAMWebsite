package StepDefinitions;

import Runner.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import pages.PageObjectManager;

public class TakeALotSteps extends TestBase {
    public TakeALotSteps() {
        PageObjectManager pageObjectManager = new PageObjectManager(driver);
    }

   /* @AfterStep
    public void setWait() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Exception" + e);
        }
    }*/
   SoftAssertions sa = null;

    @Then("User is on take a lot-Start your Order page")
    public void userIsOnTakeALotStartYourOrderPage() {
        parentWindow = pageObjectManager.getTakeALot().switchToChildWindow();
        waitForLoad(driver);
       Assert.assertTrue(pageObjectManager.getTakeALot().isTALStartYourOrderPage());
    }

    @And("Select Take a lot destination as {string}")
    public void selectTakeALotDestinationAs(String destination) {
        pageObjectManager.getTakeALot().setSelectTALDestination(destination);
    }

    @And("Enter PO Number as {string}")
    public void enterPONumberAs(String poNumber) throws InterruptedException {
        pageObjectManager.getTakeALot().setTALPONumber(poNumber);
        Thread.sleep(1000);
    }

    @And("Enter TAL collection address as {string}")
    public void enterTALCollectionAddressAs(String address) {
        pageObjectManager.getTakeALot().setTALFromAddress(address);
    }

    @When("Select TAL parcelContent as {string}")
    public void selectTALParcelContentAs(String content) {
        pageObjectManager.getTakeALot().setTALParcelContent(content);
    }

    @Then("Take a lot-Start your Order page will open in new tab")
    public void takeALotStartYourOrderPageWillOpenInNewTab() {
        //switchWindowTab(driver);
        String parent = pageObjectManager.getTakeALot().switchToChildWindow();
        waitForLoad(driver);
        pageObjectManager.getTakeALot().isTALStartYourOrderPage();
    }

    @And("Click on TAL Next button")
    public void clickOnTALNextButton() {
      // pageObjectManager.getTakeALot().clickOnTALForm();
        pageObjectManager.getTakeALot().clickBtnTALNext();
        //Thread.sleep(1000);
       // System.out.println("next buttton clicked performed");
       // Thread.sleep(1000);
    }

    @Then("Step TAL {string} completed")
    public void stepTALCompleted(String step) throws InterruptedException {
        waitForLoad(driver);
        Assert.assertTrue(pageObjectManager.getTakeALot().isTALStepDone(step));
        Thread.sleep(1000);
    }

    @When("Select default service type")
    public void selectDefaultServiceType() throws InterruptedException {
        pageObjectManager.getSendAParcel().selectServiceType();
        Thread.sleep(2000);
    }

    @When("Use registration details is {string}")
    public void useRegistrationDetailsIs(String status) {
        pageObjectManager.getTakeALot().selectCollectionChkBox(status);
    }

    @Then("Get error for TAL parcelContent field = {string}")
    public void getErrorForParcelContentFieldYes(String status) {
        if (status.equalsIgnoreCase("yes"))
            Assert.assertTrue(pageObjectManager.getTakeALot().isPresentTALPContentErrorClass());
    }

    @And("Get error for TAL collection address field= {string}")
    public void getErrorForCollectionAddressField(String status) {
        if (status.equalsIgnoreCase("yes"))
            Assert.assertTrue(pageObjectManager.getTakeALot().isPresentTALCollectionAddErrorClass());
    }

    @And("Get error for Take a lot destination field {string}")
    public void getErrorForTakeALotDestinationField(String status) {
        if (status.equalsIgnoreCase("yes"))
            Assert.assertTrue(pageObjectManager.getTakeALot().isPresentTALDestinationErrorClass());
    }

    @And("Get error for TAL PO Number field ={string}")
    public void getErrorForPONumberField(String status) {
        if (status.equalsIgnoreCase("yes"))
            Assert.assertTrue(pageObjectManager.getTakeALot().isPresentTALPONumberErrorClass());
    }

    @Then("Get alert {string}")
            public void getAlert(String alertmsg) throws InterruptedException {
            Assert.assertEquals(pageObjectManager.getTakeALot().acceptAlert(), alertmsg);
    }

    @And("Click on TAL Back button")
    public void clickOnTALBackButton() {
        pageObjectManager.getTakeALot().clickBtnTALBack();
        try {
        Thread.sleep(2000);}
        catch(Exception e){}
    }

    @Then("User is navigate to TAL Start you order")
    public void userIsNavigateToTALStartYouOrder() {
   Assert.assertTrue(pageObjectManager.getTakeALot().getTALCurrentStepTitle().equalsIgnoreCase("Start Your Order"));
    }

    @And("Select TAL {string} to enter details as")
    public void selectTALToEnterDetailsAs(String parcelName) {
    pageObjectManager.getTakeALot().selectTALParcel(parcelName);
    }

    @And("TAL Parcel {int} Weight= {string}")
    public void TALparcelWeight(int parcelNo, String weight) {
        if (weight != null) {
            pageObjectManager.getTakeALot().setTALParcelWeight(parcelNo, (weight));
            //Thread.sleep(2000);
        }
    }

    @And("TAL Parcel {int} Length= {string}")
    public void TALparcelLength(int parcelNo, String length)  {
        if (length != null) {
            pageObjectManager.getTakeALot().setTALParcelLenght(parcelNo, (length));
            //Thread.sleep(2000);
        }
    }

    @And("TAL Parcel {int} Width= {string}")
    public void TALparcelWidth(int parcelNo, String width)  {
        if (width != null) {
            pageObjectManager.getTakeALot().setTALParcelWidth(parcelNo, (width));
            //Thread.sleep(2000);
        }
    }

    @And("TAL Parcel {int} Height= {string}")
    public void TALparcelHeight(int parcelNo, String height) throws InterruptedException {
        if (height != null) {
            pageObjectManager.getTakeALot().setTALParcelHeight(parcelNo, (height));
            Thread.sleep(2000);
        }
    }


    @Then("Get error in TAL Parcel {int} Weight {string}")
    public void getErrorInParcelWeight(int parcelNumber, String errorStatus) {
        if (errorStatus.equalsIgnoreCase("Yes"))
            pageObjectManager.getTakeALot().isPresentTALPWeightErrorClass(parcelNumber);
    }

    @And("Get error in TAL Parcel {int} Lenght {string}")
    public void getErrorInParcelLenght(int parcelNumber, String errorStatus) {
        if (errorStatus.equalsIgnoreCase("Yes"))
            pageObjectManager.getTakeALot().isPresentTALPLenghtErrorClass(parcelNumber);
    }

    @And("Get error in TAL Parcel {int} Width {string}")
    public void getErrorInParcelWidth(int parcelNumber, String errorStatus) {
        if (errorStatus.equalsIgnoreCase("Yes"))
            pageObjectManager.getTakeALot().isPresentTALPWidthErrorClass(parcelNumber);
    }

    @And("Get error in TAL Parcel {int} Height {string}")
    public void getErrorInParcelHeight(int parcelNumber, String errorStatus) {
        if (errorStatus.equalsIgnoreCase("Yes"))
            pageObjectManager.getTakeALot().isPresentTALPHeightErrorClass(parcelNumber);
    }

    @When("Select TAL parcel count as {string}")
    public void selectTALParcelCountAs(String parcelCount) {
        pageObjectManager.getTakeALot().setTALParcelCount(parcelCount);
    }

    @When("Select TAL default service type")
    public void selectTALDefaultServiceType() {
    pageObjectManager.getTakeALot().selectTALServiceType();
    }

    @When("Select Prohibited parcelContent")
    public void selectProhibitedParcelContent() {
        pageObjectManager.getTakeALot().setTALProhibitedContent();
    }


    @And("Click on TAL form")
    public void clickOnTALForm() {
    pageObjectManager.getTakeALot().clickOnTALForm();
    }


    @Given("User is on take a lot-Select Your Serice page")
    public void userIsOnTakeALotSelectYourSericePage() {
    Assert.assertTrue(pageObjectManager.getTakeALot().isTALSelectYourServicePage());
    }

    @And("Click on TAL Change button")
    public void clickOnTALChangeButton() {
        pageObjectManager.getTakeALot().clickTALBtnChange();
    }

    @And("Click on TAL Confirm close button")
    public void clickOnTALConfirmCloseButton() {
        pageObjectManager.getTakeALot().clickTALBtnConfirmClose();
    }

    @Then("TAL Confirm window opens")
    public void talConfirmWindowOpens() {
    Assert.assertTrue("TAL Select Your Service-Confirm Window is displayed",pageObjectManager.getTakeALot().isTALConfirmModalOpened());
    }

    @Then("TAL Confirm window is disappear")
    public void talConfirmWindowIsDisappear() {
        Assert.assertFalse("TAL Select Your Service-Confirm Window is not displayed",pageObjectManager.getTakeALot().isTALConfirmModalOpened());
    }


    @When("Click on Edit Address Button")
    public void clickOnEditAddressButton() {
        pageObjectManager.getTakeALot().clickLinkEditAddress();
    }

    @Given("TAL Address page is opened")
    @Then("User navigate to TAL Address page")
    public void userNavigateToTALAddressPage() {
        waitForLoad(driver);
        Assert.assertTrue(pageObjectManager.getTakeALot().isTALAddressPage());
    }


    @Then("Displays TAL Payment Type Error message")
    public void displaysTALPaymentTypeErrorMessage() {
    Assert.assertTrue(pageObjectManager.getTakeALot().isTALPaymentTypeErrorDisplayed());
    }


    @Then("Display msg {string} on Confirm and Proceed to Payment button")
    public void displaymsgOnConfirmAndProceedToPaymentButton(String msg) {
        Assert.assertTrue(pageObjectManager.getTakeALot().isDisplayedmsgOnTALConfirmBtn(msg));
    }

    @When("Select check box  On Delivery Email")
    public void selectCheckBoxOnDeliveryEmail() {
    pageObjectManager.getTakeALot().selectChxBoxTALOnDelEmail();
    }

    @And("Select check box On Delivery SMS")
    public void selectCheckBoxOnDeliverySMS() {
        pageObjectManager.getTakeALot().selectChxBoxTALOnDelSms();
    }

    @And("Select check box  Full Tracking Email")
    public void selectCheckBoxFullTrackingEmail() {
        pageObjectManager.getTakeALot().selectChxBoxTALFullTrackEmail();
    }

    @And("Select check box Full Tracking SMS")
    public void selectCheckBoxFullTrackingSMS() {
        pageObjectManager.getTakeALot().selectChxBoxTALFullTrackSms();
    }

    @Then("Get notification for On Delivery Email textBox")
    public void getAlertForOnDeliveryEmailTextBox() {
        sa = new SoftAssertions();
        sa.assertThat(pageObjectManager.getTakeALot().isRequiredTxtOnDelEmail()).as("On Delivery email is checked but emailAddress not entered").isEqualTo(true);
    }

    @And("Get notification for On Delivery SMS textBox")
    public void getNotificationForOnDeliverySMSTextBox() {
        //sa = new SoftAssertions();
        sa.assertThat(pageObjectManager.getTakeALot().isRequiredTxtOnDelSms()).as("On Delivery sms is checked but mobile number not entered").isEqualTo(true);
    }

    @And("Get notification for Full Tracking Email textBox")
    public void getNotificationForFullTrackingEmailTextBox() {
        sa.assertThat(pageObjectManager.getTakeALot().isRequiredTxtFullTrackEmail()).as("Full Tracking email is checked but emailAddress not entered").isEqualTo(true);
    }

    @And("Get notification for Full Tracking SMS textBox")
    public void getNotificationForFullTrackingSMSTextBox() {
        sa.assertThat(pageObjectManager.getTakeALot().isRequiredTxtFullTrackSms()).as("Full tracking SMS is checked but mobile number not entered").isEqualTo(true);
   sa.assertAll();
    }

    @And("all notification check boxes are selected")
    public void allNotificationsCheckBoxesAreSelected() {
        sa = new SoftAssertions();
        sa.assertThat(pageObjectManager.getTakeALot().isSelectedChkBoxOnDelEmail()).as("On delivery Email check box was not selected").isEqualTo(true);
        sa.assertThat(pageObjectManager.getTakeALot().isSelectedChkBoxOnDelSms()).as("On delivery SMS check box was not selected").isEqualTo(true);;
        sa.assertThat(pageObjectManager.getTakeALot().isSelectedChkBoxFullTrackEmail()).as("Full Tracking Email check box was not selected").isEqualTo(true);
        sa.assertThat(pageObjectManager.getTakeALot().isSelectedChkBoxFullTrackSms()).as("Full Tracking SMS check box was not selected").isEqualTo(true);;
        sa.assertAll();
    }

    @And("Enter On Delivery Email = {string}")
    public void enterOnDeliveryEmail(String email) {
    pageObjectManager.getTakeALot().setTxtTALOnDelEmail(email);
    }

    @And("Enter On Delivery SMS = {string}")
    public void enterOnDeliverySMS(String mobNo) {
        pageObjectManager.getTakeALot().setTxtTALOnDelSms(mobNo);
    }

    @And("Enter Full Tracking Email = {string}")
    public void enterFullTrackingEmail(String email) {
        pageObjectManager.getTakeALot().setTxtTALFullTrackEmail(email);
    }

    @And("Enter Full Tracking SMS = {string}")
    public void enterFullTrackingSMS(String mobNo) {
        pageObjectManager.getTakeALot().setTxtTALFullTrackSms(mobNo);
    }

    @Then("Disable the field collection_Firstname")
    public void disableTheFieldCollection_Firstname() {
    Assert.assertTrue("TAL Collection FirstName field should be disabled",pageObjectManager.getTakeALot().isEnabledTALCollectionFirstName());
    }

    @And("Disable the field collection_Surname")
    public void disableTheFieldCollection_Surname() {
        Assert.assertTrue("TAL Collection SurName field should be disabled",pageObjectManager.getTakeALot().isEnabledTALCollectionSurname());
    }

    //@And("User not navigated to secure EFT payment page")
    @Given("TAL Confirm page is opened")
    @Then("TAL Confirm page get opened")
    public void tALConfirmPageGetOpened() {
       waitForLoad(driver);
        Assert.assertTrue(pageObjectManager.getTakeALot().isTALConfirmPage());
    }

    @Given("User is on TAL {string} step")
    public void userIsTALOnStep(String step) {
        Assert.assertTrue(pageObjectManager.getTakeALot().getTALCurrentStepTitle().equalsIgnoreCase(step));
    }
}