package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.nio.charset.StandardCharsets;
import java.text.StringCharacterIterator;

public class SignIn {

    private WebDriver driver;

    @FindBy(xpath = "//input[@id='email_create']")
    WebElement emailAdress;

    @FindBy(xpath = "//button[@id='SubmitCreate']")
    WebElement createAccountButton;

    @FindBy(xpath = "//input[@id='id_gender1']")
    WebElement genderButton1;

    @FindBy(xpath = "//input[@id='customer_firstname']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id='customer_lastname']")
    WebElement lastName;

    @FindBy(xpath = "//input[@id='passwd']")
    WebElement password;

    @FindBy(xpath = "//input[@id='firstname']")
    WebElement firstNameInAddress;

    @FindBy(xpath = "//input[@id='lastname']")
    WebElement lastNameInAddress;

    @FindBy(xpath = "//input[@id='address1']")
    WebElement address;

    @FindBy(xpath = "//input[@id='city']")
    WebElement city;

    @FindBy(xpath = "//select[@id='id_state']")
    WebElement state;

    @FindBy(xpath = "//input[@id='postcode']")
    WebElement postCode;

    @FindBy(xpath = "//select[@id='id_country']")
    WebElement country;

    @FindBy(xpath = "//input[@id='phone_mobile']")
    WebElement phone;

    @FindBy(xpath = "//button[@id='submitAccount']")
    WebElement registerButton;

    public SignIn(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void createAccount(String email, String name, String surname, String pass, String address1, String city1, String value, String zipcode, String value2, String mobile) {
        emailAdress.sendKeys(email);
        createAccountButton.click();
        genderButton1.click();
        firstName.sendKeys(name);
        lastName.sendKeys(surname);
        password.sendKeys(pass);
        address.sendKeys(address1);
        city.sendKeys(city1);
        Select subject = new Select(state);
        subject.selectByValue(value);
        postCode.sendKeys(zipcode);
        Select subject2 = new Select(country);
        subject2.selectByValue(value2);
        phone.sendKeys(mobile);
        registerButton.click();
    }
}
