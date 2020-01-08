package com.example.ec.web;

import javax.validation.constraints.NotNull;

/**
 * Information supplied when attempting to login.
 *
 * Created By Mary Ellen Bowman
 */
public class LoginDto {
    @NotNull
    private String username;

    @NotNull
    private String password;

    private String firstName;

    private String lastName;

    /**
     * Default constructor
     */
    protected LoginDto() {
    }

    /**
     * Partial constructor
     * @param username user name
     * @param password password
     */
    public LoginDto(String username, String password) {
        this.username = username;
        this.password = password;
    }
    /**
     * Full constructor
     *
     * @param username user name
     * @param password password
     */
    public LoginDto(String username, String password, String firstName, String lastName) {
       this(username, password);
       this.firstName = firstName;
       this.lastName = lastName;
    }


    /**
     * Get the username.
     *
     * @return username string
     */
    public String getUsername() {
        return username;
    }

    /**
     * set the username.
     *
     * @param username username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * get the password.
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * set the password.
     *
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the first name.
     *
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Get the last name.
     *
     * @return last name
     */
    public String getLastName() {
        return lastName;
    }
}
