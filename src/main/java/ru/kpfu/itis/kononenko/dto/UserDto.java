package ru.kpfu.itis.kononenko.dto;

public class UserDto {

    private String name;
    private Integer lastname;
    private String login;

    public UserDto(String name, Integer lastname, String login) {
        this.name = name;
        this.lastname = lastname;
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public Integer getLastname() {
        return lastname;
    }

    public String getLogin() {
        return login;
    }
}