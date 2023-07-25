package org.met.testing.challenges;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.met.testing.challenges.factory.WebDriverFactory;
import org.met.testing.challenges.factory.WebDriverType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class GoogleSearchTest {

    private final WebDriver chromeDriver = WebDriverFactory.builder(WebDriverType.CHROME)
                                                     .withInitialUrl("https://www.google.com/")
                                                     .withImplicitWait(Duration.of(10, ChronoUnit.SECONDS))
                                                     .build();

    @Test
    public void testGooglePage() {
        WebElement searchBox = chromeDriver.findElement(By.name("q"));
        searchBox.clear();
        searchBox.sendKeys("Comunidad MeT");
        searchBox.submit();
        //chromeDriver.manage().timeouts().implicitlyWait(Duration.of(10, ChronoUnit.SECONDS));
        assertThat(chromeDriver.getTitle()).isEqualTo("Comunidad MeT - Buscar con Google");
    }
}
