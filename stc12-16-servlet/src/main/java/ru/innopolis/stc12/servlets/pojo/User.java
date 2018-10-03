package ru.innopolis.stc12.servlets.pojo;

public class User {
    private Integer id;
    private String name;
    private String password;
    private Integer role;

    public User(Integer id, String name, String password, Integer role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public User(String name, String password, Integer role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
