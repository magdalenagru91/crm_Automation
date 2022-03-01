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

public class US03_LogoutFunction {

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
        // Expected Title: "Portal"

        String expectedPageTitle = "Portal";
        String actualPageTitle = driver.getTitle();

        Assert.assertEquals(actualPageTitle, expectedPageTitle);

        // 2. Users see the "Log out" option in the bottom of the dropdown

        WebElement profileBtn = driver.findElement(By.xpath("//span[@class='user-name']"));
        profileBtn.click();

        WebElement logoutOption = driver.findElement(By.xpath("//span[.='Log out']"));
        logoutOption.isDisplayed();

    }

    @Test
    public void click_logout_option(){

        // 1. Users should be able to access the homepage successfully
        // 2. Users can see "Log out" option in the bottom of the dropdown
        WebElement profileBtn = driver.findElement(By.xpath("//span[@class='user-name']"));
        profileBtn.click();

        // 3. Users should be able to go back to the Log in page successfully
        // Expected Title: "Authorization"

        WebElement logoutOption = driver.findElement(By.xpath("//span[.='Log out']"));
        logoutOption.click();

        String expectedPageTitle = "Authorization";
        String actualPageTitle = driver.getTitle();

        Assert.assertEquals(actualPageTitle, expectedPageTitle);

    }

    @AfterMethod
    public void closeDriver(){
        driver.close();
    }


}
