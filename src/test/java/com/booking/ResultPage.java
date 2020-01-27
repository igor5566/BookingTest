package com.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ResultPage extends BasePage {

    private By cityName = By.xpath("//div[@class='sr_card_address_line']/a");
    private By checkInDateField = By.xpath("(//div[@class='sb-date-field__display'])[1]");
    private By checkOutDateField = By.xpath("(//div[@class='sb-date-field__display'])[2]");
    private By languageField = By.cssSelector("li[class='user_center_option uc_language js-uc-language '] > a");
    private By ukrLanguageIcon = By.cssSelector("li[class='lang_uk']");
    private By accommodationBtn = By.cssSelector("span[class='xpb__link selected'] > span:nth-child(2)");

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getResultCities() {
        isElementVisible(cityName);
        List<WebElement> cities;
        cities = driver.findElements(cityName);
        List<String> citiesStr = new ArrayList<String>();
        for (WebElement c : cities) {
            citiesStr.add(c.getText());
        }
        return citiesStr;
    }

    public String getCheckInDate() {
        isElementVisible(checkInDateField);
        return getText(checkInDateField);
    }

    public String getCheckOutDate() {
        isElementVisible(checkOutDateField);
        return getText(checkOutDateField);
    }

    public void chooseUkrLanguage() {
        isElementVisible(languageField);
        click(languageField);
        isElementVisible(ukrLanguageIcon);
        click(ukrLanguageIcon);
    }

    public String getTextOfAccommodationBtn() {
        isElementVisible(accommodationBtn);
        return getText(accommodationBtn);
    }
}
