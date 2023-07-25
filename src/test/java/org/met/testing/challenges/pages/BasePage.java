package org.met.testing.challenges.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected static WebDriver driver;
    private static WebDriverWait wait;

    static {
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(1));
    }

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void navigateTo(String url) {
        driver.get(url);
    }

    public static void CloseBrowser() {
        driver.quit();
    }

    private WebElement findMe(String locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator) {
        findMe(locator).click();
    }

    public void write(String locator, String textToWrite) {
        //findMe(locator).clear();
        //findMe(locator).sendKeys(textToWrite);
        WebElement element = driver.findElement(By.xpath(locator));
        element.sendKeys(textToWrite);
    }

    public String textFromElement(String locator) {
        return findMe(locator).getText();
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public boolean elementIsDisplayed(String locator) {
        try {
            return findMe(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
