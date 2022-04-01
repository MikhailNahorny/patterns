package com.nahorny.automationqa.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Web {

    private static WebDriver driver;

    private static final Logger logger = Logger.getLogger("Web");

    public static void setDriver(WebDriver drv) {
        driver = drv;
    }

    public static WebDriver driver() {
        return driver;
    }

    public static JavascriptExecutor js() {
        return (JavascriptExecutor) driver();
    }

    public static Actions act() {
        return new Actions(driver());
    }

    public static void clickJs(WebElement element) {
        js().executeScript("arguments[0].click()", element);
    }

    public static void clickActions(WebElement element) {
        new Actions(driver()).moveToElement(element).click(element).build().perform();
    }

    public static void clickBlind(String xpath, int offsetY, int offsetX) {
        clickBlind(xpath, offsetY, offsetX, false);
    }

    public static void clickBlind(String xpath, int offsetY, int offsetX, boolean isDebug) {
        WebElement e = getElement(xpath);
        Actions act = new Actions(driver()).moveToElement(e).moveByOffset(offsetX, offsetY);
        if (isDebug) {
            act.contextClick().build().perform();
        } else {
            act.click().build().perform();
        }
    }

    public static void complexClick(WebElement e) {
        waitUntilPageIsLoaded();
        getClickWait().withMessage("Click failed").until(driver -> {
            scrollForElementToBeUnderHeader(e);
            clickJs(e);
            return true;
        });
    }

    public static void scrollToBottom() {
        js().executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void scrollToTop() {
        js().executeScript("window.scrollTo(0, -document.body.scrollHeight)");
    }

    public static void scrollForElementToBeClickable(WebElement element) {
        if (!Web.isElementInClickableAria(element)) {
            Web.scrollForElementToBeUnderHeader(element);
        }
    }

    public static WebElement scrollForElementToBeUnderHeader(WebElement e) {
        logger.info(String.format("User scrolls until %s to be under header ", getLocator(e)));
        int previousPosition = e.getLocation().y;
        int offset = previousPosition - 40;
        js().executeScript(String.format("window.scrollBy(0, %d)", offset), "");
        int millis = 100 + 50 * Math.abs((previousPosition - offset) / 100);
        pause(millis);
        return e;
    }

    public static String getLocator(WebElement e) {
        String locator = ("" + e).split(": ")[2];
        return String.format("\"%s\"", locator.substring(0, locator.length() - 1));
    }

    private static FluentWait<WebDriver> getClickWait() {
        return new WebDriverWait(driver(), Timeouts.CLICK)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(ElementNotInteractableException.class);
    }

    public static boolean isElementPresent(WebElement e) {
        //does not work for invisible elements. use isElementPresent(String xpath)
        try {
            return e.isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    public static boolean isElementPresent(String xpath) {
        return !driver().findElements(By.xpath(xpath)).isEmpty();
    }

    public static void waitNotStrict(String message, Callable<Boolean> c, int timeout) {
        try {
            waitUntil(message, c, timeout);
        } catch (Exception e) {
            logger.info(message);
        }
    }

    public static Logger getLog() {
        return logger;
    }

    public static void waitUntil(String message, Callable<Boolean> c) {
        waitUntil(message, c, Timeouts.AFTER_CLICK);
    }

    public static void waitUntil(String message, Callable<Boolean> c, int timeout) {
        FluentWait<WebDriver> wait = new WebDriverWait(driver(), timeout).withMessage(message);
        wait.until(driver -> {
            try {
                return c.call();
            } catch (Exception ignored) {
                return false;
            }
        });
    }

    public static void wait(int seconds) {
        pause(seconds * 1000);
    }

    public static void pause(int millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (InterruptedException ignored) {
        }
    }

    public static void waitUntilPageIsLoaded() {
        FluentWait<WebDriver> wait = new WebDriverWait(driver(), Timeouts.PAGE_LOADING)
                .withMessage("Page was not loaded in " + Timeouts.PAGE_LOADING)
                .ignoring(StaleElementReferenceException.class);
        wait.until(d -> js().executeScript("return document.readyState").equals("complete")
                && driver().findElements(By.xpath("//div[@class='-loading-inner']")).stream().noneMatch(WebElement::isDisplayed)
                && driver().findElements(By.xpath("//div[@class='loader']")).stream().noneMatch(WebElement::isDisplayed)
                && driver().findElements(By.xpath("//*[text()='Loading...']")).stream().noneMatch(WebElement::isDisplayed)
                && driver().findElements(By.xpath("//*[text()='Processing...']")).stream().noneMatch(WebElement::isDisplayed));
    }

    public static boolean isElementInClickableAria(WebElement e) {
        Dimension window = driver().manage().window().getSize();
        int y = 10;
        Rectangle clickableRect = new Rectangle(10, y, window.height, window.width);
        Rectangle elementRect = e.getRect();
        return (elementRect.y - 10) >= clickableRect.y & (elementRect.y + elementRect.height + 10) <= clickableRect.height;
    }

    public static WebElement getElement(String xpath) {
        List<WebElement> asList = getElements(xpath);
        if (asList.isEmpty())
            throw new NoSuchElementException(Messages.noSuchElement(xpath));
        return getElements(xpath).get(0);
    }

    public static List<WebElement> getElements(String xpath) {
        return driver().findElements(By.xpath(xpath));
    }

    public static WebElement getElementUnder(WebElement e, String xpath) {
        return getElementsUnder(e, xpath).get(0);
    }

    public static List<WebElement> getElementsUnder(WebElement e, String xpath) {
        return e.findElements(By.xpath("." + xpath));
    }

    public static void clickElement(WebElement element) {
        StringBuilder log = new StringBuilder("Click " + Web.getLocator(element));
        scrollForElementToBeClickable(element);
        Web.pause(400);
        boolean isPrevClickedWasSuccessful = false;
        try {
            element.click();
            isPrevClickedWasSuccessful = true;
        } catch (Exception exSimple) {
            log.append("; Simple click failed; ");
        }
        if (!isPrevClickedWasSuccessful) {
            try {
                log.append("Try click by Actions; ");
                Web.clickActions(element);
                log.append("Click by Actions successful.");
                isPrevClickedWasSuccessful = true;
            } catch (Exception exActions) {
                log.append("Click by Actions failed; ");
            }
        }
        if (!isPrevClickedWasSuccessful) {
            try {
                log.append("Try click by JS; ");
                Web.clickJs(element);
                log.append("Click by JS successful.");
                isPrevClickedWasSuccessful = true;
            } catch (Exception exJx) {
                log.append("Click by JS failed; ");
            }
        }
        if (!isPrevClickedWasSuccessful) {
            try {
                log.append("Try complex click; ");
                Web.complexClick(element);
                log.append("Complex click successful.");
            } catch (Exception exComplex) {
                log.append("Click failed.");
                logger.info(log.toString());
                throw new RuntimeException("click element '" + element + "' failed");
            }
        }
        logger.info(log.toString());
        Web.pause(100);
    }

    public static int random(List l) {
        return random(l.size());
    }

    public static int random(int max) {
        return (int) (Math.random() * max);
    }

    public static void dragAndDropToUpload(Path fileToUpload) {
        dragAndDropToUpload(fileToUpload, PathStorage.getUnnamedElementPath("@upload_input"));
    }

    public static void dragAndDropToUpload(Path fileToUpload, String inputPath) {
        WebElement input = getElement(inputPath);
        waitUntil(Messages.INPUT_NOT_ENABLED, input::isEnabled);
        input.sendKeys(fileToUpload.toString());
        waitUntilPageIsLoaded();
    }

    public static void saveScreen(String fileName) {
        File srcFile = ((TakesScreenshot) driver()).getScreenshotAs(OutputType.FILE);
        String targetPath = PathStorage.getFilePathByName("screen_folder")
                + FileSystems.getDefault().getSeparator() + fileName
                + Dates.now().timeStamp()
                + ".png";
        logger.info("saved screen: " + targetPath);
        FileUtilz.copy(srcFile.toPath(), Paths.get(targetPath));
    }


}
