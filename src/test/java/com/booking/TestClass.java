package com.booking;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TestClass extends BaseTest {

    private WebDriver driver;
    private ResultPage resultPage;
    private final String BASE_URL = "https://www.booking.com/index.en-gb.html";

    @BeforeTest
    public void setUp() {
        driver = getDriver();
    }

    @Test(priority = 1)
    public void firstTest() {
        open(BASE_URL);
        MainPage mainPage = new MainPage(driver);
        mainPage.enterCityAndDate();
        resultPage = mainPage.getResultPage();
        for (String c : resultPage.getResultCities()) {
            assertTrue((c.contains("New York")), "City(ies) is(are) not correct");
        }
    }

    @Test(priority = 2)
    public void secondTest() {
        assertTrue(resultPage.getCheckInDate().contains("1 May 2020"));
        assertTrue(resultPage.getCheckOutDate().contains("30 May 2020"));
    }

    @Test(priority = 3)
    public void thirdTest() {
        resultPage.chooseUkrLanguage();
        assertTrue(resultPage.getTextOfAccommodationBtn().equals("Помешкання"));
    }
}
