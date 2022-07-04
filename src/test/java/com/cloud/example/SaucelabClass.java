package com.cloud.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SaucelabClass {
    static WebDriver driver;

    @BeforeSuite
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.setPlatformName("Windows 10");
        options.setBrowserVersion("latest");

        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", "oauth-sagorkars-1e075");
        sauceOptions.put("accessKey", "0a01100c-3d24-470f-99af-a7c662ba7f83");
        sauceOptions.put("name", "Sopan");

        options.setCapability("sauce:options", sauceOptions);
        URL url = null;
        try {
            url = new URL("https://oauth-sagorkars-1e075:0a01100c-3d24-470f-99af-a7c662ba7f83@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver = new RemoteWebDriver(url, options);
    }
    @Test
    public void openURL(){
        driver.get("https://www.saucedemo.com");
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
}
