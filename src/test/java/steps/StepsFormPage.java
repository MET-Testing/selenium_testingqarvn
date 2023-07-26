package steps;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;

import pages.BasePage;
import pages.FormPage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StepsFormPage {

FormPage test = new FormPage();

@Test
@Order(value=1)
public void navigateToPage(){
    test.navigateToPage();
}

@Test
@Order(value=2)
public void fillForm() {
    test.fillForm();
}

@Test
@Order(value=3)
public void clickLenguage(){
    test.clickLenguage();
}
@Test
@Order(value=4)
public void clickRadio(){
    try {
        assertFalse(test.isSelected(By.id("wsf-1-label-51-row-1")));
        System.out.println("Radio button 1 no está seleccionado.");
    } catch (AssertionError e) {
        System.out.println("Radio button 1 está seleccionado.");
    }

    // Verificar si el radio button 2 está seleccionado
    try {
        assertTrue(test.isSelected(By.id("wsf-1-label-51-row-2")));
        System.out.println("Radio button 2 está seleccionado.");
    } catch (AssertionError e) {
        System.out.println("Radio button 2 no está seleccionado.");
    }
}

@Test
@Order(value=5)
public void clickButton(){
    test.clickButton();
    assertTrue(test.isDisplayed(By.id("ws-form-1")));

    try {
        // Pausa de 6 segundos después de hacer clic en los radio buttons
        Thread.sleep(60000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}

@AfterAll
public static void cleanDriver(){
    BasePage.CloseBrowser();
}
}