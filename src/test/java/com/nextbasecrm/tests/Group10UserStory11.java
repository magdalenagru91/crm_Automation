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

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Group10UserStory11 {

    WebDriver driver;

    @BeforeMethod
    public void setup_and_login() {

        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("env"));
        CRM_Utilities.crm_login(driver, ConfigurationReader.getProperty("HRUsername1"), ConfigurationReader.getProperty("password"));
    }
        @Test
        public void Test1(){

                //user dropdown to see the options, one of them is My Profile
                WebElement userDropdown = driver.findElement(By.className("user-block"));
                userDropdown.click();
                //user selects My Profile option
                WebElement myProfileOption = driver.findElement(By.className("menu-popup-item-text"));
                myProfileOption.click();

            }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.sleep(3);
        driver.close();

        }

    }




