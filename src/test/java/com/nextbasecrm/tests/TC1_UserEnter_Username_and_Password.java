package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.BrowserUtils;
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

public class TC1_UserEnter_Username_and_Password {

// 1 TC for login
    /*
     * 1- go to login page
     * 2-write username
     * 3-write password
     * 4-click login button
     */

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver =  WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //1- go to login page
        driver.get(ConfigurationReader.getProperty("env"));
    }


    @AfterMethod
    public void tearDown() {
        BrowserUtils.sleep(3);
        driver.close();
    }


    @Test
    public void login_Page_Title(){
        String expectedResult ="Authorization";
        String actualResult = driver.getTitle();
        Assert.assertEquals(expectedResult,expectedResult);
    }


    //Positive scenario
    @Test (priority = 1)
    public void login_with_valid_credentials_with_login_btn(){

        String [] usernameList2 = {"hr28@cydeo.com", "hr29@cydeo.com", "hr30@cydeo.com","helpdesk28@cydeo.com","helpdesk29@cydeo.com" ,"helpdesk30@cydeo.com","marketing28@cydeo.com","marketing29@cydeo.com","marketing30@cydeo.com"
        };

        for (String each : usernameList2) {
            //find the userName and password input box
            WebElement userName = driver.findElement(By.xpath("(//input[@class='login-inp'])[1]"));
            WebElement password = driver.findElement(By.xpath("(//input[@class='login-inp'])[2]"));
            //send the username and password
            userName.sendKeys(each);
            password.sendKeys(ConfigurationReader.getProperty("password"));

            //4-click login button
            BrowserUtils.sleep(2);
            WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
            BrowserUtils.sleep(1);
            loginBtn.click();

            // verify title
            String expectedTitle = "Portal";
            String actualTitle = driver.getTitle();
            BrowserUtils.sleep(2);
            Assert.assertEquals(actualTitle,expectedTitle);

            BrowserUtils.sleep(5);

            //click to log out button
            WebElement userProfile = driver.findElement(By.xpath("//span[@id='user-name']"));
            userProfile.click();

            WebElement userLogOut = driver.findElement(By.xpath("(//span[@class='menu-popup-item-text'])[5]"));
            userLogOut.click();

            //After going back click to Log in and clear the username
            userName = driver.findElement(By.xpath("(//input[@placeholder='Login'])[1]"));
            // userName.click();
            userName.clear();

        }

    }


    //Negative Scenario
    @Test
    public void login_with_valid_username_invalid_password(){
        //2-write username
        WebElement userName = driver.findElement(By.xpath("(//input[@class='login-inp'])[1]"));
        userName.sendKeys(ConfigurationReader.getProperty("HRUsername1"));

        //3-write password
        WebElement password = driver.findElement(By.xpath("(//input[@class='login-inp'])[2]"));
        password.sendKeys("abcd");

        //4-click login button
        WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        BrowserUtils.sleep(1);
        loginBtn.click();

        // verify error message
        String expectedErrorTitle = "Incorrect login or password";
        String actualTitle = driver.findElement(By.xpath("//div[@class='errortext']")).getText();
        Assert.assertEquals(actualTitle,expectedErrorTitle);

    }

    //Negative scenario
    @Test
    public void login_with_invalid_username(){
        //2-write username
        WebElement userName = driver.findElement(By.xpath("(//input[@class='login-inp'])[1]"));
        userName.sendKeys("helSD643esk1@cydeo.com");

        //3-write password
        WebElement password = driver.findElement(By.xpath("(//input[@class='login-inp'])[2]"));
        password.sendKeys(ConfigurationReader.getProperty("password"));

        //4-click login button
        WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        BrowserUtils.sleep(1);
        loginBtn.click();

        // verify error message
        String expectedErrorTitle = "Incorrect login or password";
        String actualTitle = driver.findElement(By.xpath("//div[@class='errortext']")).getText();
        Assert.assertEquals(actualTitle,expectedErrorTitle);


    }





}
