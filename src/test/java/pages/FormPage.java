package pages;

import java.util.Map;

import org.openqa.selenium.By;
import utils.FixtureUtils;

public class FormPage extends BasePage {

    // private String name = "(//input[@id=\"wsf-1-field-54\"])";
    // private String lastname ="//input[@id=\"wsf-1-field-55\"]";
    // private String email = "(//input[@id='wsf-1-field-56'])";
    // private String phone = "(//input[@id='wsf-1-field-57'])";
    // private String adress = "//textarea[@id='wsf-1-field-58']";
    By submit = By.id("wsf-1-field-62");
    By radioButton1 = By.xpath("//label[@id='wsf-1-label-60-row-1']");
    By radioButton2 = By.xpath("//label[@id='wsf-1-label-60-row-2']");
    By phytonButton = By.id("wsf-1-label-59-row-2");
    By phpButton = By.id("wsf-1-label-59-row-1");
    By dropdown = By.id("wsf-1-field-61");

    private Map<String, String> locators;
    private Map<String, String> validData;
    private Map<String, String> assertLocators;

    public FormPage() {

        super(driver);
        Map<String, Map<String, String>> tempMap = FixtureUtils.map("src/test/java/resources/validData.json");
        Map<String, Map<String, String>> assertMap = FixtureUtils.map("src/test/java/resources/assertionsLocators.json");
        locators = tempMap.get("locators");
        validData = tempMap.get("values_1");
        assertLocators = assertMap.get("locators");
 
    }

    public By getLocator(String key) {
        return By.id(locators.get(key));
    }

    public void navigateToPage() {
        navigateTo("https://testingqarvn.com.es/combobox-dependiente/");
    }

    public void fillForm() {
        System.out.println("ejecutando fill");

        write(locators.get("name"), validData.get("name"));
        write(locators.get("lastname"), validData.get("lastname"));
        write(locators.get("email"), validData.get("email"));
        write(locators.get("phone"), validData.get("phone"));
        write(locators.get("address"), validData.get("address"));
    }

    public void clickLenguage(){
        click(getLocator("phpButton"));
        click(getLocator("phytonButton"));

    }

    public void clickRadio() {
        click(getLocator("radio1"));
        click(getLocator("radio2"));

    }

    public void selectSystem() {
        selectFromDropdownByVisibleText(dropdown, "Linux");

    }

    public void clickButton() {
        click(submit);

    }

}
