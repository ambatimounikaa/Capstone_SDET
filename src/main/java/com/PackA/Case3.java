package com.PackA;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Case3 {
	WebDriver dr;
    String base_Url;

    @FindBy(how=How.TAG_NAME,using="h1")
    WebElement color;

    @FindBy( how = How.XPATH, using="//button[@class='btn btn-info']")
    WebElement window1;

    @FindBy( how = How.XPATH, using="//a[@href='#Seperate']")
    WebElement window2;

    @FindBy( how = How.XPATH,using ="//button[@class='btn btn-primary']")
    WebElement button2;

    @FindBy(how=How.XPATH,using ="//a[@href='#Multiple']")
    WebElement window3;

    @FindBy(how=How.XPATH,using ="//button[@onclick='multiwindow()']")
    WebElement button3;

    public Case3(WebDriver dr) {
        this.dr = dr;
        PageFactory.initElements(dr, this);
    }
    //To verify Parent Window
    public void verifyPage() {
        String title = dr.getTitle();
        System.out.println(title);
        Assert.assertEquals(title, "Frames & windows");
    }

    //To open new tabbed windows
    public void newTabbedWindows() {
        base_Url = dr.getWindowHandle();
        System.out.println("Parent Window ID :"+base_Url);

        window1.click();

        Set<String> base_childID = dr.getWindowHandles();
        System.out.println("All Windows :"+base_childID);
        for(String id:base_childID) {
            if(!base_Url.equals(id)) {
                dr.switchTo().window(id);
                System.out.println(dr.getTitle());
                dr.close();
            }
        }
        dr.switchTo().window(base_Url);
    }
    //to open new separate windows
    public void seperate_windows() {
        base_Url = dr.getWindowHandle();
        window2.click();
        button2.click();

        Set<String> childs = dr.getWindowHandles();
        System.out.println("All Windows : "+childs);
        for(String id:childs) {
            if(!base_Url.equals(id)) {
                dr.switchTo().window(id);
                System.out.println(dr.getTitle());
                dr.close();
            }
        }
        dr.switchTo().window(base_Url);

    }

    //To open multiple windows
    public void multipleWindows() {
        base_Url = dr.getWindowHandle();
        window3.click();
        button3.click();

        Set<String> Cwindows = dr.getWindowHandles();
        System.out.println("All Windows: "+Cwindows);
        for(String id:Cwindows) {
            if(!base_Url.equals(id)) {
                dr.switchTo().window(id);
                System.out.println(dr.getTitle());
                dr.close();
            }
        }
        dr.switchTo().window(base_Url);
    }
}
