package com.itechart.by.tut;
;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by ASUS on 18.11.2017.
 */
public class FirstTest {
    private WebDriver driver;
    private String shopsXpath = "//div[@data-popup='addon-menu-items']//a[@title='Магазины']";
    private String searchXpath = "//input[@placeholder='Поиск']";

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("http://tut.by/");
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void testForTutby() {
        HomePage homePage = new HomePage(driver);
        homePage.waitForElement();
        ShopsPage shops = homePage.openInNewTab(shopsXpath);
        shops.checkTitle();
        shops.closeTab();
        homePage.checkElement(searchXpath);
    }
}
