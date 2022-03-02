package com.nextbasecrm.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRM_Utilities {

    /*
    This method will login with helpdesk1@cybertekschool.com user when it is called.
     */

    public static void crm_login(WebDriver driver){

        //3. Enter valid username
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys("helpdesk1@cybertekschool.com");

        //4. Enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");

        //5. Click to `Log In` button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();
    }


    public static void crm_login(WebDriver driver, String username, String password){

        //3. Enter valid username
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys(username);

        //4. Enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys(password);

        //5. Click to `Log In` button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();
    }


    public static void logout_Function(WebDriver driver){

        // 1. User can see "Log out" option when he clicks his profile
        WebElement profileBtn = driver.findElement(By.xpath("//span[@class='user-name']"));
        profileBtn.click();

        // 2. User clicks the logout option and goes back to the login page
        WebElement logoutOption = driver.findElement(By.xpath("//span[.='Log out']"));
        logoutOption.click();
    }
}
