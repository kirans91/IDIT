package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import testBase.BaseClass;

import javax.management.Descriptor;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExtentReportManager implements ITestListener {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

    String repName;

    @Override
    public void onStart(ITestContext testContext){
        String timestamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        repName="Test-Report-"+timestamp+ ".html";
        sparkReporter = new ExtentSparkReporter("reports/" + repName);//to specify the location of the report
        sparkReporter.config().setDocumentTitle("Real Estate policy creation Automation Report");
        sparkReporter.config().setReportName("RE policy creation Functional Testing");
        sparkReporter.config().setTheme(Theme.DARK);

        extent=new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Application","IDIT");
        extent.setSystemInfo("Module","Admin");
        extent.setSystemInfo("Sub Module","Contact");
        extent.setSystemInfo("user Name",System.getProperty("user.name"));
        extent.setSystemInfo("Environment","PROD_CIQA");

        String os=testContext.getCurrentXmlTest().getParameter("os");
        extent.setSystemInfo("Operating System",os);

        String browser=testContext.getCurrentXmlTest().getParameter("browser");
        extent.setSystemInfo("Browser",browser);

        List<String> includedGroups=testContext.getCurrentXmlTest().getIncludedGroups();
        if(!includedGroups.isEmpty()){
            extent.setSystemInfo("Groups",includedGroups.toString());
        }
    }

    public void onTestSuccess(ITestResult result){
        test=extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());//to display groups in report
        test.log(Status.PASS,result.getName()+ "got successfully executed");
    }

    public void onTestFailure(ITestResult result){
        test=extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());

        test.log(Status.FAIL,result.getName()+ "got Failed");
        test.log(Status.INFO,result.getThrowable().getMessage());

        try{
            String imgPath=new BaseClass().captureScreenshot(result.getName());
            test.addScreenCaptureFromPath(imgPath);
        }catch(Exception e1){
            e1.printStackTrace();
        }
    }
     public void onTestSkipped(ITestResult result){
         test=extent.createTest(result.getTestClass().getName());
         test.assignCategory(result.getMethod().getGroups());

         test.log(Status.SKIP,result.getName()+ "got skipped");
         test.log(Status.INFO,result.getThrowable().getMessage());

     }
     @Override
     public void onFinish(ITestContext context){
        extent.flush();
         String pathOfExtentReport=System.getProperty("user.dir")+"\\reports\\"+repName;
         File extentReport=new File(pathOfExtentReport);
         try {
             Desktop.getDesktop().browse(extentReport.toURI());
         } catch (IOException e) {
             e.printStackTrace();
         }
     }


}
