package KBCSharedServices;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;


    @FindBy(xpath = "//div[contains(@id, 'title')]/h1")
    public WebElement mainPage_title;

    @FindBy (xpath = "//menu/menuitem[1]")
    public WebElement mainPage_menu_main;

    @FindBy (xpath = "//menu/menuitem[2]")
    public WebElement mainPage_menu_aboutUs;

    @FindBy (xpath = "//menu/menuitem[3]")
    public WebElement mainPage_menu_career;

    @FindBy (xpath = "//menu/menuitem[4]")
    public WebElement mainPage_menu_contact;

    @FindBy (xpath = "//menuitem/a[contains(@class, 'active')]")
    public WebElement mainPage_menu_active;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
