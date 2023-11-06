package ru.netology.jdrestauthorization.repository;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private final String name;
    private final String password;
    private final List<Authorities> authorities;

/*
    IF YOU DON'T USE LOMBOK

      public User(String name, String password, List<Authorities> authorities) {
        this.name = name;
        this.password = password;
        this.authorities = authorities;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public List<Authorities> getAuthorities() {
        return authorities;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", authorities=" + authorities +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(password, user.password) && Objects.equals(authorities, user.authorities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password, authorities);
    }
*/

}
