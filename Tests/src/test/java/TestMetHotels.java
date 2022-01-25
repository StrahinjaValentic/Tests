import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MetHotelsPage;
import utils.PropReader;

import java.io.IOException;
import java.time.Duration;

public class TestMetHotels {

    private WebDriver wd;

    @BeforeClass
    public void init() throws IOException {
        System.setProperty("webdriver.chrome.driver",
                PropReader.fetchProperty("WEBDRIVER.CHROME.PATH"));

        wd = new ChromeDriver();

        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        wd.manage().window().maximize();
    }

    @AfterClass
    public void zatvoriWebDriver() throws IOException {
        wd.close();
        System.out.println("Web driver closed");
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
    }

    @Test
    public void testiranjeFunkcionalnostiMetHotels() {
        System.out.println("Go to https://it-255-dz-06-andjela-bojic3972.vercel.app/");
        wd.get("https://it-255-dz-06-andjela-bojic3972.vercel.app/");

        System.out.println("Assert that the current url is correct");
        Assert.assertEquals(wd.getCurrentUrl(), "https://it-255-dz-06-andjela-bojic3972.vercel.app/",
                "The current url should be equal to https://it-255-dz-06-andjela-bojic3972.vercel.app/");
        System.out.println("The current url is correct");
        System.out.println();

        MetHotelsPage page = new MetHotelsPage(wd);

        page.brisanje();

        page.dodajNovSmestaj();
        Assert.assertTrue(wd.getPageSource().contains("Smestaj 1"));

        page.dodajNovuSobu();
        Assert.assertTrue(wd.findElement(By.xpath("//body/app-root[1]/div[1]/div[1]/div[2]/lista-smestaja-component[1]/div[1]/smestaj-component[1]/div[1]/div[1]/ul[1]"))
                .getText().contains("Dnevna -- 20m2"));
    }
}
