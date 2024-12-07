package ru.kpfu.itis.kononenko.service;

import ru.kpfu.itis.kononenko.dto.UserDto;
import ru.kpfu.itis.kononenko.dto.UserRegistrationDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAll();

    UserDto get(Integer id);

    UserDto getByLogin(String login);

    void register(UserRegistrationDto user);

}
