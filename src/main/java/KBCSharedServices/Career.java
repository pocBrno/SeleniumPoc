package KBCSharedServices;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Career {
    private WebDriver driver;

    @FindBy(xpath = "//div[contains(@class, 'job_title')]/h3[contains(text(),'Custody Ninja')]")
    public WebElement career_careerTile_CustodyNinja;

    @FindBy(xpath = "//div[contains(@class, 'job_title')][1]")
    public WebElement career_careerTile_First;

    @FindBy(xpath = "//div[contains(@class, 'job_relationship')]/span[contains(text(), 'part-time')][1]")
    public WebElement career_careerTile_PartTime;

    @FindBy(xpath = "//section[contains(@id, 'vacancy_description')]/span[contains(text(), 'part-time')]")
    public WebElement career_detail_PartTime;

    @FindBy(xpath = "//section[contains(@id, 'vacancy_title')]//h1")
    public WebElement career_detail_careerTitle;

    public Career(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
