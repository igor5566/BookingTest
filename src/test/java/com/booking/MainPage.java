package com.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage extends BasePage {

    private By searchField = By.name("ss");
    private By calendar = By.cssSelector("div[class='xp__dates xp__group']");
    private By monthName = By.cssSelector("div[class='bui-calendar__month']");
    private By nextBtn = By.cssSelector("div[class='bui-calendar__control bui-calendar__control--next']");
    private By firstDate = By.cssSelector("div:nth-child(1) > table[class='bui-calendar__dates'] td[data-date='2020-05-01']");
    private By secondDate = By.cssSelector("div:nth-child(1) > table[class='bui-calendar__dates'] td[data-date='2020-05-30']");
    private By submit = By.cssSelector("div[class='sb-searchbox-submit-col -submit-button '] > button");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void enterCityAndDate() {
        isElementVisible(searchField);
        find(searchField).sendKeys("New York");
        isElementVisible(calendar);
        click(calendar);
        for (int i = 0; i <= 12; i++) {
            if (!(isElementVisible(monthName).getText().contains("May 2020"))) {
                click(nextBtn);
            } else {
                break;
            }
        }
        isElementVisible(firstDate);
        click(firstDate);
        isElementVisible(secondDate);
        click(secondDate);
    }

    public ResultPage getResultPage() {
        isElementVisible(submit);
        click(submit);
        return new ResultPage(driver);
    }

}
