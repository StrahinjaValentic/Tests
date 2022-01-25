package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactUs {

    private WebDriver driver;

    @FindBy(xpath = "//select[@id='id_contact']")
    WebElement dropdown;

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailAddress;

    @FindBy(xpath = "//input[@id='id_order']")
    WebElement orderRef;

    @FindBy(xpath = "//input[@id='fileUpload']")
    WebElement uploadFileField;

    @FindBy(xpath = "//textarea[@id='message']")
    WebElement messageField;

    @FindBy(xpath = "//button[@id='submitMessage']")
    WebElement sendAMsg;

    @FindBy(className = "alert-success")
    WebElement confirmationBox;

    @FindBy(className = "alert-danger")
    WebElement invalidEmail;

    public ContactUs(WebDriver driver) { //konstruktor sa webdriverom
        this.driver = driver;
        PageFactory.initElements(driver, this); //inicijalizacija svih elemenata na web stranici
    }

    public void selectValueFromDropdown(String value) {
        Select subject = new Select(dropdown);
        subject.selectByValue(value);
    }

    public void inputEmailAddress(String email) {
        emailAddress.sendKeys(email);
    }

    public void inputOrderReference(String value) {
        orderRef.sendKeys(value);
    }

    public void uploadFile(String pathToFile) {
        uploadFileField.sendKeys(pathToFile);
    }

    public void sendAMessage(String message) {
        messageField.sendKeys(message);
    }

    public void clickSendButton() {
        sendAMsg.click();
    }

    public String getConfirmationMessage() {
        return confirmationBox.getText();
    }

    public String getInvalidMessage() {
        return invalidEmail.getText();
    }
}
