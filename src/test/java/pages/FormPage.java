package pages;


public class FormPage extends BasePage {

    private String name = "(//input[@placeholder='Nombre:'])[1]";
    private String lastname ="(//input[@name='field_46'])";
    private String email = "(//input[@id='wsf-1-field-47'])";
    private String phone = "(//input[@id='wsf-1-field-48'])";
    private String adress = "(//input[@id='wsf-1-field-49'])";
    private String submit = "(//button[@id='wsf-1-field-52'])";
    private String radioButton = "(//*[@value='CypressIO'])";
    private String phytonButton = "(//*[@value='PYTHON'])";
    

    public FormPage() {

    super(driver);
    }

    public void navigateToPage(){
        navigateTo("https://testingqarvn.com.es/combobox/");
    }
    public void fillForm() {
        
        write(name, "Valentina");
        write(lastname,"Bianchi");
        write(email, "valentinabinachik");
        
    }

    public void clickLenguage(){
        clickElement(phytonButton);
    }
    
    public void clickRadio(){
        clickElement(radioButton);
    }


    public void clickButton(){
        clickElement(submit);
    }

}




