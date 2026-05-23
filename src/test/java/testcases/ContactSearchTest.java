package testcases;

import org.testng.annotations.Test;
import pageObjects.ContactCreationPage;
import pageObjects.ContactSearchPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class ContactSearchTest extends BaseClass {

    ContactSearchPage cnSearchPage;
    ContactCreationPage cnPage;

    @Test(priority = 1,dataProvider = "contactSearchData",dataProviderClass = DataProviders.class,groups={"Sanity","Regression","Master"})
    public void contactSearch(String legalForm,String LastCompanyName){
        cnSearchPage=new ContactSearchPage(driver);
        cnPage=new ContactCreationPage(driver);

        cnSearchPage.setHomeButton();
        cnSearchPage.setLegalFormDropDown();
        cnSearchPage.selectLegalForm(legalForm);
        cnPage.setLastCompanyName(LastCompanyName);
        cnSearchPage.setFindButton();


    }

}
