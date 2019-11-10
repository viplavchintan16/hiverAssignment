package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AmazonHomepage {
    WebDriver driver;
    public AmazonHomepage(WebDriver driver){
        this.driver = driver;
    }
    @FindBy(how= How.XPATH,using="//input[@id='twotabsearchtextbox']")
    WebElement SearchBox;
    @FindBy(how = How.XPATH,using = "//div[@class='nav-search-submit nav-sprite']")
    WebElement Searchicon;

    public void setSearchBox(String Search){
        SearchBox.sendKeys(Search);
    }
    public void clickonSearch(){
        Searchicon.click();
    }

}
