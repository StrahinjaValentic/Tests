package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountOrderDetails {

    private WebDriver driver;

    @FindBy(xpath = "//header/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/a[1]")
    WebElement dressesPage;

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/ul[1]/li[3]/a[1]")
    WebElement summerDresses;

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/h5[1]/a[1]")
    WebElement dressElement1;

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/div[2]/a[1]")
    WebElement addToCartElement1;

    @FindBy(xpath = "//header/div[3]/div[1]/div[1]/div[4]/div[1]/div[2]/div[4]/span[1]")
    WebElement continueShopping;

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[3]/div[1]/div[2]/h5[1]/a[1]")
    WebElement dressElement2;

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[3]/div[1]/div[2]/div[2]/a[1]")
    WebElement addToCartElement2;

    @FindBy(xpath = "//header/div[3]/div[1]/div[1]/div[4]/div[1]/div[2]/div[4]/a[1]")
    WebElement proceedToCheckout;

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/p[2]/a[1]")
    WebElement proceedToCheckout2;

    @FindBy(xpath = "//input[@id='cgv']")
    WebElement checkBox;

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/form[1]/p[1]/button[1]")
    WebElement proceedToCheckout3;

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/p[1]/button[1]")
    WebElement proceedToCheckout4;

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/p[1]/a[1]")
    WebElement paymentOption;

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/form[1]/p[1]/button[1]")
    WebElement orderConfirmation;

    @FindBy(xpath = "//header/div[2]/div[1]/div[1]/nav[1]/div[1]/a[1]")
    WebElement accountButton;

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]")
    WebElement orderHistoryAndDetailsButton;

    public MyAccountOrderDetails(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addToCart() throws InterruptedException {
        dressesPage.click();
        summerDresses.click();
        Actions action = new Actions(driver);
        action.moveToElement(dressElement1);
        action.moveToElement(addToCartElement1);
        action.click().build().perform();
        Thread.sleep(2000);
        continueShopping.click();
        action.moveToElement(dressElement2);
        action.moveToElement(addToCartElement2);
        action.click().build().perform();
        Thread.sleep(2000);
        proceedToCheckout.click();
    }

    public void proceedToCheckout() throws InterruptedException {
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", proceedToCheckout);
        proceedToCheckout2.click();
        //checkBox.click();
        proceedToCheckout3.click();
        Actions action = new Actions(driver);
        action.moveToElement(checkBox);
        action.click().build().perform();
        proceedToCheckout4.click();
        paymentOption.click();
        orderConfirmation.click();
    }

    public void orderDetails() {
        accountButton.click();
        orderHistoryAndDetailsButton.click();
    }
}
