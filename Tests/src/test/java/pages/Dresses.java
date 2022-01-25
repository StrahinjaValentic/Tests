package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dresses {
    private WebDriver driver;

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/ul[1]/li[3]/a[1]")
    WebElement summerDresses;

    @FindBy(xpath ="//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/h5[1]/a[1]")
    WebElement dressElement1;

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[3]/div[2]/a[1]")
    WebElement addToCompareElement1;

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[3]/div[1]/div[2]/h5[1]/a[1]")
    WebElement dressElement2;

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[3]/div[1]/div[3]/div[2]/a[1]")
    WebElement addToCompareElement2;

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/div[2]/div[2]/form[1]/button[1]")
    WebElement compareButton;

    public Dresses(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void compareDresses() throws InterruptedException {
        summerDresses.click();
        Actions action = new Actions(driver);
        action.moveToElement(dressElement1);
        action.moveToElement(addToCompareElement1);
        action.click().build().perform();
        Thread.sleep(1000);
        action.moveToElement(dressElement2);
        action.moveToElement(addToCompareElement2);
        action.click().build().perform();
        Thread.sleep(1000);
        compareButton.click();
    }

    public void compareDressesOneDress() throws InterruptedException {
        summerDresses.click();
        Actions action = new Actions(driver);
        action.moveToElement(dressElement1);
        action.moveToElement(addToCompareElement1);
        action.click().build().perform();
        Thread.sleep(1000);
        compareButton.click();
    }
}
