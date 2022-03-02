package com.nextbasecrm.tests;


import com.nextbasecrm.utilities.BrowserUtils;
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

public class TC8Chat_Call_SubModules {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //to get to the webpage
        driver.get(ConfigurationReader.getProperty("env"));

        //user logs in
        CRM_Utilities.crm_login(driver, ConfigurationReader.getProperty("MarketingUsername1"),ConfigurationReader.getProperty("password"));
    }

    @Test
    public void verify_Message() {

        WebElement chatCallModule = driver.findElement(By.xpath("//a[@title='Chat and Calls']"));
        chatCallModule.click();

        WebElement messageTab = driver.findElement(By.xpath("//div[@id='bx-desktop-tab-im']"));

        String actualResult = messageTab.getAttribute("title");

        String expectedResult = "Message";
        Assert.assertTrue(actualResult.contains(expectedResult));

    }

    @Test
    public void verifyNotifications() {

        WebElement chatCallModule = driver.findElement(By.xpath("//a[@title='Chat and Calls']"));
        chatCallModule.click();
        WebElement notificationTab = driver.findElement(By.xpath("//div[@data-id='notify']"));
        String actualResult = notificationTab.getAttribute("title");
        String expectedResult = "Notifications";
        Assert.assertEquals(expectedResult, actualResult);
    }
    @Test
    public void settingsVerify(){

        WebElement chatCallModule = driver.findElement(By.xpath("//a[@title='Chat and Calls']"));
        chatCallModule.click();

        WebElement settingTab = driver.findElement(By.xpath("//div[@data-id='config']"));
        String actualResult = settingTab.getAttribute("title");

        String expectedResult = "Settings";
        Assert.assertEquals(expectedResult, actualResult);
    }

   @Test
    public void activeStream(){

        WebElement chatCallModule = driver.findElement(By.xpath("//a[@title='Chat and Calls']"));
        chatCallModule.click();

        WebElement activeStreamTab = driver.findElement(By.xpath("//div[@data-id='im-lf']"));
        System.out.println("activeStreamTab.getAttribute(\"title\") = " + activeStreamTab.getAttribute("title"));
        String actualResult = activeStreamTab.getAttribute("title");

        String expectedResult ="Activity Stream ";
        Assert.assertEquals(expectedResult, actualResult);

    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.sleep(3);
        driver.close();
    }

}
//Acceptance Criteria:
//1. There should be four sub-modules once the user click the Chat and Calls module:
//1. Message
//2. Notifications
//3. Settings
//4. Active Stream
//scenarios :
//1. Verify users (HR, marketing, Helpdesk) access to the Chat and Calls submodules.

