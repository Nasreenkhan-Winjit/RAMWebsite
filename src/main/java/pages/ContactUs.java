package pages;

import commonModule.TabletoDict;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

public class ContactUs extends BaseClass{
    public ContactUs(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="SuppliedName")
    WebElement name;
    @FindBy(id="SuppliedPhone")WebElement phone;
    @FindBy(id="SuppliedEmail")WebElement email;
    @FindBy(id="Subject")WebElement trackingnumber;
    @FindBy(id="Type")WebElement selectCaseType;
    @FindBy(id="Description")WebElement desc;
    @FindBy(id="sendcase")WebElement btnSend;

    //Side-bar link
    @FindBy(xpath="//div[@class='page-sidebar']//a[contains(text(),'Track Your')]")WebElement linkCustomerService;
    @FindBy(xpath="//div[@class='page-sidebar']//a[contains(text(),'Track Your')]")WebElement linkTrackYourParcel;
    @FindBy(xpath="//div[@class='page-sidebar']//a[contains(text(),'Sale')]")WebElement linkSales;
    @FindBy(xpath="//div[@class='page-sidebar']//a[contains(text(),'Career')]")WebElement linkCareers;

    //Track Your Parcel
    @FindBy(css="div.ram-input-btn span.ram-input input#waybill")WebElement txtWaybillnumber;
    @FindBy(css="div.ram-input-btn  button[class='ram-btn green']")WebElement btnSubmitWaybill;
    @FindBy(css="div.col-sm-12 h2.red-head")WebElement waybill_Noresult;
    @FindBy(css="div.col-sm-12 tbody td#waybill-no")WebElement tdWaybillNumber;

    public void clickCustomerServices(){
        linkCustomerService.click();
    }
    public void clickTrackYourParcel(){
        linkTrackYourParcel.click();
    }
    public void clickSales(){
        linkSales.click();
    }
    public void clickCareers(){
        linkCareers.click();
    }

    public void fillContactDetailsForm(List<List<String>> table){
        Map<String, String> contactDet = TabletoDict.TableDictionaryConverter(table);
        setText(name,contactDet.get("name"));
        setText(phone,contactDet.get("contact_number"));
        setText(email,contactDet.get("email"));
        setText(trackingnumber,contactDet.get("tracking_number"));
        selectByVisibleText(selectCaseType,contactDet.get("case_type"));
        setText(desc,contactDet.get("details"));
    }

    public void clickBtnSend(){
    btnSend.click();
    }
    public void setWaybillNumber(String number){
        setText(txtWaybillnumber,number);
    }
    public void clickBtnSubmitWaybill(){
        btnSubmitWaybill.click();
    }
    public boolean isDispalyedNoResult(String msg){
        return waybill_Noresult.getText().equalsIgnoreCase(msg);
    }
    public boolean isDisplayedWaybillDetails(String waybill){
        return tdWaybillNumber.getText().equalsIgnoreCase(waybill);

    }
}
