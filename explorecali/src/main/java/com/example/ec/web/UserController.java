package com.example.ec.web;

import com.example.ec.domain.User;
import com.example.ec.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import javax.validation.Valid;
import java.util.List;

/**
 * User Controller for API's of the /users endpoint
 *
 * Created by Mary Ellen Bowman
 */
@RestController
@RequestMapping("/users")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * Endpoint to login to the application.
     *
     * @param loginDto the login credentials
     * @return JWT String to be added to header of each successive api call.
     * @throws HttpServerErrorException-Forbidden if invalid login credentials
     */
    @PostMapping("/signin")
    public String login(@RequestBody @Valid LoginDto loginDto) {
       return userService.signin(loginDto.getUsername(), loginDto.getPassword()).orElseThrow(()->
               new HttpServerErrorException(HttpStatus.FORBIDDEN, "Login Failed"));
    }

    /**
     * Endpoint to add a new customer service representative user.
     * Only invokable by an Admin user.
     *
     * @param loginDto credentials of the new user
     * @return a User object once created if it does not already exist
     * @throws HttpServerErrorException-400 if user already exists
     */
    @PostMapping("/signup")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public User signup(@RequestBody @Valid LoginDto loginDto){
        return userService.signup(loginDto.getUsername(), loginDto.getPassword(), loginDto.getFirstName(),
                loginDto.getLastName()).orElseThrow(() -> new HttpServerErrorException(HttpStatus.BAD_REQUEST,"User already exists"));
    }

    /**
     * Get the list of all users.
     *
     * @return all users in the system
     */
    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<User> getAllUsers() {
        return userService.getAll();
    }

}