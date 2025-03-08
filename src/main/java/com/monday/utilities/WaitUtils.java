package com.monday.utilities;

import com.monday.config.ConfigManager;
import com.monday.enums.WaitStrategy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    WebDriver driver;
public static WebElement applyWait(WebDriver driver, WebElement element, WaitStrategy waitStrategy) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigManager.getProperty_int("timeout")));
    switch (waitStrategy) {
        case VISIBLE:
            return wait.until(ExpectedConditions.visibilityOf(element));
        case CLICKABLE:
          return   wait.until(ExpectedConditions.elementToBeClickable(element));
        case NONE:
        default:
            return element;

    }
}
public static void applyGlobalWait(){
    try {
        Thread.sleep(ConfigManager.getProperty_int("globalWaitTimeOut"));
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}
public static WebElement applyFluentWait(WebDriver driver,WebElement element){
    FluentWait<WebDriver> wait=new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
   return wait.until(ExpectedConditions.visibilityOf(element));
}

}

