package ru.netology.jdrestauthorization.repository;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static ru.netology.jdrestauthorization.repository.Authorities.*;

@Repository
public class UserRepository {
    private final List<User> users;

    public UserRepository() {
        users = new CopyOnWriteArrayList<>();
        users.add(new User("Sam", "1234", Arrays.asList(READ, WRITE, DELETE)));
        users.add(new User("Yar", "123", Arrays.asList(READ, DELETE)));
        users.add(new User("Elena", "4321", Arrays.asList(DELETE, WRITE)));
        users.add(new User("Max", "1111", Arrays.asList(DELETE, WRITE)));
        users.add(new User("Mic", "0000", Arrays.asList(READ, DELETE)));
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> userAuthorities = Collections.emptyList();
        for (User person : users) {
            if (person.getName().equals(user) && person.getPassword().equals(password))
                userAuthorities = person.getAuthorities();
        }
        return userAuthorities;
    }
}