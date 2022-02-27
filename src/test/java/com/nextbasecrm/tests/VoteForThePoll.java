package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VoteForThePoll {

    WebDriver driver;

    @BeforeMethod
    public void setup_and_login(){

        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("env"));
        CRM_Utilities.crm_login(driver, ConfigurationReader.getProperty("HRUsername2"), ConfigurationReader.getProperty("password"));
    }

    @Test
    public void vote_forAPoll_withOneAnswer() throws InterruptedException {

        // 1. Go to the homepage
        // Expected Title: "Portal"

        String expectedPageTitle = "Portal";
        String actualPageTitle = driver.getTitle();

        Assert.assertEquals(actualPageTitle, expectedPageTitle);

        // 2. Verify if the Vote massage blog is displayed

        WebElement voteMassageBlog = driver.findElement(By.xpath("//div[@id='blg-post-img-6436']"));

        voteMassageBlog.isDisplayed();

        // 3. Click on Java answer

        WebElement javaBtn = driver.findElement(By.xpath("//span[@class='bx-vote-block-input-wrap bx-vote-block-radio-wrap']//label[@for='vote_radio_1163_2610']//span"));
        javaBtn.click();

        javaBtn.isSelected();


        // 4. Verify VOTE button text is as expected: "VOTE"
        WebElement voteBtn = driver.findElement(By.xpath("//div[@class='bx-vote-buttons']/button[2]"));

        String expectedVoteText = "VOTE";
        String actualVoteText = voteBtn.getText();

        Assert.assertEquals(actualVoteText, expectedVoteText);

        // 4. Click VOTE button

        voteBtn.click();


    }


    public static void logout_Function(WebDriver driver){

        // 1. User can see "Log out" option when he clicks his profile
        WebElement profileBtn = driver.findElement(By.xpath("//span[@class='user-name']"));
        profileBtn.click();

        // 2. User clicks the logout option and goes back to the login page
        WebElement logoutOption = driver.findElement(By.xpath("//span[.='Log out']"));
        logoutOption.click();
    }


    @AfterMethod
    public void closeDriver(){

        logout_Function(driver);

        driver.close();
    }


}
