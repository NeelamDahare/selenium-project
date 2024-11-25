package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Listeners(ExtentReportListener.class)
public class BaseClass {

    protected WebDriver driver;

    @BeforeTest
    public void Test(){

        //System.setProperty("webdriver.chrome.driver","C:/Users/pooja/Downloads/chromedriver_win32/chromedriver.exe");
        //driver.navigate().to("https://www.irctc.co.in/nget/train-search");
        ChromeOptions options = new ChromeOptions();


        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.irctc.co.in/nget/train-search");

    }

    @AfterTest
    public void  closeBrowser(){
        driver.close();
    }

}
