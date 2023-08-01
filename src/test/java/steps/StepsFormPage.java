package steps;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
WebElement labelName = test.findElement(By.id("wsf-1-label-54"));
WebElement inputName = test.findElement(By.id("wsf-1-field-54"));
String labelTextName = labelName.getText();
String inputPlaceholderName = inputName.getAttribute("placeholder");
try{
assertEquals(labelTextName, inputPlaceholderName);
    } catch (AssertionError e) {
        System.out.println("The Name elements dont match");
    }
WebElement labelLastname = test.findElement(By.id("wsf-1-label-55"));
WebElement inputLastName = test.findElement(By.id("wsf-1-field-55"));
String labelTextLastname = labelLastname.getText();
String inputPlaceholderLastname = inputLastName.getAttribute("placeholder");
try{
assertEquals(labelTextLastname, inputPlaceholderLastname);
    } catch (AssertionError a) {
        System.out.println("The Lastname elements dont match");
    }
WebElement labelEmail = test.findElement(By.id("wsf-1-label-56"));
WebElement inputEmail = test.findElement(By.id("wsf-1-field-56"));
String labelTextEmail = labelEmail.getText();
String inputPlaceholderEmail = inputEmail.getAttribute("placeholder");
try {
    assertEquals(labelTextEmail, inputPlaceholderEmail);
    } catch (AssertionError b) {
        System.out.println("The Email elements dont match");
    }
WebElement labelPhone = test.findElement(By.id("wsf-1-label-57"));
WebElement inputPhone = test.findElement(By.id("wsf-1-field-57"));
String labelTextPhone = labelPhone.getText();
String inputPlaceholderPhone = inputPhone.getAttribute("placeholder");
try {
    assertEquals(labelTextPhone, inputPlaceholderPhone);
    } catch (AssertionError c) {
        System.out.println("The Phone elements dont match");
    }
WebElement labelAdress = test.findElement(By.id("wsf-1-label-58"));
WebElement inputAdress = test.findElement(By.id("wsf-1-field-58"));
String labelTextAdress = labelAdress.getText();
String inputPlaceholderAdress = inputAdress.getAttribute("placeholder");
try {
    assertEquals(labelTextAdress, inputPlaceholderAdress);
    } catch (AssertionError d) {
        System.out.println("The Adress elements dont match");
    }
}

@Test
@Order(value=3)
public void clickLenguage(){
    test.clickLenguage();
    try {
        assertTrue(test.isSelected(By.id("wsf-1-field-59-row-1")));
        System.out.println("Phyton está seleccionado.");
    } catch (AssertionError e) {
        System.out.println("Phyton no está seleccionado.");
    }
    try {
        assertTrue(test.isSelected(By.id("wsf-1-field-59-row-2")));
        System.out.println("PHP está seleccionado.");
    } catch (AssertionError e) {
        System.out.println("PHP no está seleccionado.");
    }
}

@Test
@Order(value=4)
public void clickRadio(){
    test.clickRadio();
    try {
        assertFalse(test.isSelected(By.xpath("//input[@id='wsf-1-field-60-row-1']")));
        System.out.println("Radio button 1 no está seleccionado.");
    } catch (AssertionError e) {
        System.out.println("Radio button 1 está seleccionado.");
    }
    try {
        assertTrue(test.isSelected(By.xpath("//input[@id='wsf-1-field-60-row-2']")));
        System.out.println("Radio button 2 está seleccionado.");
    } catch (AssertionError e) {
        System.out.println("Radio button 2 no está seleccionado.");
    }
}

@Test
@Order(value=5)
public void selectSystem(){
    test.selectSystem();
}

@Test
@Order(value=6)
public void clickButton(){
    test.clickButton();
    assertTrue(test.isDisplayed(By.id("ws-form-1")));
}

@AfterAll
public static void cleanDriver(){
    BasePage.CloseBrowser();
}
}