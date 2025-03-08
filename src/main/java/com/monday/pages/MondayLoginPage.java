package com.monday.pages;

import com.monday.enums.WaitStrategy;
import com.monday.utilities.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MondayLoginPage {
    WebDriver driver;
    @FindBy(xpath = "//input[@id='user_email']")
   public WebElement emailField;
    @FindBy(css = "input#user_password")
    public WebElement passwordField;
    @FindBy(xpath = "//div[text()='Next']")
    public WebElement nextButton;
    public MondayLoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void sendEmailToEmailField(String Email){
        WaitUtils.applyFluentWait(driver,emailField).sendKeys(Email);

        WaitUtils.applyGlobalWait();
//        Actions actions=new Actions(driver);
//        actions.keyDown(Keys.ENTER).perform();
//        actions.keyUp(Keys.ENTER).perform();
         WaitUtils.applyFluentWait(driver,nextButton).click();


    }
    public void sendPasswordToPassField(String pass){
        WaitUtils.applyFluentWait(driver,passwordField).sendKeys(pass);
      //  WaitUtils.applyGlobalWait();
        Actions actions=new Actions(driver);
        actions.keyDown(Keys.ENTER).perform();
        actions.keyUp(Keys.ENTER).perform();
    }
}

