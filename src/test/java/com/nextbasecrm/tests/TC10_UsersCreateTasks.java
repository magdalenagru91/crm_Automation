package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.BrowserUtils;
import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        CRM_Utilities.crm_login(driver, ConfigurationReader.getProperty("MarketingUsername1"),ConfigurationReader.getProperty("password"));

    }


    @Test
    public void test_task_title() {


        //Users click the TASK tab

        //driver.findElement(By.id("feed-add-post-form-tab-tasks")).click();
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

        driver.switchTo().parentFrame();


        //Users click the SEND button
        driver.findElement(By.id("blog-submit-button-save")).click();

        //Verify the task is displayed on the feed

        WebElement displayedFeed= driver.findElement(By.xpath("//span[@class='menu-item-link-text']"));


    }


    @AfterMethod
    public void tearDown() {
        BrowserUtils.sleep(3);
       //  driver.close();
    }


}


