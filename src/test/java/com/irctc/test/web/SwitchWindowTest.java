package com.irctc.test.web;

import com.irctc.action.web.SwitchWindowPage;
import common.BaseClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SwitchWindowTest extends BaseClass {
    SwitchWindowPage switchWindowPage;

   @BeforeClass
   public void setSwitchWindowPage(){
    switchWindowPage = new SwitchWindowPage(driver);
   }

   @Test(priority = 1)
    public void switchToAboutEWalletPage(){
     switchWindowPage.navigateToNewTab();
  }
}
