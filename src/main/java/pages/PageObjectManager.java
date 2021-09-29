package pages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private final WebDriver driver;
    private DashBoard dashboard;
    private HomePage homepage;
    private Login loginPage;
    private UserRegistration userRegistration;
    private Solutions solutions;
    private Services services;
    private FAQ faq;
    private Footer footer;
    private PassRecovery passRecovery;
    private SendAParcel sendAParcel;
    private TakeALot takeALot;
    private ContactUs contactUs;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public DashBoard getDashboard() {
        return (dashboard == null) ? dashboard = new DashBoard(driver) : dashboard;
    }

    public HomePage getHomepage() {
        return (homepage == null) ? homepage = new HomePage(driver) : homepage;
    }

    public Login getLoginPage() {
        return (loginPage == null) ? loginPage = new Login(driver) : loginPage;
    }

    public UserRegistration getUserRegistration() {
        return (userRegistration == null) ? userRegistration = new UserRegistration(driver) : userRegistration;
    }

    public Solutions getSolutions() {
        return (solutions == null) ? solutions = new Solutions(driver) : solutions;
    }

    public Services getServices() {
        return (services == null) ? services = new Services(driver) : services;
    }

    public FAQ getFAQ() {
        return (faq == null) ? faq = new FAQ(driver) : faq;
    }
    public Footer getFooter() {
        return (footer == null) ? footer = new Footer(driver) : footer;
    }
    public PassRecovery getPassRecovery() {
        return (passRecovery == null) ? passRecovery = new PassRecovery(driver) : passRecovery;
    }
    public SendAParcel getSendAParcel() {
        return (sendAParcel == null) ? sendAParcel = new SendAParcel(driver) : sendAParcel;
    }
    public TakeALot getTakeALot() {
        return (takeALot == null) ? takeALot = new TakeALot(driver) :takeALot;
    }
    public ContactUs getContactUs() {
        return (contactUs == null) ? contactUs = new ContactUs(driver) :contactUs;
    }
}
