import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.Dresses;
import utils.PropReader;

import java.io.IOException;
import java.time.Duration;

public class TestCompareDresses {
    private WebDriver wd;

    @BeforeClass
    public void init() throws IOException {
        System.setProperty("webdriver.chrome.driver",
                PropReader.fetchProperty("WEBDRIVER.CHROME.PATH"));

        wd = new ChromeDriver();

        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void zatvoriWebDriver() throws IOException {
        wd.close();
        System.out.println("Web driver closed");
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");//ubija chromedriver proccess u task manager-u
    }

    @Test
    public void testCompareDresses() throws IOException, InterruptedException {
        System.out.println("Go to http://automationpractice.com/index.php?id_category=8&controller=category");
        wd.get("http://automationpractice.com/index.php?id_category=8&controller=category");
        wd.manage().window().maximize();

        System.out.println("Assert that the current url is correct");
        Assert.assertEquals(wd.getCurrentUrl(), "http://automationpractice.com/index.php?id_category=8&controller=category",
                "The current url should be equal to http://automationpractice.com/index.php?id_category=8&controller=category");
        System.out.println("The current url is correct");
        System.out.println();

        Dresses dressesPage = new Dresses(wd);

        System.out.println("Add 2 dresses for comparison");
        dressesPage.compareDresses();
        System.out.println();

        System.out.println("Assert that 'Printed Summer Dress' is on the page");
        Assert.assertTrue(wd.getPageSource().contains("Printed Summer Dress"));
        System.out.println("Printed Summer Dress is on the page");
        System.out.println();

        System.out.println("Assert that 'Printed Chiffon Dress' is on the page");
        Assert.assertTrue(wd.getPageSource().contains("Printed Chiffon Dress"));
        System.out.println("Printed Chiffon Dress is on the page");
    }

    @Test
    public void testCompareDressesWithOneDress() throws InterruptedException {
        System.out.println("Go to http://automationpractice.com/index.php?id_category=8&controller=category");
        wd.get("http://automationpractice.com/index.php?id_category=8&controller=category");
        wd.manage().window().maximize();

        System.out.println("Assert that the current url is correct");
        Assert.assertEquals(wd.getCurrentUrl(), "http://automationpractice.com/index.php?id_category=8&controller=category",
                "The current url should be equal to http://automationpractice.com/index.php?id_category=8&controller=category");
        System.out.println("The current url is correct");
        System.out.println();

        Dresses dressesPage = new Dresses(wd);

        System.out.println("Add 1 dress for comparison");
        dressesPage.compareDressesOneDress();
        System.out.println();

        try {
            Assert.assertEquals(wd.getCurrentUrl(), "http://automationpractice.com/index.php?id_category=11&controller=category",
                    "The compare button should not work.");
        } catch (Throwable  e) {
            System.err.println(e);
        }
    }
}
