package org.met.testing.challenges.suites.chrome;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.met.testing.challenges.utils.ChromeWebDriverUtils.getDriver;
import static org.met.testing.challenges.utils.ChromeWebDriverUtils.quitDriver;

public class SampleFullTest {

    private static final Logger logger = LogManager.getLogger();
    private static WebDriver driver;

    @BeforeAll
    static void beforeAll() {
        driver  = getDriver();
    }

    @DisplayName("Testing google search on Chrome")
    @ParameterizedTest(name = "should get title {1} for key {0} ")
    @MethodSource("searchProvider")
    public void testChromeGoogleSearch(String key, String title) {
        driver.get("https://www.google.com/");

        logger.info("Sample log use. Driver type is [{}], current url is [{}] and current key is [{}]", driver.getClass().getName(), driver.getCurrentUrl(), key);

        WebElement searchBox = driver.findElement(By.name("q"));

        assertTrue(searchBox.isDisplayed());

        searchBox.clear();
        searchBox.sendKeys(key);
        searchBox.submit();

        assertThat(driver.getTitle()).isEqualTo(title);
    }

    @AfterAll
    static void afterAll() {
        quitDriver();
    }

    static Stream<Arguments> searchProvider() {
        return Stream.of(
                Arguments.of("Comunidad MeT", "Comunidad MeT - Buscar con Google"),
                Arguments.of("java + selenium", "java + selenium - Buscar con Google"),
                Arguments.of("google", "google - Buscar con Google")
        );
    }
}