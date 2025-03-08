package com.monday.pages;

import com.monday.enums.WaitStrategy;
import com.monday.utilities.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchedForMondayPage {
    WebDriver driver;
   @FindBy(xpath = "//a[@href='https://auth.monday.com/login']")
   // @FindBy(xpath = "//div[@class='p4wth']")
    public WebElement loginLink;
    public SearchedForMondayPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void clickOnMondayLink(){
        WaitUtils.applyWait(driver,loginLink, WaitStrategy.CLICKABLE).click();
        WaitUtils.applyGlobalWait();
    }


}
