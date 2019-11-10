package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProfilePageFlipkart {
    WebDriver driver;
    public Integer PriceinProfile= 0;
    public ProfilePageFlipkart(WebDriver driver){
        this.driver=driver;
    }
    @FindBy(how=How.XPATH,using="//div[@class='_1vC4OE _3qQ9m1']")
    WebElement pricetag;
    @FindBy(how= How.XPATH,using="//button[@class=\"_2AkmmA _2Npkh4 _2MWPVK\"]")
    WebElement Addtocart;
    public void clickonAdd() throws InterruptedException {
        Thread.sleep(2000);
        Addtocart.click();
    }
    public Integer getPrice() throws InterruptedException{
        Thread.sleep(2000);
        String ActualAmount = pricetag.getText();
        String tempactualamount=ActualAmount.replaceAll("[^0-9]","").trim();
        Integer AmountinInt = Integer.parseInt(tempactualamount);
        System.out.println(AmountinInt);
        System.out.println("Flipkart Price :" + AmountinInt);
        PriceinProfile = AmountinInt;
        return AmountinInt;

    }
}
