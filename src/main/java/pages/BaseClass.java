package pages;

import io.cucumber.datatable.DataTable;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Dictionary;
import java.util.Iterator;
import java.util.Set;


public class BaseClass {
    @Getter(AccessLevel.PROTECTED)
    private WebDriver driver;

    public WebDriverWait getWait(int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait;
    }

    public BaseClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected String getAttributeVal(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

    protected boolean verifyPageTitle(String pageTitle) {
        getWait(20).until(ExpectedConditions.titleContains(pageTitle));
        return (getPageTitle().equals(pageTitle));
    }

    protected void setText(WebElement element, String value) {
        //scrollToElement(element);
        element.clear();
        element.sendKeys(value);
    }

    protected void clickElement(WebElement element) {
        element.click();
    }

    protected String getPageTitle() {
        return (driver.getTitle());
    }

    protected String getAlertText() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }

    public String acceptAlert() throws InterruptedException {
        new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
        Alert a = driver.switchTo().alert();
        String alertText=a.getText();
        a.accept();
        Thread.sleep(10000);
        return alertText;
    }
    public boolean isMandatoryField(WebElement element){
        boolean required = Boolean.parseBoolean(element.getAttribute("required"));
        return required;
    }
public boolean verifyisChxBoxSelected(WebElement element){
        return element.isSelected();
}
    public WebElement getWaitElementClickable(WebElement element) {
        return new WebDriverWait(getDriver(), 30).until(ExpectedConditions.elementToBeClickable(element));
    }


    public String switchToChildWindow() {
        //Get handles of the windows
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(driver -> !driver.getWindowHandles().equals(allWindowHandles));
        Iterator<String> iterator = allWindowHandles.iterator();

        // Here we will check if child window has other child windows and will fetch the heading of the child window
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                break;
            }
        }
        return mainWindowHandle;

    }

    //<editor-fold desc="Check search/find element is in viewport @google guru">
    private boolean isVisibleInViewport(WebElement element) {
        return (Boolean) ((JavascriptExecutor) getDriver()).executeScript(
                "var elem = arguments[0],                 " +
                        "  box = elem.getBoundingClientRect(),    " +
                        "  cx = box.left + box.width / 2,         " +
                        "  cy = box.top + box.height / 2,         " +
                        "  e = document.elementFromPoint(cx, cy); " +
                        "for (; e; e = e.parentElement) {         " +
                        "  if (e === elem)                        " +
                        "    return true;                         " +
                        "}                                        " +
                        "return false;                            "
                , element);
    }

    protected Month getCurrentMonth(){
        LocalDate currentdate = LocalDate.now();
        //Getting the current month
        Month currentMonth = currentdate.getMonth();
        return currentMonth;
    }
    protected int getCurrentYear(){
        LocalDate currentdate = LocalDate.now();
        //Getting the current month
        int currentYear = currentdate.getYear();
        return currentYear;
    }
    //</editor-fold>
//<editor-fold desc="Scroll page to element if not not is viewport">
    protected void scrollToElement(WebElement webElement) {
        if (!isVisibleInViewport(webElement)) {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", webElement);
        }
    }
//</editor-fold>
    protected void selectByVisibleText(WebElement webelement,String visibleTxt){
        scrollToElement(webelement);
        Select select=new Select(webelement);
        select.selectByVisibleText(visibleTxt);
    }
    protected void selectByIndex(WebElement webelement, int index){
        Select select=new Select(webelement);
        select.selectByIndex(index);
    }
    public void leftClick(){
        Actions action=new Actions(getDriver());
        action.click();
    }

}

