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
        homePage.waitForElement("//a[@href='https://www.tut.by/resource/' and contains(text(),'Разделы')]");
        ShopsPage shops = homePage.openInNewTab("//div[@data-popup='addon-menu-items']//a[@title='Магазины']");
        shops.checkTitle();
        shops.closeTab();
        homePage.checkElement("//input[@placeholder='Поиск']");
    }
}
