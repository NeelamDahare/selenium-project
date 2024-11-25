package com.irctc.action.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    Actions action;
    public HomePage(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver,this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.action = new Actions(driver);
    }
    @FindBy(css = "button[class*='btnDefault']:nth-of-type(1) > span[class='hidden-xs']")
    private WebElement sortByDuration;
    @FindBy(css = "div[class='pull-left tb-pad text-center ng-star-inserted']:nth-of-type(5) > button[class='btnDefault ng-star-inserted']")
    private WebElement arrivalEarlyFirst;
    @FindBy(css = "a[aria-label='Menu Holiday']")
    private WebElement holidays;
    @FindBy(css = "a[aria-label='Sub Menu of Holiday, Tourist Trains. Having sub menu'] > span[class='list_text']")
    private WebElement touristTrain;

    @FindBy(css = "li[class='menu-list header-icon-menu']:nth-of-type(9) li:nth-of-type(1)>ul[class='child-drop']>li:nth-of-type(2) span[class='list_text']")
    private WebElement maharajaExpress;

    public void sortTrainByDuration(){
        wait.until(ExpectedConditions.visibilityOf(sortByDuration));
        this.sortByDuration.click();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        this.arrivalEarlyFirst.click();
    }

    public  void goToTouristTrain(){
        wait.until(ExpectedConditions.elementToBeClickable(holidays));
        action.moveToElement(holidays).build().perform();
        action.moveToElement(touristTrain).build().perform();
        this.maharajaExpress.click();
    }

    public  void verifyMaharajaExpressUrl(){
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.the-maharajas.com/";
        Assert.assertEquals(currentUrl,expectedUrl,"URL is wrong");
    }

}
