package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchResultFlipkart {
    WebDriver driver;
    public SearchResultFlipkart (WebDriver driver){
        this.driver = driver;
    }
    @FindBy(how= How.XPATH,using = "//div[contains(text(),'OnePlus') and contains(text(),'7T') and contains(text(),'Glacier Blue') and contains(text(),'256')]")
    WebElement SearchedPhone;

    public void clickonPhone() throws InterruptedException {
        Thread.sleep(1000);
        SearchedPhone.click();
    }
}
