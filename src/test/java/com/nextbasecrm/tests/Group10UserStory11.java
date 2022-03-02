package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Group10UserStory11 {

    WebDriver driver;

        @Test
        public void Test1(){
            String crm1="https://login2.nextbasecrm.com/";
            String crm2="https://login.nextbasecrm.com/";
            String hr28="hr28@cydeo.com";
            String hr29="hr29@cydeo.com";
            String hr30="hr30@cydeo.com";
            String mark28="marketing28@cydeo.com";
            String mark29="marketing29@cydeo.com";
            String mark30="marketing30@cydeo.com";
            String hd28="helpdesk28@cydeo.com";
            String hd29="helpdesk29@cydeo.com";
            String hd30="helpdesk30@cydeo.com";
            String password="UserUser";
            ArrayList<String> userNames=new ArrayList<>();
            userNames.add(hr28);
            userNames.add(hr29);
            userNames.add(hr30);
            userNames.add(mark28);
            userNames.add(mark29);
            userNames.add(mark30);
       /* userNames.add(hd28);
        userNames.add(hd29);
        userNames.add(hd30);*/
            for (String userName : userNames) {
                driver = WebDriverFactory.getDriver("chrome");
                driver.manage().window().maximize();
                driver.get(crm1);
                WebElement loginInput = driver.findElement(By.name("USER_LOGIN"));
                loginInput.sendKeys(userName);
                WebElement passwordInput = driver.findElement(By.name("USER_PASSWORD"));
                passwordInput.sendKeys(password);
                WebElement loginButton = driver.findElement(By.className("login-btn"));
                loginButton.click();
                //user dropdown
                WebElement userDropdown = driver.findElement(By.className("user-block"));
                userDropdown.click();
                WebElement myProfileOption = driver.findElement(By.className("menu-popup-item-text"));
                myProfileOption.click();
                //driver.close();
            }
        }
        @AfterMethod
        public void wrapUp(){
            driver.quit();

        }

    }




