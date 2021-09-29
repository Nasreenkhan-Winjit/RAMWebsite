package pages;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TakeALot extends BaseClass {
    public TakeALot(WebDriver driver) {
        super(driver);
    }

    Actions actions;
    @FindBy(css = "div.step-title")
    List<WebElement> tALstepTitle;
    @FindBy(css = "div.step-no")
    List<WebElement> tALstepNo;
    @FindBy(css = "a[class='step current'] div[class='step-no']")
    WebElement tALcurrentStepNo;
    @FindBy(css = "a[class='step current'] div[class='step-title']")
    WebElement tALcurrentStepTitle;
    @FindBy(css = "a[class='step done'] div[class='step-no']")
    List<WebElement> tALdoneStepNo;
    @FindBy(css = "a[class='step done'] div[class='step-title']")
    List<WebElement> tALdoneStepTitle;
    @FindBy(css = "div.frosted-block")
    WebElement divTALForm;
    //@FindBy(id = "quick-send-slider")
    @FindBy(id = "form-restrictedList")
    WebElement selectTALParcelContent;
    @FindBy(id = "form-fromAddress")
    WebElement txtTALFromAddress;
    @FindBy(id = "ui-id-1")
    WebElement frmTALAddressList;

    @FindBy(id = "form-toAddress")
    WebElement selectTALDestination;
    @FindBy(id = "form-PONumber")
    WebElement txtTALPONumber;

    @FindBy(id = "send-next")
    WebElement btnTALSendNext;
    @FindBy(id = "send-backBtn")
    WebElement btnTALSendBack;
    @FindBy(id = "parcel-count")
    WebElement selectTALParcelCount;
    @FindBy(css = "div[class='slick-list draggable'] div[class='slick-track'] div")
    List<WebElement> tALParcels;
    @FindBy(css = "tbody tr:nth-child(1) input")
    List<WebElement> txtTALParcelWeight;
    @FindBy(css = "tbody tr:nth-child(2) input")
    List<WebElement> txtTALParcelLenght;
    @FindBy(css = "tbody tr:nth-child(3) input")
    List<WebElement> txtTALParcelWidth;
    @FindBy(css = "tbody tr:nth-child(4) input")
    List<WebElement> txtTALParcelHeight;
    @FindBy(css = "img[src='images/slider-left.png']")
    WebElement tALPrevSlider;
    @FindBy(css = "img[src='images/slider-right.png']")
    WebElement tALNextSlider;

    @FindBy(id = "confirm")
    WebElement divTALConfirmModalWindow;
    @FindBy(css = "form[class='quote-form']")
    WebElement formTALQuote;
    @FindBy(css = "table.service-table tbody tr:nth-child(7) td button")
    WebElement btnTALSelectOption;
    @FindBy(id = "confirm-change")
    WebElement btnTALConfirmChange;
    @FindBy(css = "div#confirm div.close-btn")
    WebElement btnTALConfirmClose;

    //@FindBy(css = "div.tickforaddress")
    //@FindBy(id ="collection_cbx")
    @FindBy(css = "span.ram-radio input#collection_cbx")
    WebElement chkBoxCollection;
    @FindBy(name = "collection.firstname")
    WebElement tALCollectionFirstName;
    @FindBy(name = "collection.surname")
    WebElement tALCollectionSurName;
    @FindBy(name = "collection.cell")
    WebElement tALCollectionMobile;
    @FindBy(name = "collection.email")
    WebElement tALCollectionEmail;
    @FindBy(name = "collection.type")
    WebElement tALCollectionType;
    @FindBy(id = "collection-address")
    WebElement tALCollectionAddress;

    @FindBy(css = "a.ram-wire-btn.stick-bottom")
    WebElement linkTALEditAddress;
    @FindBy(id = "payment-type-error")
    WebElement divTALPaymentTypeError;
    @FindBy(css = "button[class='submit-btn teal']")
    WebElement btnTALConfirmProceed;

    @FindBy(id = "ondel_email_cbx")
    WebElement chkBoxOnDelEmail;
    @FindBy(id = "ondel_sms_cbx")
    WebElement chkBoxOnDelSms;
    @FindBy(id = "fulldel_email_cbx")
    WebElement chkBoxFullTrackEmail;
    @FindBy(id = "fulldel_sms_cbx")
    WebElement chkBoxFullTrackSms;


    @FindBy(id = "ondel_email")
    WebElement txtTALOnDelEmail;
    @FindBy(id = "ondel_sms")
    WebElement txtTALOnDelSms;
    @FindBy(id = "fulldel_email")
    WebElement txtTALFullTrackEmail;
    @FindBy(id = "fulldel_sms")
    WebElement txtTALFullTrackSms;


    String tALStartYourOrderPage = "RAM - Start Your Order";
    String tALSelectYourServicePage = "RAM - Select your Service";
    String tALAddressPageUrl = "https://www.ram.co.za/Send/TakealotAddress";
    String tALConfirmPageUrl = "https://www.ram.co.za/Send/TakealotConfirm";

    JavascriptExecutor javascript = (JavascriptExecutor) getDriver();
    public boolean isTALAddressPage() {
        return getDriver().getCurrentUrl().equalsIgnoreCase(tALAddressPageUrl);
    }

    public boolean isTALStartYourOrderPage() {
        return verifyPageTitle(tALStartYourOrderPage);
    }

    public boolean isTALSelectYourServicePage() {
        return verifyPageTitle(tALSelectYourServicePage);
    }

    public void clickTALBtnChange() {
        btnTALConfirmChange.click();
    }

    public void clickTALBtnConfirmClose() {
        btnTALConfirmClose.click();
    }

    public boolean isTALConfirmModalOpened() {
        return divTALConfirmModalWindow.isDisplayed();
    }

    public void setTALParcelContent(String parcelContent) {
        selectByVisibleText(selectTALParcelContent, parcelContent);
    }

    public void setTALFromAddress(String frmAddress) {
        setText(txtTALFromAddress, frmAddress);
        try {
            getWait(30).until(ExpectedConditions.visibilityOf(frmTALAddressList));
            //Thread.sleep(2000);

        } catch (Exception e) {
        }
        txtTALFromAddress.sendKeys(Keys.ENTER);
    }

    public void setSelectTALDestination(String talDestination) {
        selectByVisibleText(selectTALDestination, talDestination);
    }

    public void setTALPONumber(String poNumber) {
        setText(txtTALPONumber, poNumber);
    }

    public void clickBtnTALNext() {
        // actions = new Actions(getDriver());
        //actions.moveToElement(btnTALSendNext).click().build().perform();
        //txtTALFromAddress.click();
        getWait(10).until(ExpectedConditions.elementToBeClickable(btnTALSendNext));
        clickElement(btnTALSendNext);
    }

    public void clickBtnTALBack() {
        btnTALSendBack.click();
    }

    public String getTALCurrentStepTitle() {
        return tALcurrentStepTitle.getText();
    }

    public boolean isTALStepDone(String steptitle) {
        for (WebElement stepTitle : tALdoneStepTitle) {
            if (stepTitle.getText().equalsIgnoreCase(steptitle))
                return true;
        }
        return false;
    }


    public void clickOnTALForm() {
        txtTALFromAddress.click();
        getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    public void selectTALServiceType() {
        getWait(20).until(ExpectedConditions.visibilityOf(formTALQuote));
        //scrollToElement(btnTALSelectOption);
        btnTALSelectOption.click();
    }

    public void selectCollectionChkBox(String status) {
        // getWait(30).until(ExpectedConditions.visibilityOf(chkBoxCollection));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        if (status.equalsIgnoreCase("Yes")) {
            if (!chkBoxCollection.isSelected())
                // System.out.println("inside if");
                js.executeScript("return arguments[0].click();", chkBoxCollection);
            //System.out.println("after js click");
            //chkBoxCollection.click();
        } else if (status.equalsIgnoreCase("No")) {
            if (chkBoxCollection.isSelected())
                js.executeScript("return arguments[0].click();", chkBoxCollection);
            //  chkBoxCollection.click();
        }


    }

    public boolean isPresentTALPContentErrorClass() {
        return selectTALParcelContent.getAttribute("class").toLowerCase().contains("error");
    }

    public boolean isPresentTALCollectionAddErrorClass() {
        return txtTALFromAddress.getAttribute("class").toLowerCase().contains("error");
    }

    public boolean isPresentTALDestinationErrorClass() {
        return selectTALDestination.getAttribute("class").toLowerCase().contains("error");
    }

    public boolean isPresentTALPONumberErrorClass() {
        return txtTALPONumber.getAttribute("class").toLowerCase().contains("error");
    }


    public void setTALParcelCount(String parcelCount) {
        selectByVisibleText(selectTALParcelCount, parcelCount);
    }

    public void setTALProhibitedContent() {
        selectByIndex(selectTALParcelContent, 3);
    }

    public void selectTALParcel(String parcelName) {
        for (WebElement parcel : tALParcels) {
            if (parcel.getText().equalsIgnoreCase(parcelName)) {
                parcel.click();
                break;
            }
        }
    }

    public void setTALParcelWeight(int parcelNumber, String weight) {
        //System.out.println("Count Weight ele" + txtParcelWeight.size());
        setText(txtTALParcelWeight.get(parcelNumber - 1), weight);
    }

    public void setTALParcelLenght(int parcelNumber, String length) {
        setText(txtTALParcelLenght.get(parcelNumber - 1), length);
    }

    public void setTALParcelWidth(int parcelNumber, String width) {
        setText(txtTALParcelWidth.get(parcelNumber - 1), width);
    }

    public void setTALParcelHeight(int parcelNumber, String heigth) {
        setText(txtTALParcelHeight.get(parcelNumber - 1), heigth);
    }

    //Step-2 error validation
    public boolean isPresentTALPWeightErrorClass(int parcelNumber) {
        return txtTALParcelWeight.get(parcelNumber - 1).getAttribute("class").toLowerCase().contains("error");
    }

    public boolean isPresentTALPHeightErrorClass(int parcelNumber) {
        return txtTALParcelHeight.get(parcelNumber - 1).getAttribute("class").toLowerCase().contains("error");
    }

    public boolean isPresentTALPLenghtErrorClass(int parcelNumber) {
        return txtTALParcelLenght.get(parcelNumber - 1).getAttribute("class").toLowerCase().contains("error");
    }

    public boolean isPresentTALPWidthErrorClass(int parcelNumber) {
        return txtTALParcelWidth.get(parcelNumber - 1).getAttribute("class").toLowerCase().contains("error");
    }

    public void clickLinkEditAddress() {
        try {
            getWait(30).until(ExpectedConditions.elementToBeClickable(linkTALEditAddress));
        } catch (Exception e) {
        }
        linkTALEditAddress.click();
    }

    public boolean isTALPaymentTypeErrorDisplayed() {
        return divTALPaymentTypeError.isDisplayed();
    }

    public boolean isDisplayedmsgOnTALConfirmBtn(String msg) {
        return btnTALConfirmProceed.getText().toLowerCase().contains(msg.toLowerCase());
    }


    public boolean isSelectedChkBoxOnDelEmail() {
        return chkBoxOnDelEmail.isSelected();
    }

    public boolean isSelectedChkBoxOnDelSms() {
        return chkBoxOnDelSms.isSelected();
    }

    public boolean isSelectedChkBoxFullTrackEmail() {
        return chkBoxFullTrackEmail.isSelected();
    }

    public boolean isSelectedChkBoxFullTrackSms() {
        return chkBoxFullTrackSms.isSelected();
    }

    public void setTxtTALOnDelEmail(String email) {
        setText(txtTALOnDelEmail, email);
    }

    public void setTxtTALFullTrackEmail(String email) {
        setText(txtTALFullTrackEmail, email);
    }

    public void setTxtTALOnDelSms(String mobNo) {
        setText(txtTALOnDelSms, mobNo);
    }

    public void setTxtTALFullTrackSms(String mobNo) {
        setText(txtTALFullTrackSms, mobNo);
    }

    public void selectChxBoxTALOnDelEmail() {
      //  getWait(30).until(ExpectedConditions.presenceOfElementLocated(By.id("ondel_email_cbx")));
       // scrollToElement(chkBoxOnDelEmail);
                if (!chkBoxOnDelEmail.isSelected())
            //chkBoxOnDelEmail.click();
            javascript.executeScript("arguments[0].click();",chkBoxOnDelEmail);
    }

    public void selectChxBoxTALFullTrackEmail() {
        //getWait(30).until(ExpectedConditions.visibilityOf(chkBoxFullTrackEmail));
        if (!chkBoxFullTrackEmail.isSelected())
           // chkBoxFullTrackEmail.click();
            javascript.executeScript("arguments[0].click();",chkBoxFullTrackEmail);
    }

    public void selectChxBoxTALOnDelSms() {
        //getWait(30).until(ExpectedConditions.visibilityOf(chkBoxOnDelSms));
        if (!chkBoxOnDelSms.isSelected())
         //   chkBoxOnDelSms.click();
            javascript.executeScript("arguments[0].click();",chkBoxOnDelSms);
    }

    public void selectChxBoxTALFullTrackSms() {
      //  getWait(30).until(ExpectedConditions.visibilityOf(chkBoxFullTrackSms));
        if (!chkBoxFullTrackSms.isSelected())
          //  chkBoxFullTrackSms.click();
            javascript.executeScript("arguments[0].click();",chkBoxFullTrackSms);
    }

    public boolean isRequiredTxtOnDelEmail() {
        return isMandatoryField(txtTALOnDelEmail);
    }

    public boolean isRequiredTxtOnDelSms() {
        return isMandatoryField(txtTALOnDelSms);
    }

    public boolean isRequiredTxtFullTrackEmail() {
        return isMandatoryField(txtTALFullTrackEmail);
    }

    public boolean isRequiredTxtFullTrackSms() {
        return isMandatoryField(txtTALFullTrackSms);
    }

    public boolean isEnabledTALCollectionFirstName() {
        return tALCollectionFirstName.isEnabled();
    }

    public boolean isEnabledTALCollectionSurname() {
        return tALCollectionSurName.isEnabled();
    }

    public boolean isTALConfirmPage() {
        return getDriver().getCurrentUrl().equalsIgnoreCase(tALConfirmPageUrl);
        //return verifyPageTitle(confirm_paymentPage);
    }

}