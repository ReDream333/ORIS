package ru.kpfu.itis.kononenko.homework2;

import ru.kpfu.itis.kononenko.homework1.HttpSample3;
import java.util.HashMap;
import java.util.Map;

public class MainTest {
    public static void main(String[] args) {
//        HttpSample3 h = new HttpSample3();
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
//        Map<String, String> paramsNonArgs = new HashMap<>();
//
//        Map<String, String> first = new HashMap<>();
//        first.put("firstName", "Иван");
//        first.put("lastName", "Иванов");
//        first.put("birthDate", "01-01-1990");
//        Map<String, String> second = new HashMap<>();
//        second.put("firstName", "Петр");
//        second.put("lastName", "Иванов");
//        second.put("birthDate", "01-01-1990");
//        Map<String, String> fhird = new HashMap<>();
//        fhird.put("firstName", "Герасим");
//        fhird.put("lastName", "Иванов");
//        fhird.put("birthDate", "01-01-1990");
//        Map<String, String> fourt = new HashMap<>();
//        fourt.put("firstName", "Августин");
//        fourt.put("lastName", "Иванов");
//        fourt.put("birthDate", "01-01-1990");
//
//
//        System.out.println(h.post("http://localhost:8080/posts", headers, first));
//        System.out.println(h.post("http://localhost:8080/posts", headers, second));
//        System.out.println(h.post("http://localhost:8080/posts", headers, fhird));
//        System.out.println(h.post("http://localhost:8080/posts", headers, fourt));
//        System.out.println(h.get("http://localhost:8080/posts", headers, paramsNonArgs));
//
//        Map<String, String> mapDel = new HashMap<>();
//        mapDel.put("id", "1");
//
//        System.out.println(h.delete("http://localhost:8080/posts", headers, mapDel));
//        System.out.println(h.get("http://localhost:8080/posts", headers, paramsNonArgs));
//
//        Map<String, String> mapPut = new HashMap<>();
//        mapPut.put("id", "2");
//        mapPut.put("firstName", "Петр");
//        mapPut.put("lastName", "Иванов");
//        mapPut.put("birthDate", "08-06-2002");
//
//        System.out.println(h.put("http://localhost:8080/posts", headers, mapPut));


        HttpSample3 h = new HttpSample3();

        String pass = "G7bh*g,3w@@A#K*";
        String log = "ReDream333";
        String apiKey = "PMAK-67406aef508cb400019e31da-209b5905b3a2bfcb781e07a1c9afe42565";
        String town = "London";

        Map<String, String> params = new HashMap<>();
        params.put("p", town);
        params.put("appid", apiKey);

        h.get("http://api.openweathermap.org/data/2.5//weather?q=London&appid=PMAK-67406aef508cb400019e31da-209b5905b3a2bfcb781e07a1c9afe42565", headers, params);

    }
}
