import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.SignIn;
import utils.PropReader;
import utils.Random;

import java.io.IOException;
import java.time.Duration;

public class TestSignIn {

    private WebDriver wd;

    @BeforeClass
    public void init() throws IOException {
        System.setProperty("webdriver.chrome.driver",
                PropReader.fetchProperty("WEBDRIVER.CHROME.PATH"));

        wd = new ChromeDriver();

        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void zatvoriWebDriver() {
        wd.close();
        System.out.println("Web driver closed");
    }

    @Test
    public void testSignInCreateAccount() throws IOException {
        System.out.println("Go to http://automationpractice.com/index.php?controller=authentication&back=my-account");
        wd.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        wd.manage().window().maximize();

        System.out.println("Assert that the current url is correct");
        Assert.assertEquals(wd.getCurrentUrl(), "http://automationpractice.com/index.php?controller=authentication&back=my-account",
                "The current url should be equal to http://automationpractice.com/index.php?controller=authentication&back=my-account");
        System.out.println("The current url is correct");
        System.out.println();

        SignIn signInPage = new SignIn(wd);

        System.out.println("Create account");
        signInPage.createAccount((Random.getRandomUserEmail()), "Pera", "Peric", "peraperic1", "Adresa 1", "LA",
                "5", "11111", "21", "00989282625");
        System.out.println("Account successfully created, and signed in");
        System.out.println();

        System.out.println("Assert that message is present");
        Assert.assertTrue(wd.getPageSource().contains("Welcome to your account. Here you can manage all of your personal information and orders."));
        System.out.println("The message is present");
        System.out.println();
    }
}
