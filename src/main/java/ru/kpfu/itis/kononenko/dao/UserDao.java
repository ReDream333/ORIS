package ru.kpfu.itis.kononenko.dao;



import ru.kpfu.itis.kononenko.entry.User;

import java.util.List;

public interface UserDao {
    User get(Integer id);

    User getByLogin(String login);

    List<User> getAll();

    void save(User user);
}
