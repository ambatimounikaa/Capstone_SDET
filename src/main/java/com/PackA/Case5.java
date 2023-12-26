package com.PackA;

import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Case5 {
	WebDriver dr;

    @FindBy(how =How.ID,using = "datepicker2")
    WebElement e;

    @FindBy(how = How.XPATH,using ="//div[@class='col-xs-1']/img")
    WebElement img;

    @FindBy(how = How.XPATH,using = "//span[@class='ui-datepicker-year']")
    WebElement year;

    @FindBy(how = How.XPATH,using = "//span[@class='ui-datepicker-month']")
    WebElement month;

    @FindBy(how = How.XPATH,using = "//span[@class='ui-icon ui-icon-circle-triangle-w']")
    WebElement pastDate;

    @FindBy(how = How.XPATH,using = "//span[@class='ui-icon ui-icon-circle-triangle-e']")
    WebElement futureDate;

    @FindBy(how = How.XPATH,using = "//table[@class='ui-datepicker-calendar']/tbody/tr")
    List<WebElement> trows;

    @FindBy(how = How.XPATH,using = "//table[@class='ui-datepicker-calendar']/tbody/tr/td/a")
    List<WebElement> tcols;

 

    public Case5(WebDriver dr) {
        this.dr = dr;
        PageFactory.initElements(dr, this);
    }

    //Datepicker enabled
    public void datepicker_enabled(String date) {
        e.sendKeys(date);
    }
    //DatePicker disabled
    public void datepicker_disabled(String inputDate) throws ParseException {
        img.click();
        String a[] = inputDate.split("/");
        boolean flag = true;
        while(flag) {
            //WebElement yr = dr.findElement(By.xpath("//span[@class='ui-datepicker-year']"));
            if(Integer.parseInt(a[2])== (Integer.parseInt(year.getText()))) {
                flag=false;
                boolean flagM = true;
                while(flagM) {
                    flag=false;
                    //WebElement month = dr.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
                    SimpleDateFormat inputFormat = new SimpleDateFormat("MMMM");
                    Calendar cal  = Calendar.getInstance();
                    cal.setTime(inputFormat.parse(month.getText()));
                    SimpleDateFormat outputFormat = new SimpleDateFormat("MM");
                    String monthNum = outputFormat.format(cal.getTime());
                    if(Integer.parseInt(a[0])<10) {
                        a[0]=a[0].replaceFirst("0", "");    
                    }
                    if(Integer.parseInt(a[1])== Integer.parseInt(monthNum)) {
                        flagM=false;
                        //list of rows
                        List<WebElement> rows = trows;
                        for(WebElement e:rows) {
                            List<WebElement> cols = tcols;
                            for(WebElement col:cols) {
                                if(!col.getText().equals("") && !col.getText().equals(" ") && !col.getText().isBlank()) {
                                if(Integer.parseInt(col.getText())==Integer.parseInt(a[0])) {
                                    col.click();
                                    break;
                                }
                                }
                            }
                        }
                    }
                    else if(Integer.parseInt(a[1])<Integer.parseInt(monthNum)) {
                        pastDate.click();

                    }
                    else if(Integer.parseInt(a[1])>Integer.parseInt(monthNum)) {
                        futureDate.click();
                    }
                }
            }
            else if(Integer.parseInt(a[2])< (Integer.parseInt(year.getText()))) {
                pastDate.click();
            }
            else if(Integer.parseInt(a[2])> (Integer.parseInt(year.getText()))) {
                futureDate.click();
            }
        }
    }

}
