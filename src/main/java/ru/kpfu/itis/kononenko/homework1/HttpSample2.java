package ru.kpfu.itis.kononenko.homework1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/*
Так как сервер сайта упал, то на запросы кидает ошибку 522. Нет возможности проверить корректность запросов.
 */


public class HttpSample2 {

    public static void main(String[] args) {
        // get
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts?userId=2");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            System.out.println(readResponse(connection));
            connection.disconnect();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // post
        try {
            URL putUrl = new URL("https://gorest.co.in/public/v2/users");
            HttpURLConnection putConnection = (HttpURLConnection) putUrl.openConnection();
            putConnection.setRequestMethod("POST");
            putConnection.setRequestProperty("Content-Type", "application/json");
            putConnection.setRequestProperty("Accept", "application/json");
            putConnection.setRequestProperty("Authorization", "Bearer 58762cdab4e248c10d165f6bbe89d18a444dff00267b6cfcec49acf9dceb94b7");
            putConnection.setDoOutput(true);
            String jsonInput = "{\"name\": \"Sen. Anala Iyer\",\"email\": \"dsen_anala_iyer123@stroman-leannon.test\",\"gender\": \"female\",\"status\": \"active\"}";
            try (OutputStream outputStream = putConnection.getOutputStream()) {
                byte[] input = jsonInput.getBytes(StandardCharsets.UTF_8);
                outputStream.write(input, 0, input.length);
            }
            System.out.println(putConnection.getResponseCode());
            System.out.println(readResponse(putConnection));
            putConnection.disconnect();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



        // put
        try {
            URL putUrl = new URL("https://gorest.co.in/public/v2/users/6942295");
            HttpURLConnection putConnection = (HttpURLConnection) putUrl.openConnection();
            putConnection.setRequestMethod("PUT");
            putConnection.setRequestProperty("Content-Type", "application/json");
            putConnection.setRequestProperty("Accept", "application/json");
            putConnection.setRequestProperty("Authorization", "Bearer 58762cdab4e248c10d165f6bbe89d18a444dff00267b6cfcec49acf9dceb94b7");
            putConnection.setDoOutput(true);
            String jsonInput = "{\"id\":6942295,\"name\":\"Julia Kononenko\",\"email\":\"konon@mohr.example\",\"gender\":\"female\",\"status\":\"active\"}";
            try (OutputStream outputStream = putConnection.getOutputStream()) {
                byte[] input = jsonInput.getBytes(StandardCharsets.UTF_8);
                outputStream.write(input, 0, input.length);
            }
            System.out.println(putConnection.getResponseCode());
            System.out.println(readResponse(putConnection));
            putConnection.disconnect();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //delete
        try {
            URL deleteUrl = new URL("https://gorest.co.in/public/v2/users/6942295");
            HttpURLConnection deleteConnection = (HttpURLConnection) deleteUrl.openConnection();
            deleteConnection.setRequestMethod("DELETE");
            deleteConnection.setRequestProperty("Authorization", "Bearer 58762cdab4e248c10d165f6bbe89d18a444dff00267b6cfcec49acf9dceb94b7");
            deleteConnection.setDoOutput(true);
            System.out.println(deleteConnection.getResponseCode());
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
}
