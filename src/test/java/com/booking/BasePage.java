package com.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void click(By locator) {
        new WebDriverWait(driver, 10).until(elementToBeClickable(locator)).click();
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public String getText(By locator) {
        return find(locator).getText();
    }

    public WebElement isElementVisible(By element, int time) {
        return new WebDriverWait(driver, time).until(visibilityOfElementLocated(element));
    }

    public WebElement isElementVisible(By element) {
        return isElementVisible(element, 10);
    }
}
