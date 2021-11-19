package com.nahorny.automationqa.rest;

import java.util.HashMap;
import java.util.Map;

public class HttpReqTest {
    public static void main(String[] args) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("param1", "val1");
        parameters.put("param2", "val2");

        String param = ParameterStringBuilder.getParamsString(parameters);
        String URL = "https://example.com";

        String response = HttpReq.executePost(URL, param);
        System.out.println(response);
    }
}
