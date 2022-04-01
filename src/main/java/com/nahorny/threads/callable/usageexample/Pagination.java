package com.nahorny.threads.callable.usageexample;

import com.nahorny.automationqa.utils.Messages;
import com.nahorny.automationqa.utils.Web;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Pagination {

    private static final String SELF_NAME = "Pagination";

    private int targetCount;

    private final String BASE = "//div[@class='pagination']";

    @FindBy(xpath = BASE)
    WebElement paginationBlock;

    @FindBy(xpath = BASE + "")
    WebElement prevPageButton;

    @FindBy(xpath = BASE + "")
    WebElement nextPageButton;

    public Pagination scrollToItself() {
        Web.waitUntilPageIsLoaded();
        Web.waitUntil(Messages.ELEMENT_NOT_VISIBLE, paginationBlock::isDisplayed);
        Web.scrollForElementToBeClickable(paginationBlock);
        return this;
    }

    public Pagination nextPage() {
        if (hasNext()) {
            scrollToItself();
            Web.clickElement(nextPageButton);
        }
        Web.waitUntilPageIsLoaded();
        return this;
    }

    public Pagination prevPage() {
        if (hasPrev()) {
            scrollToItself();
            Web.clickElement(prevPageButton);
        }
        Web.waitUntilPageIsLoaded();
        return this;
    }

    private boolean isEnabled(WebElement button) {
        return !button.getAttribute("class").contains("disabled");
    }

    public boolean hasNext() {
        if (!Web.isElementPresent(BASE)) {
            return false;
        }
        return isEnabled(nextPageButton);
    }

    public boolean hasPrev() {
        if (!Web.isElementPresent(BASE)) {
            return false;
        }
        return isEnabled(prevPageButton);
    }
}
