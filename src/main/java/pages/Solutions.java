package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.lang.reflect.Parameter;

public class Solutions extends BaseClass {
    //constructor
    public Solutions(WebDriver driver) {
        super(driver);
    }

    //page side bar link elements
    @FindBy(partialLinkText = "Pharmaceutical Sol")
    WebElement pharmaSol;
    @FindBy(partialLinkText = "IT And Cellular Sol")
    WebElement iTandCellularSol;
    @FindBy(partialLinkText = "Retail Sol")
    WebElement retailSol;
    @FindBy(partialLinkText = "Financial Sol")
    WebElement financialSol;
    @FindBy(partialLinkText = "Beauty and Cosmetic")
    WebElement beautyCosmeticsSol;
    @FindBy(partialLinkText = "Business to Cons")
    WebElement businessToConsumer;
    @FindBy(partialLinkText = "Supply Chain")
    WebElement supplyChain;

    @FindBy(partialLinkText = "Click here to downlo")
    WebElement fileLinkB2C;
    @FindBy(partialLinkText = "Click here to downlo")
    WebElement linkClickHere;
    @FindBy(css = "a[id='btnContactUsModal'] b")
    WebElement formLinkContactMe;
    @FindBy(id = "ContactUs")
    WebElement formContactMe;
    @FindBy(css = "button[class='close']")
    WebElement btnCloseFormContactMe;

    // Page titles of RAM Solutions page
    String pagePharma = "RAM - Pharmaceutical: Hand-to-Hand Healthcare";
    String pageITC = "RAM - IT and Cellular: Hand-to-Hand Tech";
    String pageBAC = "RAM - Beauty and Cosmetics: Hand-to-Hand Beauty";
    String pageFinance = "RAM - Financial: Hand-to-Hand Finance";
    String pageRetail = "RAM - Retail: Hand-to-Hand Retail";
    String pageSupplyChain = "RAM - Supply Chain Solutions";
    String pageB2C = "RAM - Business to consumer";

    String fileB2CUrl = "https://www.ram.co.za/files/solutions/Hand-to-Hand%20B2C.pdf";
    String fileHandToHandPharmaUrl="https://www.ram.co.za/files/solutions/Hand-to-Hand%20Pharmaceuticals.pdf";
    String fileHandToHandRetailUrl="https://www.ram.co.za/files/solutions/Hand-to-Hand%20Retail.pdf";
    String fileHandToHandBankingUrl="https://www.ram.co.za/files/solutions/Hand-to-Hand%20Banking.pdf";


    private void clickByAction(WebElement element) {
        Actions action = new Actions(getDriver());
        action.moveToElement(element).pause(5).click().build().perform();
    }

    public boolean isDisplayedPharmaPage() {
        return getPageTitle().equalsIgnoreCase(pagePharma);

    }

    public boolean isDisplayedITCPage() {
        return getPageTitle().equalsIgnoreCase(pageITC);
    }

    public boolean isDisplayedBACPage() {
        return getPageTitle().equalsIgnoreCase(pageBAC);
    }

    public boolean isDisplayedFinancialPage() {
        return getPageTitle().equalsIgnoreCase(pageFinance);
    }

    public boolean isDisplayedRetailPage() {
        return getPageTitle().equalsIgnoreCase(pageRetail);
    }

    public boolean isDisplayedB2CPage() {
        return getPageTitle().equalsIgnoreCase(pageB2C);
    }

    public boolean isDisplayedSupplyChainPage() {
        return getPageTitle().equalsIgnoreCase(pageSupplyChain);
    }

    public void clickPharmaSolu() {
        getWait(3).until(ExpectedConditions.elementToBeClickable(pharmaSol));
        clickByAction(pharmaSol);
    }

    public void clickFileLinkB2C() {
        scrollToElement(fileLinkB2C);
        clickByAction(fileLinkB2C);
    }

    public void clickFormLinkContactMe() {
        scrollToElement(formLinkContactMe);
        clickByAction(formLinkContactMe);
    }

    public void clickIT_CellularSolu() {
        getWait(3).until(ExpectedConditions.elementToBeClickable(iTandCellularSol));
        clickByAction(iTandCellularSol);
    }

    public void clickRetailSolu() {
        getWait(3).until(ExpectedConditions.elementToBeClickable(retailSol));
        clickByAction(retailSol);
    }

    public void clickFinancialSolu() {
        getWait(3).until(ExpectedConditions.elementToBeClickable(financialSol));
        clickByAction(financialSol);
    }

    public void clickBeautyCosmeticsSolu() {
        getWait(3).until(ExpectedConditions.elementToBeClickable(beautyCosmeticsSol));
        clickByAction(beautyCosmeticsSol);
    }

    public void clickBusinessToConsumer() {
        getWait(3).until(ExpectedConditions.elementToBeClickable(businessToConsumer));
        clickByAction(businessToConsumer);
    }

    public void clickSupplyChain() {
        getWait(3).until(ExpectedConditions.elementToBeClickable(supplyChain));
        clickByAction(supplyChain);
    }

    public boolean isOpenedFileB2C() {
        return getDriver().getCurrentUrl().equalsIgnoreCase(fileB2CUrl);
    }

    public boolean isOpenedFormContactMe() {
        getWait(5).until(ExpectedConditions.visibilityOf(formContactMe));
        return formContactMe.isDisplayed();
    }

    public void clickBtnCloseFormContactMe() {
        getWait(5).until(ExpectedConditions.elementToBeClickable(btnCloseFormContactMe));
        btnCloseFormContactMe.click();
    }

    public void clickLinkClickHere() {
        scrollToElement(linkClickHere);
        linkClickHere.click();
    }
    public boolean isOpenedFileFinance() {
        return getDriver().getCurrentUrl().equalsIgnoreCase(fileHandToHandBankingUrl);
    }
    public boolean isOpenedFileRetail() {
        return getDriver().getCurrentUrl().equalsIgnoreCase(fileHandToHandRetailUrl);
    }
    public boolean isOpenedFilePharma() {
        return getDriver().getCurrentUrl().equalsIgnoreCase(fileHandToHandPharmaUrl);
    }
}
