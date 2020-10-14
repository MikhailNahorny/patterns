package com.nahorny.pattern.creational.builder.V1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Client {

    public static void main(String[] args) {


        String toLongDom = "";
        for (int i = 0; i <= 254; i++) toLongDom +="a";//ok

        String domNNotAllowedSh = "lms.#ithillel.ua";//ok
        String normDomN = "    eng.lm-s.ith.ua:45      ";

        String toLongSubDom = "";
        for (int i = 0; i < 64; i++) toLongSubDom +="a";
        toLongSubDom = "lms." + toLongSubDom  + ".ithillel.ua";//ok

        String toDeep = "";
        for (int i = 0; i < 120; i++) toDeep +="aa.";//ok
        //System.out.println(toLongSubDom);

        String ip = "192.16.250.251";
        String path1 = "/path1/path2/path3/";
        String [] pathStrs= {"path1", "path8", "path3", "path4", "path5"};
        String pathLong = "/string1/string2/string3/string1/string2/string3/string1/string2//string1/string2/string3/string1/string2/string3/string1/string2//string1/string2/string3/string1/string2/string3/string1/string2//string1/string2/string3/string1/string2/string3/string1/string2/string3/string1/string2/string3/string1/string2/string3/string1/string2/string3/string1/string2/string3/string1/string2/string3/string1/string2/string3/string1/string2/string3/string1/string2/string3/string1/string2/string3/string1/string2/string3/string1/string2/string3";

        ArrayList<String> pathsList = new ArrayList<String>();
        pathsList.add("path1");
        pathsList.add("path2");
        pathsList.add("path3");
        pathsList.add("path4");
        pathsList.add(0, "path0");

        Map<String, String> paramsMap = new HashMap<String, String>();
        paramsMap.put("key1", null);
        paramsMap.put("key2", "Value2");
        paramsMap.put("key3", "");
        paramsMap.put("key4", "Value4");

        String SingleStringParam = "tip=1&id=1&style=&dost=&fmt_name=%F0%E0%EC%E0&fmt_name=%F0%E0%EC%E0&city=&amount=158&price=100&price2=&price_v=1&page=1";
        String KeyString = "key1;key2.key3;key4";
        String ValString = "Value1,, Value4";

        String argNull = null;

        URL.Composer inst_test = new URL.Composer(ip).path(path1).fragment("paragraph").isSecure(true).authority("Nil","s2345678h");
        //inst_test.param(SingleStringParam);
        //inst_test.params(paramsMap);
        inst_test.param(KeyString, ValString).port(10);
        URL result = inst_test.compose();
        System.out.println();
        System.out.println(result);
    }

}
