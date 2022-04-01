package com.nahorny.automationqa.utils;

public interface Timeouts {

    float FACTOR = 1.0f;
    int PAGE_LOADING = (int) (60 * FACTOR);
    int ELEMENT_VISIBILITY = (int) (15 * FACTOR);
    int CLICK = (int) (15 * FACTOR);
    int AFTER_CLICK = (int) (5 * FACTOR);
    int PROCESSING = (int) (25 * FACTOR);
    int ALERT = (int) (15 * FACTOR);
    int TEXT_TYPE = (int) (6 * FACTOR);
    int MODAL_TO_BE_SHOWN = (int) (7 * FACTOR);
    int DROPDOWN_TO_BE_OPENED = (int) (5 * FACTOR);
}
