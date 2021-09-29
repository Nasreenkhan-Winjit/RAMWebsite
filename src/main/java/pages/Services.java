package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.time.Month;

public class Services extends BaseClass {

    public Services(WebDriver driver) {
        super(driver);
    }

    //locating side bar menu item
    @FindBy(partialLinkText = "Local Ser")
    WebElement localServices;
    @FindBy(partialLinkText = "Special Ser")
    WebElement specialServices;
    @FindBy(partialLinkText = "Distribution Ser")
    WebElement distributionServices;
    @FindBy(partialLinkText = "International Ser")
    WebElement internationalServices;
    @FindBy(partialLinkText = "Warehousing Ser")
    WebElement warehousingServices;
    @FindBy(partialLinkText = "Fuel Sur")
    WebElement fuelSurcharge;
@FindBy(partialLinkText = "Firearm Transport") WebElement linkfirearmTransport;
@FindBy(linkText = "RAM’s Standard Terms and Conditions") WebElement linkStdTermsConditions;
@FindBy(css="tbody tr td:nth-child(1) p:nth-child(1)")WebElement dateFuelSurcharge;
    //page title variables
    String localServicesPage = "RAM - Local Services";
    String specialServicesPage = "RAM - Special Services";
    String distributionServicesPage = "RAM - Distribution Services";
    String internationalServicesPage = "RAM - International Services";
    String warehousingServicesPage = "RAM - Warehousing Services";
    String fuelSurchargePage = "RAM - Fuel Surcharge";

    public boolean isDisplayedLocalServicesPage() {
        return verifyPageTitle(localServicesPage);
    }

    public boolean isDisplayedSpecialServicesPage() {
        return verifyPageTitle(specialServicesPage);
    }

    public boolean isDisplayedDistributionServicesPage() {
        return verifyPageTitle(distributionServicesPage);
    }

    public boolean isDisplayedInternationalServicesPage() {
        return verifyPageTitle(internationalServicesPage);
    }

    public boolean isDisplayedWarehousingServicesPage() {
        return verifyPageTitle(warehousingServicesPage);
    }

    public boolean isDisplayedFuelSurchargePage() {
        return verifyPageTitle(fuelSurchargePage);
    }

    public void clickLocalServices(){
        localServices.click();
    }
    public void clickSpecialServices(){
        specialServices.click();
    }
    public void clickDistributionServices(){
        distributionServices.click();
    }
    public void clickInternationalServices(){
        internationalServices.click();
    }
    public void clickWarehousingServices(){
        warehousingServices.click();
    }
    public void clickFuelSurcharge(){
        fuelSurcharge.click();
    }

    public void clickLinkFirearmTransport(){
        linkfirearmTransport.click();
    }

    public void clickLinkStdTermsCondition(){
        linkStdTermsConditions.click();
    }
    public boolean isFuelSurchargeRateOfCurrentMonthYear(){
        //System.out.println("current MOnth: "+getCurrentMonth().toString());
        String currentMonthYear= getCurrentMonth().toString()+" "+getCurrentYear();
     return dateFuelSurcharge.getText().toLowerCase().contains(currentMonthYear.toLowerCase());
    }
}
