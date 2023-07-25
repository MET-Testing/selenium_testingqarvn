package org.met.testing.challenges.pages;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class SampleGoogleSearchTest {

    @Test
    public void testGooglePage() {
        BasePage.navigateTo("https://www.google.com/");

        WebElement searchBox = BasePage.driver.findElement(By.name("q"));
        searchBox.clear();
        searchBox.sendKeys("Comunidad MeT");
        searchBox.submit();
        assertThat(BasePage.driver.getTitle()).isEqualTo("Comunidad MeT - Buscar con Google");

        BasePage.CloseBrowser();
    }
}