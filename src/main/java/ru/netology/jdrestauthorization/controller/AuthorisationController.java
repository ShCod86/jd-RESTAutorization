package ru.netology.jdrestauthorization.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.jdrestauthorization.exceptions.InvalidCredentials;
import ru.netology.jdrestauthorization.exceptions.UnauthorizedUser;
import ru.netology.jdrestauthorization.repository.Authorities;
import ru.netology.jdrestauthorization.service.AuthorizationService;

import java.util.List;

@RestController
public class AuthorisationController {
    AuthorizationService service;

    public AuthorisationController(AuthorizationService service) {
        this.service = service;
    }


    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> ich(InvalidCredentials e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatusCode.valueOf(400));
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> uuh(UnauthorizedUser e) {
        System.out.println(e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatusCode.valueOf(401));
    }
}
