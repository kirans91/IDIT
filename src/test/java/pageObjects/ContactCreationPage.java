package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactCreationPage extends BasePage {

    public ContactCreationPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath="//li[@class='top-menu']//a[@id='NewMainMenu']")
    WebElement newButton;

    @FindBy(xpath="//a[@id='NewContactNewGenFromMenu_Link']")
    WebElement newContactButton;

    @FindBy(xpath="//input[@id='LastName']")
    WebElement lastCompanyName;

    @FindBy(xpath="//input[contains(@id,'houseNr') and not(@disabled)]")
    WebElement houseNumber;

    @FindBy(xpath="//input[contains(@id,'streetName') and not(@disabled)]")
    WebElement streetName;

    @FindBy(xpath="//input[contains(@id,'zipCode') and not(@disabled)]")
    WebElement postCode;

    @FindBy(xpath="//input[contains(@id,'cityName') and not(@disabled)]")
    WebElement city;

    @FindBy(xpath="//button[@id='Finish']")
    WebElement FinishButton;

    @FindBy(xpath="//button[@id='Ok']")
    WebElement contactOkButton;


    public void clickNew(){
        newButton.click();
    }

    public void clickNewContact(){
        newContactButton.click();
    }

    public void setLastCompanyName(String lastCompName){
        lastCompanyName.sendKeys(lastCompName);
    }

    public void setHouseNumber(String houseNo){
        waitForElementEnabled(houseNumber);
        typeText(houseNumber, houseNo);
    }

    public void setStreetName(String stName){
        waitForElementEnabled(streetName);
        typeText(streetName,stName);
    }

    public void setPostCode(String poCode){
        waitForElementEnabled(postCode);
        typeText(postCode,poCode);
    }

    public void setCity(String conCity){
        waitForElementEnabled(city);
        typeText(city,conCity);
    }

    public void conFinish(){
        FinishButton.click();
    }

    public void setContactOkButton(){
        contactOkButton.click();
    }


}
