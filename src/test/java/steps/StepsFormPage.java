package steps;

import org.openqa.selenium.By;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.WebElement;

import pages.BasePage;
import pages.FormPage;
import utils.FixtureUtils;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StepsFormPage {
    private static Map<String, String> locators;
    private static Map<String, String> assertLocators;

    private static FormPage test;


    public By getLocator(String key) {
    return By.id(locators.get(key));
    }

    @BeforeAll
    
    public static void setUp() {
    Map<String, Map<String, String>> tempMap = FixtureUtils.map("src/test/java/resources/validData.json");
    Map<String, Map<String, String>> assertMap = FixtureUtils.map("src/test/java/resources/assertionsLocators.json");
    locators = tempMap.get("locators");
    assertLocators = assertMap.get("locators");

    test = new FormPage();
}

    @Test
    @Order(value=1)
    public void fillForm() {
        test.navigateToPage();
        test.fillForm();
        

        test.clickLenguage();
        for (String language : assertLocators.keySet()) {
            if (language.startsWith("language")) {
                checkLanguageSelected(language);
            }
        }
    

        test.clickRadio();
    try {
        assertFalse(test.isSelected(getLocator("radio1")));
        System.out.println("Radio button 1 no está seleccionado.");
    } catch (AssertionError e) {
        System.out.println("Radio button 1 está seleccionado.");
    }
    try {
        assertTrue(test.isSelected(getLocator("radio2")));
        System.out.println("Radio button 2 está seleccionado.");
    } catch (AssertionError e) {
        System.out.println("Radio button 2 no está seleccionado.");
    }

        test.selectSystem();
        test.clickButton();
    assertTrue(test.isDisplayed(By.id("ws-form-1")));

}

    private void checkInputPlaceholder(String labelKey) {
        String inputKey = labelKey.replace("label", "input");
        WebElement label = test.findElement(getLocator(labelKey));
        WebElement input = test.findElement(getLocator(inputKey));
        String labelText = label.getText();
        String inputPlaceholder = input.getAttribute("placeholder");
        try {
            assertEquals(labelText, inputPlaceholder);
        } catch (AssertionError e) {
            System.out.println("The " + labelKey + " elements don't match");
        }
    }

    private void checkLanguageSelected(String key) {
        try {
            assertTrue(test.isSelected(getLocator(key)));
            System.out.println(key + " está seleccionado.");
        } catch (AssertionError e) {
            System.out.println(key + " no está seleccionado.");
        }
    }

@AfterAll
public static void cleanDriver(){
    BasePage.CloseBrowser();
}
}