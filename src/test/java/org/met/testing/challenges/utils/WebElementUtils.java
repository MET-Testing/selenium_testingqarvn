package org.met.testing.challenges.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebElementUtils {

    public static void write(WebDriver driver, String xpath, String textToWrite) {
        WebElement element = driver.findElement(By.xpath(xpath));
        write(element, textToWrite);
    }

    public static void write(WebElement element, String textToWrite) {
       assertTrue(element.isDisplayed());
        element.clear();
        element.sendKeys(textToWrite);
    }

    public static void waitAndClick(WebDriver driver, String xpath, Duration duration) {
        WebDriverWait wait = new WebDriverWait(driver, duration);
        waitAndClick(wait, xpath);
    }

    public static void waitAndClick(WebDriverWait wait, String xpath) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(xpath))).click();
    }
}
