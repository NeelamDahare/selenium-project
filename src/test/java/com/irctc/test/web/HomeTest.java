package com.irctc.test.web;

import com.irctc.action.web.HomePage;
import com.irctc.action.web.LoginPage;
import common.BaseClass;
import common.ExtentReportListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class HomeTest extends BaseClass {
    LoginPage loginPage;
    HomePage homePage;

    @BeforeClass
    public void setHomePage(){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Test(priority = 1)
    public void loginWithValidCreadenntials(){
        loginPage.setOrigin("BHOPAL  JN - BPL");
        loginPage.setDestination("INDORE JN BG - INDB");
        //driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        loginPage.clickOnSearchButton();
    }

    @Test(priority = 2)
    public void sortTrainByDuration(){
        homePage.sortTrainByDuration();
    }

    @Test(priority = 3)
    public  void goToTouristTrain(){
        homePage.goToTouristTrain();
        homePage.verifyMaharajaExpressUrl();
    }
}
