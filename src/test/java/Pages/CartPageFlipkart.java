package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CartPageFlipkart {
    WebDriver driver;
    public Integer PriceinCart = 0;
    public CartPageFlipkart(WebDriver driver){
        this.driver=driver;
    }
    @FindBy(how= How.XPATH,using="//div//button[@class=\"wNrY5O\"][2]")
    WebElement AddQuantity;
    @FindBy(how=How.XPATH,using="//span[@class=\"pMSy0p XU9vZa\"]")
    WebElement Price;
    public void clickonaddqty() throws InterruptedException {
        Thread.sleep(2000);
        AddQuantity.click();
    }
    public Integer VerifyPrice() throws InterruptedException {
        Thread.sleep(5000);
        String AmounttobePaid = Price.getText();
        String tempAmount = AmounttobePaid.replaceAll("[^0-9]","").trim();
        System.out.println(tempAmount);
        Integer AmountinInt = Integer.parseInt(tempAmount);
        System.out.println(AmountinInt);
        System.out.println("Price to be Paid by Customer : " + AmountinInt);
        PriceinCart = AmountinInt;
        return AmountinInt;

    }

}
