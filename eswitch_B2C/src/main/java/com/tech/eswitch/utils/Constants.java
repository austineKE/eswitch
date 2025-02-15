package com.tech.eswitch.utils;


import com.squareup.okhttp.MediaType;

public class Constants {
    public static final String BASIC_AUTH_STRING = "Basic";
    public static final String BEARER_AUTH_STRING = "Bearer";
    public static final String AUTHORIZATION_HEADER_STRING = "Authorization";
    public static final String CACHE_CONTROL_HEADER = "cache-control";
    public static final String CACHE_CONTROL_HEADER_VALUE = "no-cache";
    public static MediaType JSON_MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");

}
