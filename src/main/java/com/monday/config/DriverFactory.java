package com.monday.config;

import com.monday.enums.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.sql.DriverManager;
import java.util.Arrays;

public class DriverFactory {
    public static WebDriver driver;
    public static WebDriver initializeWebDriver(){
        Browser browser=Browser.valueOf(ConfigManager.getProperty("browser").toUpperCase());
        Boolean isHeadless=Boolean.parseBoolean(ConfigManager.getProperty("isHeadless"));
        System.out.println(" configuration loaded for headless mode:"+isHeadless);
        switch (browser){
            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions=new ChromeOptions();
                if (isHeadless){chromeOptions.addArguments("--headless");}
                driver=new ChromeDriver(chromeOptions);
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions=new EdgeOptions();
                if (isHeadless){edgeOptions.addArguments("--headless");}
                driver=new EdgeDriver(edgeOptions);
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions=new FirefoxOptions();
                if (isHeadless){firefoxOptions.addArguments("--headless");}
                driver=new FirefoxDriver(firefoxOptions);
                break;
            case SAFARI:
                WebDriverManager.safaridriver().setup();
                SafariOptions safariOptions=new SafariOptions();
                driver=new SafariDriver(safariOptions);
                break;

            default:
                throw new IllegalArgumentException("Browser not supported : "+browser);

        }
        driver.manage().window().maximize();
        return driver;




    }
    public static void tearDown(){
      if (driver!= null) {driver.quit();}


    }
}
