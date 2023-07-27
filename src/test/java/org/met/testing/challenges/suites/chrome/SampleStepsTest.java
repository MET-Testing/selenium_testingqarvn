package org.met.testing.challenges.suites.chrome;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.*;
import org.met.testing.challenges.utils.WebElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.met.testing.challenges.utils.ChromeWebDriverUtils.getDriver;
import static org.met.testing.challenges.utils.ChromeWebDriverUtils.quitDriver;
import static org.met.testing.challenges.utils.FixtureUtils.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SampleStepsTest {

    private static WebDriver driver;

    private static JSONObject locators;
    private static JSONObject validSampleValues;

    @BeforeAll
    static void beforeAll() {
        driver = getDriver();

        JSONObject tempJson = map("src/test/resources/fixtures/tests/sample_steps_test.json");
        assertNotNull(tempJson);
        assertTrue(tempJson.containsKey("locators"));
        assertTrue(tempJson.containsKey("values_1"));

        locators = getJSONObject(tempJson, "locators");
        validSampleValues = getJSONObject(tempJson, "values_1");
    }

    @Test
    @Order(value = 1)
    public void navigateToPage() {
        assertDoesNotThrow(() -> driver.get("https://testingqarvn.com.es/combobox/"));
    }

    @Test
    @Order(value = 2)
    public void fillForm() {
        //se presentan 3 formas de hacer lo mismo: 2 usando los métodos creados en el package utils y otra sin utils

        //WebElementUtils.write(WebDriver driver, String xpath, String key)
        assertDoesNotThrow(() -> WebElementUtils.write(driver, getString(locators, "name"), getString(validSampleValues, "name")));
        assertDoesNotThrow(() -> WebElementUtils.write(driver, getString(locators, "lastname"), getString(validSampleValues, "lastname")));

        //WebElementUtils.write(WebElement element, String key)
        assertDoesNotThrow(() -> WebElementUtils.write(driver.findElement(By.xpath(getString(locators, "email"))), getString(validSampleValues, "email")));
        assertDoesNotThrow(() -> WebElementUtils.write(driver.findElement(By.xpath(getString(locators, "phone"))), getString(validSampleValues, "phone")));

        //Sin WebElementUtils
        WebElement addressElement = driver.findElement(By.xpath(getString(locators, "address")));
        assertTrue(addressElement.isDisplayed());
        assertDoesNotThrow(addressElement::clear);
        assertDoesNotThrow(() -> addressElement.sendKeys(getString(validSampleValues, "address")));
    }

    @Test
    @Order(value = 3)
    public void clickElement() {
        //se presentan 3 formas de hacer lo mismo: 2 usando los métodos creados en el package utils y otra sin utils

        //WebElementUtils.waitAndClick(WebDriver driver, String xpath, Duration duration)
        assertDoesNotThrow(() -> WebElementUtils.waitAndClick(driver, getString(locators, "python"), Duration.of(10, ChronoUnit.SECONDS)));

        //WebElementUtils.waitAndClick((WebDriverWait wait, String xpath)
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS));
        assertDoesNotThrow(() -> WebElementUtils.waitAndClick(wait, getString(locators, "cypress")));

        //Sin WebElementUtils
        assertDoesNotThrow(() -> wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(getString(locators, "submit")))).click());
    }

    @AfterAll
    static void afterAll() {
        quitDriver();
    }
}
