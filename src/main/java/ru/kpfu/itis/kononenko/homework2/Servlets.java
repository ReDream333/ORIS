package ru.kpfu.itis.kononenko.homework2;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@WebServlet(name = "Servlets", urlPatterns = "/posts")
public class Servlets extends HttpServlet {


    private static final Logger LOG =
            LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final List<JSONObject> users = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws  IOException {
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();

        for (JSONObject user : users) {
            writer.println(user.toString());
        }
        writer.flush();
        LOG.info("Output all users");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        String requestBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        JSONObject newUser = getNewUser(requestBody);
        users.add(newUser);
        writer.print("Новый пользователь добавлен: "+ newUser);
        writer.flush();
        LOG.info("New user add");

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        String requestBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        JSONObject newUser = new JSONObject(requestBody);
        int id = newUser.getInt("id");
        users.remove(getUserById(id));
        writer.print("Пользователь "+ newUser + " удален");
        LOG.info("User was delete");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        String requestBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        JSONObject user = new JSONObject(requestBody);
        int id = user.getInt("id");
        users.remove(getUserById(id));
        users.add(user);
        writer.print("Пользователь с Id = " + id + " успешно обновлен: " + user);
        writer.flush();
        LOG.info("User was update");
    }

    private JSONObject getNewUser(String body) {
        JSONObject newUser = new JSONObject(body);
        newUser.put("id", users.size() + 1);
        return newUser;
    }

    private JSONObject getUserById(int id) {
        for (JSONObject user : users) {
            if (user.getInt("id") == id) {
                return user;
            }
        }
        return null;
    }

}
