package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.PackA.Case1;

public class TestRegisterPage {
	WebDriver dr;
    Case1 objCase1;
    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
        dr = new EdgeDriver();
        dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        dr.get("https://demo.automationtesting.in/Register.html");
        dr.manage().window().maximize();
    }

    @Test
    public void Register_Page_Test() {
        objCase1 = new Case1(dr);
        ResultSet rs;
        try
        {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/mounika","root","Mounika@2210");
        Statement s= c.createStatement();
        String query = "select * from registrationdetails";
        rs = s.executeQuery(query);
        while(rs.next()) {
            String fname = rs.getString("firstname");
            String lname = rs.getString("lastname");
            objCase1.setNames(fname, lname);
            String ads = rs.getString("address");
            String email = rs.getString("email");
            String mobile = rs.getString("mobile");
            objCase1.adressEmailMobile(ads, email, mobile);
            objCase1.radioButton();
            objCase1.checkBox();
            objCase1.scrollDown();
            String lang = rs.getString("languages");
            objCase1.multiselect(lang);
            int i = rs.getInt("skills");
            objCase1.skillsDropDown(6);
            String country = rs.getString("country");
            objCase1.countryComboBox(country);
            DateFormat monthFormat = new SimpleDateFormat("MMMM");
            String month = monthFormat.format(rs.getDate("dob"));
            DateFormat yearFormat = new SimpleDateFormat("YYYY");
            String year = yearFormat.format(rs.getDate("dob"));
            DateFormat dateFormat = new SimpleDateFormat("dd");
            String date = dateFormat.format(rs.getDate("dob"));
            objCase1.dob(year, month,date );
            String p1 = rs.getString("password");
            String p2 = rs.getString("confirm password");
            objCase1.passwords(p1, p2);
            objCase1.submitMethod();
            //c.close();
        }
        } catch (SQLException |ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @AfterTest
    public void tearDown() {
        dr.close();
    }

}
