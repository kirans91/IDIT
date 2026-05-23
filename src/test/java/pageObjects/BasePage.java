package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    public void waitForElementEnabled(WebElement element){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(driver->element.isEnabled());
    }

    public void clickElement(WebElement element){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));element.click();
    }

    public void typeText(WebElement element, String value){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll FIRST
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // THEN wait
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        element.clear();
        element.sendKeys(value);
    }
}
