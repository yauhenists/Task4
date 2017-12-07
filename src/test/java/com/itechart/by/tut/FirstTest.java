package com.itechart;
;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.openqa.selenium.Keys.*;
//import static org.testng.Assert.assertEquals;

/**
 * Created by ASUS on 18.11.2017.
 */
public class FirstTest {
    private WebDriver driver;
    WebElement link;
    WebElement title;
    String parentHandle;


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
        Assert.assertTrue(shops.getTitle().contentEquals("KUPI.TUT.BY — выбор и покупка товаров в Минске и по всей Беларуси."));

        shops.closeTab();
        homePage.checkElement("//input[@placeholder='Поиск']");

/*

        //System.setProperty("webdriver.gecko.driver","src\\geckodriver.exe");
        //WebDriver driver = new ChromeDriver();
        WebDriver driver = new FirefoxDriver();
        //driver.manage().window().maximize();
        driver.get("http://tut.by/");

        //Wait while the element is loaded
        link = (new WebDriverWait(driver, 30))
                .until(new ExpectedCondition<WebElement>() {
                    @Override
                    public WebElement apply(WebDriver d) {
                        return d.findElement(By.xpath("//a[@href='https://www.tut.by/resource/' and contains(text(),'Разделы')]"));
                    }
                });
        parentHandle = driver.getWindowHandle();
        //Open link in new tab
        link.click();
        String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
        driver.findElement(By.xpath("//div[@data-popup='addon-menu-items']//a[@title='Магазины']")).sendKeys(selectLinkOpeninNewTab);
        //Get list of tabs
        ArrayList tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs.get(1));
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.titleIs("KUPI.TUT.BY — выбор и покупка товаров в Минске и по всей Беларуси."));
        Assert.assertEquals(driver.getTitle(),"KUPI.TUT.BY — выбор и покупка товаров в Минске и по всей Беларуси.");
        System.out.println("Page title is: " + driver.getTitle());
        ////////////////////////////////////////////////////////////////////////
        driver.close();
        driver.switchTo().window(parentHandle);
        driver.findElement(By.xpath("//input[@placeholder='Поиск']"));
        driver.close();

*/
    }
}
