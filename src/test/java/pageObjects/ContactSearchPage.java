package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContactSearchPage extends BasePage {

    public ContactSearchPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//a[@id='MainMenuFind_Link']")
    WebElement homeButton;

    @FindBy(xpath="//div[@id='s2id_legalFormID']")
    WebElement legalFormButton;

    @FindBy(xpath="//ul[@id='1select2-results-3']//li")
    List<WebElement> legalFormOptions;

    @FindBy(xpath="//button[@id='selectButtonSearch']")
    WebElement findButton;

    /*
    @FindBy(xpath="//div[@id='showHiedAllFieldsButton']")
    WebElement showAddPlustButton;

    @FindBy(xpath="//fieldset[@id='panel-141461']")
    WebElement contactAdditionalButton; */

    public void setHomeButton(){
        homeButton.click();
    }

    public void setLegalFormDropDown(){
        legalFormButton.click();
    }

    public void selectLegalForm(String value){
        setLegalFormDropDown();

        for(WebElement option : legalFormOptions){
            String text=option.getText();

            if(text.equalsIgnoreCase(value)){
                option.click();
                break;
            }

        }
    }

    public void setFindButton(){
        findButton.click();
    }





}
