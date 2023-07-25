package org.met.testing.challenges.factory;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class WebDriverFactory {

    private final WebDriver webDriver;

    private WebDriverFactory(WebDriverType type) {
        this.webDriver = type.getDriver();
    }

    public static WebDriverFactory builder(WebDriverType type) {
        return new WebDriverFactory(type);
    }

    public WebDriverFactory withInitialUrl(String initialUrl) {
        this.webDriver.get(initialUrl);
        return this;
    }

    public WebDriverFactory withImplicitWait(Duration duration) {
        this.webDriver.manage().timeouts().implicitlyWait(duration);
        return this;
    }

    public WebDriver build() {
        return webDriver;
    }

    public void quit() {
        webDriver.quit();
    }

}
