package pages;

import commonModule.TabletoDict;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class HomePage extends BaseClass {
    public HomePage(WebDriver driver) {
        super(driver);
        // new WebDriverWait(getDriver(), 30).until(ExpectedConditions.titleContains("RAM - Home"));
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @FindBy(xpath = "//li[@id='liHome']//a[normalize-space()='Home']")
    WebElement menuHome;
    @FindBy(xpath = "//div[@class='header-logo']/a")
    WebElement ramHeaderLogo;
    @FindBy(xpath = "//div[@class='main-nav']//a[normalize-space()='Services']")
    WebElement menuServices;
    @FindBy(xpath = "//div[@class='main-nav']//a[normalize-space()='Solutions']")
    WebElement menuSolutions;
    @FindBy(xpath = "//div[@class='main-nav']//a[normalize-space()='Send a Parcel']")
    WebElement menuSendAParcel;
    @FindBy(xpath = "//div[@class='main-nav']//a[normalize-space()='Track your Parcel']")
    WebElement menuTrackYourParcel;
    @FindBy(xpath = "//a[@href='/Contact/CustomerService'][normalize-space()='Contact us']")
    WebElement menuContactUs;
    @FindBy(id = "Takealotlogin-btn")
    WebElement menuTakeALot;
    @FindBy(id="TakealotLink")
    WebElement linkTakeALot;
   @FindBy(xpath = "//a[@class='wbtn'][normalize-space()='Business Portal']")
    WebElement linkBusinessPortal;
    @FindBy(id = "login-btn")
    WebElement linkLogin;
   // @FindBy(xpath = "//a[@class='wbtn'][normalize-space()='Register']")
    @FindBy(css="li#reg-link a")
    List<WebElement> linkRegister;

    //Locating Different Icons present at home page
    @FindBy(id = "send-parcel")
    WebElement qToolSendAParcel;
    @FindBy(id = "waybill")
    WebElement txtWaybillNumber;
    @FindBy(id = "qtrack-submit")
    WebElement btnFindParcel;
    @FindBy(xpath = "//div[@class='qtool contact']//div[@class='title']")
    WebElement qToolContactUs;

    //Locating image Icons present at home page
    @FindBy(xpath = "//div[@class='solution-icon']//img[@data-original-title='Pharmaceutical']")
    WebElement iconPharma;
    @FindBy(xpath = "//div[@class='solution-icon']//img[@data-original-title='IT and Cellular']")
    WebElement iconITC;
    @FindBy(xpath = "//div[@class='solution-icon']//img[@data-original-title='Beauty and Cosmetics']")
    WebElement iconBAC;
    @FindBy(xpath = "//div[@class='solution-icon']//img[@data-original-title='Financial']")
    WebElement iconFinaance;
    @FindBy(xpath = "//div[@class='solution-icon']//img[@data-original-title='Retail']")
    WebElement iconRetail;
    @FindBy(xpath = "//div[@class='solution-icon']//img[@data-original-title='Explore seamless Supply Chain Solutions']")
    WebElement iconSupplyChain;


    @FindBy(tagName = "a")
    List<WebElement> pageLinks;
    @FindBy(id = "quick-login-form")
    WebElement loginForm;

    //Page title variable
    String homePage = "RAM - Home Page";
    String servicePage = "RAM - Local Services";
    String solutionPage = "RAM - Pharmaceutical: Hand-to-Hand Healthcare";
    String sendAParcelPage = "RAM - Start Your Order";
    String trackYourParcelPage = "RAM - Tracking Results";
    String contactUsPage = "RAM - Customer Service";
    String takeALotPage = "";
    String businessPortalPage = "RAM Customer Portal Home";
    //String aboutusPage = historyPage;

    public List<WebElement> getPageLinks() {
        return pageLinks;
    }

    public void clickHomeMenu() {
        if (menuHome.isDisplayed())
            menuHome.click();
        else
            ramHeaderLogo.click();
    }

    public void clickServicesMenu() {
        menuServices.click();
    }

    public void clickSolutionsMenu() {
        menuSolutions.click();
    }

    public void clickSendAParcelMenu() {
        menuSendAParcel.click();
    }

    public void clickTrackYourParcelMenu() {
        menuTrackYourParcel.click();
    }

    public void clickContactUsMenu() {
        menuContactUs.click();
    }

    public void clickTakeALotMenu() {
        //getWaitElementClickable(menuTakeALot);
        menuTakeALot.click();
    }

    public void clickLinkTakeALot() {
        getWait(10).until(ExpectedConditions.visibilityOfAllElements(linkTakeALot));
        linkTakeALot.click();
    }

    public void clickBusinessPortalLink() {
        getWaitElementClickable(linkBusinessPortal);
        linkBusinessPortal.click();
        //  JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        // jse.executeScript("arguments[0].click()", linkBusinessPortal);
    }

    public void clickLoginLink() {
        getWaitElementClickable(linkLogin);
        linkLogin.click();
        // JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        //jse.executeScript("arguments[0].click()", linkLogin);
    }

    public void clickRegisterLink() {
        getWaitElementClickable(linkRegister.get(0));
        linkRegister.get(0).click();
        //new WebDriverWait(getDriver(),30).until(ExpectedConditions.elementToBeClickable(linkRegister)).click();
        //  JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        // jse.executeScript("arguments[0].click()", linkRegister);
    }

    public boolean isUserLoggedIn() {
        return (linkRegister.size() == 0);
    }


    public boolean isDisplayedLoginForm() {
        return loginForm.isDisplayed();
    }


    public boolean isDisplayedHomePage() {
        return (verifyPageTitle(homePage));
    }

    public boolean isDisplayedServicePage() {
        return (verifyPageTitle(servicePage));
    }

    public boolean isDisplayedSolutionsPage() {
        return (verifyPageTitle(solutionPage));
    }

    public boolean isDisplayedSendAParcelPage() {
        return (verifyPageTitle(sendAParcelPage));
    }

    public boolean isDisplayedTrackYourParcelPage() {
        return (verifyPageTitle(trackYourParcelPage));
    }

    public boolean isDisplayedContactUsPage() {
        return (verifyPageTitle(contactUsPage));
    }

    public boolean isDisplayedBusinessPortalPage() {
        return (verifyPageTitle(businessPortalPage));
    }

    public String getTxtLoginLink() {
        return new String(linkLogin.getText());
    }

    public void clickQtoolSendAParcel() {
        qToolSendAParcel.click();
    }

    public void clickQtoolContactUs() {
        qToolContactUs.click();
    }

    public void setTxtWaybillN(String waybill) {
        txtWaybillNumber.sendKeys(waybill);
    }

    public void clickBtnFindParcel() {
        btnFindParcel.click();
    }

    public void clickSIconPharma() {
        iconPharma.click();
    }

    public void clickSIconITC() {
        iconITC.click();
    }

    public void clickSIBAC() {
        iconBAC.click();
    }

    public void clickSIFinance() {
        iconFinaance.click();
    }

    public void clickSIRetail() {
        iconRetail.click();
    }

    public void clickSISupplyChain() {
        iconSupplyChain.click();
    }
    public boolean compareAlertMsg(String msg){
        return getAlertText().equalsIgnoreCase(msg);
    }

 /*
    }
*/
}
