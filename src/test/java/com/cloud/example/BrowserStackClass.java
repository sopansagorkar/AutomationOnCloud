package com.cloud.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserStackClass {

    public static final String USERNAME = "sopansagorkar_1F9RBa";
    public static final String AUTOMATE_KEY = "SqQ96wFFYJxGrspyx4PA";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    static WebDriver driver;

    @BeforeSuite
    public void setUp() {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "80");

        caps.setCapability("name", "sopan's First Test");

        try {
            driver = new RemoteWebDriver(new URL(URL), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test()
    public void testOnChromeWithBrowserStackSignUp() {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.browserstack.com/users/sign_up");
        //driver.manage().window().maximize();
        driver.findElement(By.id("user_full_name")).sendKeys("<name>");
        driver.findElement(By.id("user_email_login")).sendKeys("<login email id>");
        driver.findElement(By.id("user_password")).sendKeys("<password>");
        System.out.println("this is the test related to chrome browserstack login" + " " + Thread.currentThread().getId());

    }

    @Test()
    public void testOnChromeWithBrowserStackUrl() {


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.browserstack.com/");
        driver.manage().window().maximize();
        System.out.println("this is the test related to chrome browserstack homepage" + " " + Thread.currentThread().getId());

    }


    @AfterClass
    public void close() {
        driver.quit();
    }

}

