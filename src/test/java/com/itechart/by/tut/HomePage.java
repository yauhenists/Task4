package com.itechart.by.tut;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

/**
 * Created by ASUS on 03.12.2017.
 */
public class HomePage {
    private WebDriver driver;
    private WebElement link;
    private String parentHandle;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        parentHandle = driver.getWindowHandle();
    }

    public boolean waitForElement() {
        link = (new WebDriverWait(driver, 30))
                .until(new ExpectedCondition<WebElement>() {
                    @Override
                    public WebElement apply(WebDriver d) {
                        return d.findElement(By
                                .xpath("//a[@href='https://www.tut.by/resource/' and contains(text(),'Разделы')]"));
                    }
                });
        return true;
    }

    public ShopsPage openInNewTab(String xpath) {
        link.click();
        String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
        driver.findElement(By.xpath(xpath)).sendKeys(selectLinkOpeninNewTab);
        ArrayList tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs.get(1));
        return new ShopsPage(driver, parentHandle);
    }

    public boolean checkElement(String xpath) {
        return driver.findElement(By.xpath("//input[@placeholder='Поиск']")).isDisplayed();
    }
}
