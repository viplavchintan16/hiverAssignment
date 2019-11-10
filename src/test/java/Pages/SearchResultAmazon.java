package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchResultAmazon {
    WebDriver driver;
    public Integer PriceAmazon=0;
    public SearchResultAmazon(WebDriver driver){
        this.driver =driver;
    }
    @FindBy(how = How.XPATH,using = "//a//span[contains(text(),'OnePlus') and contains(text(),'7T') and contains(text(),'Glacier Blue') and contains(text(),'256')]")
    WebElement SearchedPhone;
    @FindBy(how =How.XPATH,using = "//span[@id='priceblock_ourprice']")
    WebElement AmazonPrice;

    public boolean clickonPhone(){
        if (driver.findElements(By.xpath("//a//span[contains(text(),'OnePlus') and contains(text(),'7T') and contains(text(),'Glacier Blue') and contains(text(),'256')]")).size() > 0) {
            SearchedPhone.click();
            return true;
        }else{

            return false;
        }
    }
    public Integer getAmazonPrice() throws InterruptedException {
        Thread.sleep(1000);
        String PhonePrice = AmazonPrice.getText();
        String tempAmount = PhonePrice.replaceAll("[^0-9\\.]","").trim();
        System.out.println(tempAmount);
        String[] temp = tempAmount.split("\\.");
        Integer AmountinInt = Integer.parseInt(temp[0]);
        System.out.println(AmountinInt);
        System.out.println("AmazonPrice : " + AmountinInt);
        PriceAmazon = AmountinInt;
        return AmountinInt;

    }
}
