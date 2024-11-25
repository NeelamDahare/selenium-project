package com.irctc.action.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    By from = By.cssSelector("p-autocomplete[id='origin'] input[aria-autocomplete='list']");
    By to = By.cssSelector("p-autocomplete[id='destination'] input[aria-autocomplete='list']");
    By selectFirstElement = By.cssSelector("li[class*='ng-tns-c']:nth-of-type(2)");
    By generalDropDown = By.cssSelector("p-dropdown[id='journeyQuota'] > div[class*='ng-tns-c']");
    By searchButton = By.cssSelector("button[class='search_btn train_Search']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    //Set origin name in textbox
    public  void setOrigin(String originName){
        driver.findElement(from).sendKeys(originName);
    }

    //Set destination name in textbox
    public  void setDestination(String destinationName){
        driver.findElement(to).sendKeys(destinationName);
    }

    //Search train
    public  void clickOnSearchButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton));
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        driver.findElement(searchButton).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(searchButton));
    }

}
