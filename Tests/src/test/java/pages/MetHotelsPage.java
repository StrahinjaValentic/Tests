package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MetHotelsPage {
    private WebDriver driver;

    @FindBy(xpath = "//body/app-root[1]/div[1]/div[1]/div[2]/lista-smestaja-component[1]/div[1]/smestaj-component[1]/div[1]/div[1]/div[1]/a[2]")
    WebElement obrisi1;
    @FindBy(xpath = "//body/app-root[1]/div[1]/div[1]/div[2]/lista-smestaja-component[1]/div[1]/smestaj-component[2]/div[1]/div[1]/div[1]/a[2]")
    WebElement obrisi2;
    @FindBy(xpath = "//a[contains(text(),'Obrisi')]")
    WebElement obrisi3;
    @FindBy(xpath = "//input[@id='naziv']")
    WebElement nazivSmestaja;
    @FindBy(xpath = "//input[@id='adresa']")
    WebElement adresa;
    @FindBy(xpath = "//input[@id='cena']")
    WebElement cena;
    @FindBy(xpath = "//input[@id='slika']")
    WebElement slika;
    @FindBy(xpath = "//body/app-root[1]/div[1]/div[1]/div[1]/form-dodaj-smestaj[1]/form[1]/div[5]/button[1]")
    WebElement submit1;
    @FindBy(xpath = "//select[@id='smestaj']")
    WebElement izaberiSmestaj;
    @FindBy(xpath = "//input[@id='tip']")
    WebElement tipSobe;
    @FindBy(xpath = "//input[@id='kvadratura']")
    WebElement kvadratura;
    @FindBy(xpath = "//body/app-root[1]/div[1]/div[1]/div[1]/form-dodaj-sobu[1]/form[1]/div[4]/button[1]")
    WebElement submit2;

    public MetHotelsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void brisanje() {
        obrisi1.click();
        obrisi2.click();
        obrisi3.click();
    }

    public void dodajNovSmestaj() {
        nazivSmestaja.sendKeys("Smestaj 1");
        adresa.sendKeys("Adresa 1");
        cena.sendKeys("5000");
        slika.sendKeys("https://upload.wikimedia.org/wikipedia/commons/thumb/e/ed/Apartment-in-Berlin-by-Dezest-design-01.jpg/640px-Apartment-in-Berlin-by-Dezest-design-01.jpg");
        submit1.click();
    }

    public void dodajNovuSobu() {
        Select izaberi = new Select(izaberiSmestaj);
        izaberi.selectByValue("Smestaj 1");
        tipSobe.sendKeys("Dnevna");
        kvadratura.sendKeys("20");
        submit2.click();
    }
}
