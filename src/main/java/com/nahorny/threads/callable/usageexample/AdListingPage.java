package com.nahorny.threads.callable.usageexample;

import com.nahorny.automationqa.utils.Messages;
import com.nahorny.automationqa.utils.Web;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.Callable;

public class AdListingPage {

    private final Pagination pagination = new Pagination();

    private int indexForSearch;

    private interface Path {

        String ADS_LIST = "//div[@class='rt-tr-group']";
    }

    public int searchAdByPrice(int price) {
        return searchAdAllPages(
                () -> Ad.byIndex(indexForSearch).getPrice() == price
        );
    }

    public int searchAdByTitle(String name) {
        return searchAdAllPages(
                () -> Ad.byIndex(indexForSearch).getTitle().equalsIgnoreCase(name)
        );
    }

    public int searchAdByLocation(String status) {
        return searchAdAllPages(
                () -> Ad.byIndex(indexForSearch).getLocation().equalsIgnoreCase(status.toUpperCase())
        );
    }

    private int searchAdAllPages(Callable<Boolean> searchFor) {
        do {
            int requiredAd = searchAdOnCurrentPage(searchFor);

            if (requiredAd != -1) {
                return requiredAd;
            }

            pagination.nextPage();
        } while (pagination.hasNext());
        throw new RuntimeException(Messages.AD_NOT_FOUND);
    }

    private int searchAdOnCurrentPage(Callable<Boolean> searchFor) {
        List<WebElement> adsOnPage = Web.getElements(Path.ADS_LIST);
        for (int i = 1; i <= adsOnPage.size(); i++) {
            indexForSearch = i;
            boolean meetsRequirements = false;
            try {
                meetsRequirements = searchFor.call();
            } catch (Exception ignored) {
            }
            if (meetsRequirements) {
                return i;
            }
        }
        return -1;
    }

}
