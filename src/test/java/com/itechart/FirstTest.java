package com.itechart;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by ASUS on 18.11.2017.
 */
public class FirstTest {
    @Test
    public void firstTest() {
        //ChromeDriver driver = new ChromeDriver();
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("http://tut.by/");
    }
}
