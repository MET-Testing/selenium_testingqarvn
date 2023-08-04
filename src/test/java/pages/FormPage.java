package pages;


import org.openqa.selenium.By;

public class FormPage extends BasePage { 

    private String name = "(//input[@id=\"wsf-1-field-54\"])";
    private String lastname ="//input[@id=\"wsf-1-field-55\"]";
    private String email = "(//input[@id='wsf-1-field-56'])";
    private String phone = "(//input[@id='wsf-1-field-57'])";
    private String adress = "//textarea[@id='wsf-1-field-58']";
    By submit = By.id("wsf-1-field-62");
    By radioButton1 = By.xpath("//label[@id='wsf-1-label-60-row-1']");
    By radioButton2 = By.xpath("//label[@id='wsf-1-label-60-row-2']");
    By phytonButton = By.id("wsf-1-label-59-row-2");
    By phpButton = By.id("wsf-1-label-59-row-1");
    By dropdown = By.id("wsf-1-field-61");
    

    public FormPage() {

    super(driver);
    }

    public void navigateToPage(){
        navigateTo("https://testingqarvn.com.es/combobox-dependiente/");
    }
    public void fillForm() {
        System.out.println("ejecutando fill");

        write(name, "Valentina");
        write(lastname,"Bianchi");
        write(email, "valentinabinachik@gmail.com");
        write(phone, "2213508669");
        write(adress, "curuzu cuatia");
    
    }

    public void clickLenguage(){
        click(phytonButton);
        click(phpButton);

    }
    
    public void clickRadio(){
        click(radioButton1);
        click(radioButton2);

    }

    public void selectSystem(){
        selectFromDropdownByVisibleText(dropdown, "Linux");

    }

    public void clickButton(){
        click(submit);
        
    }

    
}




