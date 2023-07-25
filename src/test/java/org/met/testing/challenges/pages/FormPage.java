package org.met.testing.challenges.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FormPage extends BasePage {

    public String name = "//input[@id='wsf-1-field-45']";
    public String lastname = "//input[@id='wsf-1-field-46']";
    public String email = "//input[@id='wsf-1-field-47']";
    public String phone = "//input[@id='wsf-1-field-48']";
    public String adress = "//input[@id='wsf-1-field-49']";


    public FormPage() {
        super(driver);
    }


    public void navigateToPage() {
        navigateTo("https://testingqarvn.com.es/combobox/");
    }

    public void fillForm() {
            System.out.println("ejecutando fill");

            write(name, "Valentina");
            write(lastname, "Bianchi");
            write(email, "valen@gmail.com");
            write(phone, "2213508669");
            //write(adress, "curuzu cuatia 2316");
    }
}
