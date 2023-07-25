package org.met.testing.challenges.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public enum WebDriverType {
    CHROME {
        public WebDriver getDriver() {
            return new ChromeDriver();
        }
    },
    SAFARI {
        public WebDriver getDriver() {
            return new SafariDriver();
        }
    };

    public abstract WebDriver getDriver();
}
