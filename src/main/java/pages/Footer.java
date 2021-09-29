package pages;

import org.jsoup.Connection;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Footer extends BaseClass {
    public Footer(WebDriver driver) {
        super(driver);
    }

    //Locating Footer-Menu link
    // @FindBy(xpath = "//a[@href='/About']/parent::li")
    @FindBy(linkText = "About Us")
    WebElement linkAboutUs;
    @FindBy(css = "a[href='/About/NoSubcontracting']")
    WebElement linkNoSubContract;
    @FindBy(css = "a[href='/About/History']")
    WebElement linkHistory;
    @FindBy(css = "a[href='/About/Careers']")
    WebElement linkCareers;
    @FindBy(css = "a[href='/Services/Local']")
    WebElement linkLocalServices;
    @FindBy(partialLinkText = "Special Courier")
    WebElement linkSpecialServices;
    @FindBy(partialLinkText = "Distribution Ser")
    WebElement linkDistributionServices;
    @FindBy(partialLinkText = "International Ser")
    WebElement linkInternationalServices;
    @FindBy(partialLinkText = "Warehousing Ser")
    WebElement linkWarehousingServices;
    @FindBy(partialLinkText = "Sales")
    WebElement linkSales;
    @FindBy(xpath = "//ul[@class='footer-menu']//a[normalize-space()='Contact Us']")
    WebElement linkContactUs;
    @FindBy(partialLinkText = "Payment")
    WebElement linkPaymentOptions;
    @FindBy(partialLinkText = "Fuel Sur")
    WebElement linkFuelSurcharge;
    @FindBy(partialLinkText = "FAQ")
    WebElement linkFAQs;
    @FindBy(partialLinkText = "Coronavirus ESP Cer")
    WebElement linkCoronaESPCert;
    @FindBy(partialLinkText = "RAM's Standard Terms")
    WebElement linkRamTerms;
    @FindBy(partialLinkText = "RAM IT Platform Terms")
    WebElement linkRamITTerms;
    @FindBy(partialLinkText = "Legal Doc")
    WebElement linkLegalDocs;
    //Legal document page container div
    @FindBy(css = "div.page-content a")
    List<WebElement> pageLegalDocuments;
    //page titles
    String historyPage = "RAM - History";
    String noSubContract = "RAM - No Subcontracting";
    String careersPage = "RAM - Careers";
    String salesPage = "RAM - Sales";
    String legalDoc = "RAM - Legal Documents";

    String coronaCertURL = "https://www.ram.co.za/files/announcement/2020-03-16%20Newsflash%20-%20Coronavirus.pdf";
    String ramStdTermsURL = "https://www.ram.co.za/files/Standard_Terms_And_Conditions.pdf";
    String ramITPlatformTermsURL = "https://www.ram.co.za/files/RAM_IT_Platform_Ts_and_Cs.pdf";

    public void clickLinkAboutUs() throws InterruptedException {
        scrollToElement(linkAboutUs);
        Thread.sleep(3000);
        linkAboutUs.click();
    }

    public void clickLinkNoSubContract() throws InterruptedException {
        scrollToElement(linkNoSubContract);
        Thread.sleep(3000);
        linkNoSubContract.click();
    }

    public void clickLinkHistory() throws InterruptedException {
        scrollToElement(linkHistory);
        Thread.sleep(3000);
        linkHistory.click();
    }

    public void clickLinkCareers() throws InterruptedException {
        scrollToElement(linkCareers);
        Thread.sleep(3000);
        linkCareers.click();
    }

    public void clickLinkLocalServices() throws InterruptedException {
        scrollToElement(linkLocalServices);
        Thread.sleep(3000);
        linkLocalServices.click();
    }

    public void clickLinkSpecialServices() throws InterruptedException {
        scrollToElement(linkSpecialServices);
        Thread.sleep(3000);
        linkSpecialServices.click();
    }

    public void clickLinkDistributionServices() throws InterruptedException {
        scrollToElement(linkDistributionServices);
        Thread.sleep(3000);
        linkDistributionServices.click();
    }

    public void clickLinkInternationalServices() throws InterruptedException {
        scrollToElement(linkInternationalServices);
        Thread.sleep(3000);
        linkInternationalServices.click();
    }

    public void clickLinkWarehousingServices() throws InterruptedException {
        scrollToElement(linkWarehousingServices);
        Thread.sleep(3000);
        linkWarehousingServices.click();
    }

    public void clickLinkContactUs() throws InterruptedException {
        scrollToElement(linkContactUs);
        Thread.sleep(3000);
        linkContactUs.click();
    }

    public void clickLinkSales() throws InterruptedException {
        scrollToElement(linkSales);
        Thread.sleep(3000);
        linkSales.click();
    }

    public void clickLinkPaymentOptions() throws InterruptedException {
        scrollToElement(linkPaymentOptions);
        Thread.sleep(3000);
        linkPaymentOptions.click();
    }

    public void clickLinkFuelSurcharge() throws InterruptedException {
        scrollToElement(linkFuelSurcharge);
        Thread.sleep(3000);
        linkFuelSurcharge.click();
    }

    public void clickLinkFAQs() throws InterruptedException {
        scrollToElement(linkFAQs);
        Thread.sleep(3000);
        linkFAQs.click();
    }

    public void clickLinkCoronaESPCertificate() throws InterruptedException {
        scrollToElement(linkCoronaESPCert);
        Thread.sleep(3000);
        linkCoronaESPCert.click();
    }

    public void clickLinkRamStdTerms() throws InterruptedException {
        scrollToElement(linkRamTerms);
        Thread.sleep(3000);
        linkRamTerms.click();
    }

    public void clickLinkRamITTerms() throws InterruptedException {
        scrollToElement(linkRamITTerms);
        Thread.sleep(3000);
        linkRamITTerms.click();
    }

    public void clickLinkLegalDocs() throws InterruptedException {
        scrollToElement(linkLegalDocs);
        Thread.sleep(3000);
        linkLegalDocs.click();
    }

    public boolean isDisplayedHistoryPage() {

        return verifyPageTitle(historyPage);
    }

    public boolean isDisplayedNoSubContractPage() {
        return verifyPageTitle(noSubContract);
    }

    public boolean isDisplayedCareersPage() {
        return verifyPageTitle(careersPage);
    }

    public boolean isDisplayedSalesPage() {
        return verifyPageTitle(salesPage);
    }

    public boolean isOpenedCoronaCertificate() {
        return getDriver().getCurrentUrl().equalsIgnoreCase(coronaCertURL);
    }

    public boolean isOPenedRamStdTermsDoc() {
        return getDriver().getCurrentUrl().equalsIgnoreCase(ramStdTermsURL);
    }

    public boolean isOPenedITPlatTermsDoc() {
        return getDriver().getCurrentUrl().equalsIgnoreCase(ramITPlatformTermsURL);
    }

    public boolean isDisplayedLegalDocsPage() {
        return verifyPageTitle(legalDoc);
    }

    public int verifyLegalDocLinks() throws InterruptedException {
        WebElement docLink;
        String url = "";
        String parent;
        String linkfirstword;
        String linkName="";
        int count=0;

        System.out.println("Total number of links under legal document page are " + pageLegalDocuments.size());
        Iterator<WebElement> iterator = pageLegalDocuments.iterator();
        while (iterator.hasNext()) {
            docLink = iterator.next();
            url = docLink.getAttribute("href");
            ArrayList<String>  tabs2 = new ArrayList<String>(5);
            if (url == null || url.isEmpty()) {
                count++;
                System.out.println("URL is not configured or it is empty for link : " + docLink.getText());
                continue;
            }
            linkName=docLink.getText();
            docLink.click();
           // public static void switchTabs(WebDriver driver, int expectedWindowsCount,int SwitchtoWindow) throws Exception {
            try{
                (new WebDriverWait(getDriver(), 30)).until(ExpectedConditions.numberOfWindowsToBe(2));
                tabs2 = new ArrayList<String>(getDriver().getWindowHandles());
                getDriver().switchTo().window(tabs2.get(1));
                Thread.sleep(15000);
          }catch (Exception e){
                count++;
            }
           //parent = switchToChildWindow();
                        // if(getDriver().getCurrentUrl().toLowerCase().contains(docLink.getText().toLowerCase()){
            //getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            Thread.sleep(15000);
            System.out.println("Click on link : "+linkName);
            getDriver().close();

           // getDriver().switchTo().window(parent);
            getDriver().switchTo().window(tabs2.get(0));
            Thread.sleep(5000);
        }
return count;

    }
}




