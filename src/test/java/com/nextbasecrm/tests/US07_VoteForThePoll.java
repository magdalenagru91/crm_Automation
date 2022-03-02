package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.BrowserUtils;
import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class US07_VoteForThePoll {

    WebDriver driver;

    @BeforeMethod
    public void setup_and_login(){

        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("env"));
        CRM_Utilities.crm_login(driver, ConfigurationReader.getProperty("HelpdeskUsername2"), ConfigurationReader.getProperty("password"));

    }

    @Test
    public void CY10_38_vote_for_a_poll(){

        // 1. Go to the homepage
        // Expected Title: "Portal"

        String expectedPageTitle = "Portal";
        String actualPageTitle = driver.getTitle();

        Assert.assertEquals(actualPageTitle, expectedPageTitle);

        // 2. Locate poll and click for JAVA answer

        WebElement javaBtn = driver.findElement(By.xpath("//span[.='JAVA']"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", javaBtn);

        javaBtn.click();

        // 3. Verify VOTE button text is as expected: "VOTE"
        WebElement voteBtn = driver.findElement(By.xpath("//button[.='Vote']"));

        String expectedVoteText = "VOTE";
        String actualVoteText = voteBtn.getText();

        Assert.assertEquals(actualVoteText, expectedVoteText);

        // 4. Click VOTE button

        voteBtn.click();

    }


    @AfterMethod
    public void closeDriver(){

       CRM_Utilities.logout_Function(driver);

       driver.close();
    }


}
