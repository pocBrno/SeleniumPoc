package KBCSharedServices;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



/**
 * Created by brnot on 20.02.2017.
 */
public class TestSuite {

    WebDriver driver;
    WebElement element;
    MainPage mainPage;

    @BeforeTest
    public void InitTest(){
        driver = new ChromeDriver();
        driver.get("http://www.kbcsharedservicecenter.cz/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void FirstTimeRun(){
        mainPage = new MainPage(driver);
        assertEquals(mainPage.mainPage_title.getText(), "KBC SHARED SERVICE CENTER");


    }

/*    @AfterTest
    public void CleanUp(){
        driver.quit();
        driver = null;
    }*/
}
