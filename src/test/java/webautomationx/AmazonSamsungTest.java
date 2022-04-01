package webautomationx;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
        driver.quit();
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
        Helper.waitForXSecond(10);
        Helper.waitTillElementVisible(driver, 10, By.xpath("//*[@id=\"s-refinements\"]/div[17]/ul/li[4]/span/a/div"));
        WebElement samsungCheckbox = Helper.getElementByXPath(driver, "//*[@id=\"s-refinements\"]/div[17]/ul/li[4]/span/a/div");
        samsungCheckbox.click();
    }

    @Test
    @Order(6)
    void sortResultHighToLow() {
        Helper.waitTillElementClickable(driver, 60, By.id("s-result-sort-select"));
        ((JavascriptExecutor)driver).executeScript("document.getElementById('s-result-sort-select').click();");

        Helper.waitTillElementVisible(driver, 60, By.xpath("//ul//li//a[contains(.,\"Price: High to Low\")]"));
        Helper.getElementByXPath(driver, "//ul//li//a[contains(.,\"Price: High to Low\")]").click();
    }

    @Test
    @Order(7)
    void clickSecondHighest() {
        Helper.waitTillElementVisible(driver, 60, By.xpath("(//div[contains(@class,\"s-result-item\")])[3]"));
        Helper.getElementByXPath(driver, "//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/div/div/div/div[2]/div[1]/h2/a").click();
    }

    @Test
    @Order(8)
    void switchWindowAndLogTheAboutItem() {
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        Helper.waitTillElementVisible(driver, 60, By.id("feature-bullets"));
        System.out.println(Helper.getElementById(driver, "feature-bullets").getText());
    }

}
