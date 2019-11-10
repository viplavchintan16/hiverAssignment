package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FlipkartHomePage {
    WebDriver driver;
    public FlipkartHomePage(WebDriver driver){
        this.driver=driver;
    }
    @FindBy(how=How.XPATH,using = "//button[contains(text(),\"✕\")]")
    WebElement closeLoginModal;
    @FindBy(how = How.XPATH,using="//span[contains(text(),\"Electronics\")]")
    WebElement Electronics;
    @FindBy(how = How.XPATH,using="//a[@title=\"Samsung\" and contains(@href,'/samsung-mobile-store')]")
    WebElement Samsung;
    @FindBy(how = How.XPATH,using="//div[@data-tracking-id=\"Latest Samsung mobiles \" ]/div/div/div/div[1]")
    WebElement firstPhone;
    @FindBy(how = How.XPATH,using ="//input[@name='q']")
    WebElement SearchBox;
    @FindBy(how = How.XPATH,using = "//button[@class='vh79eN']")
    WebElement searchicon;
    public void closeLogin(){
        closeLoginModal.click();
    }
    public void clickonElectronics(){
        Electronics.click();
    }
    public void clickonSamsung(){
        Samsung.click();
    }
    public void clickonfirstphone(){
        firstPhone.click();
    }
    public void setSearchBox(String Search){
        SearchBox.sendKeys(Search);
    }
    public void clickonsearchicon(){
        searchicon.click();
    }
}


