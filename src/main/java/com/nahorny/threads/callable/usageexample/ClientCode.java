package com.nahorny.threads.callable.usageexample;

/*
Example of Callable usage
we have service like OLX, we need to implement all-pages search ad by title/price/location
for it lets implement search on current page method, call in on all-page search method and send searcher by feature as Callable
 */

public class ClientCode {

    public static void main(String[] args) {
        AdListingPage adListingPage = new AdListingPage();
        adListingPage.searchAdByTitle("Title");
        adListingPage.searchAdByLocation("Location");
        adListingPage.searchAdByPrice(10);
    }
}
