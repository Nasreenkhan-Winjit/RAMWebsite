package StepDefinitions;

import Runner.TestBase;
import io.cucumber.java.en.Then;
import pages.PageObjectManager;

public class FAQSteps extends TestBase {
    public FAQSteps() {
        pageObjectManager=new PageObjectManager(driver);
    }

    @Then("RAM Payment Options page should open")
    public void ramPaymentOptionsPageShouldOpen() {
    pageObjectManager.getFAQ().isDisplayedPaymentOptionPage();
    }

    @Then("RAM FAQ Services and Logistics page should open")
    public void ramFAQServicesAndLogisticsPageShouldOpen() {
pageObjectManager.getFAQ().isDisplayedServicesLogisticsPage();
    }



}
