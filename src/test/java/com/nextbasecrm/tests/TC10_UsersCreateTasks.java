package com.nextbasecrm.tests;

import com.google.common.base.Verify;
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

public class TC10_UsersCreateTasks {

    public WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("env"));
        CRM_Utilities.crm_login(driver, ConfigurationReader.getProperty("HelpdeskUsername2"),ConfigurationReader.getProperty("password"));

    }


    @Test
    public void test_task_title() {


        //Users click the TASK tab

        WebElement taskTab = driver.findElement(By.id("feed-add-post-form-tab-tasks"));
        taskTab.click();

        // Users write task title and task content/message


        WebElement thingsToDo = driver.findElement(By.xpath("//input[@data-bx-id= 'task-edit-title']"));
        thingsToDo.sendKeys("CRM Project");

        WebElement iframe = driver.findElement(By.xpath("//div[@id='bx-html-editor-iframe-cnt-lifefeed_task_form']/iframe"));

        // switched to iframe
        driver.switchTo().frame(iframe);


        WebElement messageTab = driver.findElement(By.xpath("//body[@style='min-height: 84px;']"));
        messageTab.sendKeys("CRM project detailsss");

        // Switch to the main frame (parent frame) to click to send button
        driver.switchTo().parentFrame();


        //Users click the SEND button
        driver.findElement(By.id("blog-submit-button-save")).click();

        //Verify the task is displayed on the feed

        WebElement displayedFeed= driver.findElement(By.xpath("//span[@class='menu-item-link-text']"));
       // Assert.assertEquals(displayedFeed.getText(),"CRM Project","Message did not appear!");

    }

    @Test
    public void test_task_empty_warning_message () {
        //Users click the TASK tab

        WebElement taskTab = driver.findElement(By.id("feed-add-post-form-tab-tasks"));
        taskTab.click();

        BrowserUtils.sleep(2);

        //Users click the SEND button
        driver.findElement(By.id("blog-submit-button-save")).click();

        // Verify “The message title is not specified” warning message is displayed on the page
        WebElement warningMessage = driver.findElement(By.xpath("//div[@class='task-message-label error']"));
        String expectedWarningMessage = "The task name is not specified.";
        String actualWarningMessage = warningMessage.getText();
        Assert.assertEquals(actualWarningMessage,expectedWarningMessage, "Warning Message did not appear!");

    }


    @AfterMethod
    public void tearDown() {
        BrowserUtils.sleep(3);
       //  driver.close();
    }

}


