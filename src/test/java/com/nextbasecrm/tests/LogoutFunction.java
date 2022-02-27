package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LogoutFunction {

    WebDriver driver;

    @BeforeMethod
    public void setup_and_login(){

        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("env"));
        CRM_Utilities.crm_login(driver, ConfigurationReader.getProperty("HRUsername1"), ConfigurationReader.getProperty("password"));


    }

    @Test
    public void logout_option_is_displayed(){

        // 1. Users should access the homepage successfully

        String expectedPageTitle = "Portal";
        String actualPageTitle = driver.getTitle();

        Assert.assertEquals(actualPageTitle, expectedPageTitle);

        WebElement profileBtn = driver.findElement(By.xpath("//span[@class='user-name']"));
        profileBtn.click();

        WebElement logoutOption = driver.findElement(By.xpath("//span[.='Log out']"));
        logoutOption.isDisplayed();

    }

}
