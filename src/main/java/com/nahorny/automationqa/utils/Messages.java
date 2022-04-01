package com.nahorny.automationqa.utils;

public interface Messages {

    String AD_NOT_FOUND = " Required ad was not found.";
    String INPUT_NOT_ENABLED = " Input not available for typing.";
    String ELEMENT_NOT_VISIBLE = " Element is not displayed.";

    static String noSuchElement(String xpath) {
        return String.format("NoSuchElement '%s'", xpath);
    }

}
