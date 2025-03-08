package test;

import base.BaseTest;
import com.monday.config.ConfigManager;
import com.monday.pages.GoogleHomePage;
import com.monday.pages.MondayHomePage;
import com.monday.pages.MondayLoginPage;
import com.monday.pages.SearchedForMondayPage;
import com.monday.utilities.WaitUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchMondayInGoogleTest extends BaseTest {
    @Test(priority = 1,enabled = false)
    public void searchMonday() {
  GoogleHomePage googleHomePage=new GoogleHomePage(driver);
  googleHomePage.searchInGoogleFor("monday.com login");
        WaitUtils.applyGlobalWait();
        WaitUtils.applyGlobalWait();
        WaitUtils.applyGlobalWait();
        WaitUtils.applyGlobalWait();
        SearchedForMondayPage searchedForMondayPage=new SearchedForMondayPage(driver);
        searchedForMondayPage.clickOnMondayLink();
        WaitUtils.applyGlobalWait();

    }
    @Test(priority = 2)
    public void loginToMonday(){
        driver.get("https://auth.monday.com/auth/login_monday");
        MondayLoginPage mondayLoginPage=new MondayLoginPage(driver);
        String email= "moh.amini2323@gmail.com";
        mondayLoginPage.sendEmailToEmailField(email.trim());
        WaitUtils.applyGlobalWait();
        mondayLoginPage.sendPasswordToPassField("Farah@123$");
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlToBe("https://mohamini2323s-team.monday.com/"));
//        WaitUtils.applyGlobalWait();
//        WaitUtils.applyGlobalWait();
//        WaitUtils.applyGlobalWait();
//        WaitUtils.applyGlobalWait();
        MondayHomePage mondayHomePage=new MondayHomePage(driver);
        mondayHomePage.getMondayText();
       // Assertions.assertEquals("monday",mondayHomePage.getMondayText(),"text did not matched");

    }
}
