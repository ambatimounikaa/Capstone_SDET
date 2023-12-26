package test;

 

import java.util.concurrent.TimeUnit;

 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.PackA.Case2;

 

public class TestAlertsPage {
    WebDriver dr;
    Case2 objCase2;
    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
        dr = new EdgeDriver();
        dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        dr.get("https://demo.automationtesting.in/Alerts.html");
        dr.manage().window().maximize();
    }

    //To handle the alerts with Ok button
    @Test
    public void alertsWithOk() {
        objCase2 = new Case2(dr);
        objCase2.handleAlert1();
    }

    //To handle the alerts with Ok & Cancel
    @Test(priority=1)
    public void alertsWithCancel() {
        objCase2 = new Case2(dr);
        objCase2.handleAlert2();
    }
    @DataProvider(name="data-provider")
    public Object[][] dpMethod(){
        return new Object[][] {{"Mounika Ambati "}};
    }


    //To handle the alerts with text box
    @Test(priority=2,dataProvider="data-provider")
    public void alertsWithTextBox(String a) {
        objCase2 = new Case2(dr);
        objCase2.handleAlert3(a);

    }

    //To close the driver after all the test cases are executed
    @AfterTest
    public void tearDown() {
        dr.close();
    }

 

}