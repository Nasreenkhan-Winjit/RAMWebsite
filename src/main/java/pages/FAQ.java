package pages;

import org.openqa.selenium.WebDriver;

public class FAQ extends BaseClass{
    public FAQ(WebDriver driver) {
        super(driver);
    }

// Page title variables
    String paymentOptionPage="RAM - Payment Options";
    String servicesLogisticsPage="RAM - Services and Logistics";

    public boolean isDisplayedPaymentOptionPage(){
        return verifyPageTitle(paymentOptionPage);
    }

    public boolean isDisplayedServicesLogisticsPage(){
        return verifyPageTitle(servicesLogisticsPage);
    }
}
