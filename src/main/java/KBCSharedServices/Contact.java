package KBCSharedServices;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contact {
    private WebDriver driver;

    @FindBy(xpath = "//section[contains(@id, 'section1')]//h1")
    public WebElement contact_title;

    @FindBy(xpath = "//div[contains(@id, 'facebook')]")
    public WebElement contact_facebook;

    @FindBy(xpath = "//div[contains(@class, 'recruiter')][3]//a")
    public WebElement contact_recruiter_LinkedIn;

    public Contact(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
