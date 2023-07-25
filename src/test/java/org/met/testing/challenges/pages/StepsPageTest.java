package org.met.testing.challenges.pages;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StepsPageTest {

    FormPage test = new FormPage();

    @Test
    @Order(value = 1)
    public void navigateToPage() {
        test.navigateToPage();
    }

    @Test
    @Order(value = 2)
    public void fillForm() {
        test.fillForm();
    }

    @AfterAll
    public static void cleanDriver(){
        BasePage.CloseBrowser();
    }
}
