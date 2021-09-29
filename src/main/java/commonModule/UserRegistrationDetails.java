package commonModule;

public class UserRegistrationDetails {
    public String companytype;
    public String firstname;
    public String surname;
    public String mobile;
    public String telephone;
    public String email;
    public String password;
    public String cpassword;
    public String propertytype;
    public String billingaddress;

    public UserRegistrationDetails(String companytype, String firstname, String surname, String mobile, String telephone, String email, String password, String cpassword, String propertytype, String billingaddress) {
        this.companytype = companytype;
        this.firstname = firstname;
        this.surname = surname;
        this.mobile = mobile;
        this.telephone = telephone;
        this.email = email;
        this.password = password;
        this.cpassword = cpassword;
        this.propertytype = propertytype;
        this.billingaddress = billingaddress;
    }
}

