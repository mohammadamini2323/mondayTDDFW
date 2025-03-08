package base;

import com.monday.config.ConfigManager;
import com.monday.config.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected static WebDriver driver;
  protected static final Logger logger= LogManager.getLogger(BaseTest.class);
  @BeforeMethod
    public void setUp(){
        driver= DriverFactory.initializeWebDriver();
        driver.get(ConfigManager.getProperty("baseUrl"));
        logger.info("test started with base Url "+ConfigManager.getProperty("baseUrl"));

    }
    @AfterMethod
    public void tearDown(){
      DriverFactory.tearDown();
    }
}
