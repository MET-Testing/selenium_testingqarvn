package org.met.testing.challenges.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeWebDriverUtils {
    private static WebDriver driver;

    static {
        driver = setDriver();
    }

    private static WebDriver setDriver() {
        driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver getDriver() {
        return driver != null ? driver : setDriver();
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }

    }
}
