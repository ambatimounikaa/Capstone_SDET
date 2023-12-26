package test;

 

import java.text.ParseException;

import java.util.concurrent.TimeUnit;

 

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import com.PackA.Case5;


 

public class TestDatePickerPage {

WebDriver dr;

Case5 objCase5;

 

    

    @BeforeTest

    public void setup() {

        System.setProperty("webdriver.edge.driver", "msedgedriver.exe");

        dr = new EdgeDriver();

        dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        dr.get("https://demo.automationtesting.in/Datepicker.html");

        dr.manage().window().maximize();

    }

    @Test

    public void Datepicker_Enabled() {

        objCase5 = new Case5(dr);

        objCase5.datepicker_enabled("22/10/1999");


    }

    @Test(priority=1)

    public void Datepicker_Disabled() throws ParseException {

        objCase5 = new Case5(dr);

        objCase5.datepicker_disabled("22/10/1999");


    }


    @AfterTest

    public void tearDown() {

        dr.close();

    }

}
