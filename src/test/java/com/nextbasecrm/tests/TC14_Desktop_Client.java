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

public class TC14_Desktop_Client {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //to get to the webpage
        driver.get(ConfigurationReader.getProperty("env"));

        //user logs in
        CRM_Utilities.crm_login(driver, ConfigurationReader.getProperty("MarketingUsername2"),ConfigurationReader.getProperty("password"));
    }

    @Test

    public void testingDesktopClient() {
//  Verify the users see 3 desktop options:
// 		  - MAC OS
WebElement macDesktopClient=driver.findElement(By.xpath("//div[@class='b24-app-block-content']//a//span[2]"));
        System.out.println("macDesktopClient.isDisplayed() = " + macDesktopClient.isDisplayed());
// verify - WINDOWS is displayed
        WebElement windowsDesktopClient=driver.findElement(By.xpath("//a[@href='http://dl.bitrix24.com/b24/bitrix24_desktop.exe']//span[2]"));
        System.out.println("windowsDesktopClient.isDisplayed() = " + windowsDesktopClient.isDisplayed());
//  	 	- LINUX
        WebElement linuxDesktopClient=driver.findElement(By.xpath("//a[@href='https://github.com/buglloc/brick']//span[2]"));
        System.out.println("linuxDesktopClient.isDisplayed() = " + linuxDesktopClient.isDisplayed());

    }
    @AfterMethod
    public void tearDown() {
        BrowserUtils.sleep(3);
        driver.close();
    }


}

//A user should be able to see 3 desktop options in the homepage.

//1. There should be 3 options for the desktop version:
// - MAC OS
// - WINDOWS
//- LINUX

