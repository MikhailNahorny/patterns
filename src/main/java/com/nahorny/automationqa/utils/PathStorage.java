package com.nahorny.automationqa.utils;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public final class PathStorage {

    private static final Map<String, String> PATHS_WEB;
    private static final Map<String, Path> PATHS_FILES;

    static {
        PATHS_WEB = new HashMap<>();
        PATHS_WEB.put("@calendar", "//span[contains(@class, 'calendar-icon')]");

        PATHS_WEB.put("@upload_input", "//input[@accept='image/png,image/jpg,image/jpeg']");

        PATHS_FILES = new HashMap<>();
        PATHS_FILES.put("logo", Paths.get("src/test/resources/testData/dbaExampleToUpload.jpg").toAbsolutePath());
        PATHS_FILES.put("700p_image", Paths.get("src/test/resources/testData/700p_image.jpg").toAbsolutePath());
        PATHS_FILES.put("screen_folder", Paths.get("target/screenshots").toAbsolutePath());
    }

    public static String getUnnamedElementPath(String name) {
        return PATHS_WEB.get(name);
    }

    public static Path getFilePathByName(String name) {
        return PATHS_FILES.get(name);
    }

}
