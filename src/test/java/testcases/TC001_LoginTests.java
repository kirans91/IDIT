package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC001_LoginTests extends BaseClass {
    LoginPage page;
    @Test(priority=1,dataProvider = "LoginData",dataProviderClass = DataProviders.class,groups={"Regression","Master"})
    public void verify_login(String username,String password){
        page=new LoginPage(driver);
        page.setloginUser(username);
        page.setpwduser(password);
        page.logbutton();

        String confPageMsg=page.getConfirmationpage();
        Assert.assertEquals(confPageMsg,"Search");
    }

    @Test(priority=2)
    public void close_sessions(){

        page.setCloseSession();
        page.setSessionButton();
        page.setSessionMsg();
    }

}
