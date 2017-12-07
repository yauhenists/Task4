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
public class EmailBoxPage {
    private WebDriver driver;
    private WebElement composeButton;
    private WebElement sendButton;
    private WebElement body;

    public EmailBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    public void createNewEmail() {
        composeButton = new WebDriverWait(driver, 2000)
                .until(ExpectedConditions.
                        elementToBeClickable(By.xpath("//div[@role='button' and contains(text(),'COMPOSE')]")));
        composeButton.click();
        sendButton = (new WebDriverWait(driver, 30))
                .until(new ExpectedCondition<WebElement>() {
                    @Override
                    public WebElement apply(WebDriver d) {
                        return d.findElement(By.xpath("//div[@role='button' and contains(text(),'Send')]"));
                    }
                });
    }

    public void sendNewEmail(String to, String subject, String body) {
        enterTo(to);
        enterSubject(subject);
        enterBody(body);
    }

    private void enterBody(String body) {
        this.body = new WebDriverWait(driver, 2000)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Message Body']")));
        this.body.sendKeys("test automation");
        sendButton.click();
    }

    private void enterSubject(String subject) {
        driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys(subject);
    }

    private void enterTo(String to) {
        driver.findElement(By.xpath("//textarea[@aria-label='To']")).sendKeys(to);
    }

    public void waitForPopUp() {
        new WebDriverWait(driver, 30)
                .until(new ExpectedCondition<WebElement>() {
                    @Override
                    public WebElement apply(WebDriver d) {
                        return d.findElement(By.xpath("//div[contains(text(),'Your message has been sent')]"));
                    }
                });
    }

    public void goToInbox() {
        driver.findElement(By.xpath("//a[contains(text(),'Inbox')]")).click();
    }

    public void openEmail() {
        new WebDriverWait(driver, 2000)
                .until(ExpectedConditions
                        .elementToBeClickable(By.xpath("//div[@role='main']//table//tr[1]/td[4]/div[2]"))).click();
        //driver.findElement(By.xpath("//div[@role='main']//table//tr[1]/td[4]/div[2]")).click();
    }
}
