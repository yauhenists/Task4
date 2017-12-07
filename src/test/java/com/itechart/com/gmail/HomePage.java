package com.itechart.com.gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ASUS on 07.12.2017.
 */
public class HomePage {
    private WebDriver driver;
    private WebElement emailField;
    private WebElement passwordField;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public EmailBoxPage logInWithCredentials(String login, String password) {
        enterLogin(login);
        enterPassword(password);
        return new EmailBoxPage(driver);
    }

    private void enterLogin(String login) {
        emailField = (new WebDriverWait(driver, 30))
                .until(new ExpectedCondition<WebElement>() {
                    @Override
                    public WebElement apply(WebDriver d) {
                        return d.findElement(By.xpath("//input[@type='email']"));
                    }
                });

        emailField.sendKeys(login);
        driver.findElement(By.xpath("//div[@id='identifierNext' and @role='button']")).click();
    }

    private void enterPassword(String password) {
        passwordField = new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@type,'password')]")));

        passwordField.sendKeys(password);
        driver.findElement(By.xpath("//div[@id='passwordNext']")).click();
    }
}
