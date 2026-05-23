package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    @DataProvider(name="LoginData")
    public String [][] getData() throws IOException {
        String path=".\\testData\\LoginTests.xlsx";
        ExcelUtilities xlutil=new ExcelUtilities(path);

        int totalrows= xlutil.getRowCount("login");
        int totalcols= xlutil.getCellCount("login",1);

        //System.out.println("Rows : " + totalrows);
        //System.out.println("Cols : " + totalcols);

        String logindata[][]=new String[totalrows][totalcols]; //skip header

        for(int i=1;i<=totalrows;i++){
            for(int j=0;j<totalcols;j++){
                logindata[i-1][j]=xlutil.getCellData("login",i,j); //1,0
            }
        }
        return logindata;
    }

    @DataProvider(name="contactData")
    public String [][] getContactData() throws IOException {
        String path=".\\testData\\LoginTests.xlsx";
        ExcelUtilities xlutil=new ExcelUtilities(path);

        int totalrows= xlutil.getRowCount("contactcreation");
        int totalcols= xlutil.getCellCount("contactcreation",1);

        System.out.println("Rows : " + totalrows);
        System.out.println("Cols : " + totalcols);

        String contactdata[][]=new String[totalrows][totalcols]; //skip header

        for(int i=1;i<=totalrows;i++){
            for(int j=0;j<totalcols;j++){
                contactdata[i-1][j]=xlutil.getCellData("contactcreation",i,j); //1,0
            }
        }
        return contactdata;

    }

    @DataProvider(name="contactSearchData")
    public String [][] getContactSearchData() throws IOException {
        String path=".\\testData\\LoginTests.xlsx";
        ExcelUtilities xlutil=new ExcelUtilities(path);

        int totalrows= xlutil.getRowCount("contactsearch");
        int totalcols= xlutil.getCellCount("contactsearch",1);

        System.out.println("Rows : " + totalrows);
        System.out.println("Cols : " + totalcols);

        String contactsearchData[][]=new String[totalrows][totalcols]; //skip header

        for(int i=1;i<=totalrows;i++){
            for(int j=0;j<totalcols;j++){
                contactsearchData[i-1][j]=xlutil.getCellData("contactsearch",i,j); //1,0
            }
        }
        return contactsearchData;

    }


}
