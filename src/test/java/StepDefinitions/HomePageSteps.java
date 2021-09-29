package StepDefinitions;

import Runner.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.PageObjectManager;

public class HomePageSteps extends TestBase {

    //private PageObjectManager pageObjectManager;


    public HomePageSteps() {
        pageObjectManager = new PageObjectManager(driver);
    }


    @When("User Click on Home menu")
    public void userClickOnHomeMenu() {
        pageObjectManager.getHomepage().clickHomeMenu();
    }

    @Then("User is on Home page")
    public void userIsOnHomePage()
    {
        waitForLoad(driver);
        Assert.assertTrue(pageObjectManager.getHomepage().isDisplayedHomePage());
    }

    @When("User Click on Services menu")
    public void userClickOnServicesMenu() {
        pageObjectManager.getHomepage().clickServicesMenu();
    }

    @Then("User is on Services page")
    public void userIsOnServicesPage() {
        waitForLoad(driver);
        Assert.assertTrue(pageObjectManager.getHomepage().isDisplayedServicePage());
    }

    @Given("Verify is there any broken link present on homepage")
    public void verify_is_there_any_broken_link_present_on_homepage() {
        //  int count = verifyBrokenLinks();
        // Assert.assertEquals(count, 0);
    }

    @When("User Click on Solutions menu")
    public void userClickOnSolutionsMenu() {
        pageObjectManager.getHomepage().clickSolutionsMenu();
    }

    @Then("User is on Solutions page")
    public void userIsOnSolutionsPage() {
        waitForLoad(driver);
        Assert.assertTrue(pageObjectManager.getHomepage().isDisplayedSolutionsPage());
    }


    @When("User Click on Send a Parcel menu")
    public void userClickOnSendAParcelMenu() {
        pageObjectManager.getHomepage().clickSendAParcelMenu();
    }

    @Then("User is on Send a Parcel page")
    public void userIsOnSendAParcelPage() {
        waitForLoad(driver);
        Assert.assertTrue(pageObjectManager.getHomepage().isDisplayedSendAParcelPage());
    }

    @When("User Click on Track your Parcel menu")
    public void userClickOnTrackYourParcelMenu() {
        pageObjectManager.getHomepage().clickTrackYourParcelMenu();
    }

    @Then("User is on Track your Parcel page")
    public void userIsOnTrackYourParcelPage() {
        waitForLoad(driver);
        Assert.assertTrue(pageObjectManager.getHomepage().isDisplayedTrackYourParcelPage());
    }

    @When("User Click on Contact Us menu")
    public void userClickOnContactUsMenu() {
        pageObjectManager.getHomepage().clickContactUsMenu();
    }

    @Then("User is on Contact Us page")
    public void userIsOnContactUsPage() {
        waitForLoad(driver);
        Assert.assertTrue(pageObjectManager.getHomepage().isDisplayedContactUsPage());
    }

    @When("User Click on take a Lot menu")
    public void userClickOnTakeALotMenuWithoutLoggedInToSystem() {
        pageObjectManager.getHomepage().clickTakeALotMenu();
    }

    @And("Accept alert box")
    public void acceptAlertBox() throws InterruptedException {
        String alertText=pageObjectManager.getHomepage().acceptAlert();
    }

    @When("User click on Business Portal Link")
    public void userClickOnBusinessPortalLink() {
        pageObjectManager.getHomepage().clickBusinessPortalLink();
    }

    @Then("Login form will open")
    public void loginWindowWillOpen() {
        pageObjectManager.getHomepage().switchToChildWindow();
        Assert.assertTrue(pageObjectManager.getHomepage().isDisplayedLoginForm());
    }

    @Then("RAM Customer Portal page will open in next tab")
    public void ramCustomerPortalPageWillOpenInNextTab() {
        String parent = pageObjectManager.getHomepage().switchToChildWindow();
        Assert.assertTrue(pageObjectManager.getHomepage().isDisplayedBusinessPortalPage());
        driver.close();
        driver.switchTo().window(parent);
    }

    @When("User click on Login Link")
    public void userClickOnLoginLink() {
        pageObjectManager.getHomepage().clickLoginLink();
    }

    @When("User click on Register link")
    public void userClickOnRegisterLink() {
        pageObjectManager.getHomepage().clickRegisterLink();
    }


    @When("User click on Send a parcel quick tool")
    public void userClickOnSendAParcelQuickTool() {
        pageObjectManager.getHomepage().clickQtoolSendAParcel();
    }


    @When("User enter waybill number {string} in textbox of track your parcel quick tool")
    public void userEnterWaybillNumberInTextboxOfTrackYourParcelQuickTool(String waybill) {
        pageObjectManager.getHomepage().setTxtWaybillN(waybill);
    }

    @And("Click on Find Parcel")
    public void clickOnFindParcel() {
        pageObjectManager.getHomepage().clickBtnFindParcel();
    }

    @When("User click on Contact Us quick tool")
    public void userClickOnContactUsQuickTool() {
        pageObjectManager.getHomepage().clickQtoolContactUs();
    }

    @When("user click on pharmaceutical Icon")
    public void userClickOnPharmaceuticalIcon() {
        pageObjectManager.getHomepage().clickSIconPharma();
    }

    @When("user click on IT and Cellular Icon")
    public void userClickOnITAndCellularIcon() {
        pageObjectManager.getHomepage().clickSIconITC();
    }

    @When("user click on Beauty and Cosmetics Icon")
    public void userClickOnBeautyAndCosmeticsIcon() {
        pageObjectManager.getHomepage().clickSIBAC();
    }

    @When("user click on Financial Icon")
    public void userClickOnFinancialIcon() {
        pageObjectManager.getHomepage().clickSIFinance();
    }

    @When("user click on Retail Icon")
    public void userClickOnRetailIcon() {
        pageObjectManager.getHomepage().clickSIRetail();
    }

    @When("user click on  Explore Seamless Supply Chain Solutions Icon")
    public void userClickOnExploreSeamlessSupplyChainSolutionsIcon() {
        pageObjectManager.getHomepage().clickSISupplyChain();
    }

    @When("user click on  About Us link")
    public void userClickOnAboutUsLink() throws InterruptedException {
        pageObjectManager.getFooter().clickLinkAboutUs();
    }

    @Then("RAM history page should open")
    public void ramHistoryPageShouldOpen() {
        waitForLoad(driver);
        Assert.assertTrue(pageObjectManager.getFooter().isDisplayedHistoryPage());
    }

    @When("user click on  NO Sub-Contracting link")
    public void userClickOnNOSubContractingLink() throws InterruptedException{
        pageObjectManager.getFooter().clickLinkNoSubContract();
    }


    @Then("NO Sub-Contracting page should open")
    public void noSubContractingPageShouldOpen() {
        waitForLoad(driver);
        Assert.assertTrue(pageObjectManager.getFooter().isDisplayedNoSubContractPage());
    }

    @When("user click on  History link")
    public void userClickOnHistoryLink()throws InterruptedException {
        pageObjectManager.getFooter().clickLinkHistory();
    }

    @When("user click on Careers link")
    public void userClickOnCareersLink()throws InterruptedException {
        pageObjectManager.getFooter().clickLinkCareers();
    }

    @Then("RAM Career page should open")
    public void ramCareerPageShouldOpen() {
        waitForLoad(driver);
        Assert.assertTrue(pageObjectManager.getFooter().isDisplayedCareersPage());
    }

    @When("user click on  Local Courier Services link")
    public void userClickOnLocalCourierServicesLink()throws InterruptedException {
        pageObjectManager.getFooter().clickLinkLocalServices();
    }


    @When("user click on  Special Courier Services link")
    public void userClickOnSpecialCourierServicesLink()throws InterruptedException {
        pageObjectManager.getFooter().clickLinkSpecialServices();
    }

    @When("user click on  Distribution Services link")
    public void userClickOnDistributionServicesLink()throws InterruptedException {
        pageObjectManager.getFooter().clickLinkDistributionServices();
    }

    @When("user click on  International Services link")
    public void userClickOnInternationalServicesLink() throws InterruptedException{
        pageObjectManager.getFooter().clickLinkInternationalServices();
    }

    @When("user click on  Warehousing Services link")
    public void userClickOnWarehousingServicesLink()throws InterruptedException {
        pageObjectManager.getFooter().clickLinkWarehousingServices();
    }

    @When("user click on RAM's Standard Terms & Conditions of Service link")
    public void userClickOnRAMSStandardTermsConditionsOfServiceLink()throws InterruptedException {
        pageObjectManager.getFooter().clickLinkRamStdTerms();
    }

    @Then("RAM's Standard Terms & Conditions of Service  document should open in new tab")
    public void ramSStandardTermsConditionsOfServiceDocumentShouldOpenInNewTab() throws InterruptedException {
        String parentWindow = pageObjectManager.getHomepage().switchToChildWindow();
        Assert.assertTrue(pageObjectManager.getFooter().isOPenedRamStdTermsDoc());
        Thread.sleep(2000);
        driver.close();
        driver.switchTo().window(parentWindow);
    }


    @When("user click on  Contact Us link")
    public void userClickOnContactUsLink()throws InterruptedException {
        pageObjectManager.getFooter().clickLinkContactUs();
    }

    @When("user click on  Sales link")
    public void userClickOnSalesLink()throws InterruptedException {
        pageObjectManager.getFooter().clickLinkSales();
    }

    @Then("RAM Sales page should open")
    public void ramSalesPageShouldOpen() {
        waitForLoad(driver);
        Assert.assertTrue(pageObjectManager.getFooter().isDisplayedSalesPage());
    }

    @When("user click on  Payment Options link")
    public void userClickOnPaymentOptionsLink()throws InterruptedException {
        pageObjectManager.getFooter().clickLinkPaymentOptions();
    }


    @When("user click on  Fuel Surcharge link")
    public void userClickOnFuelSurchargeLink()throws InterruptedException {
        pageObjectManager.getFooter().clickLinkFuelSurcharge();
    }

    @When("user click on  FAQs link")
    public void userClickOnFAQsLink()throws InterruptedException {
        pageObjectManager.getFooter().clickLinkFAQs();
    }

    @When("user click on  Coronavirus ESP Certificate link")
    public void userClickOnCoronavirusESPCertificateLink() throws InterruptedException{
        pageObjectManager.getFooter().clickLinkCoronaESPCertificate();
    }

    @Then("RAM Coronavirus ESP Certificate document should open in new tab")
    public void ramCoronavirusESPCertificateDocumentShouldOpenInNewTab() throws InterruptedException {
        String parentWindow = pageObjectManager.getHomepage().switchToChildWindow();
        Assert.assertTrue(pageObjectManager.getFooter().isOpenedCoronaCertificate());
        Thread.sleep(2000);
        driver.close();
        driver.switchTo().window(parentWindow);
    }

    @And("User navigate to home page")
    public void userNavigateToHomePage() {
        pageObjectManager.getHomepage().clickHomeMenu();
    }

    @Then("RAM IT Platform Terms and Conditions document should open in new tab")
    public void ramITPlatformTermsAndConditionsDocumentShouldOpenInNewTab() throws InterruptedException {
        String parentWindow = pageObjectManager.getHomepage().switchToChildWindow();
        Assert.assertTrue(pageObjectManager.getFooter().isOPenedITPlatTermsDoc());
        Thread.sleep(2000);
        driver.close();
        driver.switchTo().window(parentWindow);
    }

    @When("user click on IT Platform Terms and Conditions link")
    public void userClickOnITPlatformTermsAndConditionsLink()throws InterruptedException {
    pageObjectManager.getFooter().clickLinkRamITTerms();
    }

    @When("user click on Legal Documents link")
    public void userClickOnLegalDocumentsLink() throws InterruptedException {
    pageObjectManager.getFooter().clickLinkLegalDocs();
    }

    @Then("User is on Legal Documents")
    public void userIsOnLegalDocuments() {
        waitForLoad(driver);
        pageObjectManager.getFooter().isDisplayedLegalDocsPage();
    }

    @And("User Click on take a Lot link")
    public void userClickOnTakeALotLink() {
        pageObjectManager.getHomepage().clickLinkTakeALot();
       waitForLoad(driver);
    }

    @And("Close current page")
    public void closeCurrentPage() {
        driver.close();
        driver.switchTo().window(parentWindow);
    }

    @And("Click on every links to verify broken links")
    public void clickOnEveryLinksToVerifyBrokenLinks() throws InterruptedException {
               int brokenLinksCount=pageObjectManager.getFooter().verifyLegalDocLinks();
        System.out.println("Total number of broken links on Legal document are: "+brokenLinksCount);
       Assert.assertSame(0,brokenLinksCount,"There is broken links on Legal document page");
    }

    @And("Display alert box {string}")
    public void displayAlertBox(String msg) {
       Assert.assertTrue(pageObjectManager.getHomepage().compareAlertMsg(msg),"Correct alert message displayed");
    }
}