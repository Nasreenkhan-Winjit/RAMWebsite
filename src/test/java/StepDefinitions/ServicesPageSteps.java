package StepDefinitions;

import Runner.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.PageObjectManager;

public class ServicesPageSteps extends TestBase {
    public ServicesPageSteps() {
        PageObjectManager pageObjectManager = new PageObjectManager(driver);
    }

    @Then("RAM Local Services page should open")
    public void ramLocalServicesPageShouldOpen() {
        waitForLoad(driver);
    Assert.assertTrue( pageObjectManager.getServices().isDisplayedLocalServicesPage());
    }

    @Then("RAM Special Services page should open")
    public void ramSpecialServicesPageShouldOpen() {
        waitForLoad(driver);
        Assert.assertTrue(pageObjectManager.getServices().isDisplayedSpecialServicesPage());
    }

    @Then("RAM Distribution Services page should open")
    public void ramDistributionServicesPageShouldOpen() {
        waitForLoad(driver);
    Assert.assertTrue(pageObjectManager.getServices().isDisplayedDistributionServicesPage());
    }

    @Then("RAM International Services page should open")
    public void ramInternationalServicesPageShouldOpen() {
        waitForLoad(driver);
    Assert.assertTrue(pageObjectManager.getServices().isDisplayedInternationalServicesPage());
    }

    @Then("RAM Warehousing Services page should open")
    public void ramWarehousingServicesPageShouldOpen() {
        waitForLoad(driver);
   Assert.assertTrue(pageObjectManager.getServices().isDisplayedWarehousingServicesPage());
    }
    @Given("User is on Fuel Surcharge Page")
    @Then("RAM Fuel Surcharge page should open")
    public void ramFuelSurchargePageShouldOpen() {
        waitForLoad(driver);
        Assert.assertTrue(pageObjectManager.getServices().isDisplayedFuelSurchargePage());
    }

    @And("Click on Local Services")
    public void clickOnLocalServices() {
    pageObjectManager.getServices().clickLocalServices();
    }

    @And("Click on Special Services")
    public void clickOnSpecialServices() {
    pageObjectManager.getServices().clickSpecialServices();
    }

    @And("Click on Distribution Services")
    public void clickOnDistributionServices() {
    pageObjectManager.getServices().clickDistributionServices();
    }

    @And("Click on International Services")
    public void clickOnInternationalServices() {
    pageObjectManager.getServices().clickInternationalServices();
    }

    @And("Click on Warehousing Services")
    public void clickOnWarehousingServices() {
    pageObjectManager.getServices().clickWarehousingServices();
    }

    @And("Click on Fuel Surcharge")
    public void clickOnFuelSurcharge() {
    pageObjectManager.getServices().clickFuelSurcharge();
    }

    @And("User click on link - Click here to view our Firearm Transport Certificate.")
    public void userClickOnLinkClickHereToViewOurFirearmTransportCertificate() {
    pageObjectManager.getServices().clickLinkFirearmTransport();
    }

    @Then("Firearm Transport Certificate should open in next tab")
    public void firearmTransportCertificateShouldOpenInNextTab() {
    pageObjectManager.getServices().switchToChildWindow();
    Assert.assertTrue(driver.getCurrentUrl().contains("Firearm Transport"));
    driver.close();
    }

    @Then("Get information of fuel surcharge rate for current month")
    public void getInformationOfFuelSurchargeRateForCurrentMonth() throws InterruptedException {
    //Thread.sleep(5000);
    Assert.assertTrue(pageObjectManager.getServices().isFuelSurchargeRateOfCurrentMonthYear());
    }

    @And("User click on link - RAMs Standard Terms and Conditions.")
    public void userClickOnLinkRAMsStandardTermsAndConditions() {
    pageObjectManager.getServices().clickLinkStdTermsCondition();
    }
}
