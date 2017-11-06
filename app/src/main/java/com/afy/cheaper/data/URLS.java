package com.afy.cheaper.data;

/**
 * Created by isayed on 10/29/2017.
 */


public class URLS {

    public static String BASE_URL = "http://10.0.2.2:8080";
    private static String SUFFIX = "/api/v1/";


    public static String getBaseUrl() {
        return BASE_URL + SUFFIX;
    }

    public static void setBaseUrl(String baseUrl) {
        BASE_URL = baseUrl;
    }



}