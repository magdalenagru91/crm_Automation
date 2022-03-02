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
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NB_Send_Message {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //Open a browser
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        // Go to: https://login2.nextbasecrm.com
        driver.get(ConfigurationReader.getProperty("env"));
        WebElement userName = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        userName.sendKeys(ConfigurationReader.getProperty("MarketingUsername1"));
        WebElement password = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys(ConfigurationReader.getProperty("password"));

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();




    }

    @Test(priority = 1)
    public void sendMessage() {

        //Users click MESSAGE tab
        WebElement messageButton = driver.findElement(By.xpath("//span//span[.='Message']"));
        messageButton.click();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));

        //Users type a text "Hello World"
        WebElement writeMessage = driver.findElement(By.xpath("//body[@contenteditable='true']"));
        writeMessage.sendKeys("Hello World");
        driver.switchTo().parentFrame();

        //Users click the SEND button
        WebElement sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();
        //Verify text is displayed "Hello World"
        WebElement textProvided = driver.findElement(By.xpath("//div[.='Hello World']"));

        String actualText = textProvided.getText();
        String expectedText = "Hello World";

        Assert.assertEquals(actualText, expectedText);




    }

    @Test(priority = 2)
    public void messageWithoutContent() {

        //Users click MESSAGE tab
        WebElement messageButton = driver.findElement(By.xpath("//span//span[.='Message']"));
        messageButton.click();

        //Users click the SEND button
        WebElement sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();

        //verify expected title "The message title is not specified"
        WebElement textDisplayed = driver.findElement(By.xpath("//span[.='The message title is not specified']"));

        String actualText = textDisplayed.getText();
        String expectedText = "The message title is not specified";

        Assert.assertEquals(actualText, expectedText);


    }

    @AfterMethod
    public void close() {
        BrowserUtils.sleep(3);
        driver.close();
    }
}
