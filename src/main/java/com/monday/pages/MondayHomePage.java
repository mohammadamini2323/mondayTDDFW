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
    @FindBy(xpath ="//div[@data-testid='topbar-notifications']")
    WebElement notificationIcon;
      @FindBy(xpath ="//div[@data-testid='topbar-inbox']")
    WebElement iboxIcon;
      @FindBy(xpath ="//div[@data-testid='topbar-invite-members']")
    WebElement iviteMemberIcon;
      @FindBy(xpath ="//div[@data-testid='topbar-apps']")
    WebElement puzzelAppsIcon;
      @FindBy(xpath ="//div[@data-testid='topbar-search-everything']")
    WebElement searchIcon;
    ////button[@aria-label='Search everything']
      @FindBy(xpath ="//button[@aria-label='Search everything']")
    WebElement searchIcon;
     ////span[@class='referenceWrapper_08111980c8']/child::button[@aria-label='Close']
     @FindBy(xpath ="//span[@class='referenceWrapper_08111980c8']/child::button[@aria-label='Close']")
    WebElement closeNotificationAlert;
    ////button[@aria-label='Help']
      @FindBy(xpath ="//button[@aria-label='Help']")
    WebElement helpIcon;
      @FindBy(xpath ="//button[@aria-label='Products switcher']")
    WebElement gridIcon;
      @FindBy(xpath ="//img[@alt='Mohammad Amini']")
    WebElement imgIcon;
      @FindBy(xpath ="//a[@aria-label='Home']")
    WebElement homePageLink;
    
    public MondayHomePage(WebDriver driver){
        this.driver=driver;
    }
    public void getMondayText(){
       WaitUtils.applyFluentWait(driver,mondayText);
        System.out.println("yes");

    }

}
