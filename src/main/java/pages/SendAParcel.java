package pages;

import com.google.gson.internal.bind.util.ISO8601Utils;
import commonModule.TabletoDict;
import io.cucumber.java.et.Ja;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class SendAParcel extends BaseClass {
    public SendAParcel(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div.step-title")
    List<WebElement> stepTitle;
    @FindBy(css = "div.step-no")
    List<WebElement> stepNo;
    @FindBy(css = "a[class='step current'] div[class='step-no']")
    WebElement currentStepNo;
    @FindBy(css = "a[class='step current'] div[class='step-title']")
    WebElement currentStepTitle;
    @FindBy(css = "a[class='step done'] div[class='step-no']")
    List<WebElement> doneStepNo;
    @FindBy(css = "a[class='step done'] div[class='step-title']")
    List<WebElement> doneStepTitle;
    //Start your order page
    @FindBy(id = "domestic-parcel")
    WebElement labelDomesticParcel;
    @FindBy(id = "international-parcel")
    WebElement labelInternationalParcel;

    @FindBy(id = "parcel-type-options")
    WebElement divParcelType;
    @FindBy(id = "parcel-parcel")
    WebElement radioInputParcel;
    @FindBy(id = "parcel-document")
    WebElement radioInputDocument;
    @FindBy(id = "parcel-firearm")
    WebElement radioInputFirearm;
    @FindBy(css = "div.radio-box")
    List<WebElement> radioParcelType;
    // @FindBy(id = "form-restrictedList")
    @FindBy(css = "div[class='col-sm-6']  div[class='form-input-box'] select[id='form-restrictedList']")
    WebElement selectParcelContent;
    @FindBy(id = "ui-id-1")
    WebElement frmAddressList;
    @FindBy(id = "ui-id-2")
    WebElement toAddressList;
    @FindBy(id = "form-fromAddress")
    WebElement txtFromAddress;
    @FindBy(id = "form-toAddress")
    WebElement txtToAddress;
    @FindBy(id = "form-toCountry")
    WebElement selectToCountry;//for international parcel
    @FindBy(id = "send-next")
    WebElement btnSendNext;
    @FindBy(id = "send-backBtn")
    WebElement btnSendBack;
    @FindBy(css = "div.toast-message")
    WebElement restrictedParcelContentToaster;

    //Parcel Dimensions Page
    @FindBy(id = "parcel-count")
    WebElement selectParcelCount;
    @FindBy(css = "div[class='slick-list draggable'] div[class='slick-track'] div")
    List<WebElement> parcels;
    @FindBy(css = "tbody tr:nth-child(1) input")
    List<WebElement> txtParcelWeight;
    @FindBy(css = "tbody tr:nth-child(2) input")
    List<WebElement> txtParcelLenght;
    @FindBy(css = "tbody tr:nth-child(3) input")
    List<WebElement> txtParcelWidth;
    @FindBy(css = "tbody tr:nth-child(4) input")
    List<WebElement> txtParcelHeight;
    @FindBy(css = "img[src='images/slider-left.png']")
    WebElement prevSlider;
    @FindBy(css = "img[src='images/slider-right.png']")
    WebElement nextSlider;

    //Select Your service page
    @FindBy(id = "cheap-btn")
    WebElement btnShowAllOptions;
    @FindBy(id = "cheap-btn2")
    WebElement linkShowAllOptions;
    @FindBy(css = "table.service-table tbody tr:nth-child(7) td button")
    List<WebElement> btnSelectOptions;
    @FindBy(css = "table.service-table tbody tr:nth-child(7) td button")
    WebElement btnSelectOption;
    @FindBy(css = "table.service-table tbody tr:nth-child(1) td h1")
    List<WebElement> serviceType;
    @FindBy(css = "div#confirm div.close-btn")
    WebElement btnClose;
    @FindBy(id = "confirm-change")
    WebElement btnChange;
    @FindBy(id = "confirm-confirm")
    WebElement btnConfirm;

    //Collection & delivery details-User Login
    @FindBy(css = "div[class='form-block'] div[class='row'] div:nth-child(1) input")
    WebElement txtLoginEmail;
    @FindBy(css = "div[class='form-block'] div[class='row'] div:nth-child(2) input")
    WebElement txtLoginPass;
    @FindBy(css = "form#login-form div.col-md-2 button.submit-btn ")
    WebElement btnLogin;
    @FindBy(css="div[class='col-sm-6 col-md-5'] a")
    WebElement linkForgotPass;

    //Collection & delivery details-Register user
    @FindBy(css = "span.use-address-btn")
    List<WebElement> btnUseAddress;

    //Collection and Delivery details
    @FindBy(name = "collection.firstname")
    WebElement collectionFirstName;
    @FindBy(name = "collection.surname")
    WebElement collectionSurName;
    @FindBy(name = "collection.cell")
    WebElement collectionMobile;
    @FindBy(name = "collection.email")
    WebElement collectionEmail;
    @FindBy(name = "collection.type")
    WebElement collectionType;
    @FindBy(id = "collection-address")
    WebElement collectionAddress;

    @FindBy(name = "delivery.firstname")
    WebElement deliveryFirstname;
    @FindBy(name = "delivery.surname")
    WebElement deliverySurname;
    @FindBy(name = "delivery.cell")
    WebElement deliveryMobile;
    @FindBy(name = "delivery.email")
    WebElement deliveryEmail;
    @FindBy(name = "delivery.type")
    WebElement deliveryType;
    @FindBy(id = "delivery-address")
    WebElement deliveryAddress;

    @FindBy(name = "invoice")
    WebElement fileInvoice;
    @FindBy(css = "button[class='submit-btn teal']")
    WebElement btnDomesSubmit;
    @FindBy(css = "button[class='submit-btn grey']")
    WebElement btnInterSubmit;
    //Send Confirm Page
    @FindBy(css = "span.ram-radio input[id='payment_type_card']")
    WebElement payByCard;
    @FindBy(css = "span.ram-radio input[id='payment_type_eft']")
    WebElement payWithIEFT;
    @FindBy(css = "div.terms_chbx span.ram-radio input[id='agree_cbx']")
    WebElement agreeBox;
    @FindBy(css = "div.form-block button[class='submit-btn teal']")
    WebElement btnConfirmAndPay;

    //Firearm details
    @FindBy(name = "OwnerId")
    WebElement txtFirearmId;
    @FindBy(name = "firearms[0].type")
    WebElement selectFirearmType;
    @FindBy(name = "firearms[0].make")
    WebElement txtFirearmMake;
    @FindBy(name = "firearms[0].serialNo")
    WebElement txtFirearmSN;
    @FindBy(name = "firearms[0].scope")
    WebElement selectFirearmTeleScope;
    @FindBy(name = "firearms[0].mags")
    WebElement txtFirearmMags;
    @FindBy(name = "firearms[0].other")
    WebElement txtFirearmOther;

    //Take a lot-different field locator
    @FindBy(id = "form-toAddress")
    WebElement selectTALDestination;
    @FindBy(id = "form-PONumber")
    WebElement txtTALPONumber;
    @FindBy(xpath = "//input[@class='ui-autocomplete-input error']")
    WebElement txtAddresserror;
    @FindBy(xpath = "//select[@class='error']")
    WebElement selecterror;

    String parcelDTypeErrorClass = "form-input-box radio-switch error";
    String parcelITypeErrorClass = "form-input-box radio-switch int error";
    String addressErrorClass = "ui-autocomplete-input error";
    String selectErrorClass = "error";
  //  String restrictedParcelContentToasterMsg = "Prohibited/Restricted category not allowed";
  String restrictedParcelContentToasterMsg = "Prohibited category not allowed";
    String parcelInputErrorClass = "parcel-input error";

    String sendRegisterPageUrl="https://www.ram.co.za/Send/Register";
    String sendAddressPageUrl = "https://www.ram.co.za/Send/Address";
        String sendConfirmPageUrl = "https://www.ram.co.za/Send/Confirm";
    String secureEFTPaymentPageUrl = "https://i-pay.co.za/payment/";

    String startOrderPage = "RAM - Start Your Order";
    String selectServicePage = "RAM - Select your Service";
    String collectionDeliveryDetailsPage = "RAM - Collection & Delivery Details";
    String confirm_paymentPage = "RAM - Confirm & Payment";
    String secureEFTPaymentPage = "Ozow Instant Secure EFT Payments";

    public boolean isFromAddressDisabled(){
        boolean disabled = Boolean.parseBoolean(txtFromAddress.getAttribute("disabled"));
        return disabled;
    }
    public boolean isToAddressDisabled(){
        boolean disabled = Boolean.parseBoolean(txtToAddress.getAttribute("disabled"));
        return disabled;
    }

    public void setParcelSendType(String parcelSendType) {
        if (parcelSendType.equalsIgnoreCase("Domestic"))
            labelDomesticParcel.click();
        else if (parcelSendType.equalsIgnoreCase("International"))
            labelInternationalParcel.click();
        else
            System.out.println("Invalid send a parcel type");
    }

    public void setParcelType(String parcelType) {
        if (parcelType.equalsIgnoreCase("Parcel")) {
            //getWait(30).until(ExpectedConditions.elementToBeClickable(radioInputParcel));
            // radioInputParcel.click();
            radioParcelType.get(0).click();
        } else if (parcelType.equalsIgnoreCase("Document"))
            radioParcelType.get(1).click();
            //radioInputDocument.click();
        else if (parcelType.equalsIgnoreCase("Firearm"))
            radioParcelType.get(2).click();
        // radioInputFirearm.click();
    }

    public void setParcelContent(String parcelContent) {
        // getWait(10).until(ExpectedConditions.elementToBeClickable(selectParcelContent));
        Select select = new Select(selectParcelContent);
        select.selectByVisibleText(parcelContent);
        // selectByVisibleText(selectParcelContent, parcelContent);
    }

    public void setFromAddress(String frmAddress) {
        setText(txtFromAddress, frmAddress);
        try {
            getWait(30).until(ExpectedConditions.visibilityOf(frmAddressList));
        } catch (Exception e) {

        }
        //Thread.sleep(2000);
        txtFromAddress.sendKeys(Keys.ENTER);
        // txtFromAddress.sendKeys(Keys.ENTER);
    }

    public void setToAddress(String toAddress) {
        setText(txtToAddress, toAddress);
        try {
            getWait(30).until(ExpectedConditions.visibilityOf(toAddressList));
        } catch (Exception e) {

        }
        //Thread.sleep(2000);
        txtToAddress.sendKeys(Keys.ENTER);
    }

    public void selectCountry(String country) {
        selectByVisibleText(selectToCountry, country.toUpperCase());
    }

    public void setParcelCount(String parcelCount) {
        selectByVisibleText(selectParcelCount, parcelCount);
    }

    public void setParcelWeight(int parcelNumber, String weight) {
        //System.out.println("Count Weight ele" + txtParcelWeight.size());
        setText(txtParcelWeight.get(parcelNumber - 1), weight);
    }

    public void setParcelLenght(int parcelNumber, String length) {
        setText(txtParcelLenght.get(parcelNumber - 1), length);
    }

    public void setParcelWidth(int parcelNumber, String width) {
        setText(txtParcelWidth.get(parcelNumber - 1), width);
    }

    public void setParcelHeight(int parcelNumber, String heigth) {
        setText(txtParcelHeight.get(parcelNumber - 1), heigth);
    }

    public void clickBtnBack() {
        clickElement(btnSendBack);
    }

    public void clickBtnNext() {
        getWait(10).until(ExpectedConditions.elementToBeClickable(btnSendNext));
        clickElement(btnSendNext);
    }

    public String getCurrentStepTitle() {
        return currentStepTitle.getText();
    }

    public boolean isStepDone(String steptitle) {
        for (WebElement stepTitle : doneStepTitle) {
            if (stepTitle.getText().equalsIgnoreCase(steptitle))
                return true;
        }
        return false;
    }

    public void clickStep(String step) {
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        for (WebElement stepNumber : stepNo) {
            if (stepNumber.getText().toLowerCase().contains(step))
                stepNumber.click();
            break;
        }

    }
    public void selectParcel(String parcelName) {
        for (WebElement parcel : parcels) {
            if (parcel.getText().equalsIgnoreCase(parcelName)) {
                parcel.click();
                break;
            }
        }
    }

    public void clickBtnShowAllOptions() {

        new WebDriverWait(getDriver(), 30).until(ExpectedConditions.visibilityOf(btnShowAllOptions));
        btnShowAllOptions.click();
    }

    public void clickLinkShowAllOptions() {
        new WebDriverWait(getDriver(), 30).until(ExpectedConditions.visibilityOf(linkShowAllOptions));
        linkShowAllOptions.click();
    }

    public int selectServiceType(String type) {
        int i;
        for (i = 0; i <= serviceType.size(); i++) {
            // System.out.println("service type"+serviceType.get(i).getText());
            if (serviceType.get(i).getText().equalsIgnoreCase(type)) {

                break;
            }
        }
        return i;
    }

    public boolean isStartYourOrderPage() {
        return verifyPageTitle(startOrderPage);
    }

    public void clickBtnSelect(int btnNo) {
        // scrollToElement(btnSelectOption.get(btnNo));
        // System.out.println("Button text "+btnSelectOptions.get(btnNo).getText());
        //System.out.println("service type"+serviceType.get(btnNo).getText());
        btnSelectOptions.get(btnNo).click();
    }

    public void selectServiceType() {
        //getWait(20).until(ExpectedConditions.visibilityOf(formTALQuote));
        //scrollToElement(btnTALSelectOption);
        btnSelectOption.click();
    }

    public void clickBtnConfirm() {
        btnConfirm.click();
    }

    public void clickBtnChange() {
        btnChange.click();
    }

    public void setSendLoginEmail(String email) {
        //getWait(20).until(ExpectedConditions.visibilityOfAllElements(txtLoginEmail));
        setText(txtLoginEmail, email);
    }

    public void setSendLoginPassword(String pass) {
        getWait(20).until(ExpectedConditions.visibilityOfAllElements(txtLoginPass));
        setText(txtLoginPass, pass);
    }
public void clickLinkForgotPassword(){
        linkForgotPass.click();
}
    public void clickBtnLogin() {
        btnLogin.click();
    }

    public void setCollectionFirstName(String address) {
        setText(collectionFirstName, address);
    }

    public void setCollectionSurName(String value) {
        setText(collectionSurName, value);
    }

    public void setCollectionMobile(String value) {
        setText(collectionMobile, value);
    }

    public void setCollectionEmail(String value) {
        setText(collectionEmail, value);
    }

    public void setCollectionType(String value) {
                selectByVisibleText(collectionType, value);
    }

    public void setCollectionAddress(String value) {
        setText(collectionAddress, value);
        getWait(30).until(ExpectedConditions.visibilityOf(frmAddressList));
        //Thread.sleep(2000);
        collectionAddress.sendKeys(Keys.ENTER);
    }

    public void setDeliveryFirstname(String address) {
        setText(deliveryFirstname, address);
    }

    public void setDeliverySurname(String value) {
        setText(deliverySurname, value);
    }

    public void setDeliveryMobile(String value) {
        setText(deliveryMobile, value);
    }

    public void setDeliveryEmail(String value) {
        setText(deliveryEmail, value);
    }

    public void setDeliveryType(String value) {
               selectByVisibleText(deliveryType, value);
    }

    public void setDeliveryAddress(String value)  {
        setText(deliveryAddress, value);
        getWait(30).until(ExpectedConditions.visibilityOf(toAddressList));
        //Thread.sleep(1500);
        deliveryAddress.sendKeys(Keys.ENTER);
        getWait(30).until(ExpectedConditions.invisibilityOf(toAddressList));
    }

    public void clickBtnDomesSubmit() {
        scrollToElement(btnDomesSubmit);
        btnDomesSubmit.click();
        //getWait(30).until(ExpectedConditions.textToBePresentInElementValue(btnDomesSubmit,"PLEASE WAIT"));
    }

    public void clickBtnInterSubmit() {
        scrollToElement(btnInterSubmit);
        btnInterSubmit.click();
        //getWait(30).until(ExpectedConditions.textToBePresentInElementValue(btnInterSubmit,"PLEASE WAIT"));
    }

    public boolean isSendAddressPage() {
        new WebDriverWait(getDriver(),30).until(ExpectedConditions.urlContains(sendAddressPageUrl));
        return getDriver().getCurrentUrl().equalsIgnoreCase(sendAddressPageUrl);
       // return verifyPageTitle(collectionDeliveryDetailsPage);
    }

    public boolean isSendRegisterPage() {
        return getDriver().getCurrentUrl().equalsIgnoreCase(sendRegisterPageUrl);
        // return verifyPageTitle(collectionDeliveryDetailsPage);
    }

    public boolean isSendConfirmPage() {
        //return getDriver().getCurrentUrl().equalsIgnoreCase(sendConfirmPageUrl);
        return verifyPageTitle(confirm_paymentPage);
    }

    public void selectPayByCard() {
        payByCard.click();
    }

    public void selectPayWithIEFT() {
        payWithIEFT.click();
    }

    public void clickAgreeBox() throws InterruptedException {
        scrollToElement(agreeBox);
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", agreeBox);
        //  agreeBox.click();
    }

    public void clickBtnConfirm_Pay() {
        scrollToElement(btnConfirmAndPay);
        btnConfirmAndPay.click();
    }

    public void selectPayType(String payType) {

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        // JavascriptExecutor js=(JavascriptExecutor)getDriver();
        //js.executeScript("arguments[0].scrollIntoView(true);", agreeBox);
      //  System.out.println("\n Pay Type= " + payWithIEFT.getText());
        if (payType.equalsIgnoreCase("Pay by Card")) {
            //getWait(10).until(ExpectedConditions.elementToBeClickable(payByCard));
            // payByCard.click();
            scrollToElement(payByCard);
            js.executeScript("arguments[0].click();", payByCard);
        } else if (payType.equalsIgnoreCase("Pay with instant EFT")) {
            //  scrollToElement(payWithIEFT);
            //  getWait(10).until(ExpectedConditions.elementToBeClickable(payWithIEFT));
            // payWithIEFT.click();
            scrollToElement(payWithIEFT);
            js.executeScript("arguments[0].click();", payWithIEFT);
        }
    }

    public boolean isSecureEFTPaymentPage() {
        //return getDriver().getCurrentUrl().contains(secureEFTPaymentPageUrl);
        return verifyPageTitle(secureEFTPaymentPage);
    }

    public void chooseInvoiceFile(String filePath) {
        fileInvoice.clear();
        fileInvoice.sendKeys(filePath);
    }

    public void setSelectTALDestination(String talDestination) {
        selectByVisibleText(selectTALDestination, talDestination);
    }

    public void setTALPONumber(String poNumber) {
        setText(txtTALPONumber, poNumber);
    }

    public void clickBtnUseAddress(String btnName) {
        for (WebElement btn : btnUseAddress) {
            if (btn.getText().equalsIgnoreCase(btnName)) {
                btn.click();
                break;
            }
        }
    }


    public void setFirearmOwnerId(String id) {
        setText(txtFirearmId, id);
    }

    public void setFirearmType(String type) {
        selectByVisibleText(selectFirearmType, type);
    }

    public void setFirearmMake(String make) {
        setText(txtFirearmMake, make);
    }

    public void setFirearmSN(String number) {
        setText(txtFirearmSN, number);
    }

    public void selectFirearmScope(String telescope) {
        selectByVisibleText(selectFirearmTeleScope, telescope);
    }

    public void setFirearmMags(String mags) {
        setText(txtFirearmMags, mags);
    }

    public void setFirearmOther(String other) {
        setText(txtFirearmOther, other);
    }

    public void clickBtnNextSlider() {
        nextSlider.click();
    }

    public void clickBtnPreSlider() {
        prevSlider.click();
    }
    public void fillDetailsStep1(List<List<String>> table) {
        Map<String, String> step1 = TabletoDict.TableDictionaryConverter(table);
        setParcelSendType(step1.get("parcelSendType"));
        setParcelType(step1.get("parcelType"));
        if (!step1.get("parcelContent").equals(""))
            setParcelContent(step1.get("parcelContent"));
        if (!step1.get("fromAddress").equals(""))
            setFromAddress(step1.get("fromAddress"));
        if (!step1.get("toAddress").equals(""))
            setToAddress(step1.get("toAddress"));

    }

    //Step-1 Error validation
    public boolean isPresentDParcelTypeErrorClass() {
        return divParcelType.getAttribute("class").equalsIgnoreCase(parcelDTypeErrorClass);
    }

    public boolean isPresentIParcelTypeErrorClass() {
        return divParcelType.getAttribute("class").equalsIgnoreCase(parcelITypeErrorClass);
    }

    public boolean isPresentSelectErrorClass() {
        return selectParcelContent.getAttribute("class").equalsIgnoreCase(selectErrorClass);
    }

    public boolean isPrsentFrmAddressErrorClass() {
        return txtFromAddress.getAttribute("class").equalsIgnoreCase(addressErrorClass);
    }

    public boolean isPresentToAddressErrorClass() {
        return txtToAddress.getAttribute("class").equalsIgnoreCase(addressErrorClass);
    }


    public boolean isDisplayRestrictedParcelContentToaster() {
        getWait(5).until(ExpectedConditions.visibilityOf(restrictedParcelContentToaster));
        return (restrictedParcelContentToaster.getText().equalsIgnoreCase(restrictedParcelContentToasterMsg));
    }


    //Step-2 error validation
    public boolean isPresentPWeightErrorClass(int parcelNumber) {
        return txtParcelWeight.get(parcelNumber-1).getAttribute("class").equalsIgnoreCase(parcelInputErrorClass);
    }
    public boolean isPresentPHeightErrorClass(int parcelNumber) {
        return txtParcelHeight.get(parcelNumber-1).getAttribute("class").equalsIgnoreCase(parcelInputErrorClass);
    }
    public boolean isPresentPLenghtErrorClass(int parcelNumber) {
        return txtParcelLenght.get(parcelNumber-1).getAttribute("class").equalsIgnoreCase(parcelInputErrorClass);
    }
    public boolean isPresentPWidthErrorClass(int parcelNumber) {
        return txtParcelWidth.get(parcelNumber-1).getAttribute("class").equalsIgnoreCase(parcelInputErrorClass);
    }

    public void clickBtnClose(){
        btnClose.click();
    }


    //Step-4 User registration error validation
    public boolean isEnabledTxtFirstName(){
        return collectionFirstName.isEnabled();
    }

}


