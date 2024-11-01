package ru.kpfu.itis.kononenko.homework1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
/*
Использовала новую ссылку - "https://jsonplaceholder.typicode.com/", потому что когда начала делать домашнюю работу сервер прошлого сайта упал
 */

public class HttpSample1 {


    public static void main(String[] args) {

        // get
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts?userId=2");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            System.out.println("get "+ connection.getResponseCode());
            System.out.println(readResponse(connection));
            connection.disconnect();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // post
        try {
            URL postUrl = new URL("https://jsonplaceholder.typicode.com/posts");
            HttpURLConnection postConnection = (HttpURLConnection) postUrl.openConnection();
            postConnection.setRequestMethod("POST");
            postConnection.setRequestProperty("Content-Type", "application/json");
            postConnection.setRequestProperty("Accept", "application/json");
            postConnection.setDoOutput(true);
            String jsonInput = "{\n" +
                    "  \"userId\": 12,\n" +
                    "  \"id\": 45,\n" +
                    "  \"title\": \"foo12\",\n" +
                    "  \"body\": \"bar12\"\n" +
                    "}";
            writeToOutputStream(postConnection, jsonInput);
            System.out.println("post " + postConnection.getResponseCode());
            System.out.println(readResponse(postConnection));
            postConnection.disconnect();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // put
        try {
            URL putUrl = new URL("https://jsonplaceholder.typicode.com/posts/1");
            HttpURLConnection putConnection = (HttpURLConnection) putUrl.openConnection();
            putConnection.setRequestMethod("PUT");
            putConnection.setRequestProperty("Content-Type", "application/json");
            putConnection.setRequestProperty("Accept", "application/json");
            putConnection.setDoOutput(true);
            String jsonInput = "{\n" +
                    "  \"userId\": 127,\n" +
                    "  \"id\": 127,\n" +
                    "  \"title\": \"foo\",\n" +
                    "  \"body\": \"bar\"\n" +
                    "}";
            writeToOutputStream(putConnection, jsonInput);
            System.out.println("put " + putConnection.getResponseCode());
            System.out.println(readResponse(putConnection));
            putConnection.disconnect();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //delete
        try {
            URL deleteUrl = new URL("https://jsonplaceholder.typicode.com/posts/1");
            HttpURLConnection deleteConnection = (HttpURLConnection) deleteUrl.openConnection();
            deleteConnection.setRequestMethod("DELETE");
            deleteConnection.setDoOutput(true);
            System.out.println("delete " + deleteConnection.getResponseCode());
            System.out.println(readResponse(deleteConnection));
            deleteConnection.disconnect();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String readResponse(HttpURLConnection connection) throws IOException {
        if (connection != null) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder content = new StringBuilder();
                String input;
                while ((input = reader.readLine()) != null) {
                    content.append(input);
                }
                return content.toString();
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
}
