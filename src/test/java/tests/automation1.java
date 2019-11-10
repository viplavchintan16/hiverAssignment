package tests;

import Pages.CartPageFlipkart;
import Pages.FlipkartHomePage;
import Pages.ProfilePageFlipkart;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class automation1 extends TestBase{
    @Test(priority = 0)
    public void init() throws Exception{
        driver.get("https://www.flipkart.com");
        FlipkartHomePage homePage = PageFactory.initElements(driver,FlipkartHomePage.class);
        homePage.closeLogin();
        homePage.clickonElectronics();
        homePage.clickonSamsung();
        homePage.clickonfirstphone();
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        ProfilePageFlipkart profilepage =PageFactory.initElements(driver,ProfilePageFlipkart.class);
        profilepage.clickonAdd();
        CartPageFlipkart cartPage = PageFactory.initElements(driver,CartPageFlipkart.class);
        cartPage.clickonaddqty();
        if (cartPage.PriceinCart==profilepage.PriceinProfile*2){
            System.out.println("Price is equal");
        }else{
            System.out.println("Price is not equal");
        }
        cartPage.VerifyPrice();
        closeBrowser();
    }
    public void closeBrowser(){
        driver.quit();
    }
}
