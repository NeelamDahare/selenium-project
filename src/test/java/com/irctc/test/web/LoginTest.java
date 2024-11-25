package com.irctc.test.web;

import com.irctc.action.web.LoginPage;
import common.BaseClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest extends BaseClass {
    LoginPage loginPage;

    @BeforeClass
    public void setLoginPage(){
        // Initialize the LoginPage with the driver from BaseClass
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 1)
    public void loginWithValidCreadenntials(){
        loginPage.setOrigin("BHOPAL  JN - BPL");
        loginPage.setDestination("INDORE JN BG - INDB");
        //driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        loginPage.clickOnSearchButton();
    }


//  @Test(priority = 2)
//  public void verifyHomePage(){
//
//
//  }
}
