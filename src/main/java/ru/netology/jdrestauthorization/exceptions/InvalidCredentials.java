package ru.netology.jdrestauthorization.exceptions;

public class InvalidCredentials extends RuntimeException {

    public InvalidCredentials(String message) {
        super(message);
    }
}
