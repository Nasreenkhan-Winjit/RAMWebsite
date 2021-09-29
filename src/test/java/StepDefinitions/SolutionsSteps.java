package StepDefinitions;

import Runner.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.PageObjectManager;

public class SolutionsSteps extends TestBase {
    public SolutionsSteps() {
        PageObjectManager pageObjectManager = new PageObjectManager(driver);
    }

    @Then("Pharmaceutical Solutions page should open")
    public void pharmaceuticalSolutionPageShouldOpen() {
        Assert.assertTrue(pageObjectManager.getSolutions().isDisplayedPharmaPage());
    }

    @Then("IT and Cellular Solutions page should open")
    public void itAndCellularSolutionPageShouldOpen() {
        waitForLoad(driver);
        Assert.assertTrue(pageObjectManager.getSolutions().isDisplayedITCPage());
    }

    @Then("Beauty and Cosmetics Solutions page should open")
    public void beautyAndCosmeticsSolutionPageShouldOpen() {
        waitForLoad(driver);
        pageObjectManager.getSolutions().isDisplayedBACPage();
    }

    @Then("Financial Solutions page should open")
    public void financialSolutionPageShouldOpen() {
        waitForLoad(driver);
        pageObjectManager.getSolutions().isDisplayedFinancialPage();
    }

    @Then("Retail Solutions page should open")
    public void retailSolutionPageShouldOpen() {
        waitForLoad(driver);
        pageObjectManager.getSolutions().isDisplayedRetailPage();
    }

    @Given("User is on Supply Chain Page")
    @Then("Supply Chain Solutions page should open")
    public void supplyChainSolutionPageShouldOpen() {
        waitForLoad(driver);
        pageObjectManager.getSolutions().isDisplayedSupplyChainPage();
    }

    @Given("User is on Business to Consumer Page")
    @Then("Business to Consumer Solutions page should open")
    public void businessToConsumerSolutionsPageShouldOpen() {
        waitForLoad(driver);
        pageObjectManager.getSolutions().isDisplayedB2CPage();
    }

    @And("User click on Pharmaceutical Solutions")
    public void clickOnPharmaceuticalSolutions() {
        pageObjectManager.getSolutions().clickPharmaSolu();
    }

    @And("User click on IT and Cellular Solutions")
    public void clickOnITAndCellularSolutions() {
        pageObjectManager.getSolutions().clickIT_CellularSolu();
    }

    @And("User click on Retail Solutions")
    public void clickOnRetailSolutions() {
        pageObjectManager.getSolutions().clickRetailSolu();
    }

    @And("User click on Financial Solutions")
    public void clickOnFinancialSolutions() {
        pageObjectManager.getSolutions().clickFinancialSolu();
    }

    @And("User click on Beauty and Cosmetic Solutions")
    public void clickOnBeautyAndCosmeticSolutions() {
        pageObjectManager.getSolutions().clickBeautyCosmeticsSolu();
    }

    @And("User click on Business to Consumer")
    public void clickOnBusinessToConsumer() {
        pageObjectManager.getSolutions().clickBusinessToConsumer();
    }

    @And("User click on Supply Chain")
    public void clickOnSupplyChain() {
        pageObjectManager.getSolutions().clickSupplyChain();
    }


    @When("User click on link-Click here to download")
    public void userClickOnLinkClickHereToDownload() throws InterruptedException {
        //pageObjectManager.getSolutions().clickFileLinkB2C();
        pageObjectManager.getSolutions().clickLinkClickHere();
        Thread.sleep(5000);
    }

    @Then("Hand-to-Hand BToC document should open in next tab")
    public void handToHandBCDocumentShouldOpenInNextTab() throws InterruptedException {
        waitForLoad(driver);
        String parentWindow = pageObjectManager.getHomepage().switchToChildWindow();
        Assert.assertTrue(pageObjectManager.getSolutions().isOpenedFileB2C());
        driver.close();
        driver.switchTo().window(parentWindow);

    }

    @When("User click on link-Contact Me")
    public void userClickOnLinkContactMe() throws InterruptedException {
        pageObjectManager.getSolutions().clickFormLinkContactMe();
        Thread.sleep(3000);
    }

    @Then("Contact Me form should open")
    public void contactMeFormShouldOpen() {
        Assert.assertTrue(pageObjectManager.getSolutions().isOpenedFormContactMe());
    }

    @And("Contact Me form closed")
    public void contactMeFormClosed() {
        pageObjectManager.getSolutions().clickBtnCloseFormContactMe();
    }

    @Then("Hand-to-Hand Pharmaceuticals document should open in next tab")
    public void handToHandPharmaceuticalsDocumentShouldOpenInNextTab() throws InterruptedException {
        waitForLoad(driver);
        String parentWindow = pageObjectManager.getHomepage().switchToChildWindow();
       // Thread.sleep(3000);
        Assert.assertTrue(pageObjectManager.getSolutions().isOpenedFilePharma());
        driver.close();
        driver.switchTo().window(parentWindow);
    }

    @Then("Hand-to-Hand Retail document should open in next tab")
    public void handToHandRetailDocumentShouldOpenInNextTab() throws InterruptedException {
        waitForLoad(driver);
        String parentWindow = pageObjectManager.getHomepage().switchToChildWindow();
        //Thread.sleep(3000);
        Assert.assertTrue(pageObjectManager.getSolutions().isOpenedFileRetail());
        driver.close();
        driver.switchTo().window(parentWindow);
    }

    @Then("Hand-to-Hand Banking document should open in next tab")
    public void handToHandBankingDocumentShouldOpenInNextTab() throws InterruptedException {
        waitForLoad(driver);
        String parentWindow = pageObjectManager.getHomepage().switchToChildWindow();
        //Thread.sleep(3000);
        Assert.assertTrue(pageObjectManager.getSolutions().isOpenedFileFinance());
        driver.close();
        driver.switchTo().window(parentWindow);
    }
}
