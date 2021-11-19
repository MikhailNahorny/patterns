package com.nahorny.automationqa.webdriver;

import com.nahorny.automationqa.framework.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Cliker {
    WebDriver driver = WebDriverManager.getDriver();

    WebElement we = driver.findElement(By.xpath("//example"));
    WebElement we2 = (WebElement) ((JavascriptExecutor) driver).executeScript("return document.querySelector('selector')");

    public void clickSelenium() {
        we.click();
    }

    public void clickJS() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", we);
    }

    public void clickActions() {
        Actions act = new Actions(driver);
        act.click(we).build().perform();
        act.moveToElement(we).click().build().perform();
    }

}
