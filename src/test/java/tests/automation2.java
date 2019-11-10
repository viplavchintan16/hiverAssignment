package tests;

import Pages.*;
import Utils.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class automation2 extends TestBase {
    private boolean moveforward = false;
    @Test(priority = 1)
    public void init() throws Exception{
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        SearchResultAmazon Searchpage = PageFactory.initElements(driver, SearchResultAmazon.class);

        while (!moveforward) {
            driver.get("https://www.amazon.in");
            AmazonHomepage homePage = PageFactory.initElements(driver, AmazonHomepage.class);
            homePage.setSearchBox(Utilities.TextSearch);

            homePage.clickonSearch();
            Searchpage = PageFactory.initElements(driver, SearchResultAmazon.class);
            moveforward = Searchpage.clickonPhone();

        }
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        Integer amazonPrice = Searchpage.getAmazonPrice();
        driver.get("https://www.flipkart.com");
        FlipkartHomePage flipkartHomePage = PageFactory.initElements(driver,FlipkartHomePage.class);
        flipkartHomePage.closeLogin();
        flipkartHomePage.setSearchBox(Utilities.TextSearch);
        flipkartHomePage.clickonsearchicon();
        SearchResultFlipkart SearchResult = PageFactory.initElements(driver,SearchResultFlipkart.class);
        Thread.sleep(1000);
        SearchResult.clickonPhone();
        ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(2));
        ProfilePageFlipkart profilePage = PageFactory.initElements(driver,ProfilePageFlipkart.class);
        Thread.sleep(1000);
        Integer flipkartPrice = profilePage.getPrice();

        if (amazonPrice>flipkartPrice){
            System.out.println("Flipkart gives Cheaper Rates");
        }else if (flipkartPrice>amazonPrice){
            System.out.println("Amazon gives better Price");
        }else{
            System.out.println("Prices are Equal on both Platform");
        }


    }
}
