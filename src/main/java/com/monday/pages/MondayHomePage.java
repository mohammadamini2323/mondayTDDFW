package com.monday.pages;

import com.monday.enums.WaitStrategy;
import com.monday.utilities.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MondayHomePage {
    WebDriver driver;
    @FindBy(xpath ="span.PHBU1")
    WebElement mondayText;
    public MondayHomePage(WebDriver driver){
        this.driver=driver;
    }
    public void getMondayText(){
       WaitUtils.applyFluentWait(driver,mondayText);
        System.out.println("yes");

    }

}
