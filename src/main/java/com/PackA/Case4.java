package com.PackA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Case4 {
	WebDriver dr;

    @FindBy(how=How.ID,using="singleframe")
    WebElement singleID;

    @FindBy(how=How.XPATH,using="//input[@type='text']")
    WebElement text;

    @FindBy(how=How.XPATH,using="//a[@href = '#Multiple']")
    WebElement frameWithinFrame;

    @FindBy(how=How.XPATH,using="//iframe[@src='MultipleFrames.html']")
    WebElement nestedFrames;

    @FindBy(how=How.XPATH,using="//iframe[@src='SingleFrame.html']")
    WebElement singleInNested;

    @FindBy(how=How.XPATH,using="(//input[@type='text'])[1]")
    WebElement text1;

    public Case4(WebDriver dr) {
        this.dr=dr;
        PageFactory.initElements(dr,this);
    }


    //To get into Single Iframe
    public void singleIFrames(String a) {
        /* 
        //Switching to frames using index
        dr.switchTo().frame(0);
        dr.findElement(By.xpath("//input[@type='text']")).sendKeys("sampling");
        */

        //Switching to frames using id
        dr.switchTo().frame(singleID);
        text.sendKeys(a);
        dr.switchTo().defaultContent();
    }

    //To get into Iframe within an Iframe
    public void multipleFrames(String b) {
        frameWithinFrame.click();
        dr.switchTo().frame(nestedFrames);
        dr.switchTo().frame(singleInNested);
        text1.sendKeys(b);
    }

}
