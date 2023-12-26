package com.PackA;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Case1 {
	WebDriver dr;
    @FindBy(how = How.XPATH, using = "//h2[text()='Register']")
    WebElement pageTitle;

    @FindBy(how = How.XPATH,using = "//input[@placeholder='First Name']")
    WebElement firstName;

    @FindBy(how = How.XPATH,using = "//input[@placeholder='Last Name']")
    WebElement lastName;

    @FindBy(how = How.XPATH,using = "//div[@class='col-md-8 col-xs-8 col-sm-8']/textarea")
    WebElement address;

    @FindBy(how=How.XPATH,using = "//div[@id='eid']/input")
    WebElement emailID;

    @FindBy(how = How.XPATH,using ="//input[@type='tel']")
    WebElement phone;

    @FindBy(how = How.XPATH,using = "//input[@value='FeMale']")
    WebElement gender;

    @FindBy(how =How.ID,using = "checkbox2")
    WebElement hobbies;

    @FindBy(how =How.ID,using = "msdd")
    WebElement language;

    @FindBy(how =How.ID,using  = "Skills")
    WebElement skills;

    @FindBy(how =How.ID,using = "yearbox")
    WebElement yearOfBirth;

    @FindBy(how = How.XPATH,using = "//select[@placeholder='Month']")
    WebElement monthOfBirth;

    @FindBy(how =How.ID,using  = "daybox")
    WebElement dayOfBirth;

    @FindBy(how =How.ID,using= "firstpassword")
    WebElement password;

    @FindBy(how =How.ID,using = "secondpassword")
    WebElement confirmPassword;

    @FindBy(how = How.XPATH,using = "//span[@role ='combobox']")
    WebElement countryComboBox;

    @FindBy(how = How.XPATH,using = "//input[@type='search']")
    WebElement selectCountry;

    @FindBy(how =How.ID,using = "submitbtn")
    WebElement submitButton;

 

    
    public Case1(WebDriver dr) {
        this .dr = dr;
        PageFactory.initElements(dr, this);
    }
    public void setNames(String strFirstName,String strLastName) {
        firstName.sendKeys(strFirstName);
        lastName.sendKeys(strLastName);
    }

 

    
    public void adressEmailMobile(String a,String b,String c) {
        // TODO Auto-generated method stub
        address.sendKeys(a);
        emailID.sendKeys(b);
        phone.sendKeys(c);
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor)dr;
        js.executeScript("window.scrollBy(0,300)");
    }
    public void radioButton() {
        // TODO Auto-generated method stub
        gender.click();
    }
    public void checkBox() {
        hobbies.click();
    }
    public void multiselect(String i) {
        language.click();
        List<WebElement> li = dr.findElements(By.xpath("//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']/li"));
        for(WebElement e:li) {
            String s = e.getText();
            if(s.equals(i)) {
                System.out.println(i);
                e.click();
            break;
            }
        }
    }
    public void skillsDropDown(int i) {
        Select s = new Select(skills);
        s.selectByIndex(i);
    }
    public void dob(String a,String b ,String c) {
        Select s1  = new Select(yearOfBirth);
        s1.selectByValue(a);

        Select s2 = new Select(monthOfBirth);
        s2.selectByValue(b);

        Select s3=new Select(dayOfBirth);
        s3.selectByValue(c);
    }

    public void passwords(String p1, String p2) {
        password.sendKeys(p1);
        confirmPassword.sendKeys(p2);
    }
    public void countryComboBox(String country) {
        //selectCountry.click();
        countryComboBox.click();
        WebElement e = selectCountry;
        e.sendKeys(country);
        e.sendKeys(Keys.ENTER);

    }
    public void submitMethod() {
        submitButton.click();
    }

    public void verifyTittle() {
        String s = pageTitle.getText();
        System.out.println(s);
        Assert.assertEquals(s, "Register");
    }
}
