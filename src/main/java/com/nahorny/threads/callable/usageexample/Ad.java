package com.nahorny.threads.callable.usageexample;

public class Ad {

    protected final String BASE;

    protected Ad(final String BASE) {
        this.BASE = BASE;
    }

    protected interface Path {

        String AD_BY_INDEX = "(//div[@class='example'])[%d]";
    }

    public static Ad byIndex(int index) {
        return byPath(String.format(Path.AD_BY_INDEX, index));
    }

    public static Ad byPath(String BASE) {
        return new Ad(BASE);
    }

    public String getLocation() {
        return "Location";
    }

    public String getTitle() {
        return "Title";
    }

    public int getPrice() {
        return -1;
    }

}
