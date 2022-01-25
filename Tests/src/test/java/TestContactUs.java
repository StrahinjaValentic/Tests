import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.ContactUs;
import utils.PropReader;
import utils.Random;

import java.io.IOException;
import java.time.Duration;

public class TestContactUs {

    private WebDriver wd;

    @BeforeClass
    public void init() throws IOException {
        System.setProperty("webdriver.chrome.driver",
                PropReader.fetchProperty("WEBDRIVER.CHROME.PATH"));

        wd = new ChromeDriver();

        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Ovo ce se izvrsiti pre metode");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Ovo ce se izvrsiti pre suite");
    }

    @AfterClass
    public void zatvoriWebDriver() {
        wd.close();
    }

    /**
     * This test tests contact us happy path.
     *
     * Test steps:
     * 1. Go to http://automationpractice.com/index.php?controller=contact
     * 2. Select value 2 from dropdown
     * 3.Input email address
     * 4. Input order reference
     * 5. Upload a file
     * 6. Send a message
     * 7. Click Send button
     * 8. Assert that message is present
     * @throws IOException
     */
    @Test
    public void contactUsHappyPath() throws IOException {
        System.out.println("Go to http://automationpractice.com/index.php?controller=contact");
        wd.get("http://automationpractice.com/index.php?controller=contact");
        wd.manage().window().maximize();

        Assert.assertEquals(wd.getCurrentUrl(), "http://automationpractice.com/index.php?controller=contact",
                "The current url should be equal to http://automationpractice.com/index.php?controller=contact");

        ContactUs contactUsPage = new ContactUs(wd);
        System.out.println("Select value 2 from dropdown");
        contactUsPage.selectValueFromDropdown("2");

        System.out.println("Input email address");
        contactUsPage.inputEmailAddress(Random.getRandomUserEmail());

        System.out.println("Input order reference");
        contactUsPage.inputOrderReference("loremipsum");

        System.out.println("Upload a file");
        contactUsPage.uploadFile("C:\\testdokument.txt");

        System.out.println("Send a message");
        contactUsPage.sendAMessage("ovo je poruka");

        System.out.println("Click Send button");
        contactUsPage.clickSendButton();

        System.out.println("Assert that message is present");
        String confirmationMsg = contactUsPage.getConfirmationMessage();

        Assert.assertEquals(confirmationMsg, "Your message has been successfully sent to our team.",
                "The message should be equal to 'Your message has been successfully sent to our team.'");

    }

    @Test
    public void contactUsInvalidEmailAddress() throws IOException {
        System.out.println("Go to http://automationpractice.com/index.php?controller=contact");
        wd.get("http://automationpractice.com/index.php?controller=contact");
        wd.manage().window().maximize();

        Assert.assertEquals(wd.getCurrentUrl(), "http://automationpractice.com/index.php?controller=contact",
                "The current url should be equal to http://automationpractice.com/index.php?controller=contact");

        ContactUs contactUsPage = new ContactUs(wd);

        System.out.println("Select value 2 from dropdown");
        contactUsPage.selectValueFromDropdown("2");

        System.out.println("Click send button");
        contactUsPage.clickSendButton();

        System.out.println("Assert that message is present");
        String invalidMessage = contactUsPage.getInvalidMessage();
        Assert.assertTrue(invalidMessage.contains("Invalid email address"),
                "The message should be 'there is 1 error'");






    }
}
