package com.itechart.by.tut;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ASUS on 03.12.2017.
 */
public class ShopsPage {
    private WebDriver driver;
    private String parentHandle;

    public ShopsPage(WebDriver driver, String parentHandle) {
        this.driver = driver;
        this.parentHandle = parentHandle;
    }

    public void checkTitle() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.
                        titleIs("KUPI.TUT.BY — выбор и покупка товаров в Минске и по всей Беларуси."));
    }

    public void closeTab() {
        driver.close();
        driver.switchTo().window(parentHandle);
    }
}
