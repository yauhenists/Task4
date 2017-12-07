package com.itechart.com.gmail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * Created by ASUS on 03.12.2017.
 */
public class SecondTest {

    private WebDriver driver;
    String login = "test4task4";
    String password = "test4TASK$";
    String to = login + "@gmail.com";
    String subject = "test";
    String body = "test automation";

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://gmail.com/");
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void checkGmail() {
        HomePage homePage = new HomePage(driver);
        EmailBoxPage boxPage = homePage.logInWithCredentials(login, password);
        boxPage.createNewEmail();
        boxPage.sendNewEmail(to, subject, body);
        boxPage.waitForPopUp();
        boxPage.goToInbox();
        boxPage.openEmail();
    }

}
