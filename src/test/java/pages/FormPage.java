package pages;

import org.openqa.selenium.By;

public class FormPage extends BasePage { 

    private String name = "(//input[@id=\"wsf-1-field-45\"])";
    private String lastname ="//input[@id=\"wsf-1-field-46\"]";
    private String email = "(//input[@id='wsf-1-field-47'])";
    private String phone = "(//input[@id='wsf-1-field-48'])";
    private String adress = "//textarea[@id='wsf-1-field-49']";
    By submit = By.id("wsf-1-field-52");
    By radioButton1 = By.xpath("//div[@class='wsf-tile wsf-field-wrapper']//input[@value='CypressIO']");
    By radioButton2 = By.id("wsf-1-label-51-row-2");
    By phytonButton = By.id("wsf-1-label-50-row-2");
    By phpButton = By.id("wsf-1-label-50-row-1");


    public FormPage() {

    super(driver);
    }

    public void navigateToPage(){
        navigateTo("https://testingqarvn.com.es/combobox/");
    }
    public void fillForm() {
        System.out.println("ejecutando fill");

        write(name, "Valentina");
        write(lastname,"Bianchi");
        write(email, "valentinabinachik");
        write(phone, "2213508669");
        write(adress, "curuzu cuatia");
    
    }

    public void clickLenguage(){
        click(phytonButton);
    }
    
    public void clickRadio(){
        click(radioButton1);
        click(radioButton2);

    }

    public void clickButton(){
        click(submit);
    }

}




