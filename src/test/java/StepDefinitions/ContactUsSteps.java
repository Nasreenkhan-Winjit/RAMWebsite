package StepDefinitions;

import Runner.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.PageObjectManager;

import java.util.List;

public class ContactUsSteps extends TestBase {

    public ContactUsSteps() {
        pageObjectManager=new PageObjectManager(driver);    }

    @When("User fill details in Customer Service Page")
    public void userFillDetailsInCustomerServicePage(List<List<String>> table) {
        pageObjectManager.getContactUs().fillContactDetailsForm(table);

    }

    @And("Click on Send button")
    public void clickOnSendButton() {
        pageObjectManager.getContactUs().clickBtnSend();
    }

    @When("User click on Track your parcel")
    public void userClickOnTrackYourParcelLink() {
    pageObjectManager.getContactUs().clickTrackYourParcel();
    }

    @And("User enter waybill number {string} in textbox of track your parcel")
    public void userEnterWaybillNumberInTextboxOfTrackYourParcel(String waybill) {
    pageObjectManager.getContactUs().setWaybillNumber(waybill);
    }

    @And("User click on submit waybill button")
    public void userClickOnSubmitWaybillButton() {
    pageObjectManager.getContactUs().clickBtnSubmitWaybill();
    }

    @When("User click on  Sales")
    public void userClickOnSales() {
    pageObjectManager.getContactUs().clickSales();
    }

    @When("User click on Careers")
    public void userClickOnCareers() {
    pageObjectManager.getContactUs().clickCareers();
    }

    @And("shows the tracking details for waybill {string}")
    public void showsTheTrackingDetailsForWaybill(String waybill) {
        Assert.assertTrue(pageObjectManager.getContactUs().isDisplayedWaybillDetails(waybill));
    }

    @And("Display message {string}")
    public void displayMessageNoResultFound(String msg) {
    Assert.assertTrue(pageObjectManager.getContactUs().isDispalyedNoResult(msg));
    }
}
