package ru.kpfu.itis.kononenko.homework1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/*
Усовершенствованный клиент-сервер
 */
public class HttpSample3 implements HttpSample {


    @Override
    public String get(String url, Map<String, String> headers, Map<String, String> params) {
        try {
            URL getUrl = new URL(newUrl(url, params));
            HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
            connection.setRequestMethod("GET");
            allProperties(connection, headers);
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            System.out.println("get "+ connection.getResponseCode());
            String response = readResponse(connection);
            connection.disconnect();
            return response;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String post(String url, Map<String, String> headers, Map<String, String> data) {
        try {
            URL postUrl = new URL(url);
            HttpURLConnection postConnection = (HttpURLConnection) postUrl.openConnection();
            postConnection.setRequestMethod("POST");
            allProperties(postConnection, headers);
            postConnection.setDoOutput(true);
            writeToOutputStream(postConnection, parseMapToJSON(data));
            System.out.println("post " + postConnection.getResponseCode());
            String responce = readResponse(postConnection);
            postConnection.disconnect();
            return responce;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String put(String url, Map<String, String> headers, Map<String, String> data) {
        try {
            URL putUrl = new URL(url);
            HttpURLConnection putConnection = (HttpURLConnection) putUrl.openConnection();
            putConnection.setRequestMethod("PUT");
            allProperties(putConnection, headers);
            putConnection.setDoOutput(true);
            writeToOutputStream(putConnection, parseMapToJSON(data));
            System.out.println("put " + putConnection.getResponseCode());
            String response = readResponse(putConnection);
            putConnection.disconnect();
            return response;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String delete(String url, Map<String, String> headers, Map<String, String> data) {
        try {
            URL deleteUrl = new URL(url);
            HttpURLConnection deleteConnection = (HttpURLConnection) deleteUrl.openConnection();
            deleteConnection.setRequestMethod("DELETE");
            allProperties(deleteConnection, headers);
            deleteConnection.setDoOutput(true);
            writeToOutputStream(deleteConnection, parseMapToJSON(data));
            System.out.println("delete " + deleteConnection.getResponseCode());
            String responce = readResponse(deleteConnection);
            deleteConnection.disconnect();
            return responce;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static String readResponse(HttpURLConnection connection) {
        if (connection != null) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder content = new StringBuilder();
                String input;
                while ((input = reader.readLine()) != null) {
                    content.append(input);
                }
                return content.toString();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    private static void writeToOutputStream(HttpURLConnection connection, String json) {
        try (OutputStream outputStream = connection.getOutputStream()) {
            byte[] input = json.getBytes(StandardCharsets.UTF_8);
            outputStream.write(input, 0, input.length);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String parseMapToJSON(Map<String, String> data){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    private void allProperties( HttpURLConnection connection, Map<String, String> headers){
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            connection.setRequestProperty(entry.getKey(), entry.getValue());
        }

    }

    private String newUrl(String url, Map<String, String> params) {
        StringBuilder urlWithParams = new StringBuilder(url);
        urlWithParams.append("?");
        for (Map.Entry<String, String> entry : params.entrySet()) {
            urlWithParams.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        return urlWithParams.toString();
    }

}
