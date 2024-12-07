package ru.kpfu.itis.kononenko.dto;

public class UserRegistrationDto {
    private String name;
    private Integer lastname;
    private String login;
    private String password;

    public UserRegistrationDto(String name, Integer lastname, String login, String password) {
        this.name = name;
        this.lastname = lastname;
        this.login = login;
        this.password = password;
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

    public String getPassword() {
        return password;
    }
}
