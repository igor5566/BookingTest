package com.booking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class BaseTest {
    private WebDriver driver;

    @BeforeSuite
    public void setDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver(options);
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void open(String url) {
        driver.get(url);
    }

    @AfterSuite
    public void threadDown() {
        driver.quit();
    }
}
