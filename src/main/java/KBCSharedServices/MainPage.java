package KBCSharedServices;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by brnot on 20.02.2017.
 */
public class MainPage {

    private WebDriver driver;


    @FindBy(xpath = "//div[contains(@id, 'title')]/h1")
    public WebElement mainPage_title;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
