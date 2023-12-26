package test;

 

import java.util.concurrent.TimeUnit;

 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.PackA.Case4;

 


 

public class TestFramesPage {
    WebDriver dr;
    Case4 objCase4;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
        dr = new EdgeDriver();
        dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        dr.get("https://demo.automationtesting.in/Frames.html");
        dr.manage().window().maximize();
    }
    @DataProvider(name="data-provider")
    public Object[][] dpMethod(){
        return new Object[][] {{"Mounika"}};
    }
    /*@DataProvider(name="data-provider1")
    public Object[][] dpMethod1(){
        return new Object[][] {{"Ambati"}};
    }*/

    //To Test Single Iframes
    @Test(dataProvider="data-provider")
    public void testSingleIframe(String a) {
        objCase4 = new Case4(dr);
        objCase4.singleIFrames(a);
        System.out.println("Done with Single Iframe");
    }

    //To Test Iframe with in an Iframe
    @Test(priority=1 ,dataProvider="data-provider")
    public void testFrameWithInFrame(String b) {
        objCase4 = new Case4(dr);
        objCase4.multipleFrames(b);
        System.out.println("Done with Iframe within an Iframe");
    }

    @AfterTest
    public void tearDown() {
        dr.close();
    }

 

}