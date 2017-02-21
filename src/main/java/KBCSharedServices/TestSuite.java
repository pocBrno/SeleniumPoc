package KBCSharedServices;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;
import org.testng.reporters.XMLReporter;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * Created by brnot on 20.02.2017.
 */
public class TestSuite {

    WebDriver driver;
    WebElement element;
    HomePage homePage;
    AboutUs aboutUs;
    Career career;
    Contact contact;
    JavascriptExecutor js;


    @BeforeTest
    public void InitTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        js = (JavascriptExecutor)driver;

    }
    @Test
    public void CheckMainPage(){
        homePage = new HomePage(driver);
        driver.get("http://www.kbcsharedservicecenter.cz/");
        assertEquals(homePage.mainPage_title.getText(), "KBC SHARED SERVICE CENTER");
    }

    @Test
    public void CheckActivePage(){
        homePage = new HomePage(driver);
        driver.get("http://www.kbcsharedservicecenter.cz/");

        homePage.mainPage_menu_aboutUs.click();
        assertEquals(homePage.mainPage_menu_active.getText(), "ABOUT US");
    }

    @Test
    public void RedirectFromAboutUSToKBCSite(){
        aboutUs = new AboutUs(driver);
        driver.get("http://www.kbcsharedservicecenter.cz/about");
        js.executeScript("arguments[0].setAttribute('target','_self')", aboutUs.aboutUs_link_KBCSite );
        aboutUs.aboutUs_link_KBCSite.click();

        assertEquals(driver.getCurrentUrl(), "https://www.kbc.com/en");
    }

    @Test
    public void ClickCareerTileByName(){
        career = new Career(driver);
        driver.get("http://www.kbcsharedservicecenter.cz/career");
        career.career_careerTile_CustodyNinja.click();
        career.career_detail_careerTitle.getText();
        assertEquals(career.career_detail_careerTitle.getText(), "CUSTODY NINJA");
    }

    @Test
    public void ClickCareerTileByOrder(){
        career = new Career(driver);
        driver.get("http://www.kbcsharedservicecenter.cz/career");
        career.career_careerTile_First.click();

        assertEquals(career.career_detail_careerTitle.getText(), "ONBOARDING PROJECT MANAGER");
    }

    @Test
    public void ClickCareerTileByRelationship(){
        career = new Career(driver);
        driver.get("http://www.kbcsharedservicecenter.cz/career");
        career.career_careerTile_PartTime.click();

        assertNotNull(career.career_detail_PartTime);
    }

    @Test
    public void CheckContactTitle(){
        contact = new Contact(driver);
        driver.get("http://www.kbcsharedservicecenter.cz/contact");

        assertEquals(contact.contact_title.getText(), "OUR RECRUITMENT TEAM");
    }

    @Test
    public void NavigateFromContactToLinkedIn(){
        contact = new Contact(driver);
        driver.get("http://www.kbcsharedservicecenter.cz/contact");
        js.executeScript("arguments[0].setAttribute('target','_self')", contact.contact_recruiter_LinkedIn );
        contact.contact_recruiter_LinkedIn.click();

        assertEquals(driver.getCurrentUrl(), "https://cz.linkedin.com/in/martinfajkos");
    }

    @Test
    public void NavigateFromContactToFacebook(){
        contact = new Contact(driver);
        driver.get("http://www.kbcsharedservicecenter.cz/contact");
        contact.contact_facebook.click();
        assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/KBCBankEnVerzekering/");
    }

    @AfterTest
    public void CleanUp(){
        driver.quit();
        driver = null;
    }
}
