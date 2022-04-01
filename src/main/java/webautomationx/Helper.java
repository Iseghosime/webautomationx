package webautomationx;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Helper {

    public static WebElement getElementById(WebDriver driver, String id) {
        return driver.findElement(By.id(id));
    }

    public static WebElement getElementByClassName(WebDriver driver, String className) {
        return driver.findElement(By.className(className));
    }

    public static WebElement getElementByXPath(WebDriver driver, String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public static WebElement getElementById(WebElement webElement, String id) {
        return webElement.findElement(By.id(id));
    }

    public static WebElement getElementByClassName(WebElement webElement, String className) {
        return webElement.findElement(By.className(className));
    }

    public static WebElement getElementByXPath(WebElement webElement, String xpath) {
        return webElement.findElement(By.xpath(xpath));
    }

    public static List<WebElement> getElementsByClassName(WebDriver driver, String className) {
        return driver.findElements(By.className(className));
    }

    public static void waitTillElementVisible(WebDriver driver, int timeoutInSeconds, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitTillElementClickable(WebDriver driver, int timeoutInSeconds, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

}
