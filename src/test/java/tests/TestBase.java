package tests;


import Utils.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver = null;

    @BeforeSuite
    public void intialize() throws IOException{
        //System.out.println(Utilities.ChromeBasePath + "\\src\\test\\java\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",
                Utilities.ChromeBasePath);
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //driver.get("https://www.google.com");
    }
    @AfterSuite
    public void TeardownTest(){
        TestBase.driver.quit();
    }

}
