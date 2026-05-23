package testcases;

import org.testng.annotations.Test;
import pageObjects.ContactCreationPage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class ContactCreationTest extends BaseClass {

    ContactCreationPage conPage;
    LoginPage lgPage;
    @Test(priority = 1,dataProvider = "contactData",dataProviderClass = DataProviders.class,groups={"Sanity","Regression","Master"})
    public void createContact(String LastCompanyName,String HouseNumber, String StreetName, String PostCode, String City ) throws InterruptedException {
        conPage=new ContactCreationPage(driver);
        lgPage=new LoginPage(driver);
        conPage.clickNew();
        conPage.clickNewContact();

        conPage.setLastCompanyName(LastCompanyName);
        //Thread.sleep(5000);
        conPage.setHouseNumber(HouseNumber);
        conPage.setStreetName(StreetName);
        conPage.setPostCode(PostCode);
        conPage.setCity(City);
        conPage.conFinish();
        conPage.setContactOkButton();
        lgPage.setCloseSession();
        lgPage.setSessionButton();
        lgPage.setSessionMsg();

    }

}
