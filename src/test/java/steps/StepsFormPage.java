package steps;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import pages.BasePage;
import pages.FormPage;

public class StepsFormPage {

FormPage test = new FormPage();

@Test
public void navigateToPage(){
    test.navigateToPage();
}

@Test
public void fillForm() {
    test.fillForm();
}

@Test
public void clickLenguage(){
    test.clickLenguage();
}
@Test
public void clickRadio(){
    test.clickRadio();
}

@Test
public void clickButton(){
    test.clickButton();
}

@AfterAll
public static void cleanDriver(){
    BasePage.CloseBrowser();
}
}