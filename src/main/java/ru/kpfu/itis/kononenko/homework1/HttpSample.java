package ru.kpfu.itis.kononenko.homework1;

import java.util.Map;

public interface HttpSample {
    String get(String url, Map<String, String> headers, Map<String, String> params);
    String post(String url, Map<String, String> headers, Map<String, String> data);
    String put(String url, Map<String, String> headers, Map<String, String> data);
    String delete(String url, Map<String, String> headers, Map<String, String> data);
}
