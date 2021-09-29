package pages;

import commonModule.TabletoDict;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class UserRegistration extends BaseClass {
    public UserRegistration(WebDriver driver) {
        super(driver);
    }

    String registerPage = "RAM - Registration";
    //User Registration form elements
    //COmmon Fields
    @FindBy(id = "private_address")
    WebElement radioPrivateType;
    @FindBy(id = "company_address")
    WebElement radioCompanyType;
    @FindBy(id = "FirstName")
    WebElement txtFirstName;
    @FindBy(name = "Surname")
    WebElement txtSurname;
    @FindBy(id = "CompanyName")
    WebElement txtCompanyName;
    @FindBy(id = "VATNumber")
    WebElement txtVATNumber;
    @FindBy(name = "Cell")
    WebElement txtMobile;
    @FindBy(name = "Telelphone")
    WebElement txtTelephone;
    @FindBy(name = "Email")
    WebElement txtEmail;
    @FindBy(id = "reg-password")
    WebElement txtPassword;
    @FindBy(id = "reg-password-rep")
    WebElement txtCPassword;
    @FindBy(id = "destination-type")
    WebElement selectPropertytype;
    @FindBy(id = "geolocate-address")
    WebElement txtBillingAddress;
    @FindBy(css = "button[class='submit-btn teal']")
    WebElement btnRegister;

    //Required if Type is other than home
    @FindBy(name = "det1")
    WebElement txtDet1;
    @FindBy(name = "det2")
    WebElement txtDet2;
    @FindBy(name = "det3")
    WebElement txtDet3;
    @FindBy(name = "det4")
    WebElement txtDet4;
    @FindBy(xpath = "//form[@id='reg-form']//select[@id='destination-type']/following::div[@class='destination-details']/input[contains(@type,'text')]")
    List<WebElement> txtDet;
    @FindBy(id = "pwbox-reg")
    WebElement errorMsgDiv;
    @FindBy(id = "ui-id-1")
    WebElement addressList;

    @FindBy(css = "div.toast-message")
    WebElement emailToaster;

    public boolean isDisplayedRegistrationPage() {
        return (verifyPageTitle(registerPage));
    }

    public void fillUserRegisterationForm(List<List<String>> table) throws Throwable {
        Map<String, String> user = TabletoDict.TableDictionaryConverter(table);
        if (user.get("usertype").equalsIgnoreCase("Company")) {
            if (!radioCompanyType.isSelected()) {
                //radioCompanyType.click();
                JavascriptExecutor jse = (JavascriptExecutor) getDriver();
                jse.executeScript("arguments[0].click()", radioCompanyType);
            }
            setText(txtCompanyName, user.get("companyname"));
            setText(txtVATNumber, user.get("vatNumber"));
        } else if (user.get("usertype").equalsIgnoreCase("Private")) {
            if (!radioPrivateType.isSelected()) {
                //radioCompanyType.click();
                JavascriptExecutor jse = (JavascriptExecutor) getDriver();
                jse.executeScript("arguments[0].click()", radioPrivateType);
            }
            setText(txtFirstName, user.get("firstname"));
            setText(txtSurname, user.get("surname"));
        }

        //  if ((user.get("billingaddress").length()>0)) {
        setText(txtBillingAddress, user.get("billingaddress"));
        Thread.sleep(3000);
        // getWait(10).until(ExpectedConditions.visibilityOf(addressList));
        if (addressList.isDisplayed())
            txtBillingAddress.sendKeys(Keys.ENTER);
        //}

        Select select = new Select(selectPropertytype);
        if (!user.get("propertytype").equals(""))
            select.selectByVisibleText(user.get("propertytype"));

        int i = txtDet.size();
        if (i >= 1) {
            for (int k = 1; k <= i; k++) {
                txtDet.get(k - 1).sendKeys(user.get("det" + k));
            }
        }

        setText(txtMobile, user.get("mobile"));
        setText(txtTelephone, user.get("telephone"));
        setText(txtEmail, user.get("email"));
        setText(txtPassword, user.get("password"));
        setText(txtCPassword, user.get("cpassword"));
    }

    public void clickBtnRegister() {
        btnRegister.click();
    }

    public boolean isAlertPresent(String message) {
        System.out.println("msg text" + getAlertText());
        return (getAlertText().equalsIgnoreCase(message));
    }

    public boolean isPresentErrorBlock() {
        return (errorMsgDiv.isDisplayed());
    }

    public boolean isPresentFNErrorClass() {
        return txtFirstName.getAttribute("class").equalsIgnoreCase("error");
    }

    public boolean isPresentSNErrorClass() {
        return txtSurname.getAttribute("class").equalsIgnoreCase("error");
    }

    public boolean isPrsentCNErrorClass() {
        return txtCompanyName.getAttribute("class").equalsIgnoreCase("error");
    }

    public boolean isPresentBAErrorClass() {
        return txtBillingAddress.getAttribute("class").equalsIgnoreCase("ui-autocomplete-input error");
    }

    public boolean isPresentMobErrorClass() {
        return txtMobile.getAttribute("class").equalsIgnoreCase("error");
    }

    public boolean isPresentEmailErrorClass() {
        return txtEmail.getAttribute("class").equalsIgnoreCase("error");
    }

    public boolean isPresentPassErrorClass() {
        return txtPassword.getAttribute("class").equalsIgnoreCase("error");
    }

    public boolean isPresentCpassErrorClass() {
        return txtCPassword.getAttribute("class").equalsIgnoreCase("error");
    }

    public boolean isErrorPresent(String fieldName) {
        switch (fieldName) {
            case "firstname":
                return isPresentFNErrorClass();
            case "surname":
                return isPresentSNErrorClass();
            case "companyname":
                return isPrsentCNErrorClass();
            case "billingAddress":
                return isPresentBAErrorClass();
            case "mobile":
                return isPresentMobErrorClass();
            case "email":
                return isPresentEmailErrorClass();
            case "password":
                return isPresentPassErrorClass();
            case "confirmPassword":
                return isPresentCpassErrorClass();
            case "cPassword":
                return isPresentCpassErrorClass();
        }
        return false;
    }

    public boolean isDisplayedEmailToaster(String msg) {
        getWait(10).until(ExpectedConditions.visibilityOf(emailToaster));
        //return emailToaster.getText().equalsIgnoreCase(msg);
        if(emailToaster.isDisplayed()){
            return emailToaster.getText().equalsIgnoreCase(msg);
        }
        else
            return false;
    }

    public void setRegistrationFieldVal(String fieldName, String value) {
        switch (fieldName) {
            case "firstname":
                getWait(10).until(ExpectedConditions.elementToBeClickable(txtFirstName));
                setText(txtFirstName, value);
            case "surname":
                setText(txtSurname, value);
            case "companyname":
                setText(txtCompanyName, value);
            case "billingAddress":
                setText(txtBillingAddress, value);
            case "mobile":
                setText(txtMobile, value);
            case "email":
                setText(txtEmail, value);
            case "password":
                setText(txtPassword, value);
            case "confirmPassword":
                setText(txtCPassword, value);
            case "c5Password":
                setText(txtCPassword, value);
            case "telephone":
                setText(txtTelephone, value);
            case "propertytype":
                selectByVisibleText(selectPropertytype, value);
            case "vatNumber":
                setText(txtVATNumber, value);
        }
        //   return false;
    }

    public void selectUserType(String type) {
        if (type.equalsIgnoreCase("Company")) {
            if (!radioCompanyType.isSelected()) {
                //radioCompanyType.click();
                JavascriptExecutor jse = (JavascriptExecutor) getDriver();
                jse.executeScript("arguments[0].click()", radioCompanyType);
            }
        } else if (type.equalsIgnoreCase("Private")) {
            if (!radioPrivateType.isSelected()) {
                //radioCompanyType.click();
                JavascriptExecutor jse = (JavascriptExecutor) getDriver();
                jse.executeScript("arguments[0].click()", radioPrivateType);
            }

        }
    }

    public void setFirstname(String value) {
        setText(txtFirstName, value);
    }

    public void setSurname(String value) {
        setText(txtSurname, value);
    }

    public void setCompanyname(String value) {
        setText(txtCompanyName, value);
    }

    public void setVATNumber(String value) {
        setText(txtVATNumber, value);
    }

    public void setBillingAddress(String value) {
        setText(txtBillingAddress, value);
    }

    public void setPropertytype(String value) {
        selectByVisibleText(selectPropertytype, value);
    }

    public void setMobile(String value) {
        setText(txtMobile, value);
    }

    public void setTelephone(String value) {
        setText(txtTelephone, value);
    }

    public void setEmail(String value) {
        scrollToElement(txtEmail);
        setText(txtEmail, value);
    }

    public void setPassword(String value) {
        scrollToElement(txtPassword);
        setText(txtPassword, value);
    }

    public void setCpassword(String value) {
        scrollToElement(txtCPassword);
        setText(txtCPassword, value);
    }

}

