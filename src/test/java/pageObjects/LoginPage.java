package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath="//input[@id='UserName']")
    WebElement logintext;

    @FindBy(xpath="//input[@id='Password']")
    WebElement pwdtext;

    @FindBy(xpath="//button[@class='login-button']")
    WebElement loginbutton;

    @FindBy(xpath="//div[@id='contextBar']//b")
    WebElement loginConfirmation;

    @FindBy(xpath="//button[@class='mainMenuItemArrow']")
    WebElement closeSessionButton;

    @FindBy(xpath="//a[@id='pagesCloseAllMainMenu']//i[@class='fa fa-trash-can']")
    WebElement sessionButton;

    @FindBy(xpath="//div[@class='ui-dialog-buttonset']//button[2]")
    WebElement sessionConfirmation;




    public void setloginUser(String name){
        logintext.clear();
        logintext.sendKeys(name);
    }

    public void setpwduser(String pwd){
        pwdtext.clear();
        pwdtext.sendKeys(pwd);
    }

    public void logbutton(){
        loginbutton.click();
    }

    public String getConfirmationpage(){
        try {
            return loginConfirmation.getText();
        }catch(Exception e){
            return (e.getMessage());
        }
    }

    public void setCloseSession(){
        closeSessionButton.click();
    }

    public void setSessionButton(){
        sessionButton.click();
    }

    public void setSessionMsg(){
        sessionConfirmation.click();
    }



}
