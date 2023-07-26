package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

 protected static WebDriver driver;
    private static WebDriverWait wait;

    static {
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    
    }

    public static void navigateTo(String url){
        driver.get(url);
    }

    public static void CloseBrowser(){
        driver.quit();
    }

    public WebElement findElement(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public void write(String locator, String textToWrite){
        WebElement element = driver.findElement(By.xpath(locator));
        element.clear();
        element.sendKeys(textToWrite);
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public void type (String inputText, By locator){
        driver.findElement(locator).sendKeys(inputText);
    }

    public Boolean isDisplayed(By locator){
        try{
            return driver.findElement(locator).isDisplayed();
        } catch(org.openqa.selenium.NoSuchElementException e) {
            return false;
            }
    }

    public Boolean isEnabled(By locator){
        try{
            return driver.findElement(locator).isEnabled();
        } catch(org.openqa.selenium.NoSuchElementException e) {
            return false;
            }
    }

    public Boolean isSelected(By locator){
        try{
            return driver.findElement(locator).isSelected();
        } catch(org.openqa.selenium.NoSuchElementException e) {
            return false;
            }
    }

    public int dropDownSize(By Locator) {
        Select dropdown = new Select (findElement(Locator));
        List<WebElement> dropdownOptions = dropdown.getOptions();
        return dropdownOptions.size();
    }

    public void selectFromDropdownByValue(By locator, String valueToSelect){
        Select dropdown = new Select (findElement(locator));
        dropdown.selectByValue(valueToSelect);
    }

    public void selectFromDropdownByVisibleText(By locator, String valueToSelect){
        Select dropdown = new Select (findElement(locator));
        dropdown.selectByVisibleText(valueToSelect);

    }
// el locator es el xpath + row y column que son argumentos así los podemos usar con cualquier valor y no solamente con uno, la parte /table/tbody se usa para todas las tablas y tr es row y td es columna//
    public String getValueFromTable(String locator, int row, int column) {
        String cellINeed = locator + "/table/tbody/tr[" + row + "]/td[" + column + "]";
        By cellLocator = By.xpath(cellINeed);
        return findElement(cellLocator).getText();
    }

}








