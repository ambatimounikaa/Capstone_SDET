package test;

 

import java.util.concurrent.TimeUnit;

 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.PackA.Case3;

 

public class TestWindowsPage {
    WebDriver dr;
    Case3 objCase3;
    String base_Url;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
        dr = new EdgeDriver();
        dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        dr.get("https://demo.automationtesting.in/Windows.html");
        dr.manage().window().maximize();
        base_Url = dr.getWindowHandle();
    }

    //To test the new tabbed windows
    @Test
    public void testNewTabbedWindows() {
        objCase3 = new Case3(dr);
        objCase3.verifyPage();
        objCase3.newTabbedWindows();
    }

    //To test the seperate windows
    @Test(priority=1)
    public void testSeperateWindows() {
        objCase3 = new Case3(dr);
        objCase3.seperate_windows();

    }

    //To test the multiple windows
    @Test(priority=2)
    public void testMultipleWindows() {
        objCase3 = new Case3(dr);
        objCase3.multipleWindows();

    }

 

    @AfterTest
    public void tearDown() {
        dr.close();
    }

 

}