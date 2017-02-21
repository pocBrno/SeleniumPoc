package KBCSharedServices;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutUs {
    private WebDriver driver;


    @FindBy(xpath = "//a[contains(@href, 'https://www.kbc.com/')]")
    public WebElement aboutUs_link_KBCSite;



    public AboutUs(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
