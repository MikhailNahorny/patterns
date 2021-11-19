package com.nahorny.automationqa.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {
    private static WebDriver driver;

    public static final WebDriver getDriver() {
        if (driver == null) driver = new ChromeDriver();
        return driver;
    }
}
