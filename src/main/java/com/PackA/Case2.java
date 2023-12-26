package com.PackA;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Case2 {

	WebDriver dr;

	    @FindBy(how = How.XPATH,using =  "//button[@class='btn btn-danger']")
	    WebElement buttonOne;


	    @FindBy(how = How.ID,using = "demo")
	    WebElement alertMessage1;


	    @FindBy(how = How.XPATH,using = "//ul[@class='nav nav-tabs nav-stacked']/li[2]/a")
	    WebElement alertTwo;


	    @FindBy(how = How.CSS,using ="button[class='btn btn-primary']")
	    WebElement buttonTwo;


	    @FindBy(how = How.XPATH,using = "//ul[@class='nav nav-tabs nav-stacked']/li[3]/a")
	    WebElement alertThree;


	    @FindBy(how = How.XPATH,using   = "//button[@class='btn btn-info']")
	    WebElement buttonThree;


	    @FindBy(how = How.ID,using ="demo1")
	    WebElement alertMessage2;


	    public Case2(WebDriver dr) {
	        this.dr=dr;
	        PageFactory.initElements(dr, this);
	    }

	    //for Alert with Ok
	    public void handleAlert1() {
	        buttonOne.click();
	        Alert alert = dr.switchTo().alert();
	        String s= alert.getText();
	        alert.accept();
	        System.out.println(s);
	        Assert.assertEquals(s, "I am an alert box!");
	    }


	    //for Alert with Ok and Cancel
	    public void handleAlert2() {
	        alertTwo.click();
	        buttonTwo.click();
	        Alert alert = dr.switchTo().alert();
	        String s1= alert.getText();
	        alert.dismiss();
	        System.out.println(s1);
	        String s2 = alertMessage1.getText();
	        System.out.println(s2);
	        Assert.assertEquals(s2, "You Pressed Cancel");
	    }


	    //for Alert with TextBox
	    public void handleAlert3(String s) {
	        alertThree.click();
	        buttonThree.click();
	        Alert alert = dr.switchTo().alert();
	        alert.sendKeys(s);
	        alert.accept();
	        String s1 = alertMessage2.getText();
	        System.out.println(s1);
	        Assert.assertEquals(s1, "Hello "+s+"How are you today");
	    }
}
