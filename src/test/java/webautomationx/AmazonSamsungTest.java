package webautomationx;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AmazonSamsungTest {

    static WebDriver driver;

    @BeforeAll
    static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterAll
    static void teardown() {
        //driver.quit();
    }

    @Test
    @Order(1)
    void openAmazonIn() {
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
    }

    @Test
    @Order(2)
    void clickOnHamBurger() {
        Helper.getElementById(driver, "nav-hamburger-menu").click();
    }

    @Test
    @Order(3)
    void clickTvAndAppliances() {
        Helper.getElementByXPath(driver, "//ul//li//a[contains(.,\"TV, Appliances, Electronics\")]").click();
    }

    @Test
    @Order(4)
    void clickTelevision() {
        Helper.waitTillElementVisible(driver, 5, By.xpath("//ul//li//a[contains(.,\"Television\")]"));
        Helper.getElementByXPath(driver, "//ul//li//a[contains(.,\"Television\")]").click();
    }

    @Test
    @Order(5)
    void filterResultBySamsung() {
        try {
            Thread.sleep(2*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Helper.waitTillElementVisible(driver, 10, By.xpath("//*[@id=\"s-refinements\"]/div[17]/ul/li[4]/span/a/div"));
        WebElement samsungCheckbox = Helper.getElementByXPath(driver, "//*[@id=\"s-refinements\"]/div[17]/ul/li[4]/span/a/div");
        samsungCheckbox.click();
    }

    @Test
    @Order(6)
    void sortResultHighToLow() {
        Helper.waitTillElementClickable(driver, 60, By.id("s-result-sort-select"));
        ((JavascriptExecutor)driver).executeScript("document.getElementById('s-result-sort-select').click();");

        Helper.waitTillElementVisible(driver, 60, By.xpath("//ul//li//a[contains(.,\"Price: Low to High\")]"));
        Helper.getElementByXPath(driver, "//ul//li//a[contains(.,\"Price: Low to High\")]").click();
    }

    @Test
    @Order(7)
    void clickSecondHighest() {
    }

    @Test
    @Order(8)
    void switchWindowAndLogTheAboutItem() {
    }

}
