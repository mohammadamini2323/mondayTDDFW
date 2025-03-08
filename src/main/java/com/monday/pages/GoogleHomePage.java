package com.monday.pages;

import com.monday.enums.WaitStrategy;
import com.monday.utilities.WaitUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage {
    WebDriver driver;
    @FindBy(xpath = "//textarea[@class='gLFyf']")
    public WebElement googleSearchField;



    public GoogleHomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void searchInGoogleFor(String text){
        WaitUtils.applyWait(driver,googleSearchField, WaitStrategy.VISIBLE).sendKeys(text);
       // WaitUtils.applyGlobalWait();
        Actions actions=new Actions(driver);
        actions.keyDown(Keys.ENTER).perform();
        actions.keyUp(Keys.ENTER).perform();
        //WaitUtils.applyWait(driver,magnifierButton,WaitStrategy.CLICKABLE).click();




    }
}
