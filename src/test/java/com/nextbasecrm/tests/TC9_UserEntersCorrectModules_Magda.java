package com.nextbasecrm.tests;

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

public class TC9_UserEntersCorrectModules_Magda {

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //to get to the webpage
        driver.get(ConfigurationReader.getProperty("env"));

        //user logs in
        CRM_Utilities.crm_login(driver, ConfigurationReader.getProperty("HRUsername3"),ConfigurationReader.getProperty("password"));
    }

    @Test
    public void ActivityStreamModule(){

        //locate ActivityStreamModule WebElement
        WebElement ActivityStreamModule = driver.findElement(By.xpath("//span[.='\n" +
                        "\t\t\t\t\t\t\t\tActivity Stream\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t']"));

        //click on ActivityStreamModule
        ActivityStreamModule.click();

        //compare expected title to the actual title of the tab
        String actualTitleOfActivityStreamModule = driver.getTitle();
        String expectedTitleOfActivityStreamModule = "Portal";

        Assert.assertEquals(actualTitleOfActivityStreamModule,expectedTitleOfActivityStreamModule);
    }

    @Test
    public void TasksModule(){

        //locate TaskModule WebElement
        WebElement TaskModule = driver.findElement(By.xpath("//span[.='\n" +
                "\t\t\t\t\t\t\t\tTasks\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t']"));

        //click on TaskModule
        TaskModule.click();

        //compare expected title to the actual title of the tab
        String actualTitleOfTaskModule = driver.getTitle();
        String expectedTitleOfTaskModule = "Site map";

        Assert.assertEquals(actualTitleOfTaskModule,expectedTitleOfTaskModule);
    }

    @Test
    public void ChatAndCallsModule(){

        //locate ChatAndCallsModule WebElement
        WebElement ChatAndCallsModule = driver.findElement(By.xpath("//span[.='\n" +
                "\t\t\t\t\t\t\t\tChat and Calls\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t']"));

        //click on ChatAndCallsModule
        ChatAndCallsModule.click();

        //compare expected title to the actual title of the tab
        String actualTitleOfChatAndCallsModule = driver.getTitle();
        String expectedTitleOfChatAndCallsModule = "Chat and Calls";

        Assert.assertEquals(actualTitleOfChatAndCallsModule,expectedTitleOfChatAndCallsModule);
    }


    @Test
    public void WorkgroupsModule(){

        //locate WorkgroupsModule WebElement
        WebElement WorkgroupsModule = driver.findElement(By.xpath("//span[.='\n" +
                "\t\t\t\t\t\t\t\tWorkgroups\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t']"));

        //click on WorkgroupsModule
        WorkgroupsModule.click();

        //compare expected title to the actual title of the tab
        String actualTitleOfWorkgroupsModule = driver.getTitle();
        String expectedTitleOfWorkgroupsModule = "Workgroups and projects";

        Assert.assertEquals(actualTitleOfWorkgroupsModule,expectedTitleOfWorkgroupsModule);
    }


    @Test
    public void DriveModule(){

        //locate DriveModule WebElement
        WebElement DriveModule = driver.findElement(By.xpath("//span[.='\n" +
                "\t\t\t\t\t\t\t\tDrive\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t']"));

        //click on DriveModule
        DriveModule.click();

        //compare expected title to the actual title of the tab
        String actualTitleOfDriveModule = driver.getTitle();
        String expectedTitleOfDriveModule = "Site map";

        Assert.assertEquals(actualTitleOfDriveModule,expectedTitleOfDriveModule);
    }


    @Test
    public void CalendarModule(){

        //locate CalendarModule WebElement
        WebElement CalendarModule = driver.findElement(By.xpath("//span[.='\n" +
                "\t\t\t\t\t\t\t\tCalendar\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t']"));

        //click on CalendarModule
        CalendarModule.click();

        //compare expected title to the actual title of the tab
        String actualTitleOfCalendarModule = driver.getTitle();
        String expectedTitleOfCalendarModule = "Site map";

        Assert.assertEquals(actualTitleOfCalendarModule,expectedTitleOfCalendarModule);
    }


    @Test
    public void MailModule(){

        //locate MailModule WebElement
        WebElement MailModule = driver.findElement(By.xpath("//span[.='\n" +
                "\t\t\t\t\t\t\t\tMail\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t']"));

        //click on MailModule
        MailModule.click();

        //compare expected title to the actual title of the tab
        String actualTitleOfMailModule = driver.getTitle();
        String expectedTitleOfMailModule = "Mailbox Integration";

        Assert.assertEquals(actualTitleOfMailModule,expectedTitleOfMailModule);
    }


    @Test
    public void ContactCenterModule(){

        //locate ContactCenterModule WebElement
        WebElement ContactCenterModule = driver.findElement(By.xpath("//span[.='\n" +
                "\t\t\t\t\t\t\t\tContact Center\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t']"));

        //click on ContactCenterModule
        ContactCenterModule.click();

        //compare expected title to the actual title of the tab
        String actualTitleOfContactCenterModule = driver.getTitle();
        String expectedTitleOfContactCenterModule = "Contact Center";
    }


    @Test
    public void TimeAndReports(){

        //locate TimeAndReports WebElement
        WebElement TimeAndReports = driver.findElement(By.xpath("//span[.='\n" +
                "\t\t\t\t\t\t\t\tTime and Reports\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t']"));

        //click on TimeAndReports
        TimeAndReports.click();

        //compare expected title to the actual title of the tab
        String actualTitleOfTimeAndReports = driver.getTitle();
        String expectedTitleOfTimeAndReports = "Absence Chart";

        Assert.assertEquals(actualTitleOfTimeAndReports,expectedTitleOfTimeAndReports);
    }


    @Test
    public void EmployeesModule(){

        //locate EmployeesModule WebElement
        WebElement EmployeesModule = driver.findElement(By.xpath("//span[.='\n" +
                "\t\t\t\t\t\t\t\tEmployees\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t']"));

        //click on EmployeesModule
        EmployeesModule.click();

        //compare expected title to the actual title of the tab
        String actualTitleOfEmployeesModule = driver.getTitle();
        String expectedTitleOfEmployeesModule = "Company Structure";

        Assert.assertEquals(actualTitleOfEmployeesModule,expectedTitleOfEmployeesModule);
    }


    @Test
    public void ServicesModule(){

        //locate ServicesModule WebElement
        WebElement ServicesModule = driver.findElement(By.xpath("//span[.='\n" +
                "\t\t\t\t\t\t\t\tServices\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t']"));

        //click on ServicesModule
        ServicesModule.click();

        //compare expected title to the actual title of the tab
        String actualTitleOfServicesModule = driver.getTitle();
        String expectedTitleOfServicesModule = "Meeting Rooms";

        Assert.assertEquals(actualTitleOfServicesModule,expectedTitleOfServicesModule);
    }


    @Test
    public void CompanyModule(){

        //locate CompanyModule WebElement
        WebElement CompanyModule = driver.findElement(By.xpath("//span[.='\n" +
                "\t\t\t\t\t\t\t\tCompany\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t']"));

        //click on CompanyModule
        CompanyModule.click();

        //compare expected title to the actual title of the tab
        String actualTitleOfCompanyModule = driver.getTitle();
        String expectedTitleOfCompanyModule = "Company";

        Assert.assertEquals(actualTitleOfCompanyModule,expectedTitleOfCompanyModule);
    }

    @AfterMethod
    public void tearDownMethod(){

        BrowserUtils.sleep(1);
        driver.close();
    }


}

//locate TimeAndReports WebElement
//click on ContactCenterModule
//compare expected title to the actual title of the tab