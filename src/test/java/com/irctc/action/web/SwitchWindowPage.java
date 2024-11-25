package com.irctc.action.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class SwitchWindowPage {
    WebDriver driver;
    Actions actions;

    public SwitchWindowPage(WebDriver driver){
        this.driver = driver;
        this.actions = new Actions(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "(//li[@class='menu-list header-icon-menu ng-star-inserted'])[2]")
    private WebElement irctcEWallet;

    @FindBy(css = "li[class='menu-list header-icon-menu ng-star-inserted']:nth-of-type(5) > ul[class='box-shadow']>li:nth-of-type(1) span[class='list_text']")
    private WebElement aboutIrctcEWallet;

    public void navigateToNewTab(){
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        actions.moveToElement(irctcEWallet).build().perform();
        String currentWindowHandle = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);// open new tab
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        this.aboutIrctcEWallet.click();
        driver.switchTo().window(currentWindowHandle);//Switch back to previous tab
    }
}
